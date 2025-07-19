package com.viniciusleitecerqueira.escola.repositories


import com.viniciusleitecerqueira.escola.beans.Matricula
import org.springframework.data.jpa.repository.JpaRepository

interface MatriculaRepository : JpaRepository<Matricula, Long>