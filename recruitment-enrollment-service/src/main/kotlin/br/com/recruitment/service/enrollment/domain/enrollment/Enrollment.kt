package br.com.recruitment.service.enrollment.domain.enrollment

import br.com.recruitment.service.enrollment.infra.client.financial.dto.InstalmentDto
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "enrollment")
class Enrollment(
    @Column(length = 36)
    var coursePriceId: String,
    @Column(length = 36)
    var userId: String,
    @Column
    var duration: Int,
    @Transient
    var instalments: List<InstalmentDto> = listOf(),
) {
    @Id
    @Column(length = 36)
    var id: String = UUID.randomUUID().toString()

    constructor() : this("", "", 0)
}
