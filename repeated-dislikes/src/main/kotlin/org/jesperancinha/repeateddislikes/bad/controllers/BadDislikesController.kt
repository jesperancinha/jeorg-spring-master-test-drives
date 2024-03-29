package org.jesperancinha.repeateddislikes.bad.controllers

import org.jesperancinha.repeateddislikes.bad.services.BadDislikeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bad")
class BadDislikesController(
    val dislikeService: BadDislikeService
) {

    @GetMapping("users/all")
    fun getAllUsers() = dislikeService.getAllUsers()

    @GetMapping("receipts/all")
    fun getAllReceipts() = dislikeService.getAllReceipts()

    @GetMapping("shops/all")
    fun getAllShops() = dislikeService.getAllShops()
}