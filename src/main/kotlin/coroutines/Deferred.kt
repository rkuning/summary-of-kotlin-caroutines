package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

//Deferred -> nilai tangguhan yang dihasilkan dari proses coroutines.

fun main() = runBlocking {
    val capital = async { getCapital() }
    val income = async { getIncome() }

/*
capital & income diatas merupakan sebuah Deferred dimana jika ingin menampilkan hasilnya, kita membutuhkan function await() seperti dibawah ini
 */

    println("Your profit is ${income.await() - capital.await()}")
}