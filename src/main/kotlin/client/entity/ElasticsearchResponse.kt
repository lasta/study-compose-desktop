package client.entity

import client.entity.component.Hits
import client.entity.component.Shards
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ElasticsearchResponse(
    @SerialName("took")
    val took: Int,
    @SerialName("timed_out")
    val timedOut: Boolean,
    @SerialName("_shards")
    val shards: Shards,
    @SerialName("hits")
    val hits: Hits,
)
