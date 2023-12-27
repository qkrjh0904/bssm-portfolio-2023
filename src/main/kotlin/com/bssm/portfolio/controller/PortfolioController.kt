package com.bssm.portfolio.controller

import com.bssm.portfolio.controller.rq.CreatePortfolioRq
import com.bssm.portfolio.controller.rq.toDto
import com.bssm.portfolio.global.ApiPath
import com.bssm.portfolio.service.PortfolioService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PortfolioController(
    private val portfolioService: PortfolioService,
) {

    @PostMapping(ApiPath.PORTFOLIO_V1)
    fun createPortfolio(@RequestBody rq: CreatePortfolioRq): Long {
        return portfolioService.create(rq.toDto())
    }
}
