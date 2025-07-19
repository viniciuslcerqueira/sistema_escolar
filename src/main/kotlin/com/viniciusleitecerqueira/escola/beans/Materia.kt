package com.viniciusleitecerqueira.escola.beans

import jakarta.persistence.*


@Entity
@Table(name = "materia")
class Materia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "nome")
    var nome: String? = null

    @Column(name = "carga_horaria")
    var cargaHoraria: Int? = null

    @Column(name = "curso_id")
    var cursoId: Long? = null
}