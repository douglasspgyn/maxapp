package douglasspgyn.com.github.maxapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.common.extension.isNetworkConnected
import douglasspgyn.com.github.maxapp.ui.client.ClientActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clients.setOnClickListener {
            startActivity(Intent(this, ClientActivity::class.java))
        }

        orders.setOnClickListener {

        }

        ordersSummary.setOnClickListener {

        }

        tools.setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()

        populateFooter()
    }

    private fun populateFooter() {
        val pInfo = packageManager.getPackageInfo(packageName, 0)
        appVersion.text = getString(R.string.app_version, pInfo.versionName)

        if (isNetworkConnected()) {
            connectionState.setImageDrawable(getDrawable(R.drawable.ic_maxima_nuvem_conectado))
        } else {
            connectionState.setImageDrawable(getDrawable(R.drawable.ic_maxima_nuvem_desconectado))
        }
    }
}
