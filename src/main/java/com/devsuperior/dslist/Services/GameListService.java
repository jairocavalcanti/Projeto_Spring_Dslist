package com.devsuperior.dslist.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.Repositories.GameListRepository;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;


@Service
public class GameListService {
    

    @Autowired
    private GameListRepository gameListRepository;


  
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //Transformando cada objeto da lista original em GameListDTO
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
