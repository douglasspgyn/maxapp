package douglasspgyn.com.github.maxapp.business

import douglasspgyn.com.github.maxapp.business.network.Api
import douglasspgyn.com.github.maxapp.business.network.mapper.toListModel
import douglasspgyn.com.github.maxapp.business.persistence.worker.PedidoRealmWorker
import douglasspgyn.com.github.maxapp.common.extension.applySchedulers
import douglasspgyn.com.github.maxapp.model.Pedido
import io.reactivex.Single
import java.net.ConnectException
import java.net.UnknownHostException

class OrderBusiness {

    fun getOrders(): Single<List<Pedido>> {
        return Api.orderRoute.getOrders()
            .applySchedulers()
            .map { it.toListModel() }
            .doOnSuccess {
                PedidoRealmWorker().savePedidos(it)
            }
            .onErrorResumeNext { throwable ->
                if (throwable is UnknownHostException || throwable is ConnectException) {
                    Single.just(PedidoRealmWorker().getPedidos())
                } else {
                    Single.create { it.onError(throwable) }
                }
            }
    }
}