package com.pyb.dao;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import java.util.*;

import java.sql.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.support.*;
import com.pyb.bean.*;
import org.springframework.stereotype.Repository;
import com.highbeauty.text.EasyTemplate;

//wp_term_jxh

@Repository("wp_term_jxhDao")
public class Wp_term_jxhDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wp_term_jxhDao.class);



    private  String TABLE = "wp_term_jxh";

    private  String TABLENAME = "wp_term_jxh";

    public  String getTABLE(){
        return  TABLE;
    }

    public  String getTABLENAME(){
        return  TABLENAME;
    }

    public  String TABLEMM(){
        return TABLE + sdfMm.format(new java.util.Date());
    }

    public  String TABLEDD(){
        return TABLE + sdfDd.format(new java.util.Date());
    }


    private  String[] carrays ={"id","category_id","category_father_id","category_code","name","url","fatherurl","ctime","noe"};
    private  String coulmns ="id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe";
    private  String coulmns2 ="category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe";

    public  String[] getCarrays(){
        return  carrays;
    }

    public  String getCoulmns(){
        return  coulmns;
    }

    public  String getCoulmns2(){
        return  coulmns2;
    }

    //添加数据
    public int insert(Wp_term_jxh bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wp_term_jxh bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe) VALUES (:category_id,:category_father_id,:category_code,:name,:url,:fatherurl,:ctime,:noe)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            KeyHolder keyholder = new GeneratedKeyHolder();
            _np.update(sql, ps, keyholder);
            return keyholder.getKey().intValue();
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //添加数据
    public int insert_primarykey(Wp_term_jxh bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wp_term_jxh bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe) VALUES (:id,:category_id,:category_father_id,:category_code,:name,:url,:fatherurl,:ctime,:noe)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wp_term_jxh> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wp_term_jxh> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe) VALUES (?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_term_jxh bean = beans.get(i);
                    ps.setLong(1, bean.category_id);
                    ps.setLong(2, bean.category_father_id);
                    ps.setString(3, bean.category_code);
                    ps.setString(4, bean.name);
                    ps.setString(5, bean.url);
                    ps.setString(6, bean.fatherurl);
                    ps.setTimestamp(7, new Timestamp(bean.ctime.getTime()));
                    ps.setString(8, bean.noe);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wp_term_jxh> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wp_term_jxh> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe FROM "+TABLENAME2+" ORDER BY id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_term_jxh>(Wp_term_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wp_term_jxh>();
        }
    }

    //查询最新数据
    public List<Wp_term_jxh> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wp_term_jxh> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe FROM "+TABLENAME2+" ORDER BY id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_term_jxh>(Wp_term_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wp_term_jxh>();
        }
    }

    //根据主键查询
    public List<Wp_term_jxh> selectGtKey(long id) {
        return selectGtKey(id, TABLENAME);
    }

    //根据主键查询
    public List<Wp_term_jxh> selectGtKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe FROM "+TABLENAME2+" WHERE id>:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wp_term_jxh>(Wp_term_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wp_term_jxh>();
        }
    }

    //根据主键查询
    public Wp_term_jxh selectByKey(long id) {
        return selectByKey(id, TABLENAME);
    }

    //根据主键查询
    public Wp_term_jxh selectByKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe FROM "+TABLENAME2+" WHERE id=:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            List<Wp_term_jxh> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wp_term_jxh>(Wp_term_jxh.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey id="+id,e);
            return null;
        }
    }

    //所有数据总数
    public int count() {
        return count(TABLENAME);
    }

    //所有数据总数
    public int count(String TABLENAME2) {
        String sql;
        try{
            sql="SELECT COUNT(*) FROM "+TABLENAME2+"";
            return _np.getJdbcOperations().queryForObject(sql,Integer.class);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("count",e);
            return 0;
        }
    }

    //分页查询
    public List<Wp_term_jxh> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wp_term_jxh> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT id,category_id,category_father_id,category_code,name,url,fatherurl,ctime,noe FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wp_term_jxh>(Wp_term_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wp_term_jxh>();
        }
    }

    //修改数据
    public int updateByKey(Wp_term_jxh bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wp_term_jxh bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET category_id=:category_id,category_father_id=:category_father_id,category_code=:category_code,name=:name,url=:url,fatherurl=:fatherurl,ctime=:ctime,noe=:noe WHERE id=:id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_term_jxh> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_term_jxh> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET category_id=?,category_father_id=?,category_code=?,name=?,url=?,fatherurl=?,ctime=?,noe=? WHERE id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_term_jxh bean = beans.get(i);
                    ps.setLong(1, bean.category_id);
                    ps.setLong(2, bean.category_father_id);
                    ps.setString(3, bean.category_code);
                    ps.setString(4, bean.name);
                    ps.setString(5, bean.url);
                    ps.setString(6, bean.fatherurl);
                    ps.setTimestamp(7, new Timestamp(bean.ctime.getTime()));
                    ps.setString(8, bean.noe);
                    ps.setLong(9, bean.id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long id) throws SQLException{
        return deleteByKey(id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE id=:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            return _np.update(sql, param);
        }catch(Exception e){
            log.error("deleteByKey", e);
            throw new SQLException("deleteByKey is error", e);
        }
    }

    //批量删除数据
    public int[] deleteByKey(long[] keys) throws SQLException{
        return deleteByKey(keys, TABLENAME);
    }

    //批量删除数据
    public int[] deleteByKey(final long[] keys, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return keys.length;
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setLong(1 , keys[i]);
                }
            });
        }catch(Exception e){
            log.error("int[] deleteByKey", e);
            throw new SQLException("deleteByKey is error", e);
        }
    }

    //创建表
    public void createTable(String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS `${TABLENAME}` (" +
                 "	`id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`category_id`  BIGINT(20) COMMENT '//bigint(20)    分类目录主键ID'," +
                 "	`category_father_id`  BIGINT(20) COMMENT '//bigint(20)    父级分类的ID'," +
                 "	`category_code`  VARCHAR(100) COMMENT '//varchar(100)    分类代码'," +
                 "	`name`  VARCHAR(100) COMMENT '//varchar(100)    分类目录的抓取时候名称(标题)'," +
                 "	`url`  TINYTEXT COMMENT '//varchar(255)    分类目录抓取的URL'," +
                 "	`fatherurl`  TINYTEXT COMMENT '//varchar(255)    抓取的上级来源URL'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`noe`  TINYTEXT COMMENT '//varchar(255)    备注'," +
                 "	PRIMARY KEY (`id`)" +
                 ") ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;";
            Map<String,String> params = new HashMap<String,String>();
            params.put("TABLENAME", TABLENAME2);
            sql  = EasyTemplate.make(sql, params);
            _np.getJdbcOperations().execute(sql);
        }catch(Exception e){
            log.error("createTable",e);
            throw new SQLException("createTable is error", e);
        }
    }

    //清空表
    public void truncate() throws SQLException{
        truncate(TABLENAME);
    }

    //清空表
    public void truncate(String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql="TRUNCATE TABLE "+TABLENAME2+"";
            _np.getJdbcOperations().execute(sql);
        }catch(Exception e){
            log.error("truncate",e);
            throw new SQLException("truncate is error", e);
        }
    }

    //修复表
    public void repair(){
        repair(TABLENAME);
    }

    //修复表
    public void repair(String TABLENAME2){
        try{
            String sql;
            sql="REPAIR TABLE "+TABLENAME2+"";
            _np.getJdbcOperations().execute(sql);
        }catch(Exception e){
            log.error("repair",e);
        }
    }

    //优化表
    public void optimize(){
        optimize(TABLENAME);
    }

    //优化表
    public void optimize(String TABLENAME2){
        try{
            String sql;
            sql="OPTIMIZE TABLE "+TABLENAME2+"";
            _np.getJdbcOperations().execute(sql);
        }catch(Exception e){
            log.error("optimize",e);
        }
    }

    //执行sql
    public void execute(String sql) throws SQLException{
        try{
            _np.getJdbcOperations().execute(sql);
        }catch(Exception e){
            log.error("execute",e);
            throw new SQLException("execute is error", e);
        }
    }

}
