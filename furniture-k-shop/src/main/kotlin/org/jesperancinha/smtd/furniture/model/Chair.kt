package org.jesperancinha.smtd.furniture.model

import javax.persistence.*

@Entity
@Table(name = "chair")
data class Chair(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: String,
    var designation: String,
    var weight: Long
) {
    constructor() : this("", "", 0L) {
    }
}
