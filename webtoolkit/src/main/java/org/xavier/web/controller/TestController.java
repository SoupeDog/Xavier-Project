package org.xavier.web.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xavier.common.exception.Universal_403_X_Exception;
import org.xavier.common.exception.Universal_409_X_Exception;
import org.xavier.web.annotation.ControllerLog;
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
    @ControllerLog
    @PostMapping("/Post/token/login")
    public ResponseEntity<?> createToken(@RequestBody Map a) {
        System.out.println("a");
        return success(a);
    }

    @ControllerLog
    @GetMapping("/Get/token/login/{boardId}")
    public ResponseEntity<?> createToken(@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage, @PathVariable("boardId") String boardId) {
        System.out.println("b");
        return fail(HttpMethod.GET, "", null, HttpStatus.NOT_FOUND, 404F, "搞事情");
    }
}
