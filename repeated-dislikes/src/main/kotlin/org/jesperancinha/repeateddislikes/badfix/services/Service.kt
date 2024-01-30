package org.jesperancinha.repeateddislikes.badfix.services

import org.jesperancinha.repeateddislikes.badfix.dao.*
import org.jesperancinha.repeateddislikes.badfix.dtos.toDto
import org.springframework.stereotype.Service

@Service
class BadFixDislikeService(
    val userRepository: BadFixUserRepository,
    val receiptRepository: BadFixReceiptRepository,
    val shopRepository: BadFixShopRepository
) {
    fun getAllUsers() = userRepository.findAll().map { it.toDto() }

    fun getAllReceipts() = receiptRepository.findAll()

    fun getAllShops() = shopRepository.findAll()
}