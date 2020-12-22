package healofy.demo.model


import com.google.gson.annotations.SerializedName

data class JsonResponse(
    val message: String,
    val payload: Payload
)