package br.com.recruitment.service.financial.infra.repository.instalment

import br.com.recruitment.service.financial.application.gateway.instalment.GetInstalmentByIdGateway
import br.com.recruitment.service.financial.domain.instalment.Instalment
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class GetInstalmentByIdGatewayImpl(
    private val instalmentRepository: InstalmentRepository,
) : GetInstalmentByIdGateway {
    override fun execute(id: String): Instalment? = instalmentRepository.findById(id).getOrNull()
}
