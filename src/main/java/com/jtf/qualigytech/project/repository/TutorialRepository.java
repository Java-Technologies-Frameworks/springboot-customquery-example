package com.jtf.qualigytech.project.repository;

import com.jtf.qualigytech.project.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial,Long> {

    @Query("SELECT t FROM Tutorial t")
    List<Tutorial> findAll();

    @Query("SELECT t FROM Tutorial t WHERE t.published=?1")
    List<Tutorial> findByPublished(String isPublished);

    @Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%")
    List<Tutorial> findByTitleLike(String title);

    @Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
    List<Tutorial> findByTitleLikeCaseInsensitive(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Tutorial t SET t.published='true' WHERE t.id=?1")
    int publishTutorial(Long id);

}
