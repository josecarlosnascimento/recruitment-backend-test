package br.com.recruitment.service.enrollment.infra.controller.user

import br.com.recruitment.service.enrollment.application.gateway.user.FindUserByDocumentGateway
import br.com.recruitment.service.enrollment.application.usecase.user.CreateOrUpdateUserUsecase
import br.com.recruitment.service.enrollment.domain.user.User
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val createOrUpdateUserUsecase: CreateOrUpdateUserUsecase,
    private val findUserByDocumentGateway: FindUserByDocumentGateway,
) {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEnrollment(
        @RequestBody(required = true) user: User,
    ): User {
        return createOrUpdateUserUsecase.execute(user)
    }

    @GetMapping("/find-by-document/{document}")
    fun findByUserId(
        @PathVariable document: String,
    ): User? {
        return findUserByDocumentGateway.execute(document)
    }
}
