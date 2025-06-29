package com.root.project.lv.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document(collection = "dataset")
data class Dataset(
    val id: String = UUID.randomUUID().toString(),
    val groupId:String? = null,
    val name: String,
    val description: String,
    val dataType: DataType, // TEXT, IMAGE, AUDIO, VIDEO
    val formatRequirements: String, // e.g., "Max 60 seconds audio, WAV format"
    val sampleCountGoal: Int,
    val baseRewardPerSample: Double,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val status: DatasetStatus = DatasetStatus.ACTIVE // ACTIVE, CLOSED, COMPLETED
)

enum class DataType{ TEXT, IMAGE, VIDEO, AUDIO }
enum class DatasetStatus{ ACTIVE, CLOSED, COMPLETED }

