package br.com.recruitment.service.financial.infra.repository.instalment

import br.com.recruitment.service.financial.application.gateway.instalment.SaveInstalmentGateway
import br.com.recruitment.service.financial.domain.instalment.Instalment
import org.springframework.stereotype.Component

@Component
class SaveInstalmentGatewayImpl(
    private val instalmentRepository: InstalmentRepository,
) : SaveInstalmentGateway {
    override fun execute(instalment: Instalment): Instalment = instalmentRepository.save(instalment)
}
