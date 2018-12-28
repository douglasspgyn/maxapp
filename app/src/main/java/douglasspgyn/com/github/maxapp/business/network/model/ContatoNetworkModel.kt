package douglasspgyn.com.github.maxapp.business.network.model

import com.google.gson.annotations.SerializedName

data class ContatoNetworkModel(
        val nome: String,
        val telefone: String,
        val celular: String,
        val conjuge: String,
        val tipo: String,
        val hobbie: String?,
        val time: String,
        @SerializedName("e_mail") val email: String,
        @SerializedName("data_nascimento") val dataDeNascimento: String,
        val dataNascimentoConjuge: String?
)