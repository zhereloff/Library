package org.example

data class Book (
    var title: String,
    val price: Int,
    val author: String
): Comparable<Book> {
    override fun compareTo(other: Book): Int {

        val titleCompare = this.title.compareTo(other.title)
        if (titleCompare != 0) return titleCompare

        val authorCompare = this.author.compareTo(other.author)
        if (authorCompare != 0) return authorCompare

        return other.price.compareTo(this.price)
    }
}