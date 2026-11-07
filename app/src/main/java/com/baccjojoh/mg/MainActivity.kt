package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.baccjojoh.mg.data.AssetRepository
import com.baccjojoh.mg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AssetRepository.nettoyerCache(applicationContext)

        binding.btnScientifique.setOnClickListener {
            startActivity(Intent(this, SerieActivity::class.java).putExtra("type", "scientifique"))
        }
        binding.btnLitteraire.setOnClickListener {
            startActivity(Intent(this, SerieActivity::class.java).putExtra("type", "litteraire"))
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level >= TRIM_MEMORY_UI_HIDDEN) {
            AssetRepository.viderCacheMemoire()
        }
    }
}
