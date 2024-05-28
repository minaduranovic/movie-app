package ba.unsa.etf.lab.data

import androidx.room.Embedded
import androidx.room.Relation
import ba.unsa.etf.lab.data.Cast
import ba.unsa.etf.lab.data.Movie


data class MovieWithCast(
    @Embedded val movie : Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "fromMovieId"
    )
    val cast:List<Cast>
){

}