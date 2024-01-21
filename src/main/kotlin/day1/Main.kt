package day1

import java.io.File

fun main() {
    val encodedCalibrations = File("src/main/resources/1.txt").readLines()
    val solution = sumOfCalibrationValues(encodedCalibrations)

    println("The sum of the all the calibration values are:")
    println(solution)
}

fun sumOfCalibrationValues(encodedCalibration: List<String>): Int {
    var calibrationsSum = 0

    for (encodedCalibrationLine in encodedCalibration) {
        var calibrationNumber = ""
        val codeToChar = encodedCalibrationLine.toCharArray()

        for (char in codeToChar) {
            if (char.digitToIntOrNull() != null) {
                calibrationNumber += char
                break
            }
        }

        for (charIndexed in codeToChar.size - 1 downTo 0) {
            if (codeToChar[charIndexed].digitToIntOrNull() != null) {
                calibrationNumber += codeToChar[charIndexed]
                break
            }
        }
        calibrationsSum += (calibrationNumber.toInt())
    }
    return calibrationsSum
}