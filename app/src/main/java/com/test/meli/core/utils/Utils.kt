package com.test.meli.core.utils

import java.util.UUID
import kotlin.random.Random

fun getRandomPrice(): Double = Random.nextDouble(from = 9999.9, until = 999999.9)

fun getGuid(): String = UUID.randomUUID().toString()