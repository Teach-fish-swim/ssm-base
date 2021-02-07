package com.study.controller;

import com.study.dao.User;
import com.study.service.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("look")
public class LookMes {
    @Autowired
    User user;
    @ResponseBody
    @RequestMapping("/mes")
    public String look(){
        System.out.println("已经看到了");
        UserBean userBean= user.getUserBean(9);
        return "mes:"+userBean.toString();
    }
    @ResponseBody
    @RequestMapping("/fileUpLoad")
    public String fileUpLoad(Model model, @RequestParam(value = "username",required = false)String username,
                             @RequestParam(value = "fileName",required = false) MultipartFile file) {
        String isSuccess="fail";
        try {
            file.transferTo(new File("c://school//"+file.getName()));
            isSuccess="上传成功";
            System.out.println("yes");
            isSuccess="success";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isSuccess="上传失败";
            System.out.println("no");

        }
        model.addAttribute("isSuccess", isSuccess);
        return isSuccess;

    }

    @RequestMapping("/download")
    public void  downloadApk(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = "index.html";
        String realPath = request.getRealPath(fileName);
        response.setHeader("Content-Disposition", "attachment;file=" + URLEncoder.encode(fileName, "utf-8"));
        response.setContentType(request.getServletContext().getMimeType(realPath));
        InputStream is = null;
        OutputStream os = null;

        try {
            os = response.getOutputStream();
            is = new FileInputStream(realPath);
            int len = -1;
            byte[] byt = new byte[1024];
            while ((len = is.read(byt)) != -1) {
                os.write(byt, 0, len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        } finally {
            os.close();
            is.close();
        }

    }



}
