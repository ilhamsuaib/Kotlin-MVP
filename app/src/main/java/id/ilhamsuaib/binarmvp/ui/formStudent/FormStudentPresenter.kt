package id.ilhamsuaib.binarmvp.ui.formStudent

import id.ilhamsuaib.binarmvp.BinarMvpApp
import id.ilhamsuaib.binarmvp.common.execute
import id.ilhamsuaib.binarmvp.model.GeneralResponse
import id.ilhamsuaib.binarmvp.model.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

class FormStudentPresenter(private val view: FormStudentView) {

    fun newStudent(studentMap: Map<String, String>) {
        BinarMvpApp.api.newStudent(studentMap)
            .execute({
                view.onStudentSave(false, "Gagal menyimpan siswa, coba lagi")
            }, {
                val isSuccess = it?.status == "OK"
                if (isSuccess)
                    view.onStudentSave(isSuccess, "Sukses menyimpan siswa")
                else
                    view.onStudentSave(isSuccess, "Gagal menyimpan siswa, coba lagi")
            })
    }

    fun editStudent(studentId: Int, map: Map<String, String>) {
        BinarMvpApp.api.editStudent(studentId, map)
            .enqueue(object : Callback<GeneralResponse<Student>> {
                override fun onFailure(call: Call<GeneralResponse<Student>>, t: Throwable) {
                    view.onStudentSave(false, "Gagal mengubah data siswa, coba lagi")
                }

                override fun onResponse(
                    call: Call<GeneralResponse<Student>>,
                    response: Response<GeneralResponse<Student>>
                ) {
                    val isSuccess = response.body()?.status == "OK"
                    if (isSuccess)
                        view.onStudentSave(isSuccess, "Sukses mengubah data siswa")
                    else
                        view.onStudentSave(isSuccess, "Gagal mengubah data siswa, coba lagi")
                }
            })
    }
}