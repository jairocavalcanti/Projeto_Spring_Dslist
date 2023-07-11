package com.devsuperior.dslist.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.Repositories.GameRepository;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;

/*
 Annotation "@Service" ira registrar a classe 'GameSerivce' com um COMPONENTE do sistema 
 Sera possivel INJETAR componentes no outro
*/
@Service
public class GameService {
    
    //Injetando uma instancia de 'GameRepository' dentro de 'GameService'
    @Autowired
    private GameRepository gameRepository;

    //Funçao que ira retornar uma lista de 'Game MinDTO'
    public List<GameMinDTO> findall(){
     List<Game> result = gameRepository.findAll();
     List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
     return dto;
   
    }
}
