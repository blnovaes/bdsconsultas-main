/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author blnov
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id "
            + ",movies.name "
            + "FROM movies "
            + "INNER JOIN genres "
            + "ON movies.id_genres = genres.id "
            + "WHERE genres.description = :genreDescription")
    List<MovieMinProjection> search1(String genreDescription);

    @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(obj.id, obj.name) "
            + "FROM Movie obj "
            + "WHERE obj.genre.description = :genreDescription")
    List<MovieMinDTO> search2(String genreDescription);

}
