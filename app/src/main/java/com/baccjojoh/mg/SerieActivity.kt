package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baccjojoh.mg.databinding.ActivitySerieBinding

class SerieActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySerieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySerieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getStringExtra("type")

        if (type == "scientifique") {
            binding.title.text = "Parcours Scientifique"
            binding.btnOption1.text = "Serie C"
            binding.btnOption2.text = "Serie D"
            binding.btnOption1.setOnClickListener { ouvrirSerie("Serie C") }
            binding.btnOption2.setOnClickListener { ouvrirSerie("Serie D") }
        } else {
            binding.title.text = "Parcours Litteraire"
            binding.btnOption1.text = "Serie A1"
            binding.btnOption2.text = "Serie A2"
            binding.btnOption1.setOnClickListener { ouvrirSerie("Serie A1") }
            binding.btnOption2.setOnClickListener { ouvrirSerie("Serie A2") }
        }

        binding.btnRetour.setOnClickListener { finish() }
    }

    private fun ouvrirSerie(serie: String) {
        val i = Intent(this, MatiereActivity::class.java)
        i.putExtra("serie", serie)
        i.putExtra("type", "Sujets")
        startActivity(i)
    }
}
