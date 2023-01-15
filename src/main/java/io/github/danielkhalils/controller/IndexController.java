package io.github.danielkhalils.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.danielkhalils.model.Usuario;
import io.github.danielkhalils.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{id}/relatoriopdf", produces = "application/pdf")
	private ResponseEntity<Usuario> relatorio(@PathVariable (value = "id") Long id){
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		/* O retorno seria um relatorio */
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);	
	}
	
	//Retornando usuários pelo ID do banco de dados
	@GetMapping(value = "/{id}", produces = "application/json")
	private ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id){
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);	
	}
	
	//Retorna a lista de usuários pelo banco de dados
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario(){
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
	public ResponseEntity cadastrarVenda(@PathVariable Long iduser, 
										 @PathVariable Long idvenda) {
		
		return new ResponseEntity("id user: " + iduser + "id venda: " + idvenda, HttpStatus.OK);
	}
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		Usuario atualizarUsuario = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(atualizarUsuario, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
	public ResponseEntity atualizarVenda(@PathVariable Long iduser,
												  @PathVariable Long idvenda){
		
		/*Usuario atualizarUsuario = usuarioRepository.save(usuario);*/
		
		return new ResponseEntity("Venda cadastrada", HttpStatus.OK);
	}
	
	
}
