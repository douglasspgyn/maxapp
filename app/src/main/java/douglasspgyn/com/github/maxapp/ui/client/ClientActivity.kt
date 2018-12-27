package douglasspgyn.com.github.maxapp.ui.client

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import douglasspgyn.com.github.maxapp.R
import douglasspgyn.com.github.maxapp.ui.client.data.DataFragment
import douglasspgyn.com.github.maxapp.ui.client.license.LicenseFragment
import douglasspgyn.com.github.maxapp.ui.client.orderhistory.OrderHistoryFragment
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bottomNavigation.setOnNavigationItemSelectedListener(this)
        bottomNavigation.selectedItemId = R.id.menuData
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {

        val fragment = when (menu.itemId) {
            R.id.menuData -> {
                DataFragment()
            }
            R.id.menuOrderHistory -> {
                OrderHistoryFragment()
            }
            R.id.menuLicense -> {
                LicenseFragment()
            }
            else -> DataFragment()
        }

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}