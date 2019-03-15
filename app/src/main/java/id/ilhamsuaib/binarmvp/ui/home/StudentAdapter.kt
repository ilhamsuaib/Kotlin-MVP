package id.ilhamsuaib.binarmvp.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.binarmvp.R
import id.ilhamsuaib.binarmvp.model.Student
import kotlinx.android.synthetic.main.item_student.view.*

/**
 * Created by @ilhamsuaib on 13/03/19.
 * github.com/ilhamsuaib
 */

class StudentAdapter(private val studentList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    override fun onCreateViewHolder(group: ViewGroup, type: Int): StudentHolder {
        val inflater: LayoutInflater = LayoutInflater.from(group.context)
        return StudentHolder(inflater.inflate(R.layout.item_student, group, false))
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        val student = studentList[position]
        holder.bind(student)
    }

    inner class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(student: Student) = itemView.run {
            tvStudentName.text = student.name
            tvStudentEmail.text = student.email
        }
    }
}