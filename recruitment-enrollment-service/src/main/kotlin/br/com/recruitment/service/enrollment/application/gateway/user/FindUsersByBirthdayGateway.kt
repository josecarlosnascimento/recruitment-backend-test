package br.com.recruitment.service.enrollment.application.gateway.user

import br.com.recruitment.service.enrollment.domain.user.User
import java.time.LocalDateTime

interface FindUsersByBirthdayGateway {

    fun findByBirthDay(dtInit: LocalDateTime, dtEnd: LocalDateTime): List<User>

}
