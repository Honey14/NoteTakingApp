package honeysonwani.notetakingapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import honeysonwani.notetakingapp.R
import kotlinx.android.synthetic.main.row_list_of_notes.view.*

class ListAdapter(private val context: Context?, private val view: View) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textHeadline.text = "text header"
        holder.textDetails.text = "text note details ..."
        holder.cardHead.setOnClickListener {
            view.findNavController().navigate(R.id.action_listNoteFragment_to_noteDetailFragment)
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