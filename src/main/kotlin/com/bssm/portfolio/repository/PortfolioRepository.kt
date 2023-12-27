package com.bssm.portfolio.repository

import com.bssm.portfolio.domain.entity.Portfolio
import org.springframework.data.jpa.repository.JpaRepository

interface PortfolioRepository : JpaRepository<Portfolio, Long>
