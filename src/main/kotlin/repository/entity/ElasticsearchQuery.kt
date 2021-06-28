package repository.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO: refactor
@Serializable
data class ElasticsearchQuery(
    @SerialName("query")
    val query: TermQuery
)

@Serializable
data class TermQuery(
    @SerialName("bool")
    val bool: BoolQuery
)

@Serializable
data class BoolQuery(
    @SerialName("must")
    val must: List<MustQuery>
)

@Serializable
data class MustQuery(
    @SerialName("term")
    val term: FieldQuery
)

@Serializable
data class FieldQuery(
    @SerialName("zipcode.edges")
    val valueQuery: ValueQuery
)

@Serializable
data class ValueQuery(
    @SerialName("value")
    val `value`: String
)
