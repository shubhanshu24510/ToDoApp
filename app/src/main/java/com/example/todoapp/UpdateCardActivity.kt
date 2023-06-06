package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicquizapp.R
import kotlinx.android.synthetic.main.activity_update_card.delete_button
import kotlinx.android.synthetic.main.activity_update_card.update_button
import kotlinx.android.synthetic.main.create_card.create_priority
import kotlinx.android.synthetic.main.create_card.create_title

class UpdateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).priority
            create_title.setText(title)
            create_priority.setText(priority)

            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                myIntent()
            }
            update_button.setOnClickListener {
                DataObject.updateData(
                    pos,
                    create_title.text.toString(),
                    create_priority.text.toString()
                )
                myIntent()
            }
        }
    }
    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
