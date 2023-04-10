package com.example.todo.ui.fragment.note


import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.R
import com.example.todo.base.BaseFragment
import com.example.todo.data.model.NoteModel
import com.example.todo.databinding.FragmentNoteBinding
import com.example.todo.ui.fragment.note.adapter.NotesAdapter


class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate), NotesAdapter.OnNoteClickListener {
    private lateinit var adapter: NotesAdapter


    override fun setupUI() {
        adapter = NotesAdapter(this)
        binding.rvNote.adapter = adapter

        binding.btnFloat.setOnClickListener{
            findNavController().navigate(R.id.addNoteFragment)
        }
    }
    override fun setupObserver() {

    }

    override fun onNoteClick(note: NoteModel) {

    }
}