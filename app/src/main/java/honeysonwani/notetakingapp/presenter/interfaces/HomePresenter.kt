package honeysonwani.notetakingapp.presenter.interfaces

import androidx.navigation.NavController
import honeysonwani.notetakingapp.view.interfaces.HomeView

interface HomePresenter {
    fun setDashboardView(navController: NavController)
    fun setView(view : HomeView)
}