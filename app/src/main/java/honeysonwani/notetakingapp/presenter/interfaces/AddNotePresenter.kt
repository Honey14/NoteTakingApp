package honeysonwani.notetakingapp.presenter.interfaces

import android.content.Context
import honeysonwani.notetakingapp.view.interfaces.AddNoteView


interface AddNotePresenter {
    fun setView(view: AddNoteView, context : Context)
    fun checkFields(title: String, noteText: String): Boolean
    fun saveNote(title: String, noteText: String)
    fun getCurrentTimeStamp() : String
}