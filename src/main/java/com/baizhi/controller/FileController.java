/*
package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    public void upload(MultipartFile aa, HttpServletRequest request, HttpServletResponse response)throws Exception{
        String realPath = request.getSession().getServletContext().getRealPath("/banner");
        aa.transferTo(new File(realPath,aa.getOriginalFilename()));
        response.getWriter().print("uploads");
    }
}
*/
