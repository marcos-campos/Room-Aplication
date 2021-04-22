package com.example.roomrickmorty.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrickmorty.R
import com.example.roomrickmorty.adapter.AdapterPersonagem
import com.example.roomrickmorty.model.Result
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    val recycler by lazy { view?.findViewById<RecyclerView>(R.id.recycler_main_personagem) }
    private var listPersonagens = mutableListOf<Result>()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler?.layoutManager = LinearLayoutManager(activity)

        val adapter = activity?.let { AdapterPersonagem(listPersonagens, it) }
        recycler?.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.pegarPersonagemCoroutineOk()
        viewModel.personagemLiveData.observe(this, Observer {
            listPersonagens.addAll(it)

            adapter?.notifyDataSetChanged()
        })

    }
}