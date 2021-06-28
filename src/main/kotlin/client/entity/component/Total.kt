package client.entity.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Total(
    @SerialName("value")
    val value: Int,
    @SerialName("relation")
    val relation: String,
)
