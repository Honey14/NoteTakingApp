package honeysonwani.notetakingapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import honeysonwani.notetakingapp.presenter.classes.HomePresenterImpl
import honeysonwani.notetakingapp.view.interfaces.HomeView
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), HomeView {
    override fun setToolbarTitle(title: String) {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        toolbar_layout.visibility = View.VISIBLE
        toolbar_title.text = title
        image_menu.visibility = View.VISIBLE
        if (image_menu.isVisible) {
            image_menu.setOnClickListener {
                navController.navigate(
                    R.id.listNoteFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(
                            R.id.listNoteFragment,
                            true
                        )
                        .build()
                )
            }
        }
    }

    override fun setVisibilityInNavElements(navController1: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController, null)
        navController1.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.listNoteFragment -> {
                    setToolbarTitle(getString(R.string.notes_name))
                    image_menu.visibility = View.GONE
                }
                R.id.addNoteFragment -> {
                    setToolbarTitle(getString(R.string.add_note))
                    image_menu.visibility = View.VISIBLE
                }
                R.id.noteDetailFragment -> {
                    setToolbarTitle(getString(R.string.note_details))
                    image_menu.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun setToolbar() {
        setSupportActionBar(tool_bar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tool_bar.setTitleTextColor(Color.WHITE) // set the color before setting the toolbar
        val typefaceToolbar =
            Typeface.createFromAsset(assets, "fonts/PROXIMANOVA-BOLD.OTF")
        toolbar_title.typeface = typefaceToolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private lateinit var navController: NavController
    private lateinit var homePresenterImpl: HomePresenterImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(this, R.id.navHostFragment)
        homePresenterImpl = HomePresenterImpl()
        homePresenterImpl.setView(this)
        homePresenterImpl.setDashboardView(navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

}