package ba.unsa.etf.lab.data


import ba.unsa.etf.lab.data.Cast
import com.google.gson.annotations.SerializedName

data class GetCastResponse(
    @SerializedName("id") val page: Int,
    @SerializedName("cast") val cast: List<Cast>
)
