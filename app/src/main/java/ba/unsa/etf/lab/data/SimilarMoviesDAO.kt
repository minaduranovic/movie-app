package ba.unsa.etf.lab.data

import androidx.room.*
import ba.unsa.etf.lab.data.Movie
import ba.unsa.etf.lab.data.SimilarMovies

@Dao
interface SimilarMoviesDAO {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun insert(join: SimilarMovies)

    @Transaction
    @Delete
    suspend fun deleteSimilar(join: SimilarMovies)

    @Transaction
    @Delete
    suspend fun deleteSimilarMovies(smovies:List<Movie>)

}