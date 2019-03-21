package id.ilhamsuaib.binarmvp.common

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 20/03/19.
 * github.com/ilhamsuaib
 */

fun <T> Call<T>.execute(onError: (String) -> Unit, onSuccess: (T?) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(t.localizedMessage)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            onSuccess(response.body())
        }
    })
}