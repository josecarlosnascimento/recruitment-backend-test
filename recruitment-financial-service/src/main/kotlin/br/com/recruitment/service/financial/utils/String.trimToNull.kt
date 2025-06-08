package br.com.recruitment.service.financial.utils

fun String?.trimToNull(): String? = this?.trim()?.takeIf { it.isNotEmpty() }
