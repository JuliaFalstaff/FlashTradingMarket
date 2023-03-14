package com.jfalstaff.flashtradingmarket.data.mapper

import com.jfalstaff.flashtradingmarket.data.network.dto.SearchDto
import com.jfalstaff.domain.entity.Search
import javax.inject.Inject

class SearchMapper @Inject constructor() {

    fun mapSearchResultDtoToEntity(searchDto: SearchDto): com.jfalstaff.domain.entity.Search {
        return com.jfalstaff.domain.entity.Search(
            words = searchDto.words
        )
    }
}