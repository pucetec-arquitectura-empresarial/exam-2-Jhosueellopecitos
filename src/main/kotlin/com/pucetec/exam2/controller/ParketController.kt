package com.pucetec.exam2.controller


import com.pucetec.exam2.models.entities.Parket
import com.pucetec.exam2.repositories.ParketRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/parket")
class ParketController(private val parketRepository: ParketRepository) {


    @GetMapping
    fun listarTodos(): List<Parket> = parketRepository.findAll()


    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<Parket> {
        val parket = parketRepository.findById(id)
        return if (parket.isPresent) ResponseEntity.ok(parket.get())
        else ResponseEntity.notFound().build()
    }

}