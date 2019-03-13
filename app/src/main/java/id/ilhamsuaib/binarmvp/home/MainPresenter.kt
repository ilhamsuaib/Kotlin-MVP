package id.ilhamsuaib.binarmvp.home

import id.ilhamsuaib.binarmvp.model.Student

/**
 * Created by @ilhamsuaib on 13/03/19.
 * github.com/ilhamsuaib
 */

class MainPresenter(private val view: MainView) {

    fun saySomething() {
        view.sayHello("Hello World!")
    }

    fun getStudents() {
        /*anggap aja sumber datanya dari API / DB*/
        val studentList = mutableListOf<Student>()
        studentList.run {
            add(Student("Ilham", "ilham@gmail.com"))
            add(Student("Ilham", "ilham@gmail.com"))
            add(Student("Ahmad Dhani", "ahmad@gmail.com"))
            add(Student("Ahmad Dhani", "ahmad@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("Al ", "al@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("Dul ", "dul@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("El ", "el@gmail.com"))
            add(Student("Dul ", "dul@gmail.com"))
        }

        view.showStudents(studentList)
    }
}