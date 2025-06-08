package br.com.recruitment.service.enrollment.infra.repository.enrollment

import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface EnrollmentRepository :
    JpaRepository<Enrollment, String>,
    PagingAndSortingRepository<Enrollment, String>,
    JpaSpecificationExecutor<Enrollment> {
    fun findByUserId(userId: String): List<Enrollment>
}
