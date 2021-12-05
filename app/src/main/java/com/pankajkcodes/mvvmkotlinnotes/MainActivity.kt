package com.pankajkcodes.mvvmkotlinnotes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pankajkcodes.mvvmkotlinnotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val notesDao = NotesDatabase.getDatabase(applicationContext).notesDao()
        val notesRepository = NotesRepository(notesDao)
        val mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(notesRepository)
        )[MainViewModel::class.java]


        mainViewModel.getNotes().observe(this, {
            binding.textView.text = it.toString()

        })

        binding.addBtn.setOnClickListener {
            if (binding.editText.text!!.isEmpty()) {
                binding.editText.error = "Empty"
            } else {
                mainViewModel.insertNotes(NotesModel(0, binding.editText.text.toString()))
                Toast.makeText(this, "Done", Toast.LENGTH_LONG).show()
                binding.textView.text = binding.editText.text
                binding.editText.text = null
            }
        }
    }
}