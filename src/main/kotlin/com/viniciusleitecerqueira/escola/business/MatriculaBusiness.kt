package com.viniciusleitecerqueira.escola.business

import com.viniciusleitecerqueira.escola.repositories.MatriculaRepository
import com.viniciusleitecerqueira.escola.beans.Matricula
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
@RequestMapping("/matriculas")
class MatriculaBusiness {

    @Autowired
    lateinit var matriculaRepository: MatriculaRepository


    @GetMapping
    fun listarTodas(): List<Matricula> = matriculaRepository.findAll()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Matricula> {
        val matricula = matriculaRepository.findById(id)
        return if (matricula.isPresent) ResponseEntity.ok(matricula.get())
        else ResponseEntity.notFound().build()
    }


}