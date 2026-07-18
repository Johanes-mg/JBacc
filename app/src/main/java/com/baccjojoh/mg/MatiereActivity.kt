package com.baccjojoh.mg

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MatiereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matiere)

        val serie = intent.getStringExtra("serie") ?: ""
        val type = intent.getStringExtra("type") ?: ""
        
        findViewById<TextView>(R.id.serie_title).text = "$serie - $type"

        val matieres = listOf(
            "Mathematiques", "Physique-Chimie", "SVT",
            "Histoire-Geo", "Malagasy", "Philo", "Anglais"
        )
        
        val container = findViewById<LinearLayout>(R.id.matieres_container)
        val couleurMatieres = Color.parseColor("#88BF8C")

        matieres.forEach { matiere ->
            val button = Button(this)
            button.text = matiere
            button.textSize = 18f
            button.setPadding(0, 24, 0, 24)
            button.setBackgroundColor(couleurMatieres)
            
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 16)
            button.layoutParams = params
            
            button.setOnClickListener {
                val intent = Intent(this, ContentActivity::class.java)
                intent.putExtra("matiere", matiere)
                intent.putExtra("serie", serie)
                intent.putExtra("type", type)
                startActivity(intent)
            }
            container.addView(button)
        }
        
        findViewById<Button>(R.id.btn_retour).setOnClickListener { finish() }
    }
}
