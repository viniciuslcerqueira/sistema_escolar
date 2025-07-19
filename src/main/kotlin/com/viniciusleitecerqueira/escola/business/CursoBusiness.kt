package com.viniciusleitecerqueira.escola.business

import com.viniciusleitecerqueira.escola.repositories.CursoRepository
import com.viniciusleitecerqueira.escola.repositories.MateriaRepository
import com.viniciusleitecerqueira.escola.beans.Curso
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

    @PostMapping
    fun cadastrar(@RequestBody curso: Curso): Curso =
        cursoRepository.save(curso)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody atualizado: Curso): ResponseEntity<Curso> {
        val existente = cursoRepository.findById(id)
        return if (existente.isPresent) {
            val curso = existente.get().apply {
                nome = atualizado.nome
                cargaHoraria = atualizado.cargaHoraria
                professorId = atualizado.professorId
            }
            ResponseEntity.ok(cursoRepository.save(curso))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }


}