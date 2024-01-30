package org.jesperancinha.repeateddislikes.bad.domain


import jakarta.persistence.*
import org.hibernate.annotations.CollectionId
import org.hibernate.annotations.CollectionIdJavaType
import org.hibernate.type.descriptor.java.LongJavaType

const val SCHEMA_BAD = "bad"

@Table(name = "user", schema = SCHEMA_BAD)
@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    val name: String,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.EAGER)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name= "id")],
        inverseJoinColumns = [JoinColumn(name="receipt_id")]
    )
//    @CollectionIdJavaType(value = LongJavaType::class)
//    @CollectionId(column = Column(name="user_receipt_id"))
    val receipts: List<Receipt>,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.EAGER)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name= "id")],
        inverseJoinColumns = [JoinColumn(name="receipt_id")]
    )
//    @CollectionIdJavaType(value = LongJavaType::class)
//    @CollectionId(column = Column(name="user_shop_id"))
    val shops: List<Shop>
)

@Table(name = "receipt", schema = SCHEMA_BAD)
@Entity
data class Receipt(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    @OneToOne
    val user: User,
    @OneToOne
    val shop: Shop
)


@Table(name = "shop", schema = SCHEMA_BAD)
@Entity
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    val name: String,
    @ManyToMany(cascade = [CascadeType.DETACH], fetch = FetchType.EAGER)
    @JoinTable(
        schema = SCHEMA_BAD,
        name = "bad_dislikes_relations",
        joinColumns = [JoinColumn(name= "receipt_id")],
        inverseJoinColumns = [JoinColumn(name="id")]
    )
//    @CollectionIdJavaType(value = LongJavaType::class)
//    @CollectionId(column = Column(name="shop_receipt_id"))
    val receipts: List<Receipt>
)
