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

//wx_goods_details

@Repository("wx_goods_detailsDao")
public class Wx_goods_detailsDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_goods_detailsDao.class);



    private  String TABLE = "wx_goods_details";

    private  String TABLENAME = "wx_goods_details";

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


    private  String[] carrays ={"gd_id","g_id","goods_desc","img_urls","ctime","utime","note","is_del"};
    private  String coulmns ="gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del";
    private  String coulmns2 ="g_id,goods_desc,img_urls,ctime,utime,note,is_del";

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
    public int insert(Wx_goods_details bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_goods_details bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (g_id,goods_desc,img_urls,ctime,utime,note,is_del) VALUES (:g_id,:goods_desc,:img_urls,:ctime,:utime,:note,:is_del)";
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
    public int insert_primarykey(Wx_goods_details bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_goods_details bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del) VALUES (:gd_id,:g_id,:goods_desc,:img_urls,:ctime,:utime,:note,:is_del)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_goods_details> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_goods_details> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (g_id,goods_desc,img_urls,ctime,utime,note,is_del) VALUES (?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods_details bean = beans.get(i);
                    ps.setLong(1, bean.g_id);
                    ps.setString(2, bean.goods_desc);
                    ps.setString(3, bean.img_urls);
                    ps.setTimestamp(4, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(5, new Timestamp(bean.utime.getTime()));
                    ps.setString(6, bean.note);
                    ps.setInt(7, bean.is_del);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_goods_details> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods_details> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del FROM "+TABLENAME2+" ORDER BY gd_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods_details>(Wx_goods_details.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_goods_details>();
        }
    }

    //查询最新数据
    public List<Wx_goods_details> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods_details> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del FROM "+TABLENAME2+" ORDER BY gd_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods_details>(Wx_goods_details.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_goods_details>();
        }
    }

    //根据主键查询
    public List<Wx_goods_details> selectGtKey(long gd_id) {
        return selectGtKey(gd_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_goods_details> selectGtKey(long gd_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del FROM "+TABLENAME2+" WHERE gd_id>:gd_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gd_id", gd_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods_details>(Wx_goods_details.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_goods_details>();
        }
    }

    //根据主键查询
    public Wx_goods_details selectByKey(long gd_id) {
        return selectByKey(gd_id, TABLENAME);
    }

    //根据主键查询
    public Wx_goods_details selectByKey(long gd_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del FROM "+TABLENAME2+" WHERE gd_id=:gd_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gd_id", gd_id);
            List<Wx_goods_details> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods_details>(Wx_goods_details.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey gd_id="+gd_id,e);
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
    public List<Wx_goods_details> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_goods_details> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT gd_id,g_id,goods_desc,img_urls,ctime,utime,note,is_del FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_goods_details>(Wx_goods_details.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_goods_details>();
        }
    }

    //修改数据
    public int updateByKey(Wx_goods_details bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_goods_details bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET g_id=:g_id,goods_desc=:goods_desc,img_urls=:img_urls,ctime=:ctime,utime=:utime,note=:note,is_del=:is_del WHERE gd_id=:gd_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods_details> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods_details> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET g_id=?,goods_desc=?,img_urls=?,ctime=?,utime=?,note=?,is_del=? WHERE gd_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods_details bean = beans.get(i);
                    ps.setLong(1, bean.g_id);
                    ps.setString(2, bean.goods_desc);
                    ps.setString(3, bean.img_urls);
                    ps.setTimestamp(4, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(5, new Timestamp(bean.utime.getTime()));
                    ps.setString(6, bean.note);
                    ps.setInt(7, bean.is_del);
                    ps.setLong(8, bean.gd_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long gd_id) throws SQLException{
        return deleteByKey(gd_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long gd_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE gd_id=:gd_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gd_id", gd_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE gd_id=?";
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
                 "	`gd_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`g_id`  BIGINT(20) COMMENT '//bigint(20)    商品表主键ID'," +
                 "	`goods_desc`  TINYTEXT COMMENT '//text    详情介绍'," +
                 "	`img_urls`  TINYTEXT COMMENT '//varchar(800)    详情图片URL逗号分割'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`utime`  TIMESTAMP COMMENT '//timestamp    更新时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除:0：不删除1：删除'," +
                 "	PRIMARY KEY (`gd_id`)" +
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
