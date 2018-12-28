package douglasspgyn.com.github.maxapp.business

import douglasspgyn.com.github.maxapp.business.network.Api
import douglasspgyn.com.github.maxapp.business.network.mapper.toModel
import douglasspgyn.com.github.maxapp.business.persistence.worker.ClienteRealmWorker
import douglasspgyn.com.github.maxapp.common.extension.applySchedulers
import douglasspgyn.com.github.maxapp.model.Cliente
import io.reactivex.Single
import java.net.ConnectException
import java.net.UnknownHostException

class ClientBusiness {

    fun getCliente(): Single<Cliente> {
        return Api.clientRoute.getClients()
                .applySchedulers()
                .map { it.toModel() }
                .doOnSuccess {
                    ClienteRealmWorker().saveCliente(it)
                }
                .onErrorResumeNext { throwable ->
                    if (throwable is UnknownHostException || throwable is ConnectException) {
                        Single.just(ClienteRealmWorker().getCliente())
                    } else {
                        Single.create { it.onError(throwable) }
                    }
                }
    }
}