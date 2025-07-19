package com.viniciusleitecerqueira.escola.repositories

import com.viniciusleitecerqueira.escola.beans.Professor
import org.springframework.data.jpa.repository.JpaRepository

interface ProfessorRepository : JpaRepository<Professor, Long> {
}