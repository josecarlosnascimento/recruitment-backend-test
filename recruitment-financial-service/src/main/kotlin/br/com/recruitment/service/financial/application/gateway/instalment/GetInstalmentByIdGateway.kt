package br.com.recruitment.service.financial.application.gateway.instalment

import br.com.recruitment.service.financial.domain.instalment.Instalment

interface GetInstalmentByIdGateway {
    fun execute(id: String): Instalment?
}
