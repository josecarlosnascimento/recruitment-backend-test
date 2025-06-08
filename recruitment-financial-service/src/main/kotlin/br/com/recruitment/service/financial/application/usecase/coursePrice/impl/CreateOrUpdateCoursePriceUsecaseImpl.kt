package br.com.recruitment.service.financial.application.usecase.coursePrice.impl

import br.com.recruitment.service.financial.application.gateway.coursePrice.SaveCoursePriceGateway
import br.com.recruitment.service.financial.application.usecase.coursePrice.CreateOrUpdateCoursePriceUsecase
import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice
import br.com.recruitment.service.financial.loggerFor
import org.springframework.stereotype.Service

@Service
class CreateOrUpdateCoursePriceUsecaseImpl(
    private val saveCoursePriceGateway: SaveCoursePriceGateway,
) : CreateOrUpdateCoursePriceUsecase {
    private val log = loggerFor<CreateOrUpdateCoursePriceUsecaseImpl>()

    override fun execute(coursePrice: CoursePrice): CoursePrice {
        log.info("Creating or update Course Price ${coursePrice.id}")
        return saveCoursePriceGateway.execute(coursePrice)
    }
}
