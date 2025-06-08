package br.com.recruitment.service.financial.application.usecase.instalment.impl

import br.com.recruitment.service.financial.application.gateway.instalment.SaveInstalmentGateway
import br.com.recruitment.service.financial.application.usecase.instalment.CreateOrUpdateInstallmentUsecase
import br.com.recruitment.service.financial.domain.instalment.Instalment
import br.com.recruitment.service.financial.loggerFor
import org.springframework.stereotype.Service

@Service
class CreateOrUpdateInstallmentUsecaseImpl(
    private val saveInstalmentGateway: SaveInstalmentGateway,
) : CreateOrUpdateInstallmentUsecase {
    private val log = loggerFor<CreateOrUpdateInstallmentUsecaseImpl>()

    override fun execute(instalment: Instalment): Instalment {
        log.info("Creating or update instalment ${instalment.id}")
        return saveInstalmentGateway.execute(instalment)
    }
}
