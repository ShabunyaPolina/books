package by.shabunya.books.service

import by.shabunya.books.googleapi.GoogleApiConnection
import by.shabunya.books.model.Book
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service

@Service
class BookService(
    private val googleApiConnection: GoogleApiConnection
) {
    private val mapper = jacksonObjectMapper()

    fun findBookByName(name: String): Book {
        val response = googleApiConnection.get(name)
        return mapper.readValue(response, Book::class.java);
    }
}
