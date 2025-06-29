package com.root.project.lv.service

import com.root.project.lv.model.User
import com.root.project.lv.repo.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepo) {

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: String): User? = userRepository.findById(id).orElse(null)

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(id: String, updatedUser: User): User? {
        return if (userRepository.existsById(id)) {
            userRepository.save(updatedUser.copy(id = id))
        } else null
    }

    fun deleteUser(id: String) = userRepository.deleteById(id)
}
