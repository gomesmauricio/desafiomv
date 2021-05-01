package desafiomv.desafiomv.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafiomv.desafiomv.dto.ColaboradorDTO;
import desafiomv.desafiomv.entities.Colaborador;
import desafiomv.desafiomv.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	@Transactional(readOnly = true)
	public List<ColaboradorDTO> findAll() {
		List<Colaborador> list = repository.findAllByOrderByNomeAsc();
		return list.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
	}

}
