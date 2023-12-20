import kotlin.math.abs

fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val flattenedArray = grid.flatMap { it.asIterable() }
    val occurrenceMap = flattenedArray.groupingBy { it }.eachCount()
    val elementsOccurringTwice = occurrenceMap.filter { it.value == 2 }.keys.first()

    val missingElement = (1..grid.size * grid.size).firstOrNull { it !in flattenedArray } ?: 0

    return intArrayOf(elementsOccurringTwice, missingElement)
}

fun countTestedDevices(batteryPercentages: IntArray): Int {
    var result = 0;
    for (i in batteryPercentages.indices) {
        if (batteryPercentages[i] != 0) {
            result++
            for (j in i + 1..<batteryPercentages.size) {
                if (batteryPercentages[j] >= 1) {
                    batteryPercentages[j]--
                }
            }
        }
    }
    return result
}

fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    val result: IntArray = intArrayOf(0, 0)

    nums1.forEach outer@ { element1 ->
        nums2.forEach inner@ { element2 ->
            if (element1 == element2) {
                result[0]++
                return@outer
            }
        }
    }

    nums2.forEach outer@ { element1 ->
        nums1.forEach inner@ { element2 ->
            if (element1 == element2) {
                result[1]++
                return@outer
            }
        }
    }

    return result
}

fun findPeaks(mountain: IntArray): List<Int> {
    val result: MutableList<Int> = mutableListOf()

    for (i in mountain.indices) {
        if (i > 0 && i < mountain.size - 1
            && (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1])) {
            result.add(i)
        }
    }
    return result
}

fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
    for (i in mat.indices) {
        for (j in mat[i].indices) {
                if (mat[i][j] != mat[i][(j + abs((i % 2 - 1) * k)) % k])
                    return false
        }
    }
    return true
}

fun main() {
    val grid = arrayOf(
        intArrayOf(9, 1, 7),
        intArrayOf(8, 8, 2),
        intArrayOf(3, 4, 6)
    )

    //findMissingAndRepeatedValues(grid)
    //countTestedDevices(intArrayOf(1, 1, 2, 1, 3))
    findIntersectionValues(intArrayOf(4,3,2,3,1), intArrayOf(2,2,5,2,3,6))
}