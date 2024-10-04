package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var icHome: ImageView
    private lateinit var icFlag: ImageView
    private lateinit var icPerson: ImageView
    private lateinit var icHelmet: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        icHome = findViewById(R.id.icHome)
        icFlag = findViewById(R.id.icFlag)
        icPerson = findViewById(R.id.icPerson)
        icHelmet = findViewById(R.id.icHelmet)

        icHome.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,HomeFragment())
                .commit()
        }

        icFlag.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,RacingFragment())
                .commit()
        }

        icPerson.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,AccountFragment())
                .commit()
        }

        icHelmet.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,HelmetFragment())
                .commit()
        }




    }
}