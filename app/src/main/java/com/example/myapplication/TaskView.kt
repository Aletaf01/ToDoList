package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.*


class TaskView: ViewModel() {
    var taskOggetti= MutableLiveData<MutableList<TaskOggetto>?>()

    init {
        taskOggetti.value = mutableListOf()
    }

    fun aggiungiTaskOggetto(nuovaTask: TaskOggetto){
        val lista = taskOggetti.value
        lista!!.add(nuovaTask)
        taskOggetti.postValue(lista)
    }


    fun completaTask(taskOggetto: TaskOggetto){
        val lista = taskOggetti.value
        val task = lista!!.find { it.id == taskOggetto.id }!!
        if (task.dataCompletata == null)
            task.dataCompletata = LocalDate.now()
        taskOggetti.postValue(lista)
    }
}