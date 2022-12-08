package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun getCapital() : Int {
    delay(1000L)
    return 50000
}

suspend fun getIncome() : Int {
    delay(1000L)
    return 75000
}

fun main() = runBlocking {
//    cara sequential -> dijalankan secara berurutan seperti kode normal
    val capital = getCapital()
    val income = getIncome()

    println("Your profit is ${income - capital}")

    println("async")

//    cara async -> tidak ada ketergantungan antara 2 object shg dijalankan secara bersamaan
    val cap = async { getCapital() }
    val inc = async { getIncome() }
    println("Your profit is ${inc.await() - cap.await()}")

}