package douglasspgyn.com.github.maxapp.business.persistence.mapper

import douglasspgyn.com.github.maxapp.business.persistence.model.ClientePersistenceModel
import douglasspgyn.com.github.maxapp.model.Cliente

fun ClientePersistenceModel.toModel(): Cliente {
    return Cliente(
            this.id,
            this.codigo,
            this.razaoSocial,
            this.nomeFantasia,
            this.cnpj,
            this.ramoDeAtividade,
            this.endereco,
            this.status,
            this.contatos.toListModel()
    )
}

fun Cliente.toPersistenceModel(): ClientePersistenceModel {
    return ClientePersistenceModel(
            this.id,
            this.codigo,
            this.razaoSocial,
            this.nomeFantasia,
            this.cnpj,
            this.ramoDeAtividade,
            this.endereco,
            this.status,
            this.contatos.toPersistenceListModel()
    )
}