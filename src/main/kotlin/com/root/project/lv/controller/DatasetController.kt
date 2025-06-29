package com.root.project.lv.controller

import com.root.project.lv.model.Dataset
import com.root.project.lv.service.DatasetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/datasets")
class DatasetController(private val service: DatasetService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}") fun getById(@PathVariable id: String) = service.getById(id)

    @PostMapping
    fun create(@RequestBody dataset: Dataset) = service.create(dataset)

    @PutMapping("/{id}") fun update(@PathVariable id: String, @RequestBody dataset: Dataset) = service.update(id, dataset)

    @DeleteMapping("/{id}") fun delete(@PathVariable id: String) = service.delete(id)
}
