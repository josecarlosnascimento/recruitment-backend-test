package br.com.recruitment.service.enrollment.infra.repository.user

import br.com.recruitment.service.enrollment.application.gateway.user.SaveUserGateway
import br.com.recruitment.service.enrollment.domain.user.User
import org.springframework.stereotype.Component

@Component
class SaveUserGatewayImpl(
    private val userRepository: UserRepository,
) : SaveUserGateway {
    override fun execute(user: User): User {
        return userRepository.save(user)
    }
}
