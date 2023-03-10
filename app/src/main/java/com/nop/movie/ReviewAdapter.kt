package com.nop.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ReviewAdapter(private val reviews: Array<Review>): RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    inner class ReviewViewHolder(view: View): ViewHolder(view) {
        private val avatar = view.findViewById<ImageView>(R.id.iv_avatar)
        private val rate = view.findViewById<TextView>(R.id.tv_rate)
        private val username = view.findViewById<TextView>(R.id.tv_username)
        private val details = view.findViewById<TextView>(R.id.tv_details)

        fun bind(reviews: Review) {
            avatar.setImageResource(reviews.avatar)
            rate.text = reviews.rate
            username.text = reviews.username
            details.text = reviews.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.review, parent, false))
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

}