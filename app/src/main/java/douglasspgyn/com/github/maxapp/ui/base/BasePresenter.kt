package douglasspgyn.com.github.maxapp.ui.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter {
    val disposable: CompositeDisposable = CompositeDisposable()
}