package com.devsuperior.dslist.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 Annotation 'Entity' 
 irá configurar a classe 'game' para que ela seja equivalente a uma tabela do banco relacional 
*/
@Entity
/*
  Annotation 'Table' define o nome da tabela
 */
@Table(name = "tb_game")
public class Game { 
    
    /*Annotation 'id' configura a chave primaria do banco */
    @Id
    /*Annotation 'GeneratedValue' faz com o id seja auto-incrementado pelo banco de dados */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    /*Annotation 'column' alterando o nome da coluna 'year' para 'game_year' */
    @Column(name = "game_year")
    private Integer year;
    
    private String genre;
    private String platforms;
    private Double score;
  
    /*  
    'imgUrl' segue o padrao 'camel case' inciando com caracteres minusculos
     Ao inicio de outra palavra sera inserido um caracter maiusculo.
     ajudando assim na legibilidade
    */
    private String imgUrl;
  
    /*
    Definindo 'shortdescription' e 'longdescription' como tipos texto no banco de dados 
    Podendo assim alocar uma maior quantidade de caracteres, como o texto 'lorem ipsum'
    definido como padrao neste campo
    */
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    
    @Column(columnDefinition = "TEXT")
    private String longDescription;

    public Game(){

    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
            String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platforms;
    }

    public void setPlatform(String platform) {
        this.platforms = platform;
    }

     public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }



    /*
    Metodos que podem eventualmente serem usados para COMPARAR dois 'games' (se são iguais ou nao) 
    Por exemplo dentro de uma lista 
    */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

   


}
