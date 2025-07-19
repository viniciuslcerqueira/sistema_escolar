package com.viniciusleitecerqueira.escola.business

import com.viniciusleitecerqueira.escola.repositories.ProfessorRepository
import com.viniciusleitecerqueira.escola.beans.Professor
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
@RequestMapping("/professores")
class ProfessorBusiness {

    @Autowired
    lateinit var professorRepository: ProfessorRepository

    @GetMapping
    fun listarTodos(): List<Professor> = professorRepository.findAll()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Professor> {
        val professor = professorRepository.findById(id)
        return if (professor.isPresent) ResponseEntity.ok(professor.get())
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun cadastrar(@RequestBody professor: Professor): Professor =
        professorRepository.save(professor)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody professorAtualizado: Professor): ResponseEntity<Professor> {
        val existente = professorRepository.findById(id)
        return if (existente.isPresent) {
            val professor = existente.get().apply {
                nome = professorAtualizado.nome
                cpf = professorAtualizado.cpf
                email = professorAtualizado.email
                telefone = professorAtualizado.telefone
                especialidade = professorAtualizado.especialidade
                cep = professorAtualizado.cep
                logradouro = professorAtualizado.logradouro
                bairro = professorAtualizado.bairro
                cidade = professorAtualizado.cidade
                uf = professorAtualizado.uf
            }
            ResponseEntity.ok(professorRepository.save(professor))
        } else {
            ResponseEntity.notFound().build()
        }
    }

        @DeleteMapping("/{id}")
        fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
            return if (professorRepository.existsById(id)) {
                professorRepository.deleteById(id)
                ResponseEntity.noContent().build()
            } else {
                ResponseEntity.notFound().build()
            }
        }
    }

