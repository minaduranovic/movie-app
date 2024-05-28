package ba.unsa.etf.lab

import ba.unsa.etf.lab.data.Movie
import ba.unsa.etf.lab.data.getFavoriteMovies
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers.hasProperty
import org.junit.Test

import org.hamcrest.MatcherAssert.assertThat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {
    @Test
    fun testGetFavoriteMovies(){
        val movies = getFavoriteMovies()
        assertEquals(movies.size, 6)
        assertThat(
            movies,
            hasItem<Movie>(
                hasProperty(
                    "title",
                    `is`("Pulp Fiction")
                )
            )
        )
        assertThat(
            movies,
            not(
                hasItem<Movie>(
                    hasProperty(
                        "title",
                        `is`("Black Widow")
                    )
                )
            )
        )
    }
}
