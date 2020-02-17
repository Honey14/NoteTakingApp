package honeysonwani.notetakingapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

import honeysonwani.notetakingapp.R
import honeysonwani.notetakingapp.model.Note
import honeysonwani.notetakingapp.presenter.classes.AddNotePresenterImpl
import honeysonwani.notetakingapp.view.interfaces.AddNoteView
import kotlinx.android.synthetic.main.fragment_add_note.*

/**
 * A simple [Fragment] subclass.
 */

class AddNoteFragment : Fragment(R.layout.fragment_add_note), AddNoteView {
    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    lateinit var addNotePresenterImpl: AddNotePresenterImpl
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNotePresenterImpl = AddNotePresenterImpl()
        context?.let { addNotePresenterImpl.setView(this, it) }
        buttonSave.setOnClickListener {
            val title = note_title.text.toString()
            val noteText = note_text.text.toString()
            if (addNotePresenterImpl.checkFields(title, noteText)) {
                addNotePresenterImpl.saveNote(title, noteText)
//                val body = Note(0,title ,noteText)
//                val bundle = bundleOf("note_body" to body)
                findNavController().navigate(R.id.action_addNoteFragment_to_noteDetailFragment)
            }
        }
    }
}