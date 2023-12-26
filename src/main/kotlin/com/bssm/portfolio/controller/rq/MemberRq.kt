package com.bssm.portfolio.controller.rq

import com.bssm.portfolio.service.dto.CreateMemberDto

data class MemberRq(
    val email: String,
    val password: String,
    val name: String,
)

fun MemberRq.toDto(): CreateMemberDto {
    return CreateMemberDto(
        email = email,
        password = password,
        name = name
    )
}
