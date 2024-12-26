package co.kr.jin.repository;

import co.kr.jin.dto.PageRequestDTO;
import co.kr.jin.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {


   Page<Article> findAllByCate2(String cate, Pageable pageable);
}
