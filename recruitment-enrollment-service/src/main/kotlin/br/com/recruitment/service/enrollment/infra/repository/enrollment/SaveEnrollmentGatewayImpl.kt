package br.com.recruitment.service.enrollment.infra.repository.enrollment

import br.com.recruitment.service.enrollment.application.gateway.enrollment.SaveEnrollmentGateway
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import org.springframework.stereotype.Component

@Component
class SaveEnrollmentGatewayImpl(
    private val enrollmentRepository: EnrollmentRepository,
) : SaveEnrollmentGateway {
    override fun execute(enrollment: Enrollment): Enrollment = enrollmentRepository.save(enrollment)
}
