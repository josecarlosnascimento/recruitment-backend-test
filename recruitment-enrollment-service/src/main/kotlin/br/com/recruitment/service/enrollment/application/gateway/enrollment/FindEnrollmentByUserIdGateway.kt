package br.com.recruitment.service.enrollment.application.gateway.enrollment

import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment

interface FindEnrollmentByUserIdGateway {
    fun execute(userId: String): List<Enrollment>
}
