package br.com.recruitment.service.financial.application.usecase.coursePrice

import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice

fun interface CreateOrUpdateCoursePriceUsecase {
    fun execute(coursePrice: CoursePrice): CoursePrice
}
