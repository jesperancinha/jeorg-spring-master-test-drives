package org.jesperancinha.repeateddislikes.badfix.dao

import org.jesperancinha.repeateddislikes.badfix.domain.Receipt
import org.jesperancinha.repeateddislikes.badfix.domain.Shop
import org.jesperancinha.repeateddislikes.badfix.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BadFixUserRepository : JpaRepository<User, UUID>

interface BadFixReceiptRepository: JpaRepository<Receipt, UUID>

interface BadFixShopRepository: JpaRepository<Shop, UUID>