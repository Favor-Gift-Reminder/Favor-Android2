package com.appcenter.favor

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.appcenter.favor.UI.Onboard.OnboardFragment
import com.appcenter.favor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(mainLooper).postDelayed({
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(binding.container.id, OnboardFragment())
                .commit()
        }, 1500)
    }
}