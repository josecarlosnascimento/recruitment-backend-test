package br.com.recruitment.service.enrollment.infra.repository.user

import br.com.recruitment.service.enrollment.domain.user.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

interface UserRepository : MongoRepository<User, String> {
    @Query("{'document': ?0 }")
    fun findByDocument(document: String): User?

    @Query("{ \"birthDate\": { \"\$gte\": ?0, \"\$lte\": ?1 } }")
    fun findByBirthDay(dtInit: LocalDateTime, dtEnd: LocalDateTime): List<User>

}
