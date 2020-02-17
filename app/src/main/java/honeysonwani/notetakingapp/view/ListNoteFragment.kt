package honeysonwani.notetakingapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import honeysonwani.notetakingapp.R
import honeysonwani.notetakingapp.model.Note
import honeysonwani.notetakingapp.presenter.classes.NotesListPresenterImpl
import honeysonwani.notetakingapp.view.interfaces.NotesListView
import kotlinx.android.synthetic.main.fragment_list_note.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */

class ListNoteFragment : Fragment(R.layout.fragment_list_note), NotesListView {
    override fun setTextForEmptyList() {
        empty_notes.visibility = View.VISIBLE
    }

    override fun setRecyclerView(listOfNotes: ArrayList<Note>) {
        empty_notes.visibility = View.GONE
        listOfNotes.reverse()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ListAdapter(context, view!!, listOfNotes)
    }

    lateinit var notesListPresenterImpl: NotesListPresenterImpl
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesListPresenterImpl = NotesListPresenterImpl()
        context?.let { notesListPresenterImpl.setView(this, it) }
        notesListPresenterImpl.showNotes()
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_addNoteFragment)
        }
    }

}
