package repository

import client.entity.ElasticsearchResponse

interface ZipcodeRepository {

    suspend fun completeByZipcode(input: String): ElasticsearchResponse
}
