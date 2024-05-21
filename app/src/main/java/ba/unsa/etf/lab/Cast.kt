package ba.unsa.etf.lab

import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
)
