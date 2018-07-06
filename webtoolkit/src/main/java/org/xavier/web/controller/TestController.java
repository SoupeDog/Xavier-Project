package org.xavier.web.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.web.annotation.EnableControllerLog;
import org.xavier.web.extend.DefaultController;

import java.util.Map;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.07.05
 * @since Jdk 1.8
 */
@RestController
public class TestController extends DefaultController {
    @EnableControllerLog
    @PostMapping("/Post/token/login")
    public ResponseEntity<?> postMethod(@RequestBody Map a) {
        if(1==1)
        throw new Universal_500_X_Exception_Runtime("天哪");
        System.out.println("a");
        return success(a);
    }

    @EnableControllerLog
    @GetMapping("/Get/token/login/{boardId}")
    public ResponseEntity<?> getMethod(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage, @PathVariable("boardId") String boardId) {
        System.out.println("b");
        return fail(HttpMethod.GET, "", null, HttpStatus.NOT_FOUND, 404F, "搞事情");
    }
}
