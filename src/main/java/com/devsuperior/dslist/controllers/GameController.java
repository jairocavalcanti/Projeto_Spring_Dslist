package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.Services.GameService;
import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;

/*
Annotation 'RestController'.
definindo classe 'GameController' como um controlador 
*/
@RestController
/*
 Configurando o caminho a ser respondido na API
 */
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    //configurando paramento 'id' na rrequisição
    @GetMapping(value = "/{id}")
                            //Annotation 'PathVariable' fazendo com que o ID da requisição 'case' com o ID do metodo
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findall(){
       List<GameMinDTO> result = gameService.findall();
       return result;
    }
    
}
