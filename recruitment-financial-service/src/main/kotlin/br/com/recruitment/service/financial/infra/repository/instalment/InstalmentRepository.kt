package br.com.recruitment.service.financial.infra.repository.instalment

import br.com.recruitment.service.financial.domain.instalment.Instalment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface InstalmentRepository :
    JpaRepository<Instalment, String>,
    PagingAndSortingRepository<Instalment, String>,
    JpaSpecificationExecutor<Instalment> {
    fun findByEnrollmentId(enrollmentId: String): List<Instalment>
}
