package com.yogesh.mvidemo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yogesh.mvidemo.databinding.ActivityMainBinding
import com.yogesh.mvidemo.ui.intents.MainIntents
import com.yogesh.mvidemo.ui.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        attachObservers()
        clickHandling()

    }

    private fun clickHandling() {
        binding.btn.setOnClickListener {
            mainViewModel.fireIntent(MainIntents.GetFact)
            binding.loader.visibility = View.VISIBLE
        }
    }

    private fun attachObservers() {
        mainViewModel.catFactFailure.observe(this) {
            binding.loader.visibility = View.GONE
            binding.tv.text = it
        }

        mainViewModel.catFactSuccess.observe(this) {
            binding.loader.visibility = View.GONE
            binding.tv.text = it.fact
        }
    }
}