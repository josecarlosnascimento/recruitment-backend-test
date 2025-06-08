package br.com.recruitment.service.financial.infra.repository.coursePrice

import br.com.recruitment.service.financial.application.gateway.coursePrice.GetCoursePriceByIdGateway
import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class GetCoursePriceByIdGatewayImpl(
    private val coursePriceRepository: CoursePriceRepository,
) : GetCoursePriceByIdGateway {
    override fun execute(coursePriceId: String): CoursePrice? =
        coursePriceRepository.findById(coursePriceId).getOrNull()
}
