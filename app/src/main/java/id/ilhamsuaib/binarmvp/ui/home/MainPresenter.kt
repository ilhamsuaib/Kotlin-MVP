package id.ilhamsuaib.binarmvp.ui.home

import id.ilhamsuaib.binarmvp.BinarMvpApp
import id.ilhamsuaib.binarmvp.common.execute
import id.ilhamsuaib.binarmvp.model.NewStudentResponse
import id.ilhamsuaib.binarmvp.model.Student
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
        view.showProgress(true)
        apiServices.getAllStudents()
                .execute(view::onError) { response ->
                    view.showProgress(false)
                    if (response != null) {
                        response.data?.let { studentList ->
                            view.showStudents(studentList)
                        }
                    } else {
                        view.onError("Error : gagal memuat data")
                    }
                }
    }

    fun deleteStudent(student: Student) {
        view.showProgress(true)
        apiServices.deleteStudent(student.id)
                .enqueue(object : Callback<NewStudentResponse> {
                    override fun onFailure(call: Call<NewStudentResponse>, t: Throwable) {
                        view.onError(t.localizedMessage)
                        view.showProgress(false)
                    }

                    override fun onResponse(call: Call<NewStudentResponse>, response: Response<NewStudentResponse>) {
                        view.showProgress(false)
                        if (response.body()?.status == "OK") {
                            view.onDeleteStudent(student, true, "Berhasil menghapus siswa ${student.name}")
                        } else {
                            view.onDeleteStudent(student, false, "Error : gagal menghapus siswa ${student.name}")
                        }
                    }
                })
    }
}


























