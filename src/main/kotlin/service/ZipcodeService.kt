package service

import repository.ZipcodeRepository
import service.entity.ZipcodeCandidate

interface ZipcodeService {
    val repository: ZipcodeRepository

    suspend fun completeByZipcode(zipcodeFragment: String): Iterable<ZipcodeCandidate>
}
