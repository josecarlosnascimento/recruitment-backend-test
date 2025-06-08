package br.com.recruitment.service.enrollment.application.usecase.user

import br.com.recruitment.service.enrollment.domain.user.User

fun interface CreateOrUpdateUserUsecase {
    fun execute(user: User): User
}
