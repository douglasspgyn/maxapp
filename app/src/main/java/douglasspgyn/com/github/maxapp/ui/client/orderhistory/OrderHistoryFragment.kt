package douglasspgyn.com.github.maxapp.ui.client.orderhistory

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.*
import android.view.inputmethod.EditorInfo
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.adapter.OrderHistoryAdapter
import douglasspgyn.com.github.maxapp.common.extension.gone
import douglasspgyn.com.github.maxapp.common.extension.visible
import douglasspgyn.com.github.maxapp.model.Pedido
import kotlinx.android.synthetic.main.fragment_order_history.*

class OrderHistoryFragment : Fragment(), OrderHistoryContract.View,
        SearchView.OnQueryTextListener {

    private val presenter: OrderHistoryPresenter = OrderHistoryPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        activity?.title = getString(R.string.order_history)
    }

    override fun onResume() {
        super.onResume()

        presenter.getOrderHistory()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_order_history, menu)

        val searchItem = menu?.findItem(R.id.menuSearch)
        val searchManager = context?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        var searchView: SearchView? = null

        searchItem?.let {
            searchView = it.actionView as SearchView
        }

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView?.setOnQueryTextListener(this)
        searchView?.imeOptions = EditorInfo.IME_ACTION_SEARCH
        searchItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                presenter.removeOrderHistoryFilters()
                return true
            }

        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menuSubtitles -> showSubtitles()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSubtitles() {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.let {
            it.setView(R.layout.dialog_subtitles)
            it.setNegativeButton(R.string.close, null)
        }.show()
    }

    override fun onQueryTextSubmit(text: String?): Boolean {
        text?.let {
            if (it.trim().isNotEmpty()) {
                presenter.filterOrderHistory(it)
            }
        }

        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        return true
    }

    override fun showLoading() {
        loading.visible()
    }

    override fun hideLoading() {
        loading.gone()
    }

    override fun orderHistoryLoaded(orders: List<Pedido>) {
        emptyView.gone()
        errorView.gone()
        recyclerView.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = OrderHistoryAdapter(orders)
        }
        recyclerView.visible()
    }

    override fun orderHistoryLoadedEmpty() {
        recyclerView.gone()
        errorView.gone()
        emptyView.visible()
    }

    override fun orderHistoryFailed(e: Throwable) {
        recyclerView.gone()
        emptyView.gone()
        errorView.visible()
    }

    override fun filteredOrderHistory(orders: List<Pedido>) {
        emptyView.gone()
        errorView.gone()
        recyclerView.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = OrderHistoryAdapter(orders)
        }
        recyclerView.visible()
    }

    override fun filteredOrderHistoryEmpty() {
        recyclerView.gone()
        errorView.gone()
        emptyView.visible()
    }
}