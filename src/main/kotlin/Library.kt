package org.example


class BookNotFoundException(message: String): Exception(message)


class Library (
){
    private var _books: MutableList<Book> = mutableListOf(Book("title test", 100, "author test"))
    val books: List<Book> get() = _books.toList()

    val sortedBooks: List<Book>
        get() = _books.sorted()

    init {
        repeat(1000) {
            _books.add(getRandomBook(1,200, 100,100))
        }
    }

    fun chooseBook(maxPrice: Int, title: String, authorName: String): Book? {
        val suitableBook = books.filter {
            it.price <= maxPrice &&
            it.title == title &&
            it.author == authorName}

        return suitableBook.firstOrNull()?: throw BookNotFoundException("Book with this title, author or price do not found")

    }

    private fun getRandomBook(minPrice: Int, maxPrice: Int, NumOfAuthor: Int, NumOfTitle: Int): Book {

        val randomBookPrice = (minPrice..maxPrice).random()
        val randomAuthorNumber = (1..NumOfAuthor).random()
        val randomTitleNumber = (1.. NumOfTitle).random()

        return Book("title $randomTitleNumber", randomBookPrice, "author $randomAuthorNumber")
    }

}
