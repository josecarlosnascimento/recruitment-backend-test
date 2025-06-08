package br.com.recruitment.service.enrollment.application.usecase.user

import br.com.recruitment.service.enrollment.domain.user.User
import java.util.*

fun interface GetUsersByBirthDayUsecase {
    fun execute(): List<User>
}
