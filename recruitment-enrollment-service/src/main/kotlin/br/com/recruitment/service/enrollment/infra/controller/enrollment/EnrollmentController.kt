package br.com.recruitment.service.enrollment.infra.controller.enrollment

import br.com.recruitment.service.enrollment.application.usecase.enrollment.CreateOrUpdateEnrollmentUsecase
import br.com.recruitment.service.enrollment.application.usecase.enrollment.FindEnrollmentByUserIdUsecase
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/enrollment")
class EnrollmentController(
    private val createOrUpdateEnrollmentUseCase: CreateOrUpdateEnrollmentUsecase,
    private val findEnrollmentByUserIdUsecase: FindEnrollmentByUserIdUsecase,
) {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEnrollment(
        @RequestBody(required = true) enrollment: Enrollment,
    ): Enrollment {
        return createOrUpdateEnrollmentUseCase.execute(enrollment)
    }

    @GetMapping("/find-by-user-id/{userId}")
    fun findByUserId(
        @PathVariable userId: String,
    ): List<Enrollment> {
        return findEnrollmentByUserIdUsecase.execute(userId)
    }
}
