package bantads.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import bantads.auth.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	Optional<Pokemon> findByNome(String nome);
	
}
