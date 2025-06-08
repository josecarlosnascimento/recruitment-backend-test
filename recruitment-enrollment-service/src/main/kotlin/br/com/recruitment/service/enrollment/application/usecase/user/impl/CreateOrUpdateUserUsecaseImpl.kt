package br.com.recruitment.service.enrollment.application.usecase.user.impl

import br.com.recruitment.service.enrollment.application.gateway.user.SaveUserGateway
import br.com.recruitment.service.enrollment.application.usecase.user.CreateOrUpdateUserUsecase
import br.com.recruitment.service.enrollment.domain.user.User
import br.com.recruitment.service.enrollment.loggerFor
import org.springframework.stereotype.Service

@Service
class CreateOrUpdateUserUsecaseImpl(
    private val saveUserGateway: SaveUserGateway,
) : CreateOrUpdateUserUsecase {
    private val log = loggerFor<CreateOrUpdateUserUsecaseImpl>()

    override fun execute(user: User): User {
        log.info("Creating or update enrollment ${user.id}")
        return saveUserGateway.execute(user)
    }
}
