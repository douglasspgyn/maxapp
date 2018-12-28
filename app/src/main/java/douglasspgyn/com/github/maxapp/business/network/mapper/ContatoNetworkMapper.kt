package douglasspgyn.com.github.maxapp.business.network.mapper

import douglasspgyn.com.github.maxapp.business.network.model.ContatoNetworkModel
import douglasspgyn.com.github.maxapp.model.Contato

fun ContatoNetworkModel.toModel(): Contato {
    return Contato(this.nome,
            this.telefone,
            this.celular,
            this.conjuge,
            this.tipo,
            this.hobbie ?: "",
            this.time,
            this.email,
            this.dataDeNascimento,
            this.dataNascimentoConjuge ?: "")
}

fun List<ContatoNetworkModel>.toListModel(): List<Contato> {
    return this.map { it.toModel() }
}