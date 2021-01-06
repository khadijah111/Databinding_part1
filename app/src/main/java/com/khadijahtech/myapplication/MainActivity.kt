package com.khadijahtech.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.khadijahtech.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //button = findViewById<Button>(R.id.click_button)

        binding.clickButton.setOnClickListener {
            binding.clickButton.text = "Button 1 clicked"
            Toast.makeText(this, "hello kotlin", Toast.LENGTH_LONG).show()
            produceRandom()
        }

    }

    private fun produceRandom() {

        val randomNum = Random.nextInt(10) + 1

        val imageResource = when (randomNum) {
            1 -> R.drawable.black
            2 -> R.drawable.green
            3 -> R.drawable.blue
            4 -> R.drawable.yellow
            else -> R.drawable.pink
        }
        binding.numberTextView.setText(randomNum.toString())
        binding.image.setImageResource(imageResource)

        binding.invalidateAll()
    }


}