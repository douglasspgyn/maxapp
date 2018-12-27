package douglasspgyn.com.github.maxapp.business

import douglasspgyn.com.github.maxapp.business.network.Api
import douglasspgyn.com.github.maxapp.business.network.mapper.toListModel
import douglasspgyn.com.github.maxapp.common.extension.applySchedulers
import douglasspgyn.com.github.maxapp.model.Pedido
import io.reactivex.Single

class OrderBusiness {

    fun getOrders(): Single<List<Pedido>> {
        return Api.orderRoute.getOrders().applySchedulers().map { it.toListModel() }
    }
}