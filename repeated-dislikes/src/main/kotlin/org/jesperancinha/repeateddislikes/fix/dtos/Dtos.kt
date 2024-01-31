package org.jesperancinha.repeateddislikes.fix.dtos

import org.jesperancinha.repeateddislikes.fix.domain.User
import java.util.*

data class UserDTO(
    val id: UUID?,
    val name: String,
    val receipts: List<UUID>,
    val shops: List<String>
)

data class ReceiptDTO(
    val id: UUID,
    val user: UserDTO,
    val shop: ShopDTO
)


data class ShopDTO(
    val id: UUID,
    val name: String,
    val receipts: List<ReceiptDTO>
)


fun User.toDto() = UserDTO (
    id = id,
    name = name,
    receipts = receipts.map { it.id },
    shops = shops.map { it.name }
)

fun UserDTO.toEntity() = User(
    id = id,
    name = name,
    receipts = emptyList(),
    shops = emptyList()
)
