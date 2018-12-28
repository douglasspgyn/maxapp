package douglasspgyn.com.github.maxapp.business.network.model

import com.google.gson.annotations.SerializedName

data class ClienteNetworkModel(
        val id: Long,
        val codigo: String,
        @SerializedName("razao_social") val razaoSocial: String,
        val nomeFantasia: String,
        val cpf: String?,
        val cnpj: String,
        @SerializedName("ramo_atividade") val ramoDeAtividade: String,
        val endereco: String,
        val status: String,
        val contatos: List<ContatoNetworkModel>
)