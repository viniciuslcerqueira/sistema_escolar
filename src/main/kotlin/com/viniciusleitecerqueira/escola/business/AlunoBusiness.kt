package com.viniciusleitecerqueira.escola.business

import com.viniciusleitecerqueira.escola.beans.Aluno
import com.viniciusleitecerqueira.escola.repositories.AlunoRepository
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
@RequestMapping("/alunos")
class AlunoBusiness {

    @Autowired
    lateinit var alunoRepository: AlunoRepository

    @GetMapping
    fun listarTodos(): List<Aluno> = alunoRepository.findAll()


    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Aluno> {
        val aluno = alunoRepository.findById(id)
        return if (aluno.isPresent) ResponseEntity.ok(aluno.get())
        else ResponseEntity.notFound().build()
    }

}