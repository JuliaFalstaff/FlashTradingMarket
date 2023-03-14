package com.jfalstaff.data.mapper

import com.jfalstaff.data.network.dto.SearchDto
import com.jfalstaff.domain.entity.Search
import javax.inject.Inject

class SearchMapper @Inject constructor() {

    fun mapSearchResultDtoToEntity(searchDto: SearchDto): Search {
        return Search(
            words = searchDto.words
        )
    }
}