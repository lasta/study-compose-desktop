package repository

import client.ElasticsearchClient
import client.entity.ElasticsearchResponse
import repository.entity.BoolQuery
import repository.entity.ElasticsearchQuery
import repository.entity.FieldQuery
import repository.entity.MustQuery
import repository.entity.TermQuery
import repository.entity.ValueQuery

class ZipcodeRepositoryImpl(
    private val client: ElasticsearchClient
) : ZipcodeRepository {
    override suspend fun completeByZipcode(input: String): ElasticsearchResponse =
        client.exec(input.toCompletionZipcodeQuery())

    companion object {
        private fun String.toCompletionZipcodeQuery(): ElasticsearchQuery = ElasticsearchQuery(
            query = TermQuery(
                bool = BoolQuery(
                    must = listOf(
                        MustQuery(
                            term = FieldQuery(
                                valueQuery = ValueQuery(
                                    value = this
                                )
                            )
                        )
                    )
                )
            )

        )
    }
}
