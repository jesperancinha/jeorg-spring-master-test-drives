package org.jesperancinha.repeateddislikes.bad.services

import org.jesperancinha.repeateddislikes.bad.dao.ReceiptRepository
import org.jesperancinha.repeateddislikes.bad.dao.ShopRepository
import org.jesperancinha.repeateddislikes.bad.dao.UserRepository
import org.jesperancinha.repeateddislikes.bad.dtos.toDto
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