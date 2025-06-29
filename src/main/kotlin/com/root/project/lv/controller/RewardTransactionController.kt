package com.root.project.lv.controller

import com.root.project.lv.model.RewardTxn
import com.root.project.lv.service.RewardTransactionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rewards")
class RewardTransactionController(private val service: RewardTransactionService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}") fun getById(@PathVariable id: String) = service.getById(id)

    @PostMapping fun create(@RequestBody tx: RewardTxn) = service.create(tx)

    @PutMapping("/{id}") fun update(@PathVariable id: String, @RequestBody tx: RewardTxn) = service.update(id, tx)

    @DeleteMapping("/{id}") fun delete(@PathVariable id: String) = service.delete(id)
}
