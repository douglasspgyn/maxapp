package douglasspgyn.com.github.maxapp.ui.client.data

import douglasspgyn.com.github.maxapp.model.Cliente

interface DataContract {

    interface View {
        fun showLoading()
        fun hideLoading()

        fun clientLoaded(client: Cliente)
        fun clienteFailed(e: Throwable)
    }

    interface Presenter {
        fun getClient()
    }
}