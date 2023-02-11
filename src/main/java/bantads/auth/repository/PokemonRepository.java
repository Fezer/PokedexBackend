package bantads.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import bantads.auth.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	Optional<Pokemon> findByNome(String nome);

	Optional<Pokemon> findByTipo(String tipo);

	@Query("FROM Pokemon WHERE UPPER(tipo) LIKE UPPER(CONCAT('%',:tipo,'%'))")
	List<Pokemon> findByTipoLike(String tipo);

	@Query("FROM Pokemon WHERE UPPER(habilidades) LIKE UPPER(CONCAT('%',:habilidade,'%'))")
	List<Pokemon> findByHabilidadeLike(String habilidade);
	
}
