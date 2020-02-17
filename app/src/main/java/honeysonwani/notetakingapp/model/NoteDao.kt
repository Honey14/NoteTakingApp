package honeysonwani.notetakingapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: Note)

    @Query("SELECT * FROM note_table") //  ORDER BY Note DESC
    fun getNoteList() : List<Note>
}