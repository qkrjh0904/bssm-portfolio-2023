package com.bssm.portfolio.service

import com.bssm.portfolio.domain.entity.Member
import com.bssm.portfolio.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberReadService(
    private val memberRepository: MemberRepository,
) {
    fun findByIdOrThrow(id: Long): Member {
        return memberRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("해당 회원이 존재하지 않습니다.")
    }
}
