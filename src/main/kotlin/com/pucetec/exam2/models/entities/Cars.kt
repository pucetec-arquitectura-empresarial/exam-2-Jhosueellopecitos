package com.pucetec.exam2.models.entities

import jakarta.persistence.*
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.time.LocalDateTime


@Entity
@Table(name = "cars")
data class Cars (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var ingreso: Boolean = false,

    var fechaEntrada: LocalDateTime? = null,

    var fechaSalida: LocalDateTime? = null,

    var assignedFloor: String? = null
)
