package Servlet;

import Service.Service;
import qsap.qsap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Service service = new Service();
    /**
     * 方法选择
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");

        if ("add".equals(method)) {
            add(req, resp);
        }
        else if ("list".equals(method)) {
            list(req, resp);
        }
        else if ("update".equals(method)) {
            update(req, resp);
        }
        else if ("getbyname1".equals(method)) {
            getByName1(req, resp);
        }
        else if ("getbyname".equals(method)) {
            getByName(req, resp);
        }
        else if ("search".equals(method)) {
            search(req, resp);
        }  else if ("getdel".equals(method)) {
            getdel(req, resp);
        }
        else if ("getdel1".equals(method)) {
            getdel1(req, resp);
        }
        else if ("del".equals(method)) {
            del(req, resp);
        }

    }


    /**
     * 添加
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
//获取数据
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String place = req.getParameter("place");

        qsap qsap = new qsap(id,name,place);
//添加后消息显示
        if(id.length()>20||name.length()>500||place.length()>500)
        {
            req.setAttribute("message", "不符合要重新开始");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
        else{
            if(service.add(qsap)) {
                req.setAttribute("message", "添加成功");
                List<qsap> list = new ArrayList<>();
                list= service.list();
                req.setAttribute("list",list);
                req.getRequestDispatcher("liu.jsp").forward(req,resp);
            } else {
                req.setAttribute("message", "不符合要重新开始");
                req.getRequestDispatcher("add.jsp").forward(req,resp);
            }}
    }
    private void list(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException
    {
        req.setCharacterEncoding("utf-8");
        List<qsap> list = new ArrayList<>();
        list= service.list();
        req.setAttribute("list",list);



        req.getRequestDispatcher("liu.jsp").forward(req,resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String place = req.getParameter("place");
        qsap qsap = new qsap(id,name,place);

        service.update(qsap,id);
        req.setAttribute("message", "修改成功");
        req.getRequestDispatcher("h.jsp").forward(req,resp);
    }
    private void getByName1(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        qsap  qsap=service.getByName(id);
        req.setAttribute("qsap", qsap);
        req.getRequestDispatcher("detail2.jsp").forward(req,resp);
    }
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String place = req.getParameter("place");

        List<qsap> list = new ArrayList<>();
        list=service.getBy(id,name,place);
        req.setAttribute("list", list);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
    private void getdel(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        List<qsap> list= new ArrayList<>();
        list=service.getdel(id);
        if(list==null)
        {
            req.setAttribute("message", "查无此人！");
            req.getRequestDispatcher("del.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("list",list);
            req.getRequestDispatcher("detail.jsp").forward(req,resp);

        }


    }
    private void getdel1(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        List<qsap> list= new ArrayList<>();
        list=service.getdel(id);
        if( list.size()==0 )
        {
            req.setAttribute("message", "查无此人！");
            req.getRequestDispatcher("del.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("list",list);
            req.getRequestDispatcher("detail2.jsp").forward(req,resp);
        }



    }

    private void del(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");

        service.del(id);
        req.setAttribute("message", "删除成功！");
        req.getRequestDispatcher("del.jsp").forward(req,resp);
    }
    private void getByName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        qsap qsap=service.getByName(id);
        if(qsap == null) {
            req.setAttribute("message", "查无此人！");
            req.getRequestDispatcher("del.jsp").forward(req,resp);
        } else {
            req.setAttribute("qsap", qsap);
            req.getRequestDispatcher("detail.jsp").forward(req,resp);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
