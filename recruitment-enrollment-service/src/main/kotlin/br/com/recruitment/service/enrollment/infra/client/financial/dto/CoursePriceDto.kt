package br.com.recruitment.service.enrollment.infra.client.financial.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

data class CoursePriceDto (
    @JsonProperty("id")
    var id: String = UUID.randomUUID().toString(),
    @JsonProperty("price")
    val price: BigDecimal
) : Serializable
