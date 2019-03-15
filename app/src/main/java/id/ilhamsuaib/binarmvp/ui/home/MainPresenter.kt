package id.ilhamsuaib.binarmvp.ui.home

import id.ilhamsuaib.binarmvp.BinarMvpApp
import id.ilhamsuaib.binarmvp.model.StudentResponse
import id.ilhamsuaib.binarmvp.network.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 13/03/19.
 * github.com/ilhamsuaib
 */

class MainPresenter(private val view: MainView) {

    private val apiServices: ApiServices by lazy {
        BinarMvpApp.api
    }

    fun getStudents() {
        apiServices.getAllStudents()
            .enqueue(object : Callback<StudentResponse> {
                override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }

                override fun onResponse(call: Call<StudentResponse>, response: Response<StudentResponse>) {
                    val body: StudentResponse? = response.body()
                    if (body != null) {
                        body.data?.let { studentList ->
                            view.showStudents(studentList)
                        }
                    } else {
                        view.onError("Error : gagal memuat data")
                    }
                }
            })
    }
}