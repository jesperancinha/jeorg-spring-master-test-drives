package org.jesperancinha.repeateddislikes.fix.dao

import org.jesperancinha.repeateddislikes.fix.domain.Receipt
import org.jesperancinha.repeateddislikes.fix.domain.Shop
import org.jesperancinha.repeateddislikes.fix.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID>

interface ReceiptRepository: JpaRepository<Receipt, UUID>

interface ShopRepository: JpaRepository<Shop, UUID>