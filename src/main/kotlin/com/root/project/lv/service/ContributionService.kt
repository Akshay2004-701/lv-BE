package com.root.project.lv.service

import com.root.project.lv.model.Contribution
import com.root.project.lv.repo.ContributionRepo
import org.springframework.stereotype.Service
import java.io.File

@Service
class ContributionService(
    private val repository: ContributionRepo,
    private val uploadService: UploadService,
    private val datasetService: DatasetService
) {

    fun getAll(): List<Contribution> = repository.findAll()

    fun getById(id: String): Contribution? = repository.findById(id).orElse(null)

    fun create(userId:String, datasetId:String, file:File): Contribution {
        val grpId = datasetService.getById(datasetId)?.groupId!!
        val contribution = Contribution(
            userId = userId,
            datasetId = datasetId
        )
        val url = uploadService.uploadFile(file,contribution.id,grpId)
        return repository.save(contribution.copy(url=url))
    }

    fun update(id: String, contribution: Contribution): Contribution? {
        return if (repository.existsById(id)) {
            repository.save(contribution.copy(id = id))
        } else null
    }

    fun delete(id: String) = repository.deleteById(id)
}
