package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityListaViewBinding

class ListaView : AppCompatActivity(),TaskOggettoCliccato {

    private lateinit var binding: ActivityListaViewBinding
    private lateinit var taskView: TaskView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityListaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskView = ViewModelProvider(this).get(TaskView::class.java)
        binding.fab.setOnClickListener {
            aggiungiTask(null).show(supportFragmentManager, "nuovaTask")
        }
        setRecyclerView()
    }

    private fun setRecyclerView(){
        val ListaView = this
        taskView.taskOggetti.observe(this){
            binding.RecyclerViewLista.apply{
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = AdapterTaskOggetto(it!!, ListaView)
            }
        }
    }

    override fun modificaTaskOggetto(taskOggetto: TaskOggetto) {
        aggiungiTask(taskOggetto).show(supportFragmentManager,"Nuova Task")
    }

    override fun completaTaskOggetto(taskOggetto: TaskOggetto) {
        taskView.completaTask(taskOggetto)
    }

}