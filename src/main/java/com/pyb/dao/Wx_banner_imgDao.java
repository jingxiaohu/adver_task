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

//wx_banner_img

@Repository("wx_banner_imgDao")
public class Wx_banner_imgDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_banner_imgDao.class);



    private  String TABLE = "wx_banner_img";

    private  String TABLENAME = "wx_banner_img";

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


    private  String[] carrays ={"bi_id","img_name","img_url","img_intro","ctime","note","weight","jump_url"};
    private  String coulmns ="bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url";
    private  String coulmns2 ="img_name,img_url,img_intro,ctime,note,weight,jump_url";

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
    public int insert(Wx_banner_img bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_banner_img bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (img_name,img_url,img_intro,ctime,note,weight,jump_url) VALUES (:img_name,:img_url,:img_intro,:ctime,:note,:weight,:jump_url)";
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
    public int insert_primarykey(Wx_banner_img bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_banner_img bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url) VALUES (:bi_id,:img_name,:img_url,:img_intro,:ctime,:note,:weight,:jump_url)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_banner_img> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_banner_img> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (img_name,img_url,img_intro,ctime,note,weight,jump_url) VALUES (?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_banner_img bean = beans.get(i);
                    ps.setString(1, bean.img_name);
                    ps.setString(2, bean.img_url);
                    ps.setString(3, bean.img_intro);
                    ps.setTimestamp(4, new Timestamp(bean.ctime.getTime()));
                    ps.setString(5, bean.note);
                    ps.setInt(6, bean.weight);
                    ps.setString(7, bean.jump_url);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_banner_img> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_banner_img> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url FROM "+TABLENAME2+" ORDER BY bi_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_banner_img>(Wx_banner_img.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_banner_img>();
        }
    }

    //查询最新数据
    public List<Wx_banner_img> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_banner_img> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url FROM "+TABLENAME2+" ORDER BY bi_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_banner_img>(Wx_banner_img.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_banner_img>();
        }
    }

    //根据主键查询
    public List<Wx_banner_img> selectGtKey(long bi_id) {
        return selectGtKey(bi_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_banner_img> selectGtKey(long bi_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url FROM "+TABLENAME2+" WHERE bi_id>:bi_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("bi_id", bi_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_banner_img>(Wx_banner_img.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_banner_img>();
        }
    }

    //根据主键查询
    public Wx_banner_img selectByKey(long bi_id) {
        return selectByKey(bi_id, TABLENAME);
    }

    //根据主键查询
    public Wx_banner_img selectByKey(long bi_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url FROM "+TABLENAME2+" WHERE bi_id=:bi_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("bi_id", bi_id);
            List<Wx_banner_img> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_banner_img>(Wx_banner_img.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey bi_id="+bi_id,e);
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
    public List<Wx_banner_img> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_banner_img> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT bi_id,img_name,img_url,img_intro,ctime,note,weight,jump_url FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_banner_img>(Wx_banner_img.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_banner_img>();
        }
    }

    //修改数据
    public int updateByKey(Wx_banner_img bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_banner_img bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET img_name=:img_name,img_url=:img_url,img_intro=:img_intro,ctime=:ctime,note=:note,weight=:weight,jump_url=:jump_url WHERE bi_id=:bi_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_banner_img> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_banner_img> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET img_name=?,img_url=?,img_intro=?,ctime=?,note=?,weight=?,jump_url=? WHERE bi_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_banner_img bean = beans.get(i);
                    ps.setString(1, bean.img_name);
                    ps.setString(2, bean.img_url);
                    ps.setString(3, bean.img_intro);
                    ps.setTimestamp(4, new Timestamp(bean.ctime.getTime()));
                    ps.setString(5, bean.note);
                    ps.setInt(6, bean.weight);
                    ps.setString(7, bean.jump_url);
                    ps.setLong(8, bean.bi_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long bi_id) throws SQLException{
        return deleteByKey(bi_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long bi_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE bi_id=:bi_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("bi_id", bi_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE bi_id=?";
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
                 "	`bi_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`img_name`  VARCHAR(80) COMMENT '//varchar(80)    图片名称'," +
                 "	`img_url`  VARCHAR(200) COMMENT '//varchar(200)    图片URL'," +
                 "	`img_intro`  TINYTEXT COMMENT '//varchar(255)    图片功能简介'," +
                 "	`ctime`  TIMESTAMP NOT NULL COMMENT '//timestamp    创建时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`weight`  INT(11) COMMENT '//int(11)    权重'," +
                 "	`jump_url`  VARCHAR(200) COMMENT '//varchar(200)    跳转的目的地链接'," +
                 "	PRIMARY KEY (`bi_id`)" +
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
