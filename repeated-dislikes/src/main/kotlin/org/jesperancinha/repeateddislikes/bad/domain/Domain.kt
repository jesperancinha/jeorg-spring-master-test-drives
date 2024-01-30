package org.jesperancinha.repeateddislikes.bad.domain


import jakarta.persistence.*
import java.util.UUID

const val SCHEMA_BAD = "bad"

@Table(name = "users", schema = SCHEMA_BAD)
@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name= "user_id")],
        inverseJoinColumns = [JoinColumn(name="receipt_id")]
    )
    val receipts: List<Receipt>,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name= "user_id")],
        inverseJoinColumns = [JoinColumn(name="shop_id")]
    )
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
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name= "receipt_id")],
        inverseJoinColumns = [JoinColumn(name="id")]
    )
    val receipts: List<Receipt>
)
