package com.bssm.portfolio.service

import com.bssm.portfolio.repository.MemberRepository
import com.bssm.portfolio.service.dto.CreateMemberDto
import com.bssm.portfolio.service.dto.toEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun create(dto: CreateMemberDto): Long {
        val member = dto.toEntity()
        memberRepository.save(member)
        return member.id
    }
}
