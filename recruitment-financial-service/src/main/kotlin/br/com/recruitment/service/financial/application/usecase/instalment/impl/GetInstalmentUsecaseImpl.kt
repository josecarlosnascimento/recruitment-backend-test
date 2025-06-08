package br.com.recruitment.service.financial.application.usecase.instalment.impl

import br.com.recruitment.service.financial.application.gateway.instalment.GetInstalmentByIdGateway
import br.com.recruitment.service.financial.application.usecase.instalment.GetInstalmentUsecase
import br.com.recruitment.service.financial.domain.instalment.Instalment
import br.com.recruitment.service.financial.loggerFor
import org.springframework.stereotype.Service

@Service
class GetInstalmentUsecaseImpl(
    private val getInstalmentByIdGateway: GetInstalmentByIdGateway,
) : GetInstalmentUsecase {
    private val log = loggerFor<GetInstalmentUsecaseImpl>()

    override fun execute(id: String): Instalment? {
        return getInstalmentByIdGateway.execute(id)
    }
}
