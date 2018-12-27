package douglasspgyn.com.github.maxapp.business.network.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class PedidoNetworkModel(
        @SerializedName("numero_ped_Rca") val numeroPedidoRca: Long,
        @SerializedName("numero_ped_erp") val numeroPedidoErp: String,
        val codigoCliente: String,
        @SerializedName("NOMECLIENTE") val nomeDoCliente: String,
        val data: Date,
        val status: String,
        val critica: String?,
        val tipo: String,
        val legendas: List<String>?
)