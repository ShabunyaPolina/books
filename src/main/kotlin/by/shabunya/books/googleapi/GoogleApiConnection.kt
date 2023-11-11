package by.shabunya.books.googleapi

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Component
class GoogleApiConnection {
    private val urlPrefix = "https://www.googleapis.com/books/v1/volumes?q=intitle:"

    fun get(name: String): String {
        val url = URL(urlPrefix + name)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.doOutput = true

        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        var line: String?
        val response = StringBuilder()
        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }
        reader.close()

        println(response.toString())
        return response.toString()
    }
}
