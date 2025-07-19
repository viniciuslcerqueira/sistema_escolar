package com.viniciusleitecerqueira.escola.business

import com.viniciusleitecerqueira.escola.beans.Curso
import com.viniciusleitecerqueira.escola.repositories.CursoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cursos")
class CursoBusiness {

    @Autowired
    lateinit var cursoRepository: CursoRepository

    @GetMapping
    fun listarTodos(): List<Curso> = cursoRepository.findAll()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Curso> {
        val curso = cursoRepository.findById(id)
        return if (curso.isPresent) ResponseEntity.ok(curso.get())
        else ResponseEntity.notFound().build()
    }

}