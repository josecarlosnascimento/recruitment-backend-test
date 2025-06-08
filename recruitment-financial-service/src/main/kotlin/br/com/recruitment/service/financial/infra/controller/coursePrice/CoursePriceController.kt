package br.com.recruitment.service.financial.infra.controller.coursePrice

import br.com.recruitment.service.financial.application.usecase.coursePrice.CreateOrUpdateCoursePriceUsecase
import br.com.recruitment.service.financial.application.usecase.coursePrice.GetCoursePriceUsecase
import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/course-price")
class CoursePriceController(
    private val createOrUpdateCoursePriceUsecase: CreateOrUpdateCoursePriceUsecase,
    private val getCoursePriceUsecase: GetCoursePriceUsecase,
) {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCoursePrice(
        @RequestBody(required = true) coursePrice: CoursePrice,
    ): CoursePrice {
        return createOrUpdateCoursePriceUsecase.execute(coursePrice)
    }

    @GetMapping("/find-by-id/{coursePriceId}")
    fun findById(
        @PathVariable coursePriceId: String,
    ): CoursePrice? {
        return getCoursePriceUsecase.execute(coursePriceId)
    }
}
