package service

import repository.ZipcodeRepository
import service.entity.ZipcodeCandidate

class ZipcodeServiceImpl(override val repository: ZipcodeRepository) : ZipcodeService {
    override suspend fun completeByZipcode(zipcodeFragment: String): Iterable<ZipcodeCandidate> {
        val documents = repository.completeByZipcode(zipcodeFragment)
        return documents.hits.hitDocuments?.map { document ->
            ZipcodeCandidate(
                zipcode = document.source.zipcode,
                address = with(document.source) { prefectureName + cityName + townName },
                ruby = with(document.source) { prefectureRuby + cityRuby + townRuby }
            )
        } ?: emptyList()
    }
}
