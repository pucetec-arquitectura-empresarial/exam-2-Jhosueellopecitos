package com.pucetec.exam2.repositories

import com.pucetec.exam2.models.entities.Parket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ParketRepository : JpaRepository<Parket, Long> {

    @Query("SELECT SUM(p.total_capacity) FROM Parket p")
    fun sumTotalCapacity(): Number

    @Query("SELECT SUM(p.occupied_spots) FROM Parket p")
    fun sumOccupiedSpots(): Number
}

