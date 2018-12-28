package douglasspgyn.com.github.maxapp.ui.client.data

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.adapter.ContactAdapter
import douglasspgyn.com.github.maxapp.common.extension.*
import douglasspgyn.com.github.maxapp.common.service.DateTimeListener
import douglasspgyn.com.github.maxapp.common.service.DateTimeService
import douglasspgyn.com.github.maxapp.model.Cliente
import douglasspgyn.com.github.maxapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_data.*
import java.text.SimpleDateFormat
import java.util.*

class DataFragment : BaseFragment<DataPresenter>(), DataContract.View, ServiceConnection {

    override fun viewPresenter(): DataPresenter = DataPresenter(this)
    private var dateTimeListener: DateTimeListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getString(R.string.client_data)

        activity?.bindService(Intent(context, DateTimeService::class.java), this, 0)

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
        clientCPF.text = getString(R.string.client_cpf, client.cpf.formValidateNotInformedField(context!!)).formSpanColor(4)
        clientCNPJ.text = getString(R.string.client_cnpj, client.cnpj).formSpanColor(5)
        clientIndustry.text = getString(R.string.client_industry, client.ramoDeAtividade).formSpanColor(18)
        clientAddress.text = getString(R.string.client_address, client.endereco).formSpanColor(9)

        contactRecyclerView.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = ContactAdapter(client.contatos)
            it.isNestedScrollingEnabled = false
        }

        verifyClientStatus.setOnClickListener {
            val message = dateTimeListener?.let { dateTimeListener ->
                getString(R.string.client_status_active, dateTimeListener.getDateTime())
            }
                    ?: getString(R.string.client_status_inactive, SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(System.currentTimeMillis()))

            snackbar(message, dismissText = getString(R.string.close))
        }
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        val serviceController: DateTimeService.ServiceController? = service as? DateTimeService.ServiceController
        dateTimeListener = serviceController?.getDateTimeListener()
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        dateTimeListener = null
    }
}