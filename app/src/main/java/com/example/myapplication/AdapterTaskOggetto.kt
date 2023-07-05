package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CellaTaskBinding

// Questa classe ci permette di visualizzare la lista di Tasks
class AdapterTaskOggetto(
    private val taskOggetti: List<TaskOggetto>,
    private val clickListener: TaskOggettoCliccato
): RecyclerView.Adapter<TaskOggettoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskOggettoViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CellaTaskBinding.inflate(from, parent, false)
        return TaskOggettoViewHolder(parent.context, binding, clickListener)
    }

    override fun getItemCount(): Int = taskOggetti.size

    override fun onBindViewHolder(holder: TaskOggettoViewHolder, position: Int) {
        holder.bindTaskOggetto(taskOggetti[position])
    }
}