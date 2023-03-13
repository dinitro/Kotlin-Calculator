//fun main(args: Array<String>) {
//    println("Hello World!")
//
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//}

import java.util.*


// Functions for performing calculations
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

// Function for getting the symbol of the operation
fun getOperationSymbol(choice: Int): String {
    return when (choice) {
        1 -> "+"
        2 -> "-"
        3 -> "*"
        4 -> "/"
        5 -> "%"
        else -> throw IllegalArgumentException("Invalid choice")
    }
}


fun main() {
    Locale.setDefault(Locale.US)
    val scanner = Scanner(System.`in`)
    val results = mutableListOf<Double>()
    val operations = mutableListOf<String>()

    while (true) {
        // Display menu and prompt for choice
        println("Select an operation:")
        println("1. Add")
        println("2. Subtract")
        println("3. Multiply")
        println("4. Divide")
        println("5. Modulo")
        println("6. Show Results")
        println("7. Exit")
        print("Choice: \n")
        val choice = scanner.nextInt()

        // Exit program if user chooses 7
        if (choice == 7) {
            println("Goodbye!")
            break
        }

        // Display results
        if (choice == 6) {
            if (results.isEmpty()) {
                print("No results stored \n")
            } else {
                println("\nResults:")
                for (i in 0 until results.size) {
                    println("${i + 1}) ${operations[i]} = ${results[i]}")
                }
            }
            println()
            continue
        }

        try {
            // Prompt user for numbers
            println("Enter the first number:")
            val num1 = scanner.nextDouble()
            println("Enter the second number:")
            val num2 = scanner.nextDouble()
            scanner.nextLine()

            // Perform operation based on user choice
            val result = when (choice) {
                1 -> add(num1, num2)
                2 -> subtract(num1, num2)
                3 -> multiply(num1, num2)
                4 -> divide(num1, num2)
                5 -> modulo(num1, num2)
                else -> throw IllegalArgumentException("Invalid operation.")
            }

            // Add result and operation to lists and print result
            val operation = getOperationSymbol(choice)
            operations.add("$num1 $operation $num2")
            results.add(result)
            // Print result
            println()
            println("The result is $result\n")
        } catch (e: InputMismatchException) {
            // Handle invalid input
            println("Invalid input.\n")
            scanner.nextLine()
        } catch (e: Exception) {
            // Handle other exceptions
            println(e.message)
        }
    }
}