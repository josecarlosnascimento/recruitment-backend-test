package br.com.recruitment.service.enrollment.infra.client.financial

import br.com.recruitment.service.enrollment.application.gateway.financial.instalment.GetCoursePriceById
import br.com.recruitment.service.enrollment.infra.client.AbstractWebClient
import br.com.recruitment.service.enrollment.infra.client.financial.dto.CoursePriceDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class GetCoursePriceByIdGatewayImpl(
    @Value("\${client.financial.url}")
    private val baseUrl: String,
) : AbstractWebClient(baseUrl), GetCoursePriceById {
    private val client: WebClient = getClient()

    override fun execute(id: String): CoursePriceDto {
        val uri = "/api/v1/course-price/find-by-id/$id"

        return client.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(CoursePriceDto::class.java)
            .block() ?: throw Exception("Internal Server Error")
    }
}
