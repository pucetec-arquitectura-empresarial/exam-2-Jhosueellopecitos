package com.pucetec.exam2.controller

import com.pucetec.exam2.models.entities.Cars
import com.pucetec.exam2.models.entities.Parket
import com.pucetec.exam2.services.CarsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.pucetec.exam2.repositories.ParketRepository
import com.pucetec.exam2.services.ParketService

@RestController
@RequestMapping("/api/parking")
class CarsController(private val carsService: CarsService,
private val parketRepository: ParketRepository) {

    @GetMapping("/availability")
    fun disponibilidad(): ResponseEntity<Map<String, Number>> {
        val total = parketRepository.sumTotalCapacity()
        val ocupados = parketRepository.sumOccupiedSpots()
        val disponibles = total.toInt() - ocupados.toInt()

        val respuesta = mapOf(
            "capacidad_total" to total,
            "puestos_ocupados" to ocupados,
            "puestos_disponibles" to disponibles
        )
        return ResponseEntity.ok(respuesta)
    }


    @PostMapping("/entry")
    fun registrarEntrada(@RequestBody cars: Cars): ResponseEntity<Cars> {
        val result = carsService.registrarEntrada(cars)
        return ResponseEntity(result, HttpStatus.CREATED)
    }

    @PostMapping("/exit/{id}")
    fun registrarSalida(@PathVariable id: Long): ResponseEntity<String> {
        val mensaje = carsService.registrarSalida(id)
        return ResponseEntity(mensaje, HttpStatus.OK)
    }
}
