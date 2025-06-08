package br.com.recruitment.service.enrollment.infra.client.financial

import br.com.recruitment.service.enrollment.application.gateway.financial.instalment.FindInstalmentsIdsByEnrollmentId
import br.com.recruitment.service.enrollment.infra.client.AbstractWebClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class FindInstalmentsIdsByEnrollmentIdGatewayImpl(
    @Value("\${client.financial.url}")
    private val baseUrl: String,
) : AbstractWebClient(baseUrl), FindInstalmentsIdsByEnrollmentId {
    private val client: WebClient = getClient()

    override fun execute(enrollmentId: String): List<String> {
        val uri = "/api/v1/instalment/find-instalment-ids-by-enrollment-id/$enrollmentId"

        return client.get()
            .uri(uri)
            .retrieve()
            .bodyToMono(object : ParameterizedTypeReference<List<String>>() {})
            .block() ?: throw Exception("Internal Server Error")
    }
}
