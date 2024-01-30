package org.jesperancinha.repeateddislikes.fix.services

import org.jesperancinha.repeateddislikes.fix.dao.ReceiptRepository
import org.jesperancinha.repeateddislikes.fix.dao.ShopRepository
import org.jesperancinha.repeateddislikes.fix.dao.UserRepository
import org.jesperancinha.repeateddislikes.fix.dtos.toDto
import org.springframework.stereotype.Service

@Service
class DislikeService(
    val userRepository: UserRepository,
    val receiptRepository: ReceiptRepository,
    val shopRepository: ShopRepository
) {
    fun getAllUsers() = userRepository.findAll().map { it.toDto() }

    fun getAllReceipts() = receiptRepository.findAll()

    fun getAllShops() = shopRepository.findAll()
}