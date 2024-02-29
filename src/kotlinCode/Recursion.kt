package kotlinCode

import kotlin.math.absoluteValue

fun main() {
    println(multiplyTwo(-10.0))
    var a = -10.0
    do {
        a *= 1.5
    } while (a.absoluteValue <= 1000)
    println(a)
}

fun multiplyTwo(double: Double): Double {
    if (double.absoluteValue > 1000) return double
    return multiplyTwo(double * 1.5)
}