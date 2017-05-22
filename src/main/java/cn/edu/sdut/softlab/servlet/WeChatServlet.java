package cn.edu.sdut.softlab.servlet;

/**
 * 获取值
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdut.softlab.util.ChecktUtil;

public class WeChatServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public WeChatServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        MyWechat myWechat = new MyWechat(request);
//        String result = myWechat.execute();
//        response.getOutputStream().write(result.getBytes());
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        // 调用逻辑验证
        PrintWriter out = response.getWriter();
        if (ChecktUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("check ok!");
            out.println(echostr);
        }
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        MyWechat myWechat = new MyWechat(request);
//        String result = myWechat.execute();
//        response.getOutputStream().write(result.getBytes());
    }
}
