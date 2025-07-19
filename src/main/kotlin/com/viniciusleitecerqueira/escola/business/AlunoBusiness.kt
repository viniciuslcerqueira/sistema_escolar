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

    @PostMapping
    fun cadastrar(@RequestBody aluno: Aluno): Aluno = alunoRepository.save(aluno)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody alunoAtualizado: Aluno): ResponseEntity<Aluno> {
        val existente = alunoRepository.findById(id)
        return if (existente.isPresent) {
            val aluno = existente.get().apply {
                nome = alunoAtualizado.nome
                cpf = alunoAtualizado.cpf
                email = alunoAtualizado.email
                telefone = alunoAtualizado.telefone
                cep = alunoAtualizado.cep
                logradouro = alunoAtualizado.logradouro
                bairro = alunoAtualizado.bairro
                cidade = alunoAtualizado.cidade
                uf = alunoAtualizado.uf
            }
            ResponseEntity.ok(alunoRepository.save(aluno))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}