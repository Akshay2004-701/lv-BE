package com.root.project.lv.controller

import com.root.project.lv.model.VerificationLog
import com.root.project.lv.service.VerificationLogService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/verification-logs")
class VerificationLogController(private val service: VerificationLogService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}") fun getById(@PathVariable id: String) = service.getById(id)

    @PostMapping
    fun create(@RequestBody log: VerificationLog) = service.create(log)

    @PutMapping("/{id}") fun update(@PathVariable id: String, @RequestBody log: VerificationLog) = service.update(id, log)

    @DeleteMapping("/{id}") fun delete(@PathVariable id: String) = service.delete(id)
}
