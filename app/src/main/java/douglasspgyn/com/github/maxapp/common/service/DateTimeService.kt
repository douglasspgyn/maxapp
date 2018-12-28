package douglasspgyn.com.github.maxapp.common.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class DateTimeService : Service(), DateTimeListener {

    private val serviceController: ServiceController = ServiceController()

    override fun onBind(intent: Intent?): IBinder? {
        return serviceController
    }

    override fun getDateTime(): String {
        return SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(System.currentTimeMillis())
    }

    inner class ServiceController : Binder() {
        fun getDateTimeListener(): DateTimeListener = this@DateTimeService
    }
}