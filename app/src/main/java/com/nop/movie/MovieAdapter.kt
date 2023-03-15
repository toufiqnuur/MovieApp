package com.nop.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MovieAdapter(var movie: Array<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var onItemClickListener: ((Movie) -> Unit)? = null

    inner class MovieViewHolder(view: View): ViewHolder(view) {
        private val poster = view.findViewById<ImageView>(R.id.iv_poster)
        private val name = view.findViewById<TextView>(R.id.tv_movie_name)
        private val date = view.findViewById<TextView>(R.id.tv_movie_release)
        private val rate = view.findViewById<TextView>(R.id.tv_movie_rate)

        fun bind(movie: Movie) {
            poster.setImageResource(movie.poster)
            name.text = movie.title
            date.text = movie.date
            rate.text = movie.rating
        }
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movie[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(movie[position])
        }
    }

     fun updateItem(newMovie: Array<Movie>) {
        movie = newMovie
        notifyDataSetChanged()
    }
}