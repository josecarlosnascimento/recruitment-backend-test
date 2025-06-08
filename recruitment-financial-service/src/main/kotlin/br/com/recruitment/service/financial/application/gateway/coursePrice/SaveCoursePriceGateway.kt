package br.com.recruitment.service.financial.application.gateway.coursePrice

import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice

interface SaveCoursePriceGateway {
    fun execute(coursePrice: CoursePrice): CoursePrice
}
