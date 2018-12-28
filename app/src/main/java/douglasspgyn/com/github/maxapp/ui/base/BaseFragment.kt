package douglasspgyn.com.github.maxapp.ui.base

import android.support.v4.app.Fragment

abstract class BaseFragment<T : BasePresenter> : Fragment() {

    val presenter: T
    abstract fun viewPresenter(): T
    private var title: String = ""

    init {
        presenter = this.viewPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.disposable.clear()
    }

    fun setToolbarTitle(text: String) {
        title = text
    }

    override fun onResume() {
        super.onResume()

        activity?.title = title
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)

        if (!hidden) {
            activity?.title = title
        }
    }
}