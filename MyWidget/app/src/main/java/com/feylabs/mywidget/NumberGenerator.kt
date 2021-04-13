package com.feylabs.mywidget

import java.util.*

internal object NumberGenerator {

    fun generateNumber(max: Int): Int {
        val random = Random()
        return random.nextInt(max)
    }
}