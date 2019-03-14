package id.ilhamsuaib.binarmvp

import android.app.Application
import id.ilhamsuaib.binarmvp.network.ApiServices
import id.ilhamsuaib.binarmvp.network.NetworkConfig

/**
 * Created by @ilhamsuaib on 14/03/19.
 * github.com/ilhamsuaib
 */

class BinarMvpApp : Application() {

    companion object {
        lateinit var api: ApiServices
    }

    override fun onCreate() {
        super.onCreate()

        api = NetworkConfig.getRetrofit().create(ApiServices::class.java)
    }
}