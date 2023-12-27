package com.bssm.portfolio.service

import com.bssm.portfolio.service.dto.CreateAttachFileDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AttachFileServiceTest(
    private val attachFileService: AttachFileService,
    private val attachFileReadService: AttachFileReadService,
) : BehaviorSpec({

    given("첨부파일 데이터 생성") {
        val dto = CreateAttachFileDto("fileUid", "filePath", "fileName", 100L)
        `when`("첨부파일 데이터를 저장하면") {
            val fileUid = attachFileService.create(dto)
            then("첨부파일 데이터가 정상적으로 저장되고 ID를 반환한다.") {
                attachFileReadService.findByFileUidOrThrow(fileUid) shouldNotBe null
            }
        }
    }

})
