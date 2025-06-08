package br.com.recruitment.service.financial.domain.coursePrice

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*

@Document(collection = "coursePrice")
data class CoursePrice(
    @Id
    var id: String = UUID.randomUUID().toString(),
    val price: BigDecimal,
)
