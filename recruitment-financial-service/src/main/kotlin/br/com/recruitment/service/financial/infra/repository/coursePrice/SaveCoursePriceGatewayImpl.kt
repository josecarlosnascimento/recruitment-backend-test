package br.com.recruitment.service.financial.infra.repository.coursePrice

import br.com.recruitment.service.financial.application.gateway.coursePrice.SaveCoursePriceGateway
import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice
import org.springframework.stereotype.Component

@Component
class SaveCoursePriceGatewayImpl(
    private val coursePriceRepository: CoursePriceRepository,
) : SaveCoursePriceGateway {
    override fun execute(coursePrice: CoursePrice): CoursePrice {
        return coursePriceRepository.save(coursePrice)
    }
}
