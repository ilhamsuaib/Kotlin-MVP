package id.ilhamsuaib.binarmvp.ui.newStudent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.binarmvp.R
import id.ilhamsuaib.binarmvp.common.toast
import kotlinx.android.synthetic.main.activity_new_student.*

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

class NewStudentActivity : AppCompatActivity(), NewStudentView {

    private val presenter = NewStudentPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        setupView()
    }

    private fun setupView() {
        btnSaveStudent.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val name = edtStudentName.text.toString()
        val email = edtStudentEmail.text.toString()

        if (name.isBlank() || email.isBlank()) {
            toast("Nama dan email tidak boleh kosong")
            return
        }

        val map = mutableMapOf<String, String>()
        map["name"] = name
        map["email"] = email

        presenter.newStudent(map)
    }

    override fun onStudentSave(status: Boolean, message: String) {
        toast(message)
        if (status) {
            finish()
        }
    }
}