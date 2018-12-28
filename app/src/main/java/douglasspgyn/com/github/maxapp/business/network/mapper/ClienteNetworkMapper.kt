package douglasspgyn.com.github.maxapp.business.network.mapper

import douglasspgyn.com.github.maxapp.business.network.model.ClienteNetworkModel
import douglasspgyn.com.github.maxapp.model.Cliente

fun ClienteNetworkModel.toModel(): Cliente {
    return Cliente(
            this.id,
            this.codigo,
            this.razaoSocial,
            this.nomeFantasia,
            this.cpf ?: "",
            this.cnpj,
            this.ramoDeAtividade,
            this.endereco,
            this.status,
            this.contatos.toListModel()
    )
}

fun List<ClienteNetworkModel>.toListModel(): List<Cliente> {
    return this.map { it.toModel() }
}