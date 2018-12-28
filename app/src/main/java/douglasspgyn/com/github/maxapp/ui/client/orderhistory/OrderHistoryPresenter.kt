package douglasspgyn.com.github.maxapp.ui.client.orderhistory

import douglasspgyn.com.github.maxapp.business.OrderBusiness
import douglasspgyn.com.github.maxapp.common.extension.rx
import douglasspgyn.com.github.maxapp.model.Pedido
import douglasspgyn.com.github.maxapp.ui.base.BasePresenter

class OrderHistoryPresenter(val view: OrderHistoryContract.View) : OrderHistoryContract.Presenter, BasePresenter() {

    private var orders: List<Pedido> = mutableListOf()

    override fun getOrderHistory() {
        view.showLoading()

        disposable.add(OrderBusiness().getOrders()
                .rx({
                    orders = it

                    if (it.isEmpty()) {
                        view.orderHistoryLoadedEmpty()
                    } else {
                        view.orderHistoryLoaded(it)
                    }
                }, {
                    view.orderHistoryFailed(it)
                }, {
                    view.hideLoading()
                })
        )
    }

    override fun filterOrderHistory(text: String) {
        val filteredOrders = orders.filter { it.numeroPedidoRca.toString().contains(text, true) or it.numeroPedidoErp.contains(text, true) or it.nomeDoCliente.contains(text, true) or it.codigoCliente.contains(text, true) }

        if (filteredOrders.isEmpty()) {
            view.filteredOrderHistoryEmpty()
        } else {
            view.filteredOrderHistory(filteredOrders)
        }
    }

    override fun removeOrderHistoryFilters() {
        view.orderHistoryLoaded(orders)
    }
}