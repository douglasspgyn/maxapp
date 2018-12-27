package douglasspgyn.com.github.maxapp.business.persistence.mapper

import douglasspgyn.com.github.maxapp.business.persistence.model.PedidoPersistenceModel
import douglasspgyn.com.github.maxapp.model.Pedido
import io.realm.RealmList

fun PedidoPersistenceModel.toModel(): Pedido {
    return Pedido(
        this.numeroPedidoRca,
        this.numeroPedidoErp,
        this.codigoCliente,
        this.nomeDoCliente,
        this.data,
        this.status,
        this.critica,
        this.tipo,
        this.legendas.toList()
    )
}

fun List<PedidoPersistenceModel>.toListModel(): List<Pedido> {
    return this.map { it.toModel() }
}

fun Pedido.toPersistenceModel(): PedidoPersistenceModel {
    val realmList: RealmList<String> = RealmList()
    realmList.addAll(this.legendas)

    return PedidoPersistenceModel(
        this.numeroPedidoRca,
        this.numeroPedidoErp,
        this.codigoCliente,
        this.nomeDoCliente,
        this.data,
        this.status,
        this.critica,
        this.tipo,
        realmList
    )
}

fun List<Pedido>.toPersistenceListModel(): RealmList<PedidoPersistenceModel> {
    val realmList: RealmList<PedidoPersistenceModel> = RealmList()
    realmList.addAll(this.map { it.toPersistenceModel() })
    return realmList
}