package com.devsuperior.dslist.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.Repositories.GameListRepository;
import com.devsuperior.dslist.Repositories.GameRepository;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;


@Service
public class GameListService {
    

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

  
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //Transformando cada objeto da lista original em GameListDTO
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

          List<GameMinProjection> list = gameRepository.searchByList(listId);

           GameMinProjection obj = list.remove(sourceIndex);
           list.add(destinationIndex, obj);

           //se 'source' for menor que 'destination' entao o minimo será o 'source'
           int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
           
           int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
       
       
           for(int i = min; i<= max; i++){
               gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
           }
       
       
        }



}
