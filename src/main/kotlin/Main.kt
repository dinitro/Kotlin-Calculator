//fun main(args: Array<String>) {
//    println("Hello World!")
//
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//}

import java.util.*


fun main() {
    Locale.setDefault(Locale.US)
    val scanner = Scanner(System.`in`)
    var running = true

    while (running) {
        println("Select an operation: +, -, *, /, % (or type 'exit' to quit)")
        val operation = scanner.nextLine()

        if (operation == "exit") {
            running = false
            continue
        }

        try {
            println("Enter the first number:")
            val num1 = scanner.nextDouble()
            println("Enter the second number:")
            val num2 = scanner.nextDouble()
            scanner.nextLine()

            val result = when (operation) {
                "+" -> add(num1, num2)
                "-" -> subtract(num1, num2)
                "*" -> multiply(num1, num2)
                "/" -> divide(num1, num2)
                "%" -> modulo(num1, num2)
                else -> throw IllegalArgumentException("Invalid operation.")
            }

            println("The result is $result")
        } catch (e: InputMismatchException) {
            println("Invalid input.")
            scanner.nextLine()
        } catch (e: Exception) {
            println(e.message)
        }
    }
}

fun add(a: Double, b: Double): Double {
    return a + b
}

fun subtract(a: Double, b: Double): Double {
    return a - b
}

fun multiply(a: Double, b: Double): Double {
    return a * b
}

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) {
        throw ArithmeticException("Cannot divide by zero.")
    }
    return a / b
}

fun modulo(a: Double, b: Double): Double {
    return a % b
}