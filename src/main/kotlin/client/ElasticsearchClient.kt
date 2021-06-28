package client

import client.entity.ElasticsearchResponse
import io.ktor.client.HttpClient
import repository.entity.ElasticsearchQuery

interface ElasticsearchClient {

    val httpClientSupplier: () -> HttpClient

    suspend fun exec(body: ElasticsearchQuery): ElasticsearchResponse
}
