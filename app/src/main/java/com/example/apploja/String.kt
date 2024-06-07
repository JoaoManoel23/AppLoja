package com.example.apploja

fun String.convertToMoneyWithSymbol() = "R$".plus(this.replace(".", ","))