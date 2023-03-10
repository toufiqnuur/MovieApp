package com.nop.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class HashtagAdapter(private val hashtag: Array<String>): RecyclerView.Adapter<HashtagAdapter.HashtagViewHolder>() {
    inner class HashtagViewHolder(view: View): ViewHolder(view) {
        private val hashtag = view.findViewById<TextView>(R.id.tv_hashtag)

        fun bind(tag: String) {
            hashtag.text = tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HashtagViewHolder {
        return HashtagViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hashtag, parent, false))
    }

    override fun getItemCount(): Int {
        return hashtag.size
    }

    override fun onBindViewHolder(holder: HashtagViewHolder, position: Int) {
        holder.bind(hashtag[position])
    }
}