package com.baccjojoh.mg

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.baccjojoh.mg.data.AssetRepository
import com.baccjojoh.mg.data.CheminsContenu
import com.baccjojoh.mg.databinding.ActivityContentBinding
import com.baccjojoh.mg.ui.adapters.FichierAdapter

class ContentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContentBinding
    private lateinit var adapter: FichierAdapter
    private var cheminCourant: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val matiere = intent.getStringExtra("matiere") ?: ""
        val serie = intent.getStringExtra("serie") ?: ""

        binding.contentTitle.text = matiere
        binding.contentSubtitle.text = serie

        adapter = FichierAdapter { nom -> ouvrirFichier(nom) }
        binding.pdfContainer.layoutManager = LinearLayoutManager(this)
        binding.pdfContainer.adapter = adapter
        binding.pdfContainer.setHasFixedSize(true)

        val chemin = CheminsContenu.sujets(serie, matiere)
        cheminCourant = chemin

        if (chemin != null) {
            val fichiers = AssetRepository.listerFichiers(this, chemin)
            if (fichiers.isNotEmpty()) {
                binding.contentText.visibility = View.GONE
                binding.pdfContainer.visibility = View.VISIBLE
                adapter.submitList(fichiers.toList())
            } else {
                afficherIndisponible()
            }
        } else {
            afficherIndisponible()
        }

        binding.btnRetour.setOnClickListener { finish() }
    }

    private fun afficherIndisponible() {
        binding.contentText.visibility = View.VISIBLE
        binding.pdfContainer.visibility = View.GONE
        binding.contentText.gravity = Gravity.CENTER
        binding.contentText.text = "INDISPONIBLE"
    }

    private fun ouvrirFichier(nom: String) {
        val chemin = cheminCourant ?: return
        try {
            val fichier = AssetRepository.extraireFichier(this, chemin, nom)
            val uri = FileProvider.getUriForFile(this, "com.baccjojoh.mg.fileprovider", fichier)
            val mime = AssetRepository.mimeType(nom)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, mime)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivity(Intent.createChooser(intent, "Ouvrir avec"))
        } catch (e: Exception) {
            binding.contentText.visibility = View.VISIBLE
            binding.contentText.gravity = Gravity.CENTER
            binding.contentText.text = "Erreur: ${e.message}"
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level >= TRIM_MEMORY_UI_HIDDEN) {
            AssetRepository.viderCacheMemoire()
        }
    }
}
