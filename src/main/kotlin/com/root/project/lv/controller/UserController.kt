package com.root.project.lv.controller

import com.root.project.lv.model.User
import com.root.project.lv.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers() = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String) = userService.getUserById(id)

    @PostMapping
    fun createUser(@RequestBody user: User) = userService.createUser(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody user: User) =
        userService.updateUser(id, user)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String) = userService.deleteUser(id)
}
