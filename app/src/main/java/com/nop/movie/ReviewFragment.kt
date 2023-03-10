package com.nop.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReviewFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reviewObj = Review(R.drawable.avatar, "6.2", "John Doe","From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.")
        val reviewList = arrayOf(reviewObj, reviewObj)
        recyclerView = view.findViewById(R.id.rv_reviews)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ReviewAdapter(reviewList)
    }
}