package com.example.myapplication

import android.content.Context
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

// Classe per le singole tasks
class TaskOggetto(
    var nome: String,
    var tempo: LocalTime?,
    var dataCompletata: LocalDate?,
    var id: UUID = UUID.randomUUID()
)
{
    fun completato() = dataCompletata != null
    fun immagineCheckbox(): Int = if(completato()) R.drawable.check_24 else R.drawable.unchecked_24
    fun coloreCheckbox(context: Context): Int = if(completato()) green(context) else black(context)

    private fun green(context: Context) = ContextCompat.getColor(context, R.color.teal_700)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)
}