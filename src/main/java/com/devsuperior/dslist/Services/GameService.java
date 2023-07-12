package com.devsuperior.dslist.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.Repositories.GameRepository;
import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

/*
 Annotation "@Service" ira registrar a classe 'GameSerivce' com um COMPONENTE do sistema 
 Sera possivel INJETAR componentes no outro
*/
@Service
public class GameService {
    
    //Injetando uma instancia de 'GameRepository' dentro de 'GameService'
    @Autowired
    private GameRepository gameRepository;


    //Convertendo objeto 'Game'  em objeto 'GameDTO'
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    //Funçao que ira retornar uma lista de 'Game MinDTO'
    @Transactional(readOnly = true)
     public List<GameMinDTO> findall(){
     List<Game> result = gameRepository.findAll();
     List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
     return dto;
   
    }

     @Transactional(readOnly = true)
     public List<GameMinDTO> findbyList(Long listId){
     List<GameMinProjection> result = gameRepository.searchByList(listId);
     List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
     return dto;
   
    }


}
