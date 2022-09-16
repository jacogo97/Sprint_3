package com.App.App.Repositorio;


import com.App.App.Entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoDineroRepositorio extends JpaRepository<MovimientoDinero, Integer> {
}
