package douglasspgyn.com.github.maxapp.model

import douglasspgyn.com.github.maxapp.business.network.model.ContatoNetworkModel

data class Cliente(
        val id: Long,
        val codigo: Long,
        val razaoSocial: String,
        val nomeFantasia: String,
        val cnpj: String,
        val ramoDeAtividade: String,
        val endereco: String,
        val status: String,
        val contatos: List<ContatoNetworkModel>
)