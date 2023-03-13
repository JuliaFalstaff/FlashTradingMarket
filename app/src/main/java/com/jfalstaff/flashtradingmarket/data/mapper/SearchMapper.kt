package com.jfalstaff.flashtradingmarket.data.mapper

import com.jfalstaff.flashtradingmarket.data.network.dto.SearchDto
import com.jfalstaff.flashtradingmarket.domain.entity.Search
import javax.inject.Inject

class SearchMapper @Inject constructor() {

    fun mapSearchResultDtoToEntity(searchDto: SearchDto): Search {
        return Search(
            words = searchDto.words
        )
    }
}