package br.com.recruitment.service.financial.infra.repository.coursePrice

import br.com.recruitment.service.financial.domain.coursePrice.CoursePrice
import org.springframework.data.mongodb.repository.MongoRepository

interface CoursePriceRepository : MongoRepository<CoursePrice, String>
