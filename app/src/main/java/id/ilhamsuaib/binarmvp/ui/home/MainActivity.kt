package id.ilhamsuaib.binarmvp.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import id.ilhamsuaib.binarmvp.R
import id.ilhamsuaib.binarmvp.common.Constants
import id.ilhamsuaib.binarmvp.common.toast
import id.ilhamsuaib.binarmvp.model.Student
import id.ilhamsuaib.binarmvp.ui.formStudent.FormStudentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private val studentList = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList, this::onClick, this::onLongClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        presenter.getStudents()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.manu_new_student, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.newStudent) {
            startActivity(Intent(this, FormStudentActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupView() {
        this.title = "MVP Example"
        rvStudentList.run {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }

        swipeRefresh.setOnRefreshListener {
            presenter.getStudents()
            swipeRefresh.isRefreshing = false
        }
    }

    private fun onLongClick(student: Student) {
        //ketika item recycler view di klik tahan/lama
        val options = arrayOf("Edit", "Hapus")
        AlertDialog.Builder(this)
                .setItems(options) { dialog, which ->
                    when (which) {
                        0 -> editStudent(student)
                        1 -> askForDelete(student)
                    }
                    dialog.dismiss()
                }
                .show()
    }

    private fun editStudent(student: Student) {
        val intent = Intent(this, FormStudentActivity::class.java)
        intent.putExtra(Constants.STUDENT, student)
        startActivity(intent)
    }

    private fun askForDelete(student: Student) {
        AlertDialog.Builder(this)
                .setTitle("Hapus Siswa?")
                .setMessage("Anda yakin akan menghapus siswa bernama ${student.name}?")
                .setPositiveButton("Tidak") { dialog, which ->
                    dialog.dismiss()
                }
                .setNegativeButton("Ya") { dialog, which ->
                    presenter.deleteStudent(student)
                }
                .show()
    }

    private fun onClick(student: Student) {
        //ketika item recycler view di klik
    }

    override fun showStudents(results: List<Student>) {
        studentList.clear()
        studentList.addAll(results.sortedByDescending { it.id })
        studentAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        toast(message)
    }

    override fun onDeleteStudent(student: Student, isSuccess: Boolean, message: String) {
        if (isSuccess) {
            studentList.remove(student)
            studentAdapter.notifyDataSetChanged()
        }
        toast(message)
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progress.visibility = View.VISIBLE
        } else {
            progress.visibility = View.GONE
        }
    }
}



















