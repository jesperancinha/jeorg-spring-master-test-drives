package org.jesperancinha.repeateddislikes.bad.dao

import org.jesperancinha.repeateddislikes.bad.domain.Receipt
import org.jesperancinha.repeateddislikes.bad.domain.Shop
import org.jesperancinha.repeateddislikes.bad.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BadUserRepository : JpaRepository<User, UUID>

interface BadReceiptRepository: JpaRepository<Receipt, UUID>

interface BadShopRepository: JpaRepository<Shop, UUID>