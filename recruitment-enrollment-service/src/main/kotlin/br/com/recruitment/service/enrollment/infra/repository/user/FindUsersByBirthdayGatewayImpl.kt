package br.com.recruitment.service.enrollment.infra.repository.user

import br.com.recruitment.service.enrollment.application.gateway.user.FindUsersByBirthdayGateway
import br.com.recruitment.service.enrollment.domain.user.User
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class FindUsersByBirthdayGatewayImpl(
    private val userRepository: UserRepository
) : FindUsersByBirthdayGateway{
    override fun findByBirthDay(dtInit: LocalDateTime, dtEnd: LocalDateTime): List<User> {
        return userRepository.findByBirthDay(dtInit, dtEnd);
    }
}
