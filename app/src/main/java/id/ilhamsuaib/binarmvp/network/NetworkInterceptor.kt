package id.ilhamsuaib.binarmvp.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by @ilhamsuaib on 26/03/19.
 * github.com/ilhamsuaib
 */


/**
 * NetworkInterceptor akan dieksekusi setipa kali melakukan request
 * 1. Jika token expired response code = 401 & new_token = xxxxxxxxx
 * 2. Simpan token baru ke SP lalu lakukan request ulang*/


class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "xxxxx" //ngambil dari shared pref

        /*menambahkan header auth uk setiap request*/
        val modifyRequest: Request? = chain.request().newBuilder()
            .addHeader("Authorization", "bearer $token")
            .build()

        val mResponse: Response = chain.proceed(modifyRequest!!)

        /*jika token expired maka code = 401*/
        if (mResponse.code() == 401) {
            /*ambil token baru dari objek mResponse
            lalu lakukan ulang request*/

            val newToken = "yyyy" //ambil dari mResponse

            val newRequest: Request? = chain.request().newBuilder()
                .addHeader("Authorization", "bearer $newToken")
                .build()

            return chain.proceed(newRequest!!)
        }

        return mResponse
    }
}