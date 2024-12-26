package co.kr.jin.controller;


import co.kr.jin.dto.PageRequestDTO;
import co.kr.jin.dto.PageResponseDTO;
import co.kr.jin.dto.ProductDTO;
import co.kr.jin.service.ProductService;
import co.kr.jin.util.CustomFileUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CustomFileUtil customFileUtil;


    @GetMapping("/product/{pg}")
    public PageResponseDTO<ProductDTO> getProducts(PageRequestDTO pageRequestDTO){

        PageResponseDTO<ProductDTO> pageResponseDTO = productService.list(pageRequestDTO);


        return pageResponseDTO;
    }


    @PostMapping("/product")
    public Map<String,Integer> register(ProductDTO productDTO) {
        log.info("productDTO : "+productDTO);
        List<MultipartFile> files= productDTO.getThumbFiles();

        //파일저장
        Map<String,String> uploadsName =  customFileUtil.saveFiles(files);
        productDTO.setThumbNames(uploadsName);

        int pno = productService.register(productDTO);

        return Map.of("pno",pno);

    }


    @GetMapping("/product/thumb/{fileName}")
    public ResponseEntity<Resource> thumbnail(@PathVariable  String fileName, HttpServletResponse response) {
        return customFileUtil.getFile(fileName);

    }




}
