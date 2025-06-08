package br.com.recruitment.service.enrollment.utils

fun String?.trimToNull(): String? = this?.trim()?.takeIf { it.isNotEmpty() }
