package br.com.recruitment.service.enrollment.application.usecase.enrollment.impl

import br.com.recruitment.service.enrollment.application.gateway.enrollment.FindEnrollmentByUserIdGateway
import br.com.recruitment.service.enrollment.application.usecase.enrollment.FindEnrollmentByUserIdUsecase
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import br.com.recruitment.service.enrollment.infra.client.financial.FindInstalmentsIdsByEnrollmentIdGatewayImpl
import br.com.recruitment.service.enrollment.infra.client.financial.GetInstalmentByIdGatewayImpl
import br.com.recruitment.service.enrollment.loggerFor
import org.springframework.stereotype.Service

@Service
class FindEnrollmentByUserIdUsecaseImpl(
    private val findEnrollmentByUserIdGateway: FindEnrollmentByUserIdGateway,
    private val findInstalmentsIdsByEnrollmentIdGatewayImpl: FindInstalmentsIdsByEnrollmentIdGatewayImpl,
    private val getInstalmentByIdGatewayImpl: GetInstalmentByIdGatewayImpl,
) : FindEnrollmentByUserIdUsecase {
    private val log = loggerFor<FindEnrollmentByUserIdUsecaseImpl>()

    override fun execute(userId: String): List<Enrollment> {
        return findEnrollmentByUserIdGateway.execute(userId).map { enrollment ->
            enrollment.instalments =
                findInstalmentsIdsByEnrollmentIdGatewayImpl.execute(enrollment.id).map { instalmentId ->
                    getInstalmentByIdGatewayImpl.execute(instalmentId)
                }

            enrollment
        }
    }
}
