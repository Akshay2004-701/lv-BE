package com.root.project.lv.service

import com.root.project.lv.model.Dataset
import com.root.project.lv.repo.DatasetRepo
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class DatasetService(
    private val repository: DatasetRepo,
    private val uploadService: UploadService
) {

    fun getAll(): List<Dataset> = repository.findAll()

    fun getById(id: String): Dataset? = repository.findById(id).orElse(null)

    fun create(dataset: Dataset): Dataset {
        val seed = (1..8).map { "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"[
            Random(dataset.hashCode().toLong()).nextInt(62)] }.joinToString("")
        return repository.save(
            dataset.copy(groupId = uploadService.createGroup(seed))
        )
    }

    fun update(id: String, dataset: Dataset): Dataset? {
        return if (repository.existsById(id)) {
            repository.save(dataset.copy(id = id))
        } else null
    }

    fun delete(id: String) = repository.deleteById(id)
}
