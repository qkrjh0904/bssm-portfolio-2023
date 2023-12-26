package com.bssm.portfolio.service.dto

import com.bssm.portfolio.domain.entity.Member

data class CreateMemberDto(
    val email: String,
    val password: String,
    val name: String,
)

fun CreateMemberDto.toEntity(): Member {
    return Member.createAdmin(
        email = email,
        password = password,
        name = name
    )
}
