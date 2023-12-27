package com.bssm.portfolio.controller

import com.bssm.portfolio.controller.rq.UploadAttachFileRq
import com.bssm.portfolio.controller.rq.toDto
import com.bssm.portfolio.global.ApiPath
import com.bssm.portfolio.service.AttachFileService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AttachFileController(
    private val attachFileService: AttachFileService,
) {

    @PostMapping(ApiPath.FILE_V1)
    fun uploadFile(@RequestBody rq: UploadAttachFileRq): String {
        return attachFileService.create(rq.toDto())
    }
}
