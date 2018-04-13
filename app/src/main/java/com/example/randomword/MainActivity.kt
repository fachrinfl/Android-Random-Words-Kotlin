package com.example.randomword

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val listWord = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar:Toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle("Randow words")
        setSupportActionBar(toolbar)

        btnAddWord.setOnClickListener {
            if (edtWord.length() < 3){
                Toast.makeText(this, "Your word is too short", Toast.LENGTH_SHORT).show()
            } else if(edtWord.length() > 12){
                Toast.makeText(this, "Your word is too long", Toast.LENGTH_SHORT).show()
            }else {
                val newWord = edtWord.text.toString()
                listWord.add(newWord)
                edtWord.text.clear()
                tvNumberWord.text = "The number of words you have : ${listWord.size}"
                tvSelectedWord.text = newWord
                println(listWord)
            }
        }

        btnRandom.setOnClickListener {

            if (listWord.size < 5){
                Toast.makeText(this, "Input more words", Toast.LENGTH_SHORT).show()
            } else {
                val random = Random()
                val randomWord = random.nextInt(listWord.count())
                tvSelectedWord.text = listWord[randomWord]
            }
        }
    }
}
