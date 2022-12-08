package coroutines

import kotlinx.coroutines.*

//run blccking -> memulai coroutien utama
fun main() = runBlocking {

//    launch -> menjalankan coroutine baru
    launch {
//        delay -> jeda waktu tampilnya kode prinlen dibawhanya adlaah 1dt
        delay(1000L)
        print("Coroutines!")
    }
    println("Hello,")
//    delay dibawah artinya jarak waktu sebelum berhentinya program adalah 2dt
    delay(2000L)

}