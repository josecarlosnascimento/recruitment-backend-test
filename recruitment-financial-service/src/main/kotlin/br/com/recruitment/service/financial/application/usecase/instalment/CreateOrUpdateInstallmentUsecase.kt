package br.com.recruitment.service.financial.application.usecase.instalment

import br.com.recruitment.service.financial.domain.instalment.Instalment

fun interface CreateOrUpdateInstallmentUsecase {
    fun execute(instalment: Instalment): Instalment
}
