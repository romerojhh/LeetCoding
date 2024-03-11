package kotlinCode

import kotlin.collections.ArrayDeque

fun main() {
    val a = "abcba"
    val b = "abccba"
    val c = "abcd"

    println(isPalindrome(a))
    println(isPalindrome(b))
    println(isPalindrome(c))

    println(isPalindromeUsingTwoPointers(a))
    println(isPalindromeUsingTwoPointers(b))
    println(isPalindromeUsingTwoPointers(c))
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

fun isPalindromeUsingTwoPointers(string: String): Boolean {
    var left = 0
    var right = string.length - 1

    while (left <= right) {
        if (string[left] == string[right] || left == right) {
            left++
            right--
        } else {
            return false
        }
    }

    return true
}