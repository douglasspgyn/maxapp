package douglasspgyn.com.github.maxapp.business.persistence.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ContatoPersistenceModel(
        var nome: String = "",
        var telefone: String = "",
        @PrimaryKey var celular: String = "",
        var conjuge: String = "",
        var tipo: String = "",
        var hobbie: String = "",
        var time: String = "",
        var email: String = "",
        var dataDeNascimento: String = "",
        var dataNascimentoConjuge: String = ""
) : RealmObject()