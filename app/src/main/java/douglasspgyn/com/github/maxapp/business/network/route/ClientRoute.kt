package douglasspgyn.com.github.maxapp.business.network.route

import douglasspgyn.com.github.maxapp.business.network.model.ClienteNetworkModel
import io.reactivex.Single
import retrofit2.http.GET

interface ClientRoute {

    @GET("/clientes")
    fun getClients(): Single<ClienteNetworkModel>
}