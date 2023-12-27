package com.bssm.portfolio.service.dto

import com.bssm.portfolio.domain.entity.AttachFile
import com.bssm.portfolio.domain.entity.Member
import com.bssm.portfolio.domain.entity.Portfolio
import com.bssm.portfolio.domain.enums.PortfolioProtectType
import com.bssm.portfolio.domain.enums.PortfolioThemeType

data class CreatePortfolioDto(
    val title: String,
    val theme: PortfolioThemeType,
    val protectType: PortfolioProtectType,
    val description: String,
    val webUrl: String,
    val gitUrl: String,
    val memberId: Long,
    val videoFileUid: String,
    val thumbnailFileUid: String,
)

fun CreatePortfolioDto.toEntity(
    member: Member,
    videoFile: AttachFile,
    thumbnailFile: AttachFile,
) = Portfolio(
    title = title,
    theme = theme,
    protectType = protectType,
    description = description,
    webUrl = webUrl,
    gitUrl = gitUrl,
    member = member,
    videoFile = videoFile,
    thumbnailFile = thumbnailFile
)
