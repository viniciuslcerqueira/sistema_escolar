package com.viniciusleitecerqueira.escola.beans

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "matricula")
class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "aluno_id")
    var alunoId: Long? = null

    @Column(name = "curso_id")
    var cursoId: Long? = null

    @Column(name = "data_matricula")
    var dataMatricula: LocalDate? = null

}