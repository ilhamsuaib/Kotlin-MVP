package id.ilhamsuaib.binarmvp.ui.newStudent

import id.ilhamsuaib.binarmvp.BinarMvpApp
import id.ilhamsuaib.binarmvp.model.NewStudentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

class NewStudentPresenter(private val view: NewStudentView) {

    fun newStudent(studentMap: Map<String, String>) {
        BinarMvpApp.api.newStudent(studentMap)
                .enqueue(object : Callback<NewStudentResponse> {
                    override fun onFailure(call: Call<NewStudentResponse>, t: Throwable) {
                        view.onStudentSave(false, t.localizedMessage)
                    }

                    override fun onResponse(call: Call<NewStudentResponse>, response: Response<NewStudentResponse>) {
                        val isSuccess = response.body()?.status == "OK"
                        if (isSuccess)
                            view.onStudentSave(isSuccess, "Sukses menyimpan siswa")
                        else
                            view.onStudentSave(isSuccess, "Gagal menyimpan siswa, coba lagi")
                    }
                })
    }
}