package douglasspgyn.com.github.maxapp.ui.client.data

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.adapter.ContactAdapter
import douglasspgyn.com.github.maxapp.common.extension.formSpanColor
import douglasspgyn.com.github.maxapp.common.extension.gone
import douglasspgyn.com.github.maxapp.common.extension.visible
import douglasspgyn.com.github.maxapp.model.Cliente
import kotlinx.android.synthetic.main.fragment_data.*

class DataFragment : Fragment(), DataContract.View {

    private val presenter: DataPresenter = DataPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getString(R.string.client_data)

        presenter.getClient()
    }

    override fun showLoading() {
        loading.visible()
    }

    override fun hideLoading() {
        loading.gone()
    }

    override fun clientLoaded(client: Cliente) {
        errorView.gone()
        populateClientView(client)
        clientContainer.visible()
    }

    override fun clienteFailed(e: Throwable) {
        clientContainer.gone()
        errorView.visible()
    }

    private fun populateClientView(client: Cliente) {
        clientIdAndSocialName.text = getString(R.string.client_id_social_name, client.id, client.razaoSocial)
        clientFantasyName.text = client.nomeFantasia
        clientCNPJ.text = getString(R.string.client_cnpj, client.cnpj).formSpanColor(5)
        clientIndustry.text = getString(R.string.client_industry, client.ramoDeAtividade).formSpanColor(18)
        clientAddress.text = getString(R.string.client_address, client.endereco).formSpanColor(9)

        contactRecyclerView.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = ContactAdapter(client.contatos)
        }
    }
}