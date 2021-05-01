package desafiomv.desafiomv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafiomv.desafiomv.dto.ColaboradorDTO;
import desafiomv.desafiomv.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> findAll(){
		List<ColaboradorDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
