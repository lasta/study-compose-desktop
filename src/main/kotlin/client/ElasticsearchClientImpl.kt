package client

import client.entity.ElasticsearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import repository.entity.ElasticsearchQuery


class ElasticsearchClientImpl(
    override val httpClientSupplier: () -> HttpClient = {
        HttpClient(Apache) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
) : ElasticsearchClient {

    override suspend fun exec(body: ElasticsearchQuery): ElasticsearchResponse = httpClientSupplier().use { client ->
        try {
            client.get("$baseUrl/$indexName/$handler") {
                contentType(ContentType.Application.Json)
                this.body = body
            }
        } catch (e: Exception) {
            println(e)
            throw e
        }
    }

    companion object {
        private const val baseUrl = "http://localhost:9200"
        private const val indexName = "zipcode"
        private const val handler = "_search"
    }
}
