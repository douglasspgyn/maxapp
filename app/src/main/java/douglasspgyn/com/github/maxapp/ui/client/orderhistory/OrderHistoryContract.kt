package douglasspgyn.com.github.maxapp.ui.client.orderhistory

import douglasspgyn.com.github.maxapp.model.Pedido

interface OrderHistoryContract {

    interface View {
        fun showLoading()
        fun hideLoading()

        fun orderHistoryLoaded(orders: List<Pedido>)
        fun orderHistoryLoadedEmpty()
        fun orderHistoryFailed(e: Throwable)

        fun filteredOrderHistory(orders: List<Pedido>)
        fun filteredOrderHistoryEmpty()
    }

    interface Presenter {
        fun getOrderHistory()
        fun filterOrderHistory(text: String)
        fun removeOrderHistoryFilters()
    }
}