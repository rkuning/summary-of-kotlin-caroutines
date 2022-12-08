package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis



fun main() = runBlocking{

    val timeOne = measureTimeMillis {
        val capital = getCapital()
        val income = getIncome()
        println("Your profit is ${income - capital}")
    }

    val timeTwo = measureTimeMillis {
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await() - capital.await()}")
    }

    println("Completed in $timeOne ms vs $timeTwo ms")

}