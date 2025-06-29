package com.root.project.lv.repo

import com.root.project.lv.model.*
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo:MongoRepository<User,String>

@Repository
interface DatasetRepo:MongoRepository<Dataset,String>

@Repository
interface ContributionRepo:MongoRepository<Contribution,String>

@Repository
interface VerilogRepo:MongoRepository<VerificationLog,String>

@Repository
interface TxnRepo:MongoRepository<RewardTxn,String>