package com.derster.jpa.repositories;

import com.derster.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNameQuery(@Param("age") int age);
    @Modifying
    @Transactional
    @Query("update Author  a set a.age= :age where a.id= :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author  a set a.age= :age")
    int updateAuthorAge(int age);

    // Select * from author where first_name = 'modeste';
    List<Author> findAllByFirstName(String fn);

    // Select * from author where first_name = 'mod'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // Select * from author where first_name like '%mod%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // Select * from author where first_name like 'mod%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // Select * from author where first_name like '%mod'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);


    // Select * from author where first_name in ( 'mod', 'ders', 'koua' )
    List<Author>findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
