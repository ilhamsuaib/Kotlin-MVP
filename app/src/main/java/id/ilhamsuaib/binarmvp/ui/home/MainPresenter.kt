package id.ilhamsuaib.binarmvp.ui.home

import id.ilhamsuaib.binarmvp.BinarMvpApp
import id.ilhamsuaib.binarmvp.common.execute
import id.ilhamsuaib.binarmvp.model.Student
import id.ilhamsuaib.binarmvp.network.ApiServices

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
            .execute({
                view.showProgress(false)
                view.onDeleteStudent(student, false, "Error : gagal menghapus siswa ${student.name}")
            }, { response ->
                view.showProgress(false)
                if (response?.status == "OK") {
                    view.onDeleteStudent(student, true, "Berhasil menghapus siswa ${student.name}")
                } else {
                    view.onDeleteStudent(student, false, "Error : gagal menghapus siswa ${student.name}")
                }
            })
    }
}


























