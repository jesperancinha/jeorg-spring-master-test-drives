package org.jesperancinha.smtd.furniture.model

import jakarta.persistence.*

/**
 * Case
 * Spring plugin is specifically not used in this project!
 *
 * @property id
 * @property designation
 * @property weight
 * @constructor Create empty Case
 */
@Entity
@Table(name = "shelf_case")
data class Case(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long?,
    var designation: String?,
    var weight: Long?
) {
    constructor() : this(0L, null, null)

    override fun toString(): String {
        return super.toString()
    }
}