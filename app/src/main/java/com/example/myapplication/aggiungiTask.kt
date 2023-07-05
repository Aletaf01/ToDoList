package com.example.myapplication

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentAggiungiTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.LocalTime
import kotlin.math.min

// Menu a tendina per aggiunta task con orario
class aggiungiTask(var taskOggetto: TaskOggetto?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAggiungiTaskBinding
    private lateinit var taskView: TaskView
    private var tempo: LocalTime? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()


        binding.titoloTask.text = "Nuova Task"

        taskView = ViewModelProvider(activity).get(TaskView::class.java)
        binding.bottoneAgg.setOnClickListener(){
            saveAction()
        }
        binding.bottoneOrario.setOnClickListener(){
            apriOrologio()
        }
    }

    private fun apriOrologio() {
        if(tempo == null)
            tempo = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener{_, ora, minuti ->
            tempo = LocalTime.of(ora, minuti)
            aggiornaBottoneOrario()
        }
        val dialog = TimePickerDialog(activity, listener, tempo!!.hour, tempo!!.minute, true)
        dialog.setTitle("Inserisci orario")
        dialog.show()
    }

    private fun aggiornaBottoneOrario() {
        binding.bottoneOrario.text = String.format("%02d:%02d",tempo!!.hour,tempo!!.minute)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAggiungiTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun saveAction() {
        val nome = binding.nomeTitolo.text.toString()
        if(taskOggetto == null){
            val nuovaTask = TaskOggetto(nome, tempo, null )
            taskView.aggiungiTaskOggetto(nuovaTask)
        }
        binding.nomeTitolo.setText("")
        dismiss()
    }
}