package client.entity.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hits(
    @SerialName("total")
    val total: Total,
    @SerialName("max_score")
    val maxScore: Double?,
    @SerialName("hits")
    val hitDocuments: List<Hit<ZipcodeDocument>>?
)
