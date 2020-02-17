package honeysonwani.notetakingapp.view.interfaces

import androidx.navigation.NavController

interface HomeView {
        fun setToolbar()
        fun setVisibilityInNavElements(navController1: NavController)
        fun setToolbarTitle(title : String)
}