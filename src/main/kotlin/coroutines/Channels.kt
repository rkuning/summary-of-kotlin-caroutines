package coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Channels -> nilai deferred yang menyediakan cara mudah untuk mentrasnfer niai tunggal antar coroutine.
 */

fun main() = runBlocking(CoroutineName("main")) {
    val channel = Channel<Int>()
    launch(CoroutineName("v1coroutine")){
        println("Sending from ${Thread.currentThread().name}")
        for (x in 1..5) channel.send(x * x)
    }

    repeat(5) { println(channel.receive())}
    println("Received in ${Thread.currentThread().name}")
}