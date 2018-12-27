package douglasspgyn.com.github.maxapp.business.network

import com.google.gson.GsonBuilder
import douglasspgyn.com.github.maxapp.business.network.route.ClientRoute
import douglasspgyn.com.github.maxapp.business.network.route.OrderRoute
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private const val API_URL: String = "http://private-e38ef-maxapp.apiary-mock.com"

    private var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    private fun <T> provideService(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    val clientRoute: ClientRoute = provideService(ClientRoute::class.java)
    val orderRoute: OrderRoute = provideService(OrderRoute::class.java)
}