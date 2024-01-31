package org.jesperancinha.repeateddislikes.badfix.domain


import jakarta.persistence.*
import java.util.UUID
import kotlin.random.Random

const val SCHEMA_BAD = "BADFIX"

@Table(name = "users", schema = SCHEMA_BAD)
@Entity(name = "badfix_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "receipt_id")]
    )
    val receipts: List<Receipt>,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "shop_id")]
    )
    val shops: Set<Shop>
)


@Table(name = "receipts", schema = SCHEMA_BAD)
@Entity(name = "badfix_receipt")
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
@Entity(name = "badfix_shop")
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name = "receipt_id")],
        inverseJoinColumns = [JoinColumn(name = "id")]
    )
    val receipts: List<Receipt>
)

