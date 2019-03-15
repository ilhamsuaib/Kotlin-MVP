package id.ilhamsuaib.binarmvp.ui.home

import id.ilhamsuaib.binarmvp.model.Student

/**
 * Created by @ilhamsuaib on 13/03/19.
 * github.com/ilhamsuaib
 */

interface MainView {

    fun showStudents(results: List<Student>)
    fun onError(message: String)
}