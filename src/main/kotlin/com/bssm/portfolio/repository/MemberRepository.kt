package com.bssm.portfolio.repository

import com.bssm.portfolio.domain.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>
