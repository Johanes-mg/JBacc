package com.baccjojoh.mg.data

import android.content.Context
import java.io.File

object AssetRepository {

    private val cacheFichiers = HashMap<String, Array<String>>(16)

    fun listerFichiers(context: Context, chemin: String): Array<String> {
        cacheFichiers[chemin]?.let { return it }
        val resultat = try {
            val brut = context.assets.list(chemin) ?: emptyArray()
            brut.filter { estSupporte(it) }.sortedWith(comparateur).toTypedArray()
        } catch (e: Exception) {
            emptyArray()
        }
        cacheFichiers[chemin] = resultat
        return resultat
    }

    private val comparateur = Comparator<String> { a, b ->
        val ca = categorie(a)
        val cb = categorie(b)
        if (ca != cb) ca - cb else a.compareTo(b, true)
    }

    private fun categorie(nom: String): Int {
        val n = nom.lowercase()
        return when {
            n.startsWith("sujet") -> 0
            n.startsWith("corrig") -> 1
            else -> 2
        }
    }

    fun contientDesFichiers(context: Context, chemin: String): Boolean {
        return listerFichiers(context, chemin).isNotEmpty()
    }

    fun estSupporte(nom: String): Boolean {
        return nom.endsWith(".pdf", true) ||
                nom.endsWith(".jpg", true) ||
                nom.endsWith(".jpeg", true) ||
                nom.endsWith(".png", true) ||
                nom.endsWith(".pps", true)
    }

    fun mimeType(nom: String): String = when {
        nom.endsWith(".pdf", true) -> "application/pdf"
        nom.endsWith(".jpg", true) || nom.endsWith(".jpeg", true) -> "image/jpeg"
        nom.endsWith(".png", true) -> "image/png"
        nom.endsWith(".pps", true) -> "application/vnd.ms-powerpoint"
        else -> "*/*"
    }

    fun extraireFichier(context: Context, cheminAsset: String, nomFichier: String): File {
        val cible = File(context.cacheDir, nomFichier)
        val ageMax = 7L * 24L * 60L * 60L * 1000L
        val maintenant = System.currentTimeMillis()
        if (cible.exists() && (maintenant - cible.lastModified()) < ageMax) {
            return cible
        }
        context.assets.open("$cheminAsset/$nomFichier").use { entree ->
            cible.outputStream().use { sortie ->
                entree.copyTo(sortie, 8192)
            }
        }
        return cible
    }

    fun nettoyerCache(context: Context) {
        val cache = context.cacheDir ?: return
        val ageMax = 7L * 24L * 60L * 60L * 1000L
        val maintenant = System.currentTimeMillis()
        val fichiers = cache.listFiles() ?: return
        var i = 0
        while (i < fichiers.size) {
            val f = fichiers[i]
            if (f.isFile && (maintenant - f.lastModified()) > ageMax) {
                f.delete()
            }
            i++
        }
    }

    fun viderCacheMemoire() {
        cacheFichiers.clear()
    }
}
