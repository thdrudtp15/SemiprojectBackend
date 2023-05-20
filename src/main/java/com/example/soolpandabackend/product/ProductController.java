package com.example.soolpandabackend.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RestController //return 데이터 json형식으로 반환
public class ProductController {

    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping("/list")
    public List<ProductVO> getAllList() {
        List<ProductVO> list = productService.getAllList();
        return list;
    }

    @RequestMapping("/count")
    public int getCount() {
        int res = productService.getCount();
        return res;
    }

    @RequestMapping("/insert")
    public int insertProduct(@RequestBody ProductVO prod) {
        //@RequestBody: json기반의 메시지를 사용하는 요청의 경우 사용함
        int res = productService.insertProduct(prod);
        return res;
    }

    @RequestMapping("/detail")
    public ProductVO getDetail(@RequestParam int prod_num) {
        productService.addViewCount(prod_num);
        ProductVO vo = productService.getDetail(prod_num);
        return vo;
    }

    @RequestMapping("/modify")
    public int modifyProduct(@RequestBody ProductVO prod) {
        int res = productService.modifyProduct(prod);
        return res;
    }

    @RequestMapping("/delete")
    public int deleteProduct(@RequestBody ProductVO prod) {
        int res = productService.deleteProduct(prod);
        return res;
    }

    //	application.yml(설정파일)에 설정된 내용을 주입시켜주는 어노테이션
    @Value("${spring.servlet.multipart.location}")
    String uploadDir;

    @ResponseBody // 리액트에서 데이터를 json형식으로 전달받기 위해 사용
    @RequestMapping("/upload")
    public List<String> uploadImage(@RequestParam("uploadfiles") MultipartFile[] uploadfiles, @RequestParam("prod_num") int prod_num) throws IOException {
        List<String> list = new ArrayList<>();
        for (MultipartFile file : uploadfiles) {
            if (!file.isEmpty()) {
                File storedFilename = new File(UUID.randomUUID().toString() + "_" + file.getOriginalFilename());
                list.add(storedFilename.toString());
                file.transferTo(storedFilename); //업로드
            }
        }
        ProductVO img = new ProductVO();
        img.setProd_num(prod_num);
        img.setProd_images(list.toString());
        productService.insertImages(img);
        return list;
    }

    @ResponseBody // 리액트에서 데이터를 json형식으로 전달받기 위해 사용
    @RequestMapping("/uploadmodify")
    public List<String> modifyImage(@RequestParam("uploadfiles") MultipartFile[] uploadfiles, @RequestParam("prod_num") int prod_num, @RequestParam("prod_images") String prod_images) throws IOException {
        List<String> list = new ArrayList<>();
        for (MultipartFile file : uploadfiles) {
            if (!file.isEmpty()) {
                File storedFilename = new File(UUID.randomUUID().toString() + "_" + file.getOriginalFilename());
                list.add(storedFilename.toString());
                file.transferTo(storedFilename); //업로드
            }
        }
        String[] arr = prod_images.replace("[", "").replace("]", "").replaceAll(" ", "").split(",");
        for (String str : arr) {
            list.add(str);
        }
        ProductVO img = new ProductVO();
        img.setProd_num(prod_num);
        img.setProd_images(list.toString());
        productService.insertImages(img);
        return list;
    }

    @RequestMapping("/download")
    public ResponseEntity<UrlResource> download(@RequestParam("img") String stored) throws MalformedURLException {
        UrlResource resource = new UrlResource("file:" + uploadDir + "/" + stored);
        return ResponseEntity.ok().body(resource);
    }

}
