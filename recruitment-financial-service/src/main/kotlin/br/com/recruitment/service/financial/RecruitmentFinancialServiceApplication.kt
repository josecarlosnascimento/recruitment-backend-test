package br.com.recruitment.service.financial

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import java.net.InetAddress
import java.util.*

@EnableAutoConfiguration(
    exclude = [
        SecurityAutoConfiguration::class,
        ManagementWebSecurityAutoConfiguration::class,
    ],
)
@SpringBootApplication
class RecruitmentFinancialServiceApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("utc"))
    val env = runApplication<RecruitmentFinancialServiceApplication>(*args).environment
    val appName = env.getProperty("spring.application.name")
    val protocol = if (env.getProperty("server.ssl.key-store", "").isBlank()) "http" else "https"
    val port = env.getProperty("server.port", "8080")

    loggerFor<RecruitmentFinancialServiceApplication>().info(
        """
        ----------------------------------------------------------
        Application '$appName' is running! Access URLs:
        Local:      $protocol://localhost:$port
        External:   $protocol://${InetAddress.getLocalHost().hostAddress}:$port
        Profile(s): ${env.activeProfiles.joinToString()}
        ----------------------------------------------------------
        """.trimIndent(),
    )
}

inline fun <reified T> loggerFor(): Logger = LoggerFactory.getLogger(T::class.java)
