package douglasspgyn.com.github.maxapp.business.persistence.worker

import douglasspgyn.com.github.maxapp.business.persistence.mapper.toModel
import douglasspgyn.com.github.maxapp.business.persistence.mapper.toPersistenceModel
import douglasspgyn.com.github.maxapp.business.persistence.model.ClientePersistenceModel
import douglasspgyn.com.github.maxapp.model.Cliente
import io.realm.kotlin.where

class ClienteRealmWorker : BaseRealmWorker {

    fun getCliente(): Cliente? {
        return realmInstance.where<ClientePersistenceModel>().findFirst()?.toModel()
    }

    fun saveCliente(client: Cliente) {
        realmInstance.executeTransaction {
            it.insertOrUpdate(client.toPersistenceModel())
        }
    }
}