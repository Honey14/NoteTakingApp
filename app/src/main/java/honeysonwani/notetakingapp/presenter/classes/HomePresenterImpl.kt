package honeysonwani.notetakingapp.presenter.classes

import androidx.navigation.NavController
import honeysonwani.notetakingapp.presenter.interfaces.HomePresenter
import honeysonwani.notetakingapp.view.interfaces.HomeView

class HomePresenterImpl : HomePresenter {
    private lateinit var view: HomeView
    override fun setDashboardView(navController: NavController) {
        view.setToolbar()
        view.setVisibilityInNavElements(navController)
    }

    override fun setView(view: HomeView) {
        this.view = view
    }
}