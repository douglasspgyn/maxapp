package douglasspgyn.com.github.maxapp.business.persistence.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ClientePersistenceModel(
        @PrimaryKey var id: Long = 0,
        var codigo: String = "",
        var razaoSocial: String = "",
        var nomeFantasia: String = "",
        var cpf: String = "",
        var cnpj: String = "",
        var ramoDeAtividade: String = "",
        var endereco: String = "",
        var status: String = "",
        var contatos: RealmList<ContatoPersistenceModel> = RealmList()
) : RealmObject()