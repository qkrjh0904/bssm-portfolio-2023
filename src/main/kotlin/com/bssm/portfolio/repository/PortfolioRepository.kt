package com.bssm.portfolio.repository

import com.bssm.portfolio.domain.entity.Portfolio
import com.bssm.portfolio.domain.entity.QPortfolio.portfolio
import com.bssm.portfolio.service.dto.SearchPortfolioDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface PortfolioRepository : JpaRepository<Portfolio, Long>, CustomPortfolioRepository

interface CustomPortfolioRepository {
    fun findPageBy(pageRq: PageRequest, dto: SearchPortfolioDto): Page<Portfolio>
}

class PortfolioRepositoryImpl : CustomPortfolioRepository, QuerydslRepositorySupport(Portfolio::class.java) {
    override fun findPageBy(pageRq: PageRequest, dto: SearchPortfolioDto): Page<Portfolio> {
        val result = from(portfolio)
            .where(
                dto.title?.let { portfolio.title.contains(it) }
            )
            .orderBy(portfolio.createDateTime.desc())
            .offset(pageRq.offset)
            .limit(pageRq.pageSize.toLong())
            .fetchResults()
        return PageImpl(result.results, pageRq, result.total)
    }
}
