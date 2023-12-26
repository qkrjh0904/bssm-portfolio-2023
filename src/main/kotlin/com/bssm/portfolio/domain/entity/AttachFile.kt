package com.bssm.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class AttachFile(
    fileUid: String,
    filePath: String,
    fileName: String,
    fileSize: Long,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var fileUid: String = fileUid
        protected set

    @Column(nullable = false)
    var filePath: String = filePath
        protected set

    @Column(nullable = false)
    var fileName: String = fileName
        protected set

    @Column(nullable = false)
    var fileSize: Long = fileSize
        protected set
}
