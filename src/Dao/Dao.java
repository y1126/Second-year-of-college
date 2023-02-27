package Dao;
import qsap.qsap;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Dao {

    public boolean add(qsap qsap) {
        String sql = "insert into qsap(id,name,place) values('" + qsap.getId() + "','" + qsap.getName() + "','" + qsap.getPlace()  + "')";

        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;
    }

    public List<qsap> list() {
        String sql = "select * from qsap";
        List<qsap> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            qsap bean = null;
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String place = rs.getString("place");
                bean = new qsap(id,name,place);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return list;
    }



    public boolean update(qsap qsap,String id) {
        String sql = " UPDATE qsap SET id='" + qsap.getId() + "', name ='" + qsap.getName()+ "' ;";
        boolean f = false;
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;

        try {
            state = conn.createStatement();
            a= state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        if (a > 0) {
            f = true;
        }
        return f;


    }



    public qsap getByName(String id) {
        String sql = "select * from qsap where id ='" + id + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        qsap qsap= null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String place = rs.getString("place");
                qsap = new qsap(name,place);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return qsap;
    }


    public List<qsap>getBy(String id,String name,String place) {
        String sql = "select * from qsap where id ='" + id+ "'or name ='"+name+"'or place='"+place+"'";
        List<qsap> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        qsap qsap= null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String id1 = rs.getString("zhuti");
                String name1 = rs.getString("name1");
                String place1 = rs.getString("place1");


                qsap = new qsap(id1,name1,place1);
                list.add(qsap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return list;
    }

    public boolean delete (String id) {
        boolean f = false;
        String sql = "DELETE from qsap WHERE id like '%"+id+"%'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;

        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;
    }











    public  List<qsap> getdel(String id)
    { String sql = "select * from qsap where id ='" + id + "'";
        List<qsap> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        qsap qsap= null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String place = rs.getString("place");
                qsap = new qsap(id,name,place);
                list.add(qsap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        return list;
    }

}
