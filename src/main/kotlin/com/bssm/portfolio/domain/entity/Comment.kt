package com.bssm.portfolio.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class Comment(
    content: String,
    portfolio: Portfolio,
    member: Member,
    comment: Comment?,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var content: String = content

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "portfolio_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_COMMENT_PORTFOLIO_ID")
    )
    var portfolio: Portfolio = portfolio
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "member_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_COMMENT_MEMBER_ID")
    )
    var member: Member = member
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "parent_id",
        foreignKey = ForeignKey(name = "FK_COMMENT_PARENT_ID")
    )
    var parent: Comment? = comment
        protected set
}
