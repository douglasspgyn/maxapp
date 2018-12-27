package douglasspgyn.com.github.maxapp.ui.client.orderhistory

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.*
import douglasspgyn.com.github.maxapp.R


class OrderHistoryFragment : Fragment(), SearchView.OnQueryTextListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        activity?.title = "Hist. de pedidos"
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
        return true
    }

    override fun onQueryTextChange(text: String?): Boolean {
        return true
    }
}