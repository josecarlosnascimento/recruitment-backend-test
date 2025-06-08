package br.com.recruitment.service.enrollment.infra.client

import org.springframework.web.reactive.function.client.*
import reactor.core.publisher.Mono

abstract class AbstractWebClient(
    private val baseUrl: String,
) {
    fun getClient(headers: Map<String, String> = mapOf()): WebClient =
        WebClient.builder()
            .baseUrl(baseUrl)
            .exchangeStrategies(exchangeStrategies)
            .defaultHeaders {
                headers.forEach { (key, value) -> it[key] = value }
            }
            .filter(errorHandlingFilter())
            .filter(debugFilter())
            .build()

    private val exchangeStrategies =
        ExchangeStrategies.builder()
            .codecs {
                it.defaultCodecs().maxInMemorySize(10 * 1024 * 1024) // 10MB
            }.build()

    private fun debugFilter(): ExchangeFilterFunction {
        return ExchangeFilterFunction.ofRequestProcessor { request ->
            Mono.just(request)
        }
    }

    private fun errorHandlingFilter(): ExchangeFilterFunction {
        return ExchangeFilterFunction.ofResponseProcessor { response ->
            if (response.statusCode().isError.not()) {
                return@ofResponseProcessor Mono.just(response)
            }
            mapError(response)
        }
    }

    protected fun mapError(response: ClientResponse): Mono<ClientResponse> {
        return response.bodyToMono(String::class.java).flatMap {
            Mono.error(
                Exception(
                    "Error on request: $it",
                ),
            )
        }
    }
}
