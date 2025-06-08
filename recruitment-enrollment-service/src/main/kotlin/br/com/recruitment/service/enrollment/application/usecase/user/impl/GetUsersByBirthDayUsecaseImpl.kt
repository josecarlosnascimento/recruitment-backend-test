package br.com.recruitment.service.enrollment.application.usecase.user.impl

import br.com.recruitment.service.enrollment.application.gateway.enrollment.FindEnrollmentByUserIdGateway
import br.com.recruitment.service.enrollment.application.gateway.user.FindUsersByBirthdayGateway
import br.com.recruitment.service.enrollment.application.usecase.user.GetUsersByBirthDayUsecase
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import br.com.recruitment.service.enrollment.domain.user.User
import br.com.recruitment.service.enrollment.infra.client.financial.FindInstalmentsIdsByEnrollmentIdGatewayImpl
import br.com.recruitment.service.enrollment.infra.client.financial.GetInstalmentByIdGatewayImpl
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class GetUsersByBirthDayUsecaseImpl(
    private val findUsersByBirthDayGateway: FindUsersByBirthdayGateway,
    private val findEnrollmentByUserIdGateway: FindEnrollmentByUserIdGateway,
    private val findInstalmentsIdsByEnrollmentIdGatewayImpl: FindInstalmentsIdsByEnrollmentIdGatewayImpl,
    private val getInstalmentByIdGatewayImpl: GetInstalmentByIdGatewayImpl
): GetUsersByBirthDayUsecase {
    @Scheduled(cron = "*/10 * * * * *")
    override fun execute(): List<User> {
       var users =  findUsersByBirthDayGateway
            .findByBirthDay(LocalDate.of(2001,6, 1).atTime(LocalTime.MIN),
                            LocalDate.of(2001,6, 1).atTime(LocalTime.MAX))


       val enrollments: List<Enrollment> = users
            .flatMap { user -> findEnrollmentByUserIdGateway.execute(user.id) }


       val ids: List<String> =  enrollments
           .flatMap{ enrollment -> findInstalmentsIdsByEnrollmentIdGatewayImpl.execute(enrollment.id) }

       ids.forEach{ i ->
           val dto =  getInstalmentByIdGatewayImpl.execute(i);
           println(dto)
       }

        return users;
    }
}
