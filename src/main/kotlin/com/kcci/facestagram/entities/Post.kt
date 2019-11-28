package com.kcci.facestagram.entities

import java.time.LocalDateTime

class Post : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = postId

    var postId: Int = 0
    var userId: Int = 0
    var content: String = ""
    var lastModified: LocalDateTime? = null
    var planStartDatetime: LocalDateTime? = null
    var planEndDatetime: LocalDateTime? = null
    var placeId: Int = 0
    var accessibleLevelId: Int = 1
}