package br.com.recruitment.service.financial.application.service

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.TimeUnit

@Service
class RedisLockService(private val redisTemplate: StringRedisTemplate) {
    @Throws(InterruptedException::class)
    fun tryLock(
        key: String,
        waitTimeMillis: Long,
        leaseTimeMillis: Long,
    ): String? {
        val lockValue = UUID.randomUUID().toString()

        val deadline = System.currentTimeMillis() + waitTimeMillis

        while (System.currentTimeMillis() < deadline) {
            val success =
                redisTemplate.opsForValue()
                    .setIfAbsent(key, lockValue, leaseTimeMillis, TimeUnit.MILLISECONDS)

            if (success == true) {
                return lockValue
            }

            Thread.sleep(100)
        }

        return null
    }

    fun releaseLock(
        key: String,
        lockValue: String,
    ) {
        val currentValue = redisTemplate.opsForValue()[key]

        if (lockValue == currentValue) {
            redisTemplate.delete(key)
        }
    }
}
