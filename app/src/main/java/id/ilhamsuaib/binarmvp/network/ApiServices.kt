package id.ilhamsuaib.binarmvp.network

import id.ilhamsuaib.binarmvp.model.NewStudentResponse
import id.ilhamsuaib.binarmvp.model.StudentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

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
}