package com.bssm.portfolio.service

import com.bssm.portfolio.domain.entity.AttachFile
import com.bssm.portfolio.repository.AttachFileRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AttachFileReadService(
    private val attachFileRepository: AttachFileRepository,
) {
    fun findByFileUidOrThrow(fileUid: String): AttachFile {
        return attachFileRepository.findByFileUid(fileUid)
            ?: throw IllegalArgumentException("해당 파일이 존재하지 않습니다.")
    }
}
