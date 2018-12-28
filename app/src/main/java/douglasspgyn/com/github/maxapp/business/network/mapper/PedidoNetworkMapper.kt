package douglasspgyn.com.github.maxapp.business.network.mapper

import douglasspgyn.com.github.maxapp.business.network.model.PedidoNetworkModel
import douglasspgyn.com.github.maxapp.model.Pedido

fun PedidoNetworkModel.toModel(): Pedido {
    return Pedido(this.numeroPedidoRca,
            this.numeroPedidoErp,
            this.codigoCliente,
            this.nomeDoCliente,
            this.datetime,
            this.status,
            this.critica ?: "",
            this.tipo,
            this.legendas ?: mutableListOf())
}

fun List<PedidoNetworkModel>.toListModel(): List<Pedido> {
    return this.map { it.toModel() }
}