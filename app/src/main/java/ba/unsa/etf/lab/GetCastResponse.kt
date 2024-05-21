package ba.unsa.etf.lab


import com.google.gson.annotations.SerializedName

data class GetCastResponse(
    @SerializedName("id") val page: Int,
    @SerializedName("cast") val cast: List<Cast>
)
