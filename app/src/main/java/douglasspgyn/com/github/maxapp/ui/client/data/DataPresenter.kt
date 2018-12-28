package douglasspgyn.com.github.maxapp.ui.client.data

import douglasspgyn.com.github.maxapp.business.ClientBusiness
import douglasspgyn.com.github.maxapp.common.extension.rx
import douglasspgyn.com.github.maxapp.ui.base.BasePresenter

class DataPresenter(private val view: DataContract.View) : DataContract.Presenter, BasePresenter() {

    override fun getClient() {
        view.showLoading()

        disposable.add(ClientBusiness().getCliente()
                .rx({
                    view.clientLoaded(it)
                }, {
                    view.clienteFailed(it)
                }, {
                    view.hideLoading()
                })
        )
    }
}