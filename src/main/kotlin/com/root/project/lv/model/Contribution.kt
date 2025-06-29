package com.root.project.lv.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document(collection = "contribution")
data class Contribution(
    val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val datasetId: String,
    val url: String? = null,
    val uploadedAt: LocalDateTime = LocalDateTime.now(),
    val verificationScore: Double ? = null,
    val status: VerificationStatus = VerificationStatus.PENDING // PENDING, VERIFIED, REJECTED
)

enum class VerificationStatus { PENDING, VERIFIED, REJECTED }

