package kotlinCode

fun main() {
    println(fibonacci(10))
}

/**
 * Get fibonacci number at n'th order
 *
 * @param order the order of the fibonacci number
 */
fun fibonacci(order: Int): Int {
    if (order == 1) return 0
    else if (order == 2) return 1
    val sum = fibonacci(order - 2) + fibonacci(order - 1)
    return sum
}