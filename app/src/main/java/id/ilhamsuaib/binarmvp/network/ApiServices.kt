package id.ilhamsuaib.binarmvp.network

import id.ilhamsuaib.binarmvp.model.NewStudentResponse
import id.ilhamsuaib.binarmvp.model.StudentResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by @ilhamsuaib on 14/03/19.
 * github.com/ilhamsuaib
 */

interface ApiServices {

    @GET("api/v1/student/all")
    fun getAllStudents(): Call<StudentResponse>

    @Headers("Content-Type: application/json")
    @POST("api/v1/student/")
    fun newStudent(@Body studentMap: Map<String, String>): Call<NewStudentResponse>

    @DELETE("api/v1/student/{studentId}")
    fun deleteStudent(@Path("studentId") id: Int): Call<NewStudentResponse>

}











