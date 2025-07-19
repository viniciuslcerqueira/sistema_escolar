package com.viniciusleitecerqueira.escola.repositories


import com.viniciusleitecerqueira.escola.beans.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long>