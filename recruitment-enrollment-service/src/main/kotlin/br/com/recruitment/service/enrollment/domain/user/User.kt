package br.com.recruitment.service.enrollment.domain.user

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document(collection = "users")
data class User(
    @Id
    var id: String = UUID.randomUUID().toString(),
    var fullName: String,
    val document: String,
    val birthDate: LocalDate,
)
