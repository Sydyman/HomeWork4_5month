package com.ex.homework4_5month

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ex.homework4_5month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewNodel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnPlus.setOnClickListener {
                viewNodel.increment()
            }

            btnMinus.setOnClickListener {
                viewNodel.decrement()
            }
        }
        viewNodel.counterData.observe(this){count ->
            binding.tvRes.text = count.toString()
            viewNodel.showResult(this)
        }
        viewNodel.colorData.observe(this){color ->
            binding.tvRes.setTextColor(ContextCompat.getColor(this,color))

        }


    }
}