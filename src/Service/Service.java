package Service;

import Dao.Dao;
import qsap.qsap;

import java.util.List;

public class Service {

    /**
     * Service
     * 服务层
     * @author Hu
     *
     */
    Dao cDao = new Dao();

    /**
     * 添加
     * @param
     * @return
     */
    public boolean add(qsap qsap) {
        boolean f = false;
        cDao.add(qsap);
        f = true;
        return f;
    }
    public List<qsap> list() {
        return cDao.list();
    }
    public void update(qsap qsap,String id) {
        cDao.update(qsap,id);
    }
    public  qsap getByName(String id) {
        return cDao.getByName(id);
    }
    public qsap getByName1(String id) {
        return cDao.getByName(id);
    }
    public List<qsap>getBy(String id,String name,String place){
        return cDao.getBy( id,name,place);
    }

    public void del(String id) {
        cDao.delete(id);
    }

    public  List<qsap>getdel(String id)
    {
        return cDao.getdel(id);
    }
}
