package br.com.recruitment.service.financial.infra.controller.instalment

import br.com.recruitment.service.financial.application.usecase.instalment.CreateOrUpdateInstallmentUsecase
import br.com.recruitment.service.financial.application.usecase.instalment.GetInstalmentUsecase
import br.com.recruitment.service.financial.application.usecase.instalment.GetInstalmentsIdsByEnrollmentIdUsecase
import br.com.recruitment.service.financial.domain.instalment.Instalment
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/instalment")
class InstalmentController(
    private val createOrUpdateInstallmentUseCase: CreateOrUpdateInstallmentUsecase,
    private val getInstalmentsIdsByEnrollmentIdUsecase: GetInstalmentsIdsByEnrollmentIdUsecase,
    private val getInstalmentUsecase: GetInstalmentUsecase,
) {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createInstalment(
        @RequestBody(required = true) instalment: Instalment,
    ): Instalment {
        return createOrUpdateInstallmentUseCase.execute(instalment)
    }

    @GetMapping("/find-instalment-ids-by-enrollment-id/{enrollmentId}")
    fun findByEnrollmentId(
        @PathVariable enrollmentId: String,
    ): List<String> {
        return getInstalmentsIdsByEnrollmentIdUsecase.execute(enrollmentId)
    }

    @GetMapping("/get-instalment-by-id/{id}")
    fun getInstalment(
        @PathVariable id: String,
    ): Instalment? {
        return getInstalmentUsecase.execute(id)
    }
}
