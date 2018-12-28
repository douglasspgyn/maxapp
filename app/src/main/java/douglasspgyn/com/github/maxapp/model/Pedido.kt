package douglasspgyn.com.github.maxapp.model

import java.util.*

data class Pedido(
        val numeroPedidoRca: Long,
        val numeroPedidoErp: String,
        val codigoCliente: String,
        val nomeDoCliente: String,
        val datetime: Date,
        val status: String,
        val critica: String,
        val tipo: String,
        val legendas: List<String>
)