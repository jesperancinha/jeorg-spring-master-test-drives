package org.jesperancinha.smtd.furniture.dto

data class ChairDto(
    var id: Long,
    var designation: String?,
    var weight: Long?
) {
    constructor() : this(0L, null, null)
}