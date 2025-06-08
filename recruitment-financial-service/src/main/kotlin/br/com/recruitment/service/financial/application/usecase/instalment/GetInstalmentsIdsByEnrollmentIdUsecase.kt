package br.com.recruitment.service.financial.application.usecase.instalment

fun interface GetInstalmentsIdsByEnrollmentIdUsecase {
    fun execute(enrollmentId: String): List<String>
}
