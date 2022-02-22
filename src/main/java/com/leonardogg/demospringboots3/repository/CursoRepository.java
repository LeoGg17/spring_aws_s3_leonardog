package com.leonardogg.demospringboots3.repository;

import com.leonardogg.demospringboots3.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
