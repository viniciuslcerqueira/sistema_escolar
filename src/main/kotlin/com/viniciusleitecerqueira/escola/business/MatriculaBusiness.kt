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

    @PostMapping
    fun cadastrar(@RequestBody matricula: Matricula): Matricula =
        matriculaRepository.save(matricula)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody atualizada: Matricula): ResponseEntity<Matricula> {
        val existente = matriculaRepository.findById(id)
        return if (existente.isPresent) {
            val matricula = existente.get().apply {
                alunoId = atualizada.alunoId
                cursoId = atualizada.cursoId
                dataMatricula = atualizada.dataMatricula
            }
            ResponseEntity.ok(matriculaRepository.save(matricula))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }


}