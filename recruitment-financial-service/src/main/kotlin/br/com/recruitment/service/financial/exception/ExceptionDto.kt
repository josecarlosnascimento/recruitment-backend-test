package br.com.recruitment.service.financial.exception

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class ExceptionDto(
    @JsonProperty("httpStatus")
    val httpStatus: Int,
    @JsonProperty("internalCode")
    val internalCode: String,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("friendlyMessage")
    val friendlyMessage: String?,
    @JsonProperty("internalTraceId")
    val internalTraceId: UUID,
    @JsonProperty("type")
    val type: ExceptionType,
)
