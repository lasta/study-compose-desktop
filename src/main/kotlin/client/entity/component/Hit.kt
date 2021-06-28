package client.entity.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hit<T>(
    @SerialName("_index")
    val index: String,

    @SerialName("_id")
    val id: String,

    @SerialName("_score")
    val score: Double,

    @SerialName("_source")
    val source: T
)
