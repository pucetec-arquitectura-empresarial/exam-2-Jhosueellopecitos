package com.pucetec.exam2.services

import com.pucetec.exam2.models.entities.Parket
import com.pucetec.exam2.repositories.ParketRepository
import org.springframework.stereotype.Service

@Service
class ParketService(private val parketRepository: ParketRepository) {

    fun listarParkets(): List<Parket> = parketRepository.findAll()

    fun obtenerParketPorId(id: Long): Parket =
        parketRepository.findById(id).orElseThrow { IllegalArgumentException("No se encontró el parket con: $id") }

    fun crearParket(parket: Parket): Parket = parketRepository.save(parket)

    fun actualizarParket(id: Long, datos: Parket): Parket {
        val original = obtenerParketPorId(id)
        val actualizado = original.copy(
            level = datos.level,
            total_capacity = datos.total_capacity,
            occupied_spots = datos.occupied_spots
        )
        return parketRepository.save(actualizado)
    }

    fun eliminarParket(id: Long) {
        parketRepository.deleteById(id)
    }
}
