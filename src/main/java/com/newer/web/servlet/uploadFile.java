package com.newer.web.servlet;

import com.newer.util.FileResolve;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class uploadFile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("uploadFile");
        String inputName=part.getName();
        InputStream input=part.getInputStream();
        String tagDir=getServletContext().getRealPath("/upload");
        //产生随机uuid做文件名
        String realFileName=UUID.randomUUID().toString();
        File newFile = new File(tagDir,realFileName);
        OutputStream output=new FileOutputStream(newFile);
        int len=0;
        byte[] buff=new byte[1024*8];

        while ((len = input.read(buff)) > -1) {
            output.write(buff, 0, len);
        }

        input.close();
        output.close();
        int file_pages = FileResolve.getPages(newFile);

        response.setCharacterEncoding("utf-8");
        response.getWriter().print("upload success!!");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
