package br.com.recruitment.service.enrollment.application.gateway.user

import br.com.recruitment.service.enrollment.domain.user.User

interface FindUserByDocumentGateway {
    fun execute(document: String): User?
}
