package douglasspgyn.com.github.maxapp.ui.client.license

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.ui.base.BaseFragment

class LicenseFragment : BaseFragment<LicencePresenter>(), LicenseContract.View {

    override fun viewPresenter(): LicencePresenter = LicencePresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_license, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle(getString(R.string.license))
    }
}