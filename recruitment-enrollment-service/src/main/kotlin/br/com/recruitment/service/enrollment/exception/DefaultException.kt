package br.com.recruitment.service.enrollment.exception

import java.util.*

open class DefaultException(
    open val httpStatus: Int,
    open val internalCode: String,
    override val message: String,
    open val friendlyMessage: String?,
    open val internalTraceId: UUID,
    open val type: ExceptionType,
) : RuntimeException(message) {
    override fun toString(): String {
        return "${this.javaClass.simpleName}[$httpStatus] - $message," +
            " internalCode: $internalCode," +
            " internalTraceId: $internalTraceId"
    }

    fun toExceptionDto() =
        ExceptionDto(
            httpStatus = httpStatus,
            internalCode = internalCode,
            message = message,
            friendlyMessage = friendlyMessage,
            internalTraceId = internalTraceId,
            type = type,
        )
}
