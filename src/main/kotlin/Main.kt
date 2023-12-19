fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val flattenedArray = grid.flatMap { it.asIterable() }
    val occurrenceMap = flattenedArray.groupingBy { it }.eachCount()
    val elementsOccurringTwice = occurrenceMap.filter { it.value == 2 }.keys.first()

    val missingElement = (1..grid.size * grid.size).firstOrNull { it !in flattenedArray } ?: 0

    return intArrayOf(elementsOccurringTwice, missingElement)
}

fun main() {
    val grid = arrayOf(
        intArrayOf(9, 1, 7),
        intArrayOf(8, 8, 2),
        intArrayOf(3, 4, 6)
    )

    findMissingAndRepeatedValues(grid)
}