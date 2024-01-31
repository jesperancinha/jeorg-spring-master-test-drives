package org.jesperancinha.repeateddislikes.fix.controllers

import org.jesperancinha.repeateddislikes.fix.dtos.UserDTO
import org.jesperancinha.repeateddislikes.fix.services.DislikeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("fix")
class DislikesController(
    val dislikeService: DislikeService
) {

    @GetMapping("users/all")
    fun getAllUsers() = dislikeService.getAllUsers()

    @GetMapping("receipts/all")
    fun getAllReceipts() = dislikeService.getAllReceipts()

    @GetMapping("shops/all")
    fun getAllShops() = dislikeService.getAllShops()

    @PostMapping("users")
    fun createUser(@RequestBody userDTO: UserDTO) = dislikeService.create(userDTO)
}