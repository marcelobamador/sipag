package br.com.sipag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sipag.model.AdquirenteEntity;

@Repository
public interface ComercioRepository extends JpaRepository<AdquirenteEntity, Long> {
}
