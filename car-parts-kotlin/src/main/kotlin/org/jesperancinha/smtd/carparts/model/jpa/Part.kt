package org.jesperancinha.smtd.carparts.model.jpa

import jakarta.persistence.*

@Entity
@Table(name = "PARTS")
data class Part(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String
)
