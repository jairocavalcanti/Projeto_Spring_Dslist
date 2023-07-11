package com.devsuperior.dslist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dslist.entities.Game;

//Interface dedicada a operaçoes basicas no banco de dados com as informaçoes da classe "Game"
//JpaRepository responsavel por fazer isso no Spring boot
//Primeiro parametro no "<>": nome da entidade 'Game'
//Segundo parametro no "<>": tipo do ID da entidade
public interface GameRepository extends JpaRepository<Game, Long> {
    



} 
