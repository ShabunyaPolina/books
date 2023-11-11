package by.shabunya.books

import by.shabunya.books.googleapi.GoogleApiConnection
import by.shabunya.books.service.BookService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BooksApplication

fun main(args: Array<String>) {
    runApplication<BooksApplication>(*args)

//    val googleApiConnection = GoogleApiConnection()
//    val bookService = BookService(googleApiConnection)
//    println(bookService.findBookByName("муму"))
}
