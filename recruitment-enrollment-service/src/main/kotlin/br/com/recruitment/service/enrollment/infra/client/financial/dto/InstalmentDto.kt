package br.com.recruitment.service.enrollment.infra.client.financial.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class InstalmentDto(
    @JsonProperty("id")
    var id: String,
    @JsonProperty("enrollmentId")
    var enrollmentId: String,
    @JsonProperty("amount")
    var amount: BigDecimal,
    @JsonProperty("dueDate")
    var dueDate: LocalDate,
    @JsonProperty("status")
    var status: InstalmentStatus,
    @JsonProperty("paidAmount")
    var paidAmount: BigDecimal,
) : Serializable

enum class InstalmentStatus {
    OPEN,
    PAID,
}
