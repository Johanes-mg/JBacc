package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var serie: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        serie = intent.getStringExtra("serie") ?: ""
        findViewById<TextView>(R.id.serie_title).text = serie
        
        when(serie) {
            "Serie C" -> findViewById<TextView>(R.id.serie_subtitle).text = "Sciences Mathematiques"
            "Serie D" -> findViewById<TextView>(R.id.serie_subtitle).text = "Sciences Naturelles"
            "Serie A1" -> findViewById<TextView>(R.id.serie_subtitle).text = "Lettres et Philosophie"
            "Serie A2" -> findViewById<TextView>(R.id.serie_subtitle).text = "Lettres et Langues"
        }

        findViewById<Button>(R.id.btn_lecons).setOnClickListener {
            val intent = Intent(this, MatiereActivity::class.java)
            intent.putExtra("serie", serie)
            intent.putExtra("type", "Lecons")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_sujets).setOnClickListener {
            val intent = Intent(this, MatiereActivity::class.java)
            intent.putExtra("serie", serie)
            intent.putExtra("type", "Sujets")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_retour).setOnClickListener { finish() }
    }
}
