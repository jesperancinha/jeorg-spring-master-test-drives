package org.jesperancinha.smtd.furniture.model

import jakarta.persistence.*

@Entity
@Table(name = "shelf_case")
data class Case(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var designation: String?,
    var weight: Long?
) {
    constructor() : this(0L, null, null)
}