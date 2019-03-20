package id.ilhamsuaib.binarmvp.ui.home

import id.ilhamsuaib.binarmvp.BinarMvpApp
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

    fun deleteStudent(student: Student) {
        apiServices.deleteStudent(student.id)
            .enqueue(object : Callback<NewStudentResponse> {
                override fun onFailure(call: Call<NewStudentResponse>, t: Throwable) {
                    view.onError(t.localizedMessage)
                }

                override fun onResponse(call: Call<NewStudentResponse>, response: Response<NewStudentResponse>) {
                    if (response.body()?.status == "OK") {
                        view.onDeleteStudent(student, true, "Berhasil menghapus siswa ${student.name}")
                    } else {
                        view.onDeleteStudent(student, false, "Error : gagal menghapus siswa ${student.name}")
                    }
                }
            })
    }
}


























