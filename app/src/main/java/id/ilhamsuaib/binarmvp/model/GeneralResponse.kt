package id.ilhamsuaib.binarmvp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

data class GeneralResponse<T>(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("data")
    val data: T?,

    @field:SerializedName("error")
    val error: ErrorResponse?
)