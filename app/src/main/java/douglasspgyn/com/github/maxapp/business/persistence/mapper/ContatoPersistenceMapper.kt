package douglasspgyn.com.github.maxapp.business.persistence.mapper

import douglasspgyn.com.github.maxapp.business.persistence.model.ContatoPersistenceModel
import douglasspgyn.com.github.maxapp.model.Contato
import io.realm.RealmList

fun ContatoPersistenceModel.toModel(): Contato {
    return Contato(
            this.nome,
            this.telefone,
            this.celular,
            this.conjuge,
            this.tipo,
            this.hobbie,
            this.time,
            this.email,
            this.dataDeNascimento,
            this.dataNascimentoConjuge
    )
}

fun List<ContatoPersistenceModel>.toListModel(): List<Contato> {
    return this.map { it.toModel() }
}

fun Contato.toPersistenceModel(): ContatoPersistenceModel {
    return ContatoPersistenceModel(
            this.nome,
            this.telefone,
            this.celular,
            this.conjuge,
            this.tipo,
            this.hobbie,
            this.time,
            this.email,
            this.dataDeNascimento,
            this.dataNascimentoConjuge
    )
}

fun List<Contato>.toPersistenceListModel(): RealmList<ContatoPersistenceModel> {
    val realmList: RealmList<ContatoPersistenceModel> = RealmList()
    realmList.addAll(this.map { it.toPersistenceModel() })
    return realmList
}