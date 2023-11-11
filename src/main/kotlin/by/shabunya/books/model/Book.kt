package by.shabunya.books.model

import by.shabunya.books.deserialization.BookDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = BookDeserializer::class)
data class Book(
    val title: String,
    val subtitle: String?,
    val authors: String?,
    val description: String?
)
