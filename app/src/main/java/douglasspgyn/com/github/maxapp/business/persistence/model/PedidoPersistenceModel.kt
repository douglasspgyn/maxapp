package douglasspgyn.com.github.maxapp.business.persistence.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class PedidoPersistenceModel(
        @PrimaryKey var numeroPedidoRca: Long = 0,
        var numeroPedidoErp: String = "",
        var codigoCliente: String = "",
        var nomeDoCliente: String = "",
        var datetime: Date = Date(),
        var status: String = "",
        var critica: String = "",
        var tipo: String = "",
        var legendas: RealmList<String> = RealmList()
) : RealmObject()