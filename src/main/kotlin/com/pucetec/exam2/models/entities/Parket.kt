package com.pucetec.exam2.models.entities

import jakarta.persistence.*
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name = "parket")
data class Parket (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    val level: Number? = null,
    val total_capacity: Number? = null,
    val occupied_spots: Number? = null
)

