package id.ilhamsuaib.binarmvp.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import id.ilhamsuaib.binarmvp.R
import id.ilhamsuaib.binarmvp.common.toast
import id.ilhamsuaib.binarmvp.model.Student
import id.ilhamsuaib.binarmvp.ui.newStudent.NewStudentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private val studentList = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList)

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
            startActivity(Intent(this, NewStudentActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupView() {
        this.title = "MVP Example"
        rvStudentList.run {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
    }

    override fun showStudents(results: List<Student>) {
        studentList.clear()
        studentList.addAll(results.sortedByDescending { it.id })
        studentAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        toast(message)
    }
}
