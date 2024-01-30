package org.jesperancinha.repeateddislikes.badfix.controllers

import org.jesperancinha.repeateddislikes.badfix.services.BadFixDislikeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("badfix")
class BadFixDislikesController(
    val dislikeService: BadFixDislikeService
) {

    @GetMapping("users/all")
    fun getAllUsers() = dislikeService.getAllUsers()

    @GetMapping("receipts/all")
    fun getAllReceipts() = dislikeService.getAllReceipts()

    @GetMapping("shops/all")
    fun getAllShops() = dislikeService.getAllShops()
}