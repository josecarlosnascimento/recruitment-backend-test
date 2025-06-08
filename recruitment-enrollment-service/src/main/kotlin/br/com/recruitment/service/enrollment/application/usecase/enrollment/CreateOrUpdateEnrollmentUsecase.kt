package br.com.recruitment.service.enrollment.application.usecase.enrollment

import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment

fun interface CreateOrUpdateEnrollmentUsecase {
    fun execute(enrollment: Enrollment): Enrollment
}
