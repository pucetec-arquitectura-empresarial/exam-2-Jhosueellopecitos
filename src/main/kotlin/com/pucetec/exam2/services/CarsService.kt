package com.pucetec.exam2.services

import com.pucetec.exam2.models.entities.Cars
import com.pucetec.exam2.repositories.CarsRepository
import org.springframework.stereotype.Service

@Service
class CarsService(private val carsRepository: CarsRepository) {

    fun listarVehiculos(): List<Cars> {
        return carsRepository.findAll()
    }

    fun registrarEntrada(cars: Cars): Cars {
        cars.ingreso = true
        cars.fechaEntrada = java.time.LocalDateTime.now()
        return carsRepository.save(cars)
    }

    fun registrarSalida(id: Long): String {
        val car = carsRepository.findById(id)
        if (car.isPresent) {
            val updatedCar = car.get()
            updatedCar.ingreso = false
            updatedCar.fechaSalida = java.time.LocalDateTime.now()
            carsRepository.save(updatedCar)
            return "Salida registrada para el vehículo con ID $id"
        } else {
            throw IllegalArgumentException("Vehículo con ID $id no encontrado")
        }
    }
}


