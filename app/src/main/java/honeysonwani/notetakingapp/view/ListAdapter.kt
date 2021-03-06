package honeysonwani.notetakingapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import honeysonwani.notetakingapp.R
import honeysonwani.notetakingapp.model.Note
import kotlinx.android.synthetic.main.row_list_of_notes.view.*

class ListAdapter(
    private val context: Context?,
    private val view: View,
    private val listOfNotes: ArrayList<Note>
) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val noteTitleString = listOfNotes[position].note_title
        val noteTitle = noteTitleString.substring(0,1).toUpperCase() + noteTitleString.substring(1).toLowerCase()
        val noteDetailString = listOfNotes[position].note_detail
        val noteDetail = noteDetailString.substring(0,1).toUpperCase() + noteDetailString.substring(1).toLowerCase()
        holder.textHeadline.text = noteTitle
        holder.textDetails.text = noteDetail
        holder.cardHead.setOnClickListener {
            val bundle = bundleOf("note_clicked" to listOfNotes[position])
            view.findNavController().navigate(R.id.action_listNoteFragment_to_noteDetailFragment,bundle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_list_of_notes, parent, false)
        return ListViewHolder(view)
    }

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardHead = view.card_head
        val textHeadline = view.text_headline
        val textDetails: TextView = view.text_details
    }
}