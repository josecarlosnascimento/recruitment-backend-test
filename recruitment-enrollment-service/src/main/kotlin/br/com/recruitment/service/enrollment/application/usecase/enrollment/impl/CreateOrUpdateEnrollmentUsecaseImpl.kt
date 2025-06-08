package br.com.recruitment.service.enrollment.application.usecase.enrollment.impl

import br.com.recruitment.service.enrollment.application.gateway.enrollment.SaveEnrollmentGateway
import br.com.recruitment.service.enrollment.application.usecase.enrollment.CreateOrUpdateEnrollmentUsecase
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import br.com.recruitment.service.enrollment.loggerFor
import org.springframework.stereotype.Service

@Service
class CreateOrUpdateEnrollmentUsecaseImpl(
    private val saveEnrollmentGateway: SaveEnrollmentGateway,
) : CreateOrUpdateEnrollmentUsecase {
    private val log = loggerFor<CreateOrUpdateEnrollmentUsecaseImpl>()

    override fun execute(enrollment: Enrollment): Enrollment {
        log.info("Creating or update enrollment ${enrollment.id}")
        return saveEnrollmentGateway.execute(enrollment)
    }
}
