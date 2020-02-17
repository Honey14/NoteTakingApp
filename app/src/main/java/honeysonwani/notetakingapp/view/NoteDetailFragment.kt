package honeysonwani.notetakingapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

import honeysonwani.notetakingapp.R
import honeysonwani.notetakingapp.model.Note
import kotlinx.android.synthetic.main.fragment_note_detail.*

/**
 * A simple [Fragment] subclass.
 */
class NoteDetailFragment : Fragment(R.layout.fragment_note_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val noteClicked = arguments?.getParcelable<Note>("note_clicked")
        text_note_title.text = noteClicked?.note_title
        text_note_detail.text = noteClicked?.note_detail
        note_time.text = noteClicked?.time_stamp
    }

}
