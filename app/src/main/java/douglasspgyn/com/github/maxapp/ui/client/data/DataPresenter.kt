package douglasspgyn.com.github.maxapp.ui.client.data

import douglasspgyn.com.github.maxapp.business.ClientBusiness
import douglasspgyn.com.github.maxapp.common.extension.rx

class DataPresenter(private val view: DataContract.View) : DataContract.Presenter {

    override fun getClient() {
        view.showLoading()

        ClientBusiness().getCliente()
                .rx({
                    view.clientLoaded(it)
                }, {
                    view.clienteFailed(it)
                }, {
                    view.hideLoading()
                })
    }
}