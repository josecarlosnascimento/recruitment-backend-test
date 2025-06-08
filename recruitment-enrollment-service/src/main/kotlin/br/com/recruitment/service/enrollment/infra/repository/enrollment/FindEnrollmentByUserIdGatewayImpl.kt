package br.com.recruitment.service.enrollment.infra.repository.enrollment

import br.com.recruitment.service.enrollment.application.gateway.enrollment.FindEnrollmentByUserIdGateway
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import org.springframework.stereotype.Component

@Component
class FindEnrollmentByUserIdGatewayImpl(
    private val enrollmentRepository: EnrollmentRepository,
) : FindEnrollmentByUserIdGateway {
    override fun execute(userId: String): List<Enrollment> = enrollmentRepository.findByUserId(userId)
}
