package br.com.recruitment.service.financial.domain.instalment

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "instalment")
class Instalment(
    @Column(length = 36)
    var enrollmentId: String,
    @Column
    var amount: BigDecimal,
    @Column
    var dueDate: LocalDate,
    @Enumerated(EnumType.STRING)
    var status: InstalmentStatus,
    @Column
    var paidAmount: BigDecimal,
) {
    @Id
    @Column(length = 36)
    var id: String = UUID.randomUUID().toString()

    constructor() : this(
        "",
        BigDecimal.ZERO,
        LocalDate.now(),
        InstalmentStatus.OPEN,
        BigDecimal.ZERO,
    )
}
