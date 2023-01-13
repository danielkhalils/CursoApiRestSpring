package io.github.danielkhalils.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	/*Serviço RESTful*/
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init(@RequestParam (value = "nome", required = false) String nome) {
		System.out.print("Parâmetro sendo recebido" + nome);
		return new ResponseEntity("Olá Usuário RestSpringBoot, seu nome é " + nome, HttpStatus.OK);
	}
	
	@GetMapping(value = "/teste/", produces = "application/json")
	private ResponseEntity init(@RequestParam (value = "idade")int idade){
		System.out.print("idade sendo recebida " + idade);
		return new ResponseEntity("Sua idade é " + idade, HttpStatus.OK);
	}
	
}
