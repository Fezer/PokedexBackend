package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bantads.auth.exception.DAOException;
import bantads.auth.model.Pokemon;
import bantads.auth.model.TopPokemon;

public class PokemonDAO implements DAO<Pokemon> {
	
	private Connection con = null;
	
	private final String SELECTTOPTIPO = "select tipo_pok as item, COUNT(tipo_pok) as quantidade from tb_pokemon tp group by tipo_pok order by quantidade limit 3";
	private final String SELECTTOPHAB = "select hab_pok as item, COUNT(hab_pok) as quantidade from tb_pokemon tp group by hab_pok order by quantidade limit 3";
	private final String SELECTQUANTIDADE = "select COUNT(*) from tb_pokemon";

    public PokemonDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar PokemonDAO.");
        }
        this.con = con;
    }
    
    public List<TopPokemon> listarTopTipo() throws DAOException {
        List<TopPokemon> listaTopTipo = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECTTOPTIPO)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	TopPokemon topTipo = new TopPokemon();

            	topTipo.setItem(rs.getString(1));
            	topTipo.setQuantidade(rs.getInt(2));

            	listaTopTipo.add(topTipo);
            }

        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar top tipos: " + SELECTTOPTIPO, e);
        }

        return listaTopTipo;
    }
    
    public List<TopPokemon> listarTopHabilidade() throws DAOException {
        List<TopPokemon> listaTopHabilidade = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(SELECTTOPHAB)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	TopPokemon topHab = new TopPokemon();

            	topHab.setItem(rs.getString(1));
            	topHab.setQuantidade(rs.getInt(2));

            	listaTopHabilidade.add(topHab);
            }

        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar top habilidades: " + SELECTTOPHAB, e);
        }

        return listaTopHabilidade;
    }
    
    public int listarQuantidadePokemons() throws DAOException {
        try (PreparedStatement st = con.prepareStatement(SELECTQUANTIDADE)) {
        	try (ResultSet rs = st.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DAOException("Erro ao consultar quantidade total de Pokemons: " + SELECTQUANTIDADE, e);
        }
    }
	
	@Override
	public Pokemon buscar(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> buscarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Pokemon u) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Pokemon u) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Pokemon u) throws DAOException {
		// TODO Auto-generated method stub
		
	} 

}
