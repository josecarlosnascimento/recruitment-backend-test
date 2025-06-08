package br.com.recruitment.service.financial.application.usecase.instalment.impl

import br.com.recruitment.service.financial.application.gateway.instalment.FindInstalmentsByEnrollmentIdGateway
import br.com.recruitment.service.financial.application.usecase.instalment.GetInstalmentsIdsByEnrollmentIdUsecase
import br.com.recruitment.service.financial.loggerFor
import org.springframework.stereotype.Service

@Service
class GetInstalmentsIdsByEnrollmentIdUsecaseImpl(
    private val findInstalmentsByEnrollmentIdGateway: FindInstalmentsByEnrollmentIdGateway,
) : GetInstalmentsIdsByEnrollmentIdUsecase {
    private val log = loggerFor<GetInstalmentsIdsByEnrollmentIdUsecaseImpl>()

    override fun execute(enrollmentId: String): List<String> {
        return findInstalmentsByEnrollmentIdGateway.execute(enrollmentId).map {
            it.id
        }
    }
}
