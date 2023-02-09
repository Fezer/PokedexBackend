package bantads.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import bantads.auth.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	Optional<Pokemon> findByNome(String nome);

	Optional<Pokemon> findByTipo(String tipo);

	@Query("from Pokemon where tipo like CONCAT('%',:tipo,'%')")
	Optional<Pokemon> findByTipoLike(String tipo);

	@Query("from Pokemon where habilidades like CONCAT('%',:habilidade,'%')")
	Optional<Pokemon> findByHabilidadeLike(String habilidade);
	
}
