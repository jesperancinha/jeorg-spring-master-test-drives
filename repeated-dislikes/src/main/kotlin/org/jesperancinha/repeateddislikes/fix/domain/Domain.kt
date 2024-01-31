package org.jesperancinha.repeateddislikes.fix.domain


import jakarta.persistence.*
import java.util.*

const val SCHEMA = "fix"

@Table(name = "users", schema = SCHEMA)
@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = UUID.randomUUID(),
    val name: String,
    @OneToMany(cascade = [CascadeType.DETACH], fetch = FetchType.EAGER)
    @JoinTable(
        schema = SCHEMA,
        name = "USERS_RECEIPTS"
    )
    val receipts: List<Receipt>,
    @OneToMany(cascade = [CascadeType.DETACH], fetch = FetchType.EAGER)
    @JoinTable(
        schema = SCHEMA,
        name = "USERS_SHOPS"
    )val shops: List<Shop>
)

@Table(name = "receipts", schema = SCHEMA)
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



@Table(name = "shops", schema = SCHEMA)
@Entity
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @OneToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    val receipts: List<Receipt>
)
