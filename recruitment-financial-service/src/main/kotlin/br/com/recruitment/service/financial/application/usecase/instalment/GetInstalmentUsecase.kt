package br.com.recruitment.service.financial.application.usecase.instalment

import br.com.recruitment.service.financial.domain.instalment.Instalment

fun interface GetInstalmentUsecase {
    fun execute(id: String): Instalment?
}
