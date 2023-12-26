package com.bssm.portfolio.controller

import com.bssm.portfolio.controller.rq.MemberRq
import com.bssm.portfolio.controller.rq.toDto
import com.bssm.portfolio.global.ApiPath
import com.bssm.portfolio.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService,
) {

    @PostMapping(ApiPath.MEMBER_V1)
    fun createMember(@RequestBody rq: MemberRq): Long {
        return memberService.create(rq.toDto())
    }
}
