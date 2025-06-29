package com.root.project.lv.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document( collection = "users")
data class User(
    val id: String = UUID.randomUUID().toString(),
    val walletAddress: String,
    val username: String?,
    val joinedAt: LocalDateTime = LocalDateTime.now(),
    val totalScore: Double = 0.0,
    val totalContributions: Int = 0,
    val tokenBalance: Double = 0.0
)

