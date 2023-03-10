package com.nop.movie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nop.movie.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Category Adapter
        val categoryList = arrayOf("Top Rated","Popular","Action 1","Action 2","Action 3")
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = CategoryAdapter(categoryList)

        // Movie Adapter
        val movieObj = Movie(R.drawable.movie, "Avangers End Game", "2019-08-03", "9.2", "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.", "1466", "48.261.451")
        val movieList = arrayOf(movieObj, movieObj, movieObj, movieObj)
        val movieAdapter = MovieAdapter(movieList)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = movieAdapter

        movieAdapter.onItemClickListener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("movie", it)
            startActivity(intent)
        }
    }
}