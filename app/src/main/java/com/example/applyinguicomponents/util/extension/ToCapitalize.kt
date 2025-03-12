package com.example.applyinguicomponents.util.extension

fun String.toCapitalizeString(): String = this.lowercase().replaceFirstChar {
    it.titlecase()
}