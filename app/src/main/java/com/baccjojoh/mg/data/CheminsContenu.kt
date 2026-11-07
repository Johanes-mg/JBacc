package com.baccjojoh.mg.data

object CheminsContenu {

    fun sujets(serie: String, matiere: String): String? = when {
        matiere == "Mathematiques" && serie == "Serie D" -> "sujets/maths/serie_d"
        matiere == "Mathematiques" && serie == "Serie C" -> "sujets/maths/serie_c"
        matiere == "Mathematiques" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/maths/serie_a"

        matiere == "Physique-Chimie" && serie == "Serie D" -> "sujets/pc/serie_d"
        matiere == "Physique-Chimie" && serie == "Serie C" -> "sujets/pc/serie_c"
        matiere == "Physique-Chimie" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/pc/serie_a"

        matiere == "SVT" && serie == "Serie D" -> "sujets/svt/serie_d"
        matiere == "SVT" && serie == "Serie C" -> "sujets/svt/serie_c"
        matiere == "SVT" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/svt/serie_a"

        matiere == "Histoire-Geo" && (serie == "Serie C" || serie == "Serie D" || serie == "Serie A1" || serie == "Serie A2") -> "sujets/hg"

        matiere == "Malagasy" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/malagasy/serie_a"
        matiere == "Malagasy" && (serie == "Serie C" || serie == "Serie D") -> "sujets/malagasy/serie_cd"

        matiere == "Philo" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/philo/serie_a"
        matiere == "Philo" && (serie == "Serie C" || serie == "Serie D") -> "sujets/philo/serie_cd"

        matiere == "Anglais" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/anglais/serie_a"
        matiere == "Anglais" && (serie == "Serie C" || serie == "Serie D") -> "sujets/anglais/serie_cd"

        matiere == "Francais" && (serie == "Serie A1" || serie == "Serie A2") -> "sujets/francais/serie_a"
        matiere == "Francais" && (serie == "Serie C" || serie == "Serie D") -> "sujets/francais/serie_cd"

        else -> null
    }
}
