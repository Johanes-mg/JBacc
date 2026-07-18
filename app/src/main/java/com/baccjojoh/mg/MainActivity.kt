package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_scientifique).setOnClickListener {
            startActivity(Intent(this, SerieActivity::class.java).putExtra("type", "scientifique"))
        }
        findViewById<Button>(R.id.btn_litteraire).setOnClickListener {
            startActivity(Intent(this, SerieActivity::class.java).putExtra("type", "litteraire"))
        }
    }
}
