package com.bssm.portfolio.service

import com.bssm.portfolio.repository.AttachFileRepository
import com.bssm.portfolio.service.dto.CreateAttachFileDto
import com.bssm.portfolio.service.dto.toEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AttachFileService(
    private val attachFileRepository: AttachFileRepository,
) {
    fun create(dto: CreateAttachFileDto): String {
        // s3업로드 + UID 생성 등등
        val attachFile = attachFileRepository.save(dto.toEntity())
        return attachFile.fileUid
    }
}
