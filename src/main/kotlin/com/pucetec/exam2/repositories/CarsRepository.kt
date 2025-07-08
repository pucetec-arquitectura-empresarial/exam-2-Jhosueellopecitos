package com.pucetec.exam2.repositories

import com.pucetec.exam2.models.entities.Cars
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CarsRepository : JpaRepository<Cars, Long>
