package com.baccjojoh.mg.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.baccjojoh.mg.R

class FichierAdapter(
    private val onOuvrir: (String) -> Unit
) : ListAdapter<String, FichierAdapter.VH>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(a: String, b: String) = a == b
            override fun areContentsTheSame(a: String, b: String) = a == b
        }
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nom: TextView = itemView.findViewById(R.id.item_nom)
        val bouton: Button = itemView.findViewById(R.id.item_bouton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_fichier, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val nom = getItem(position)
        holder.nom.text = nom
        holder.bouton.setOnClickListener { onOuvrir(nom) }
    }
}
