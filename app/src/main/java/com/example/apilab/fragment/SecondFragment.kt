package com.example.apilab.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.apilab.adapter.AnimalAdapter
import com.example.apilab.model.Animal
import com.example.apilab.network.ApiClient
import com.example.apilab.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var adapter: AnimalAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchEditText: EditText = view.findViewById(R.id.Search_input)
        val searchButton: Button = view.findViewById(R.id.searchButton)

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            adapter.filter(query)

        }


        val client = ApiClient.instance

        val response = client.fetchAnimalList()


        response.enqueue(object : Callback<List<Animal>> {

            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                

                response.body()?.let {
                    adapter = AnimalAdapter(it)
                    recyclerView = view.findViewById(R.id.recyclerview)
                    recyclerView.adapter = adapter
                    adapter.submitList(it)
                }
            }

            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {

            }
        })
    }
}