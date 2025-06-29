package com.root.project.lv.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document(collection = "txn")
data class RewardTxn(
    val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val contributionId: String,
    val tokensAwarded: Double,
    val timestamp: LocalDateTime,
    val txHash: String
)
