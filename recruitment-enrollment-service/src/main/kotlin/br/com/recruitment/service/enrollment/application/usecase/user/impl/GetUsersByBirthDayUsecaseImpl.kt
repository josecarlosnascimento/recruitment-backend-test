package br.com.recruitment.service.enrollment.application.usecase.user.impl

import br.com.recruitment.service.enrollment.application.gateway.enrollment.FindEnrollmentByUserIdGateway
import br.com.recruitment.service.enrollment.application.gateway.financial.instalment.GetCoursePriceById
import br.com.recruitment.service.enrollment.application.gateway.user.FindUsersByBirthdayGateway
import br.com.recruitment.service.enrollment.application.usecase.enrollment.impl.FindEnrollmentByUserIdUsecaseImpl
import br.com.recruitment.service.enrollment.application.usecase.user.GetUsersByBirthDayUsecase
import br.com.recruitment.service.enrollment.domain.enrollment.Enrollment
import br.com.recruitment.service.enrollment.domain.user.User
import br.com.recruitment.service.enrollment.infra.client.financial.FindInstalmentsIdsByEnrollmentIdGatewayImpl
import br.com.recruitment.service.enrollment.infra.client.financial.GetCoursePriceByIdGatewayImpl
import br.com.recruitment.service.enrollment.infra.client.financial.GetInstalmentByIdGatewayImpl
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
import java.util.ArrayList

@Service
class GetUsersByBirthDayUsecaseImpl(
    private val findUsersByBirthDayGateway: FindUsersByBirthdayGateway,
    private val findEnrollmentByUserIdUsecaseImpl: FindEnrollmentByUserIdUsecaseImpl,
    private val findInstalmentsIdsByEnrollmentIdGatewayImpl: FindInstalmentsIdsByEnrollmentIdGatewayImpl,
    private val getInstalmentByIdGatewayImpl: GetInstalmentByIdGatewayImpl,
    private val getCoursePriceByIdImpl: GetCoursePriceByIdGatewayImpl
) : GetUsersByBirthDayUsecase {

    @Scheduled(cron = "*/10 * * * * *")
    override fun execute(): List<User> {
       var users =  findUsersByBirthDayGateway
            .findByBirthDay(LocalDate.of(2001,6, 1).atTime(LocalTime.MIN),
                            LocalDate.of(2001,6, 1).atTime(LocalTime.MAX),)

        var totalPaidAmount = BigDecimal.ZERO;
        var courseTotalPrice = BigDecimal.ZERO;

        var instalmentsIds: MutableList<String> = mutableListOf()

        users
            .forEach{
                user ->

                var enrollments = findEnrollmentByUserIdUsecaseImpl.execute(user.id)

                enrollments.forEach{
                    enrollment ->
                    var sum = getCoursePriceByIdImpl.execute(enrollment.coursePriceId).price.multiply(enrollment.duration.toBigDecimal());
                    courseTotalPrice = courseTotalPrice.add(sum)
                    instalmentsIds.addAll(findInstalmentsIdsByEnrollmentIdGatewayImpl.execute(enrollment.id));
                }

                instalmentsIds.forEach { i ->
                    val dto = getInstalmentByIdGatewayImpl.execute(i);
                    totalPaidAmount = dto.paidAmount;
                }

                println("ID USUARIO: "+ user.id)
                println("NOME USUARIO: "+ user.fullName)
                println("NASCIMENTO USUARIO: "+ user.birthDate)
                println("TOTAL PAGO: "+ totalPaidAmount)
                println("RESTANTE: "+ courseTotalPrice.subtract(totalPaidAmount))
                println("---------------------------------------------------------------------------------------------")
            }

        return users;
    }
}
