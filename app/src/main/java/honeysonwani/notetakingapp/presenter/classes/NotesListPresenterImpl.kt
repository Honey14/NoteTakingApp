package honeysonwani.notetakingapp.presenter.classes

import android.content.Context
import honeysonwani.notetakingapp.model.Note
import honeysonwani.notetakingapp.model.NoteDatabase
import honeysonwani.notetakingapp.presenter.interfaces.NotesListPresenter
import honeysonwani.notetakingapp.view.interfaces.NotesListView

class NotesListPresenterImpl : NotesListPresenter {
    override fun showNotes() {
        val listNotes = NoteDatabase.getDatabase(context).noteDao().getNoteList()
        if (listNotes.isNotEmpty()) {
            val arrayOfNotes: ArrayList<Note> = ArrayList()
            for (i in listNotes.indices) {
                arrayOfNotes.add(listNotes[i])
            }
            view.setRecyclerView( arrayOfNotes)
        } else {
            view.setTextForEmptyList()
        }
    }

    private lateinit var view: NotesListView
    private lateinit var context: Context

    override fun setView(view: NotesListView, context: Context) {
        this.view = view
        this.context = context
    }


}