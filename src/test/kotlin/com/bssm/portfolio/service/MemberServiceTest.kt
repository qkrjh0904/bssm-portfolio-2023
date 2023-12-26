package com.bssm.portfolio.service

import com.bssm.portfolio.repository.MemberRepository
import com.bssm.portfolio.service.dto.CreateMemberDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class MemberServiceTest(
    private val memberService: MemberService,
    private val memberRepository: MemberRepository,
) : BehaviorSpec({

    given("멤버 데이터 생성") {
        val dto = CreateMemberDto("qkrwjdgh0904@naver.com", "1234", "박정호")
        `when`("멤버 데이터를 저장하면") {
            val memberId = memberService.create(dto)

            then("멤버 데이터가 정상적으로 저장되고 ID를 반환한다.") {
                memberRepository.findByIdOrNull(memberId) shouldNotBe null
            }
        }
    }
})
