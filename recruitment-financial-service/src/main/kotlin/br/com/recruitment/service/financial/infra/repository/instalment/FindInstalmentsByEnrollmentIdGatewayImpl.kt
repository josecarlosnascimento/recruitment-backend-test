package br.com.recruitment.service.financial.infra.repository.instalment

import br.com.recruitment.service.financial.application.gateway.instalment.FindInstalmentsByEnrollmentIdGateway
import br.com.recruitment.service.financial.domain.instalment.Instalment
import org.springframework.stereotype.Component

@Component
class FindInstalmentsByEnrollmentIdGatewayImpl(
    private val instalmentRepository: InstalmentRepository,
) : FindInstalmentsByEnrollmentIdGateway {
    override fun execute(enrollmentId: String): List<Instalment> = instalmentRepository.findByEnrollmentId(enrollmentId)
}
