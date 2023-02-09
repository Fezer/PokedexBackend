package bantads.auth.rest;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bantads.auth.exception.AuthException;
import bantads.auth.model.Pokemon;
import bantads.auth.model.PokemonDTO;
import bantads.auth.repository.PokemonRepository;


@CrossOrigin
@RestController
public class PokemonREST {

	@Autowired
	private PokemonRepository repo;

	@Autowired
	private ModelMapper mapper;


	@PostMapping("/pokemons")
	public ResponseEntity<PokemonDTO> inserir(@RequestBody PokemonDTO Pokemon) {
		String nome = Pokemon.getNome();
		
		Optional<Pokemon> pokemon = repo.findByNome(nome);
		
		if(pokemon.isPresent()) {
			throw new AuthException(HttpStatus.CONFLICT, "Pokemon já cadastrado!");
		}else {
			repo.save(mapper.map(Pokemon, Pokemon.class));
			Optional<Pokemon> poke = repo.findByNome(Pokemon.getNome());
			return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(poke, PokemonDTO.class));
		}
	}
	
	@GetMapping("/pokemons")
	public ResponseEntity<List<PokemonDTO>> listarTodos() {
		
		List<Pokemon> lista = repo.findAll();
		
		if(lista.isEmpty()) {
			throw new AuthException(HttpStatus.NOT_FOUND, "Nenhum pokemon encontrado!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(lista.stream().map(e -> mapper.map(e, PokemonDTO.class)).collect(Collectors.toList()));
		}
	}
	
	@GetMapping("/pokemons/tipo")
	public ResponseEntity<List<PokemonDTO>> listarPorTipo(@RequestBody Pokemon request){
		String tipo = request.getTipo();
		List<Pokemon> lista = repo.findByTipoLike(tipo);
		
		if(lista.isEmpty()) {
			throw new AuthException(HttpStatus.NOT_FOUND, "Nenhum pokemon encontrado!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(lista.stream().map(e -> mapper.map(e, PokemonDTO.class)).collect(Collectors.toList()));
		}
	}
	
	@GetMapping("/pokemons/habilidade")
	public ResponseEntity<List<PokemonDTO>> listarPorHabilidade(@RequestBody Pokemon request){
		String habilidade = request.getHabilidades();
		List<Pokemon> lista = repo.findByHabilidadeLike(habilidade);
		
		if(lista.isEmpty()) {
			throw new AuthException(HttpStatus.NOT_FOUND, "Nenhum pokemon encontrado!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(lista.stream().map(e -> mapper.map(e, PokemonDTO.class)).collect(Collectors.toList()));
		}
	}
	
	@GetMapping("/pokemons/{id}")
	public ResponseEntity<PokemonDTO> listaPokemon(@PathVariable Long id){
		
		Optional<Pokemon> pokemon = repo.findById(id);
		if(pokemon.isEmpty()) {
			throw new AuthException(HttpStatus.NOT_FOUND, "Pokemon não encontrado!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(mapper.map(pokemon, PokemonDTO.class));
		}
	}
	
	@PutMapping("/pokemons/{id}")
	public ResponseEntity<PokemonDTO> atualizar(@PathVariable Long id, @RequestBody PokemonDTO Pokemon){
		
		Optional<Pokemon> user = repo.findById(id);
		if(user.isEmpty()) {
			throw new AuthException(HttpStatus.NOT_FOUND, "Pokemon não encontrado!");
		}else {
			Pokemon.setId(id);
			repo.save(mapper.map(Pokemon, Pokemon.class));
			user = repo.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(mapper.map(user, PokemonDTO.class));
		}
	}
	
	@DeleteMapping("/pokemons/{id}")
	public ResponseEntity deletePokemon(@PathVariable Long id){
		
		Optional<Pokemon> Pokemon = repo.findById(id);
		if(Pokemon.isEmpty()) {
			throw new AuthException(HttpStatus.NOT_FOUND, "Pokemon não encontrado!");
		}else {
			repo.delete(mapper.map(Pokemon, Pokemon.class));
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

	private String successFormat(String endpoint){
		return "{" +
				"\"path\":\""+endpoint+"\"," +
				"\"result\":\"success\"" +
				"}";
	}

	private String errorFormat(String endpoint){
		return "{" +
				"\"path\":\""+endpoint+"\"," +
				"\"result\":\"error\"" +
				"}";
	}

}
