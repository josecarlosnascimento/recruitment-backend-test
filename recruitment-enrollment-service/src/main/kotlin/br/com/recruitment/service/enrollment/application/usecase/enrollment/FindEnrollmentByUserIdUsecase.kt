package br.com.recruitment.service.enrollment.application.usecase.enrollment

import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment

fun interface FindEnrollmentByUserIdUsecase {
    fun execute(userId: String): List<Enrollment>
}
