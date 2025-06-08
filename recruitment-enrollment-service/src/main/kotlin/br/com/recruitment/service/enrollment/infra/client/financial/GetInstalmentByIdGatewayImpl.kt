package br.com.recruitment.service.enrollment.infra.client.financial

import br.com.recruitment.service.enrollment.application.gateway.financial.instalment.GetInstalmentById
import br.com.recruitment.service.enrollment.infra.client.AbstractWebClient
import br.com.recruitment.service.enrollment.infra.client.financial.dto.InstalmentDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class GetInstalmentByIdGatewayImpl(
    @Value("\${client.financial.url}")
    private val baseUrl: String,
) : AbstractWebClient(baseUrl), GetInstalmentById {
    private val client: WebClient = getClient()

    override fun execute(id: String): InstalmentDto {
        val uri = "/api/v1/instalment/get-instalment-by-id/$id"

        return client.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(InstalmentDto::class.java)
            .block() ?: throw Exception("Internal Server Error")
    }
}
