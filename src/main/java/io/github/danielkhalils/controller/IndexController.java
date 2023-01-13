package io.github.danielkhalils.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.danielkhalils.model.Usuario;

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
	
	/*Passando uma lista de usuários*/
	@GetMapping(value = "/lista", produces = "apllication/json")
	public ResponseEntity<Usuario> init() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setLogin("daniel.khalil.dkss@gmail.com");
		usuario.setNome("Daniel Khalil");
		usuario.setSenha("123");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);
		usuario2.setLogin("Adaniel.khalil.dkss@gmail.com");
		usuario2.setNome("ADaniel Khalil");
		usuario2.setSenha("1123");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		usuarios.add(usuario2);
		
		return new ResponseEntity(usuarios, HttpStatus.OK);
	}
	
	
	
	
	
	
}
