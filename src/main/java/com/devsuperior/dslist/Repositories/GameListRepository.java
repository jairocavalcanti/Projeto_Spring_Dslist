package com.devsuperior.dslist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;


public interface GameListRepository extends JpaRepository<GameList, Long> {
    
    //Annotation "Modifying" é necessario para operaçoes que nao sejam do tipo 'select'
     @Modifying
     @Query(nativeQuery = true, 
      value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
      void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

} 
