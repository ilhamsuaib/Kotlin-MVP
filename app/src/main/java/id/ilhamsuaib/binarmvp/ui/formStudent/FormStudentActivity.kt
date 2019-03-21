package id.ilhamsuaib.binarmvp.ui.formStudent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.binarmvp.R
import id.ilhamsuaib.binarmvp.common.Constants
import id.ilhamsuaib.binarmvp.common.toast
import id.ilhamsuaib.binarmvp.model.Student
import kotlinx.android.synthetic.main.activity_form_student.*

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

class FormStudentActivity : AppCompatActivity(), FormStudentView {

    private val presenter = FormStudentPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_student)

        setupView()
    }

    private fun setupView() {
        val student: Student? = intent.getParcelableExtra(Constants.STUDENT)
        btnSaveStudent.setOnClickListener {
            validateForm(student)
        }

        edtStudentName.setText(student?.name)
        edtStudentEmail.setText(student?.email)
        edtStudentName.setSelection(edtStudentName.length())
        edtStudentEmail.setSelection(edtStudentEmail.length())
    }

    private fun validateForm(student: Student?) {
        val name = edtStudentName.text.toString()
        val email = edtStudentEmail.text.toString()

        if (name.isBlank() || email.isBlank()) {
            toast("Nama dan email tidak boleh kosong")
            return
        }

        val map = mutableMapOf<String, String>()
        map["name"] = name
        map["email"] = email

        if (student == null) {
            presenter.newStudent(map)
        } else {
            presenter.editStudent(student.id, map)
        }
    }

    override fun onStudentSave(status: Boolean, message: String) {
        toast(message)
        if (status) {
            finish()
        }
    }
}