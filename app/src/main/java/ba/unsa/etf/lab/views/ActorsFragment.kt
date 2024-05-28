package ba.unsa.etf.lab.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.unsa.etf.lab.R
import ba.unsa.etf.lab.adapters.SimpleCastStringAdapter
import ba.unsa.etf.lab.data.ActorMovieRepository
import ba.unsa.etf.lab.data.Cast
import ba.unsa.etf.lab.data.GetCastResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
class ActorsFragment() : Fragment() {
    private lateinit var actorsRV: RecyclerView
    private var actorsList = listOf<Cast>()
    private lateinit var actorsRVSimpleAdapter: SimpleCastStringAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_actors, container, false)
        val intent = requireActivity().intent
        val extras = intent.extras

        if (extras != null) {
            if (extras.containsKey("movie_id")) {
                getActorsById(extras.getLong("movie_id"))
            }
        }

        actorsRV = view.findViewById<RecyclerView>(R.id.listActors)
        actorsRV.layoutManager = LinearLayoutManager(activity)
        actorsRVSimpleAdapter = SimpleCastStringAdapter(actorsList)
        actorsRV.adapter = actorsRVSimpleAdapter
        return view
    }

    fun getActorsById(query: Long) {

        val scope = CoroutineScope(Job() + Dispatchers.Main)
        scope.launch {
            val result = ActorMovieRepository.getCast(query)
            when (result) {
                is GetCastResponse -> actorsRetrieved(result.cast)
                else -> Log.v("meh", "meh")
            }
        }
    }

    fun actorsRetrieved(actors: List<Cast>) {
        actorsList = actors
        actorsRVSimpleAdapter.list = actors;
        actorsRVSimpleAdapter.notifyDataSetChanged();
    }
}