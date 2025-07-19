package com.viniciusleitecerqueira.escola.repositories

import com.viniciusleitecerqueira.escola.beans.Materia
import org.springframework.data.jpa.repository.JpaRepository

interface MateriaRepository : JpaRepository<Materia, Long>