package br.com.recruitment.service.enrollment.infra.repository.user

import br.com.recruitment.service.enrollment.application.gateway.user.FindUserByDocumentGateway
import br.com.recruitment.service.enrollment.domain.user.User
import org.springframework.stereotype.Component

@Component
class FindUserByDocumentGatewayImpl(
    private val userRepository: UserRepository,
) : FindUserByDocumentGateway {
    override fun execute(document: String): User? = userRepository.findByDocument(document)
}
