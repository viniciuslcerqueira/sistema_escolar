package com.viniciusleitecerqueira.escola.business

import com.viniciusleitecerqueira.escola.repositories.MateriaRepository
import com.viniciusleitecerqueira.escola.beans.Materia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/materias")
class MateriaBusiness {

    @Autowired
    lateinit var materiaRepository: MateriaRepository

    @GetMapping
    fun listarTodas(): List<Materia> = materiaRepository.findAll()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Materia> {
        val materia = materiaRepository.findById(id)
        return if (materia.isPresent) ResponseEntity.ok(materia.get())
        else ResponseEntity.notFound().build()
    }


}