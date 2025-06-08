package br.com.recruitment.service.enrollment.application.gateway.financial.instalment

interface FindInstalmentsIdsByEnrollmentId {
    fun execute(enrollmentId: String): List<String>
}
