package co.kr.jin.controller;


import co.kr.jin.dto.ArticleDTO;
import co.kr.jin.dto.PageRequestDTO;
import co.kr.jin.dto.PageResponseDTO;
import co.kr.jin.entity.Article;
import co.kr.jin.service.ArticleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/{cate}/{pg}")
    public PageResponseDTO list(PageRequestDTO pageReqeustDTO) {
        log.info("cate : "+pageReqeustDTO.getPg());

        PageResponseDTO responseDTO = articleService.findAll(pageReqeustDTO);

        return responseDTO;
    }

    @PostMapping("/article")
    public ResponseEntity article(@RequestBody ArticleDTO articleDTO, HttpServletRequest request) {

        log.info("들어오나?"+articleDTO);
       int no= articleService.save(articleDTO,request);

       return ResponseEntity.ok().body(no);
    }

}
