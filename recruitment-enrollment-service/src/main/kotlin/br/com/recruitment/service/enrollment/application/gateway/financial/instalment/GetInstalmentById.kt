package br.com.recruitment.service.enrollment.application.gateway.financial.instalment

import br.com.recruitment.service.enrollment.infra.client.financial.dto.InstalmentDto

interface GetInstalmentById {
    fun execute(enrollmentId: String): InstalmentDto
}
