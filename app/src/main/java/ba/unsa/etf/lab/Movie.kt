package ba.unsa.etf.lab

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val homepage: String,
    val genre: String
)