package kotlinCode

import kotlin.collections.ArrayDeque

fun main() {
    val a = "abcba"
    val b = "abccba"
    val c = "abcd"

    println(isPalindrome(a))
    println(isPalindrome(b))
    println(isPalindrome(c))
}

fun isPalindrome(string: String): Boolean {
    // abcba = true
    // abccba = true
    // abcd = false
    var midIdx = -1
    if (string.length % 2 != 0) {
        midIdx = (string.length - 1) / 2
    }

    val stack = ArrayDeque<Char>()
    for(i in string.indices) {
        if (i == midIdx) continue

        if (stack.isNotEmpty() && stack.first() == string[i]) {
            stack.removeFirst()
        } else {
            stack.addFirst(string[i])
        }
    }

    return stack.size == 0
}