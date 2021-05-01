package desafiomv.desafiomv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import desafiomv.desafiomv.entities.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {
	
	List<Colaborador> findAllByOrderByNomeAsc();
}
