package id.ilhamsuaib.binarmvp.network

import id.ilhamsuaib.binarmvp.model.GeneralResponse
import id.ilhamsuaib.binarmvp.model.Student
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
    fun newStudent(@Body studentMap: Map<String, String>): Call<GeneralResponse<Student>>

    @DELETE("api/v1/student/{studentId}")
    fun deleteStudent(@Path("studentId") id: Int): Call<GeneralResponse<Student>>

    @PUT("api/v1/student/{id}")
    fun editStudent(
        @Path("id") studentId: Int,
        @Body map: Map<String, String>
    ): Call<GeneralResponse<Student>>
}











