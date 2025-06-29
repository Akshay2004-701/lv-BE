package com.root.project.lv.controller

import com.root.project.lv.model.Contribution
import com.root.project.lv.service.ContributionService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("/api/contributions")
class ContributionController(private val service: ContributionService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}") fun getById(@PathVariable id: String) = service.getById(id)

    @PostMapping
    fun create(
        @RequestParam file:MultipartFile,
        @RequestParam userId:String,
        @RequestParam datasetId:String
    ): Contribution {
        val tempFile = File(System.getProperty("java.io.tmpdir"), file.originalFilename ?: "uploadedFile")
        file.transferTo(tempFile)
        return service.create(userId,datasetId,tempFile)
    }

    @PutMapping("/{id}") fun update(@PathVariable id: String, @RequestBody contribution: Contribution) = service.update(id, contribution)

    @DeleteMapping("/{id}") fun delete(@PathVariable id: String) = service.delete(id)
}
