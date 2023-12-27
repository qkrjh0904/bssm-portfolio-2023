package com.bssm.portfolio.service

import com.bssm.portfolio.domain.enums.PortfolioProtectType
import com.bssm.portfolio.domain.enums.PortfolioThemeType
import com.bssm.portfolio.service.dto.CreateAttachFileDto
import com.bssm.portfolio.service.dto.CreateMemberDto
import com.bssm.portfolio.service.dto.CreatePortfolioDto
import com.bssm.portfolio.service.dto.SearchPortfolioDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class PortfolioReadServiceTest(
    private val portfolioService: PortfolioService,
    private val portfolioReadService: PortfolioReadService,
    private val memberService: MemberService,
    private val attachFileService: AttachFileService,
) : BehaviorSpec({

    beforeSpec {
        val dto = CreateMemberDto("qkrwjdgh0904@naver.com", "1234", "박정호")
        memberService.create(dto)

        val videoFileDto = CreateAttachFileDto("fileUid01", "filePath", "fileName", 100L)
        val thumbnailFileDto = CreateAttachFileDto("fileUid02", "filePath", "fileName", 100L)
        attachFileService.create(videoFileDto)
        attachFileService.create(thumbnailFileDto)

        for (i in 1..20) {
            val portfolioDto = CreatePortfolioDto(
                "제목$i", PortfolioThemeType.APP, PortfolioProtectType.PUBLIC, "설명", "웹 주소",
                "깃 주소", 1, "fileUid01", "fileUid02"
            )
            portfolioService.create(portfolioDto)
        }
    }

    given("포트폴리오 상세 조회") {
        `when`("포트폴리오를 조회한다.") {
            val portfolio = portfolioReadService.findByIdOrThrow(1L)
            then("포트폴리오가 정상적으로 조회 된다.") {
                portfolio shouldNotBe null
            }
        }
    }

    given("포트폴리오 목록 조회") {
        `when`("포트폴리오 목록을 조회한다.") {
            val portfolios = portfolioReadService.findPageBy(PageRequest.of(0, 3), SearchPortfolioDto(null))
            then("포트폴리오 목록이 정상적으로 조회 된다.") {
                portfolios.content.size shouldBe 3
                portfolios.content[0].title shouldBe "제목20"
            }
        }
    }
})
