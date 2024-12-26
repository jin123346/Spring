package co.kr.jin.service;


import co.kr.jin.dto.ArticleDTO;
import co.kr.jin.dto.PageRequestDTO;
import co.kr.jin.dto.PageResponseDTO;
import co.kr.jin.entity.Article;
import co.kr.jin.entity.User;
import co.kr.jin.repository.ArticleRepository;
import jakarta.persistence.Tuple;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO findAll(PageRequestDTO pageRequestDTO){
        Pageable pageable = pageRequestDTO.getPageable("no");

            // 일반 글목록 조회
        Page<Article> pageArticle  = articleRepository.findAllByCate2(pageRequestDTO.getCate(), pageable);


        // 엔티티 리스트를 DTO 리스트 변환
        List<Article> articles = pageArticle.getContent();
        List<ArticleDTO> articleList = articles.stream().map(article -> {

            ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
            articleDTO.setWriter(article.getUser().getUid());
            articleDTO.setNick(article.getUser().getNick());
            return articleDTO;

        }).toList();

        int total = (int) pageArticle.getTotalElements();

        return PageResponseDTO.<ArticleDTO>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(articleList)
                .total(total)
                .build();
    }


    public int save(ArticleDTO articledto, HttpServletRequest request) {

        articledto.setRegip(request.getRemoteAddr());
        User user = User.builder().uid(articledto.getWriter()).build();
        Article article = modelMapper.map(articledto, Article.class);
        article.setUser(user);


        Article savedArticle = articleRepository.save(article);
        return savedArticle.getNo();
    }
}
