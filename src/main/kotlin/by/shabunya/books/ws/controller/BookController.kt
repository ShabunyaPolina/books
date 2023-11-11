package by.shabunya.books.ws.controller

import by.shabunya.books.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(private val bookService: BookService) {
    @GetMapping("/")
    fun find(@RequestParam("name") name: String) = bookService.findBookByName(name)
}
