package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.baccjojoh.mg.data.AssetRepository
import com.baccjojoh.mg.databinding.ActivityMatiereBinding
import com.baccjojoh.mg.ui.adapters.MatiereAdapter

class MatiereActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatiereBinding
    private lateinit var adapter: MatiereAdapter

    companion object {
        private val MATIERES = listOf(
            "Mathematiques", "Physique-Chimie", "SVT",
            "Histoire-Geo", "Malagasy", "Philo", "Anglais", "Francais"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatiereBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serie = intent.getStringExtra("serie") ?: ""

        binding.serieTitle.text = serie

        adapter = MatiereAdapter { matiere ->
            val i = Intent(this, ContentActivity::class.java)
            i.putExtra("matiere", matiere)
            i.putExtra("serie", serie)
            startActivity(i)
        }
        binding.matieresContainer.layoutManager = LinearLayoutManager(this)
        binding.matieresContainer.adapter = adapter
        binding.matieresContainer.setHasFixedSize(true)
        adapter.submitList(MATIERES)

        binding.btnRetour.setOnClickListener { finish() }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level >= TRIM_MEMORY_UI_HIDDEN) {
            AssetRepository.viderCacheMemoire()
        }
    }
}
