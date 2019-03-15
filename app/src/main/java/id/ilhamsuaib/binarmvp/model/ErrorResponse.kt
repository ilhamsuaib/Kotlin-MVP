package id.ilhamsuaib.binarmvp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

data class ErrorResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("code")
    val code: Int
)