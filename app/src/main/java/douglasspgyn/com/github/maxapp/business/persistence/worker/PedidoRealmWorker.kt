package douglasspgyn.com.github.maxapp.business.persistence.worker

import douglasspgyn.com.github.maxapp.business.persistence.mapper.toListModel
import douglasspgyn.com.github.maxapp.business.persistence.mapper.toPersistenceModel
import douglasspgyn.com.github.maxapp.business.persistence.model.PedidoPersistenceModel
import douglasspgyn.com.github.maxapp.model.Pedido
import io.realm.kotlin.where

class PedidoRealmWorker : BaseRealmWorker {

    fun getPedidos(): List<Pedido> {
        return realmInstance.where<PedidoPersistenceModel>().findAll().toListModel()
    }

    fun savePedido(order: Pedido) {
        realmInstance.executeTransaction {
            it.insertOrUpdate(order.toPersistenceModel())
        }
    }

    fun savePedidos(orders: List<Pedido>) {
        orders.forEach {
            savePedido(it)
        }
    }
}