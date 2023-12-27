package com.bssm.portfolio.controller.rq

import com.bssm.portfolio.service.dto.CreateAttachFileDto

data class UploadAttachFileRq(
    val fileUid: String,
    val filePath: String,
    val fileName: String,
    val fileSize: Long,
)

fun UploadAttachFileRq.toDto() = CreateAttachFileDto(
    fileUid = fileUid,
    filePath = filePath,
    fileName = fileName,
    fileSize = fileSize
)
