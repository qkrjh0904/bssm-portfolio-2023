package com.bssm.portfolio.service

import com.bssm.portfolio.domain.entity.Portfolio
import com.bssm.portfolio.repository.PortfolioRepository
import com.bssm.portfolio.service.dto.FindPortfolioDto
import com.bssm.portfolio.service.dto.SearchPortfolioDto
import com.bssm.portfolio.service.dto.toFindPortfoliosDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PortfolioReadService(
    private val portfolioRepository: PortfolioRepository,
) {
    fun findByIdOrThrow(id: Long): Portfolio {
        return portfolioRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("해당 포트폴리오가 존재하지 않습니다.")
    }

    fun findPageBy(pageRq: PageRequest, dto: SearchPortfolioDto): Page<FindPortfolioDto> {
        return portfolioRepository.findPageBy(pageRq, dto).toFindPortfoliosDto()
    }
}
