package douglasspgyn.com.github.maxapp.ui.base

import android.support.v4.app.Fragment

abstract class BaseFragment<T : BasePresenter> : Fragment() {

    val presenter: T
    abstract fun viewPresenter(): T

    init {
        presenter = this.viewPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.disposable.clear()
    }
}