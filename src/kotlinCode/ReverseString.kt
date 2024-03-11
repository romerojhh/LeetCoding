package kotlinCode

class ReverseString(val s: CharArray) {
    operator fun invoke() {
        // romero hutapea
        // aepatuh oremor
        var left = 0
        var right = s.size - 1
        var temp: Char
        while (left < right) {
            temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }
}

fun main() {
    val r = ReverseString("romero hutapea".toCharArray())
    r.invoke()
    println(r.s)
}
