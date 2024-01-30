package org.jesperancinha.repeateddislikes.fix.domain


import jakarta.persistence.*
import java.util.UUID

const val SCHEMA_BAD = "fix"

@Table(name = "users", schema = SCHEMA_BAD)
@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @OneToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    val receipts: List<Receipt>,
    @OneToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    val shops: List<Shop>
)

@Table(name = "receipts", schema = SCHEMA_BAD)
@Entity
data class Receipt(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    @OneToOne
    val user: User,
    @OneToOne
    val shop: Shop
)



@Table(name = "shops", schema = SCHEMA_BAD)
@Entity
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @OneToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    val receipts: List<Receipt>
)
