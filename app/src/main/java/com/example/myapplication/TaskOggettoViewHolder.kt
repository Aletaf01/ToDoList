package com.example.myapplication

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CellaTaskBinding
import java.time.format.DateTimeFormatter

// Classe che collega tutti i pezzi di una task

class TaskOggettoViewHolder(
    private val context: Context,
    private val binding: CellaTaskBinding,
    private val clickListener: TaskOggettoCliccato

    ): RecyclerView.ViewHolder(binding.root) {

        private val formatoOra = DateTimeFormatter.ofPattern("HH:mm")
        fun bindTaskOggetto(taskOggetto: TaskOggetto){
            binding.nome.text = taskOggetto.nome

            if (taskOggetto.completato()){
                binding.nome.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                binding.tempo.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.bottoneConferma.setImageResource(taskOggetto.immagineCheckbox())
            binding.bottoneConferma.setColorFilter(taskOggetto.coloreCheckbox(context))

            binding.bottoneConferma.setOnClickListener{
                clickListener.completaTaskOggetto(taskOggetto)
            }
            binding.cellaTask.setOnClickListener{
                clickListener.completaTaskOggetto(taskOggetto)
            }

            if(taskOggetto.tempo != null)
                binding.tempo.text = formatoOra.format(taskOggetto.tempo)
            else
                binding.tempo.text = ""
        }
}