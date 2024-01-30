package org.jesperancinha.repeateddislikes.bad.services

import org.jesperancinha.repeateddislikes.bad.dao.*
import org.jesperancinha.repeateddislikes.bad.dtos.toDto
import org.springframework.stereotype.Service

@Service
class BadDislikeService(
    val userRepository: BadUserRepository,
    val receiptRepository: BadReceiptRepository,
    val shopRepository: BadShopRepository
) {
    fun getAllUsers() = userRepository.findAll().map { it.toDto() }

    fun getAllReceipts() = receiptRepository.findAll()

    fun getAllShops() = shopRepository.findAll()
}