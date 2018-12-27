package douglasspgyn.com.github.maxapp.business.network.route

import douglasspgyn.com.github.maxapp.business.network.model.PedidoNetworkModel
import io.reactivex.Single
import retrofit2.http.GET

interface OrderRoute {

    @GET("/pedidos")
    fun getOrders(): Single<List<PedidoNetworkModel>>
}