package honeysonwani.notetakingapp.presenter.interfaces

import android.content.Context
import honeysonwani.notetakingapp.view.interfaces.NotesListView

interface NotesListPresenter {
    fun setView(view : NotesListView, context: Context)
    fun showNotes()
}