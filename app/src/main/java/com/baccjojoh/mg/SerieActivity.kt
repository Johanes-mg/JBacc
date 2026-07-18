package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SerieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)

        val type = intent.getStringExtra("type")
        val title = findViewById<TextView>(R.id.title)
        val btn1 = findViewById<Button>(R.id.btn_option1)
        val btn2 = findViewById<Button>(R.id.btn_option2)
        val retour = findViewById<Button>(R.id.btn_retour)

        if (type == "scientifique") {
            title.text = "Parcours Scientifique"
            btn1.text = "Serie C"
            btn2.text = "Serie D"
            btn1.setOnClickListener {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("serie", "Serie C")
                startActivity(intent)
            }
            btn2.setOnClickListener {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("serie", "Serie D")
                startActivity(intent)
            }
        } else {
            title.text = "Parcours Litteraire"
            btn1.text = "Serie A1"
            btn2.text = "Serie A2"
            btn1.setOnClickListener {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("serie", "Serie A1")
                startActivity(intent)
            }
            btn2.setOnClickListener {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("serie", "Serie A2")
                startActivity(intent)
            }
        }
        retour.setOnClickListener { finish() }
    }
}
