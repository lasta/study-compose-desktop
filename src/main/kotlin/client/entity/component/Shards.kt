package client.entity.component

import kotlinx.serialization.Serializable

@Serializable
data class Shards(
    val total: Int,
    val successful: Int,
    val skipped: Int,
    val failed: Int
)
