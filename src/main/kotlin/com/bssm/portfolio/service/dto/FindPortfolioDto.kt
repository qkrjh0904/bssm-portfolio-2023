package com.bssm.portfolio.service.dto

import com.bssm.portfolio.domain.entity.Portfolio
import com.bssm.portfolio.domain.enums.PortfolioThemeType
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

data class FindPortfolioDto(
    val id: Long,
    val title: String,
    val theme: PortfolioThemeType,
)

fun Page<Portfolio>.toFindPortfoliosDto() = PageImpl(
    this.content.map { it.toFindPortfoliosDto() },
    this.pageable,
    this.totalElements
)

fun Portfolio.toFindPortfoliosDto() = FindPortfolioDto(
    id = id,
    title = title,
    theme = theme
)
