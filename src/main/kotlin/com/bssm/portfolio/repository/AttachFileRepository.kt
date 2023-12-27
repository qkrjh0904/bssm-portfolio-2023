package com.bssm.portfolio.repository

import com.bssm.portfolio.domain.entity.AttachFile
import org.springframework.data.jpa.repository.JpaRepository

interface AttachFileRepository : JpaRepository<AttachFile, Long> {
    fun findByFileUid(fileUid: String): AttachFile?
}
