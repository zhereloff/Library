package org.example
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val library: Library = Library()

    try {
        val suitableBook = library.chooseBook(100, "title test", "author test")
        println("Подходящая книга $suitableBook")
    } catch (e: BookNotFoundException) {
        logger.error(e) {
            "Exception caught in library.chooseBook(..)"
        }
    }

    println("Первые 10 отсортированных книг:")
    library.sortedBooks.take(10).forEach(::println)

    println("Конец программы")
}