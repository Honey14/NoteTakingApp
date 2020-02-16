package honeysonwani.notetakingapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import honeysonwani.notetakingapp.R
import honeysonwani.notetakingapp.view.`interface`.NotesListView
import kotlinx.android.synthetic.main.fragment_list_note.*

/**
 * A simple [Fragment] subclass.
 */

class ListNoteFragment : Fragment(R.layout.fragment_list_note), NotesListView {
    override fun setRecyclerView(view: View) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ListAdapter(context, view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_addNoteFragment)
        }
    }

}
