package douglasspgyn.com.github.maxapp.ui.client.orderhistory

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import douglasspgyn.com.github.maxapp.R

class OrderHistoryFragment : Fragment() {

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
}