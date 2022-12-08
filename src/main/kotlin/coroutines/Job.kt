package coroutines

import kotlinx.coroutines.*

//Job -> sebuah hasil dari perintah async yang dijalankan.
// punya 3 property yaitu isActive, isCompleted, isCancelled
/*
isActive -> job sedang aktif
isCompleted -> job telah selesai
isCancelled -> job telah dibatalkan

state pada job :
New -> job telah di inisiasi tapi belum pernah dijalankan.
Active -> job memiliki status aktif ketika ia sedang berjalan. job yang sedang ditangguhkan juga termasuk dalam job Active
Completed -> ketika job tidak berjalan lagi.
Cancelling -> kondisi ketika fungsi cancel() dipanggil pada job yang sedang aktif dan memerlukan waktu untuk pembatalan tsb
Cancelled -> job yang sudah ebrhasil dibatalkan.
 */

//membuat Job Baru

fun main() = runBlocking {
//  menggunakan launch()
    val job = launch {
        delay(1000L)
        println("Start job!")
    }

//menggunakan Job()
    val job2 = Job()

//    setelah diinisiasi seperti diatas, job akan otomatis punya state New dan langsung dijalankan.
//    jika ingin membuat job tanpa langsung menjalankan, bisa memanfaatkan CoroutineStart.LAZY sbb :
    val job3 = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("Start new Job!")
    }

//    menjalankan job dengan fungsi start()
    job.start()
//    menjalankan job dengan fungsi join()
    job3.join()
    println("Other task!")

//    perbedaan start() dan join()
    /*
    start -> memulai job tanpa menunggu job tersebut selesai.
    output :
    Other task!
    Start Job!

    join -> menunda eksekusi sampai job selesai.
    Start new Job!
    Other task!

     */

//    setelah jalan, job akan punya state Active


}

