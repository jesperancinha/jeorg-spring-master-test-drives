package org.jesperancinha.repeateddislikes.bad.dao

import org.jesperancinha.repeateddislikes.bad.domain.Receipt
import org.jesperancinha.repeateddislikes.bad.domain.Shop
import org.jesperancinha.repeateddislikes.bad.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID>

interface ReceiptRepository: JpaRepository<Receipt, UUID>

interface ShopRepository: JpaRepository<Shop, UUID>