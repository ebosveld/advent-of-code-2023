fun main() {
    val digits = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    fun determineCalibrationValue(input: List<String>, useNames: Boolean): Int {
        val sum = input.sumOf { s ->
            val d = buildString {
                for (i in s.indices) when (s[i]) {
                    in '0'..'9' -> append(s[i])
                    else -> {
                        if(useNames) {
                            val ss = s.substring(i)
                            for (j in 1..9) if (ss.startsWith(digits[j])) {
                                append('0' + j)
                            }
                        }
                    }
                }
            }

            "${d.first()}${d.last()}".toInt()
        }
        return sum
    }

    fun part1(input: List<String>): Int {
        return determineCalibrationValue(input, false)
    }

    fun part2(input: List<String>): Int {
        return determineCalibrationValue(input, true)
    }

    // test if implementation meets criteria from the description, like:
    val testInput_part1 = readInput("day01_test_part1")
    check(part1(testInput_part1) == 142)

    val testInput_part2 = readInput("day01_test_part2")
    check(part2(testInput_part2) == 281)

    val input = readInput("day01")
    part1(input).println()
    part2(input).println()
}
