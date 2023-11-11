package by.shabunya.books.deserialization

import by.shabunya.books.model.Book
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer


class BookDeserializer @JvmOverloads constructor(vc: Class<*>? = null) : StdDeserializer<Book?>(vc) {

    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Book {
        val node: JsonNode = p.codec.readTree(p)

        val bookItem = node.get("items").get(0)
        val bookInfo = bookItem.get("volumeInfo")

        return Book(
            bookInfo.get("title").asText(),
            bookInfo.get("subtitle")?.asText(),
            bookInfo.get("authors")?.get(0)?.asText(),
            bookInfo.get("description")?.asText()
        )
    }
}
