package com.example.roomrickmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomrickmorty.ui.main.MainFragment
import com.example.roomrickmorty.ui.main.MenuFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MenuFragment())
                    .commitNow()
        }
    }
}