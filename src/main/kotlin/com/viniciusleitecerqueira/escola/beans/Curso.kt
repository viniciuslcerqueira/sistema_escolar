package com.viniciusleitecerqueira.escola.beans

import jakarta.persistence.*

@Entity
@Table(name = "curso")
class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "nome")
    var nome: String? = null

    @Column(name = "carga_horaria")
    var cargaHoraria: Int? = null

    @Column(name = "professor_id")
    var professorId: Long? = null
}