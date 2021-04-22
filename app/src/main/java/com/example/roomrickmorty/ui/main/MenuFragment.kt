package com.example.roomrickmorty.ui.main

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomrickmorty.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MenuFragment: Fragment() {
    val bottomNavigation by lazy { view?.findViewById<BottomNavigationView>(R.id.bottomNavigationView) }
    companion object {
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setCurrentFragment(MainFragment())

        bottomNavigation?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(MainFragment())
                R.id.favoritos -> setCurrentFragment(FavoritosFragment())
            }
            true
        }
    }
    fun setCurrentFragment(fragment: Fragment)=
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}

