package com.bssm.portfolio.controller.rq

import com.bssm.portfolio.domain.enums.PortfolioProtectType
import com.bssm.portfolio.domain.enums.PortfolioThemeType
import com.bssm.portfolio.service.dto.CreatePortfolioDto

data class CreatePortfolioRq(
    val title: String,
    val theme: PortfolioThemeType,
    val protectType: PortfolioProtectType,
    val description: String,
    val webUrl: String,
    val gitUrl: String,
    val member: Long,
    val videoFile: String,
    val thumbnailFile: String,
)

fun CreatePortfolioRq.toDto() = CreatePortfolioDto(
    title = title,
    theme = theme,
    protectType = protectType,
    description = description,
    webUrl = webUrl,
    gitUrl = gitUrl,
    memberId = member,
    videoFileUid = videoFile,
    thumbnailFileUid = thumbnailFile
)
