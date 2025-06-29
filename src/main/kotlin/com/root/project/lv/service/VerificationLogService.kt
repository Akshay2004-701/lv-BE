package com.root.project.lv.service

import com.root.project.lv.model.VerificationLog
import com.root.project.lv.repo.VerilogRepo
import org.springframework.stereotype.Service

@Service
class VerificationLogService(private val repository: VerilogRepo) {

    fun getAll(): List<VerificationLog> = repository.findAll()

    fun getById(id: String): VerificationLog? = repository.findById(id).orElse(null)

    fun create(log: VerificationLog): VerificationLog = repository.save(log)

    fun update(id: String, log: VerificationLog): VerificationLog? {
        return if (repository.existsById(id)) {
            repository.save(log.copy(id = id))
        } else null
    }

    fun delete(id: String) = repository.deleteById(id)
}
