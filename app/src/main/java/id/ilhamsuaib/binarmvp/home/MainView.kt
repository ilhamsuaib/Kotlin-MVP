package id.ilhamsuaib.binarmvp.home

import id.ilhamsuaib.binarmvp.model.Student

/**
 * Created by @ilhamsuaib on 13/03/19.
 * github.com/ilhamsuaib
 */

interface MainView {

    fun sayHello(hello: String)
    fun showStudents(results: List<Student>)
}