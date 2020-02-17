package honeysonwani.notetakingapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Int,
    val note_title: String,
    val note_detail: String,
    val time_stamp : String
)