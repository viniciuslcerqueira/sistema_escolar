package com.viniciusleitecerqueira.escola.repositories

import com.viniciusleitecerqueira.escola.beans.Aluno
import org.springframework.data.jpa.repository.JpaRepository

interface AlunoRepository : JpaRepository<Aluno, Long>