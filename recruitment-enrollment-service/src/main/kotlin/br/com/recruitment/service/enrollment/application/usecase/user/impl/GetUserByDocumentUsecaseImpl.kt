package br.com.recruitment.service.enrollment.application.usecase.user.impl

import br.com.recruitment.service.enrollment.application.gateway.user.FindUserByDocumentGateway
import br.com.recruitment.service.enrollment.application.usecase.user.GetUserByDocumentUsecase
import br.com.recruitment.service.enrollment.domain.user.User
import br.com.recruitment.service.enrollment.loggerFor
import org.springframework.stereotype.Service

@Service
class GetUserByDocumentUsecaseImpl(
    private val findUserByDocumentGateway: FindUserByDocumentGateway,
) : GetUserByDocumentUsecase {
    private val log = loggerFor<GetUserByDocumentUsecaseImpl>()

    override fun execute(userId: String): User? {
        return findUserByDocumentGateway.execute(userId)
    }
}
