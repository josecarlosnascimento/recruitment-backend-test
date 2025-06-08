package br.com.recruitment.service.financial.exception

import br.com.recruitment.service.financial.loggerFor
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ControllerAdvice(
    @Value("\${spring.profiles.active:local}")
    private val profile: String,
) {
    private val log = loggerFor<ControllerAdvice>()

    @ExceptionHandler(DefaultException::class)
    fun handleDefaultException(ex: DefaultException): ResponseEntity<ExceptionDto> {
        log.error(ex.toString(), ex)
        return ResponseEntity.status(ex.httpStatus).body(ex.toExceptionDto())
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<ExceptionDto> {
        val noDetailsMessage = "No details"
        val detailedMessage = ex.message ?: noDetailsMessage

        val message = if (profile == "production") noDetailsMessage else detailedMessage
        val error =
            DefaultException(
                httpStatus = 500,
                message = message,
                internalCode = "ERR_DFL_500",
                friendlyMessage = "Ocorreu um erro inesperado na aplicação",
                internalTraceId = UUID.randomUUID(),
                type = ExceptionType.UNEXPECTED,
            )
        log.error(error.toString(), error)
        return ResponseEntity.status(error.httpStatus).body(error.toExceptionDto())
    }
}
