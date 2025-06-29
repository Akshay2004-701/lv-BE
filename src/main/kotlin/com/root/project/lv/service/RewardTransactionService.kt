package com.root.project.lv.service

import com.root.project.lv.model.RewardTxn
import com.root.project.lv.repo.TxnRepo
import org.springframework.stereotype.Service

@Service
class RewardTransactionService(private val repository: TxnRepo) {

    fun getAll(): List<RewardTxn> = repository.findAll()

    fun getById(id: String): RewardTxn? = repository.findById(id).orElse(null)

    fun create(tx: RewardTxn): RewardTxn = repository.save(tx)

    fun update(id: String, tx: RewardTxn): RewardTxn? {
        return if (repository.existsById(id)) {
            repository.save(tx.copy(id = id))
        } else null
    }

    fun delete(id: String) = repository.deleteById(id)
}
