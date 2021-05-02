package desafiomv.desafiomv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import desafiomv.desafiomv.dto.ColaboradorDTO;
import desafiomv.desafiomv.dto.MessageResponseDTO;
import desafiomv.desafiomv.entities.Colaborador;
import desafiomv.desafiomv.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	//Lista todos o coloboradores
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> findAll(){
		List<ColaboradorDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	//Insere no banco um colaborador com sua opção de item do cafe
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO insertColaborador(@RequestBody Colaborador colaborador) {
		return service.insertColaborador(colaborador);
		
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<MessageResponseDTO> alterar(@PathVariable String cpf){
		MessageResponseDTO dto = service.alterar(cpf);
		return ResponseEntity.ok().body(dto);
	}
	
	
	
}
