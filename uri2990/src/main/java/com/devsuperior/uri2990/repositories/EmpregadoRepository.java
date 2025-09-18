package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

    @Query(nativeQuery = true, value
            = "SELECT A.cpf "
            + "	,A.enome "
            + "	,B.dnome "
            + "FROM empregados AS A "
            + "INNER JOIN departamentos AS B "
            + "ON A.dnumero = B.dnumero "
            + "WHERE A.cpf NOT IN ( "
            + "		SELECT C.cpf "
            + "		FROM empregados AS C "
            + "		INNER JOIN trabalha AS D "
            + "		ON C.cpf = D.cpf_emp "
            + "		) "
            + "ORDER BY A.cpf")
    List<EmpregadoDeptProjection> search1();

    @Query(nativeQuery = true, value
            = "SELECT A.cpf "
            + "	,A.enome "
            + "	,B.dnome "
            + "FROM empregados AS A "
            + "INNER JOIN departamentos AS B "
            + "ON A.dnumero = B.dnumero "
            + "LEFT JOIN trabalha AS C "
            + "ON A.cpf = C.cpf_emp "
            + "WHERE C.cpf_emp IS NULL "
            + "ORDER BY A.cpf")
    List<EmpregadoDeptProjection> search2();

    @Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf "
            + ",obj.enome "
            + ",obj.departamento.dnome) "
            + "FROM Empregado obj "
            + "WHERE obj.cpf NOT IN ( "
            + "		SELECT obj.cpf "
            + "		FROM Empregado obj "
            + "		INNER JOIN obj.projetosOndeTrabalha "
            + "		) "
            + "ORDER BY obj.cpf")
    List<EmpregadoDeptDTO> search3();

}
