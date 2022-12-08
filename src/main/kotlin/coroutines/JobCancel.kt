package coroutines

import kotlinx.coroutines.*

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking {
    val job = launch {
        delay(5000)
        println("Start new Job!")
    }
    delay(2000)
//    cancel() -> membatalkan job
//    job.cancel()
//    cancel() dapat ditambah parameter cause yaitu alasan kenaapa job dibatalkan
//    pesan pada cause dapat di akses dengan cara getCancellationException().message
    job.cancel(cause = CancellationException("Time is up!"))

    println("Cancelling job...")
    if (job.isCancelled) {
//        mengakses pesan cause pada function cancel()
        println("Job is cancelled because${job.getCancellationException().message}")
    }
}