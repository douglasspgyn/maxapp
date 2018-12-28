package douglasspgyn.com.github.maxapp.business.persistence.worker

import io.realm.Realm

interface BaseRealmWorker {

    val realmInstance: Realm
        get() = Realm.getDefaultInstance()
}