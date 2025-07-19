package com.viniciusleitecerqueira.escola.beans

import jakarta.persistence.*

@Entity
@Table(name = "professor")
class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "nome")
    var nome: String? = null

    @Column(name = "cpf")
    var cpf: String? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "telefone")
    var telefone: String? = null

    @Column(name = "especialidade")
    var especialidade: String? = null

    @Column(name = "cep")
    var cep: String? = null

    @Column(name = "logradouro")
    var logradouro: String? = null

    @Column(name = "bairro")
    var bairro: String? = null

    @Column(name = "cidade")
    var cidade: String? = null

    @Column(name = "uf")
    var uf: String? = null

}