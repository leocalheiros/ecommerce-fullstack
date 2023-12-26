package com.calheiros.backend.repository;

import com.calheiros.backend.entity.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagens, Long> {
}
