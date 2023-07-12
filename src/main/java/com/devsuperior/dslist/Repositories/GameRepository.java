package com.devsuperior.dslist.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

//Interface dedicada a operaçoes basicas no banco de dados com as informaçoes da classe "Game"
//JpaRepository responsavel por fazer isso no Spring boot
//Primeiro parametro no "<>": nome da entidade 'Game'
//Segundo parametro no "<>": tipo do ID da entidade
public interface GameRepository extends JpaRepository<Game, Long> {
   
    //Consulta SQL personalizada no JPA
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
     
            
            List<GameMinProjection> searchByList(Long listId);
    } 
