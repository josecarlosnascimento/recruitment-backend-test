package br.com.recruitment.service.enrollment.application.gateway.financial.instalment

import br.com.recruitment.service.enrollment.infra.client.financial.dto.CoursePriceDto
interface GetCoursePriceById {
    fun execute(enrollmentId: String): CoursePriceDto
}
