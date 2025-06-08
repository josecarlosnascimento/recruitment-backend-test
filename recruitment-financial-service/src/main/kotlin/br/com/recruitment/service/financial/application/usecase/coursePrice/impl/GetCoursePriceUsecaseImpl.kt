package br.com.recruitment.service.financial.application.usecase.coursePrice.impl

import br.com.recruitment.service.financial.application.gateway.coursePrice.GetCoursePriceByIdGateway
import br.com.recruitment.service.financial.application.usecase.coursePrice.GetCoursePriceUsecase
import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice
import br.com.recruitment.service.financial.loggerFor
import org.springframework.stereotype.Service

@Service
class GetCoursePriceUsecaseImpl(
    private val getCoursePriceByIdGateway: GetCoursePriceByIdGateway,
) : GetCoursePriceUsecase {
    private val log = loggerFor<GetCoursePriceUsecaseImpl>()

    override fun execute(coursePriceId: String): CoursePrice? {
        return getCoursePriceByIdGateway.execute(coursePriceId)
    }
}
