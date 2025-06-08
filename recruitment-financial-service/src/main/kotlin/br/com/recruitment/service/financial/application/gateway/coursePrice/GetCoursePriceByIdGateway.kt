package br.com.recruitment.service.financial.application.gateway.coursePrice

import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice

interface GetCoursePriceByIdGateway {
    fun execute(coursePriceId: String): CoursePrice?
}
