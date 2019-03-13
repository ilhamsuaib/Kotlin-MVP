package id.ilhamsuaib.binarmvp.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.ilhamsuaib.binarmvp.R
import id.ilhamsuaib.binarmvp.model.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this)
    private val studentList = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        presenter.saySomething()
        presenter.getStudents()
    }

    private fun setupView() {
        this.title = "MVP Example"
        rvStudentList.run {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
    }

    override fun sayHello(hello: String) {
        println(hello)
        Toast.makeText(this, hello, Toast.LENGTH_SHORT).show()
    }

    override fun showStudents(results: List<Student>) {
        studentList.clear()
        studentList.addAll(results)
        studentAdapter.notifyDataSetChanged()
    }
}
