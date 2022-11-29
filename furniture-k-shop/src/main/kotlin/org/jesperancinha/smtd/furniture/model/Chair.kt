package org.jesperancinha.smtd.furniture.model

import jakarta.persistence.*

@Entity
@Table(name = "chair")
data class Chair(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var designation: String?,
    var weight: Long?
) {
    constructor() : this(0L, null, null)
}