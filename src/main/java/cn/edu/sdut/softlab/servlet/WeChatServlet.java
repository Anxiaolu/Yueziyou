package cn.edu.sdut.softlab.servlet;

/**
 * 获取值
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeChatServlet extends HttpServlet {

    public WeChatServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyWechat myWechat = new MyWechat(request);
        String result = myWechat.execute();
        response.getOutputStream().write(result.getBytes());
//        String signature = req.getParameter("signature");
//        String timestamp = req.getParameter("timestamp");
//        String nonce = req.getParameter("nonce");
//        String echostr = req.getParameter("echostr");
//
//        // 调用逻辑验证
//        PrintWriter out = resp.getWriter();
//        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
//            System.out.println("check ok!");
//            out.println(echostr);
//        }
//        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyWechat myWechat = new MyWechat(request);
        String result = myWechat.execute();
        response.getOutputStream().write(result.getBytes());
    }
}
