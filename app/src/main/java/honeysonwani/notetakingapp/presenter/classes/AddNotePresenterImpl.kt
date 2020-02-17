package honeysonwani.notetakingapp.presenter.classes

import android.content.Context
import android.text.TextUtils
import honeysonwani.notetakingapp.model.Note
import honeysonwani.notetakingapp.model.NoteDatabase
import honeysonwani.notetakingapp.presenter.interfaces.AddNotePresenter
import honeysonwani.notetakingapp.view.interfaces.AddNoteView
import java.text.SimpleDateFormat
import java.util.*

class AddNotePresenterImpl : AddNotePresenter {
    override fun getCurrentTimeStamp() : String {
        val currentTime = SimpleDateFormat("dd MMMM yyyy, h:mm a", Locale.getDefault()).format(Date())
        val date = Date()
        return currentTime.format(date)
    }

    private lateinit var view: AddNoteView
    private lateinit var context: Context
    override fun setView(view: AddNoteView, context: Context) {
        this.view = view
        this.context = context
    }

    override fun checkFields(title: String, noteText: String): Boolean {
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(noteText)) {
            return true
        } else if (TextUtils.isEmpty(title)) {
            view.showError("Please Enter Title")
            return false
        } else if (TextUtils.isEmpty(noteText)) {
            view.showError("Please Enter Note Details")
            return false
        }
        return false
    }

    override fun saveNote(title: String, noteText: String) {
        val timeStampReceived = getCurrentTimeStamp()
        val noteBody = Note(0, title, noteText,timeStampReceived)
        NoteDatabase.getDatabase(context).noteDao().insertNote(noteBody)
    }
}