package honeysonwani.notetakingapp.view.interfaces

import honeysonwani.notetakingapp.model.Note

interface NotesListView {
    fun setRecyclerView(listOfNotes : ArrayList<Note>)
    fun setTextForEmptyList()

}