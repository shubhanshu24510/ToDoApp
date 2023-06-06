package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.create_card.create_priority
import kotlinx.android.synthetic.main.create_card.create_title
import kotlinx.android.synthetic.main.create_card.save_button

class CreateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_card)
        save_button.setOnClickListener {
            if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_priority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                var title = create_title.text as String
                var priority = create_priority.text as String
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}