package org.jesperancinha.repeateddislikes.bad.controllers

import org.jesperancinha.repeateddislikes.bad.services.DislikeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bad")
class BadDislikesController(
    val dislikeService: DislikeService
) {

    @GetMapping("users/all")
    fun getAllUsers() = dislikeService.getAllUsers()

    @GetMapping("reports/all")
    fun getAllReports() = dislikeService.getAllReports()

    @GetMapping("shops/all")
    fun getAllShops() = dislikeService.getAllShops()
}