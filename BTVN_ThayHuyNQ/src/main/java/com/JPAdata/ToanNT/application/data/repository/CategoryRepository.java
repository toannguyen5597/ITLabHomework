package com.JPAdata.ToanNT.application.data.repository;

import com.JPAdata.ToanNT.application.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select c from tbl_category c where c.type.id = :typeId")
    List<Category> findByType(@Param("typeId") int typeId);

    @Query("select c from tbl_category c where c.name = :name")
    Category findByName(@Param("name") String name);
}
