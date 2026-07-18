package com.baccjojoh.mg

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val matiere = intent.getStringExtra("matiere") ?: ""
        val serie = intent.getStringExtra("serie") ?: ""
        val type = intent.getStringExtra("type") ?: ""
        
        findViewById<TextView>(R.id.content_title).text = "$type - $matiere"
        findViewById<TextView>(R.id.content_subtitle).text = serie
        
        val container = findViewById<LinearLayout>(R.id.pdf_container)
        val textView = findViewById<TextView>(R.id.content_text)
        
        val filesPath = when (type) {
            "Lecons" -> getLeconsPath(matiere, serie)
            "Sujets" -> getSujetsPath(serie, matiere)
            else -> null
        }
        
        if (filesPath != null && contientDesFichiers(filesPath)) {
            textView.visibility = android.view.View.GONE
            container.visibility = android.view.View.VISIBLE
            afficherListeFichiers(container, filesPath)
        } else {
            textView.visibility = android.view.View.VISIBLE
            container.visibility = android.view.View.GONE
            textView.gravity = Gravity.CENTER
            textView.text = "INDISPONIBLE"
        }
        
        findViewById<Button>(R.id.btn_retour).setOnClickListener { finish() }
    }
    
    private fun getLeconsPath(matiere: String, serie: String): String? = when {
        matiere == "Mathematiques" && (serie == "Serie C" || serie == "Serie D") -> "lecons/maths"
        matiere == "Physique-Chimie" && (serie == "Serie C" || serie == "Serie D") -> "lecons/pc"
        matiere == "Histoire-Geo" -> "lecons/hg"
        matiere == "Philo" -> "lecons/philo"
        matiere == "Malagasy" -> "lecons/malagasy"
        else -> null
    }
    
    private fun getSujetsPath(serie: String, matiere: String): String? = when {
        matiere == "Mathematiques" && serie == "Serie D" -> "sujets/maths/serie_d"
        matiere == "Physique-Chimie" && serie == "Serie D" -> "sujets/pc/serie_d"
        matiere == "SVT" && serie == "Serie D" -> "sujets/svt/serie_d"
        matiere == "Histoire-Geo" && (serie == "Serie C" || serie == "Serie D") -> "sujets/hg"
        matiere == "Malagasy" && (serie == "Serie C" || serie == "Serie D") -> "sujets/malagasy/serie_cd"
        matiere == "Philo" && serie == "Serie D" -> "sujets/philo/serie_d"
        matiere == "Anglais" && serie == "Serie D" -> "sujets/anglais/serie_d"
        else -> null
    }
    
    private fun contientDesFichiers(filesPath: String): Boolean {
        return try {
            val files = assets.list(filesPath) ?: emptyArray()
            files.any { it.endsWith(".pdf") || it.endsWith(".jpg") || it.endsWith(".png") || it.endsWith(".pps") }
        } catch (e: Exception) {
            false
        }
    }
    
    private fun afficherListeFichiers(container: LinearLayout, filesPath: String) {
        try {
            val files = assets.list(filesPath)?.filter { 
                it.endsWith(".pdf") || it.endsWith(".jpg") || it.endsWith(".png") || it.endsWith(".pps")
            }?.sorted() ?: emptyList()
            
            container.removeAllViews()
            files.forEach { fileName ->
                val row = LinearLayout(this)
                row.orientation = LinearLayout.HORIZONTAL
                row.setPadding(0, 8, 0, 8)
                
                val nameView = TextView(this)
                nameView.text = fileName
                nameView.textSize = 14f
                nameView.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                
                val openButton = Button(this)
                openButton.text = "Ouvrir"
                openButton.textSize = 12f
                openButton.setPadding(16, 8, 16, 8)
                openButton.setOnClickListener { ouvrirFichier(filesPath, fileName) }
                
                row.addView(nameView)
                row.addView(openButton)
                container.addView(row)
            }
        } catch (e: Exception) {
            val textView = findViewById<TextView>(R.id.content_text)
            textView.visibility = android.view.View.VISIBLE
            container.visibility = android.view.View.GONE
            textView.text = "INDISPONIBLE"
        }
    }
    
    private fun ouvrirFichier(filesPath: String, fileName: String) {
        try {
            val inputStream = assets.open("$filesPath/$fileName")
            val outputFile = File(cacheDir, fileName)
            FileOutputStream(outputFile).use { output ->
                inputStream.copyTo(output)
            }
            inputStream.close()
            
            val uri = FileProvider.getUriForFile(this, "com.baccjojoh.mg.fileprovider", outputFile)
            
            val mimeType = when {
                fileName.endsWith(".pdf") -> "application/pdf"
                fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") -> "image/jpeg"
                fileName.endsWith(".png") -> "image/png"
                fileName.endsWith(".pps") -> "application/vnd.ms-powerpoint"
                else -> "*/*"
            }
            
            startActivity(Intent.createChooser(Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, mimeType)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }, "Ouvrir avec"))
        } catch (e: Exception) {
            findViewById<TextView>(R.id.content_text).text = "Erreur: ${e.message}"
        }
    }
}
