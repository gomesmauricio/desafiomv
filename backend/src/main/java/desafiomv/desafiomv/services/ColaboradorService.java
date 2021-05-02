package desafiomv.desafiomv.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.savedrequest.SavedCookie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafiomv.desafiomv.dto.ColaboradorDTO;
import desafiomv.desafiomv.dto.MessageResponseDTO;
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
	
	@Transactional
	public MessageResponseDTO insertColaborador(Colaborador colaborador) {
		Colaborador savedColaborador = repository.save(colaborador);
		return MessageResponseDTO
				.builder()
				.message("Colaborador: " + savedColaborador.getNome() + " Cadastrado com Sucesso! "+ savedColaborador.getOpcao() )
				.build();
		
	}
	
	@Transactional
	public MessageResponseDTO alterar(String cpf) {
		Colaborador colaborador = repository.getOne(cpf);
		colaborador.setCpf(colaborador.getCpf());
		colaborador.setNome(colaborador.getNome());
		colaborador.setOpcao(colaborador.getOpcao());
		colaborador = repository.save(colaborador);
		return MessageResponseDTO
				.builder()
				.message("Colaborador: " + colaborador.getNome()+ " Alterado com sucesso")
				.build();
	}



}
