package com.root.project.lv.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document(collection = "verilog")
data class VerificationLog(
    val id: String = UUID.randomUUID().toString(),
    val contributionId: String,
    val modelUsed: String,
    val score: Double,
    val reason: String,
    val verifiedAt: LocalDateTime
)

