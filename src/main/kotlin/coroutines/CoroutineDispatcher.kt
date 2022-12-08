package coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/*
Coroutine Dispatcher -> untuk mengetahui thread mana yang akan digunakan untuk menjalankan dan melanjutkan sebuah
coroutine.

DIspatcher.Default -> dispatcher dasar yang digunakna oleh semuat standar builder ex : launch, async, dll.
cara menggunakannya : cukup menggunakan coroutines builder tanpa harus menuliskan dispatcher secara spesific.
ex :
cara 1 :
launch {
// TODO ()
}

cara 2 :
launch(Dispatcher.Default) {
// TODO
}


Dispatcher.IO -> dispatcher yang digunakan untuk membongkar pemblokiran operasi I/O.
launch(Dispatcher.IO) {
// TODO
}

Dispatcher.Unconfined -> dispatcher ini akan menjalankan coroutines pada thread yang sedang berjalan sampai mencapai titik
penangguhan. Setelah penangguhan, coroutines akan dilanjutkan pada thread dimana komputasi penangguhan yang dipanggil.

ex : fungsi A memanggil fungsi B yang dijalankan dengan dispatcher dalam thread tertentu. fungsi A akan dilanjutkan dalam thread yang sama
dengan fungsi B dijalankan.


Single Thread Context -> Dispatcher ini menjamin bahwa setiap saat coroutine akan dijalankan pada thread yang anda tentukan.
bisa memakai newSingleThreadContext()

Thread Pool -> Dispatcher yang memiliki kumpulan thread. deklarasinya dengan memakai newFixedThreadPoolCOntext()
 */

fun main() = runBlocking<Unit> {
//    val default = launch(Dispatchers.Default) {
//        println("Dispatcher.Default")
//    }
//    val io = launch(Dispatchers.IO) {
//        println("DIspatcher IO")
//    }
//
//    val unCOnfined = launch(Dispatchers.Unconfined) {
//        println("Starting in ${Thread.currentThread().name}")
//        delay(1000)
//        println("Resuming in ${Thread.currentThread().name}")
//    }
//    unCOnfined.start()
//    println("data")

//    Single Thread Context
//    val dispatcher = newSingleThreadContext("myThread")
//    launch(dispatcher) {
//        println("Starting in ${Thread.currentThread().name}")
//        delay(1000)
//        println("Resuming in ${Thread.currentThread().name}")
//    }.start()

//    Thread Pool
    val dispatcherPool = newFixedThreadPoolContext(3, "MyPool")
    launch(dispatcherPool){
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}