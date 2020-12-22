package healofy.demo.model


import com.google.gson.annotations.SerializedName

data class Song(
    @SerializedName("Album")
    val album: String,
    @SerializedName("Artist")
    val artist: String,
    @SerializedName("Name")
    val name: String
)