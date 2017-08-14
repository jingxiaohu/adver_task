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

//user_external

@Repository("user_externalDao")
public class User_externalDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(User_externalDao.class);



    private  String TABLE = "user_external";

    private  String TABLENAME = "user_external";

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


    private  String[] carrays ={"up_id","ui_id","up_type","up_token","up_key","ctime","utime","note"};
    private  String coulmns ="up_id,ui_id,up_type,up_token,up_key,ctime,utime,note";
    private  String coulmns2 ="ui_id,up_type,up_token,up_key,ctime,utime,note";

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
    public int insert(User_external bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(User_external bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,up_type,up_token,up_key,ctime,utime,note) VALUES (:ui_id,:up_type,:up_token,:up_key,:ctime,:utime,:note)";
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
    public int insert_primarykey(User_external bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(User_external bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (up_id,ui_id,up_type,up_token,up_key,ctime,utime,note) VALUES (:up_id,:ui_id,:up_type,:up_token,:up_key,:ctime,:utime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<User_external> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<User_external> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,up_type,up_token,up_key,ctime,utime,note) VALUES (?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_external bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setInt(2, bean.up_type);
                    ps.setString(3, bean.up_token);
                    ps.setString(4, bean.up_key);
                    ps.setLong(5, bean.ctime);
                    ps.setLong(6, bean.utime);
                    ps.setString(7, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<User_external> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<User_external> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT up_id,ui_id,up_type,up_token,up_key,ctime,utime,note FROM "+TABLENAME2+" ORDER BY up_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_external>(User_external.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<User_external>();
        }
    }

    //查询最新数据
    public List<User_external> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<User_external> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT up_id,ui_id,up_type,up_token,up_key,ctime,utime,note FROM "+TABLENAME2+" ORDER BY up_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_external>(User_external.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<User_external>();
        }
    }

    //根据主键查询
    public List<User_external> selectGtKey(long up_id) {
        return selectGtKey(up_id, TABLENAME);
    }

    //根据主键查询
    public List<User_external> selectGtKey(long up_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT up_id,ui_id,up_type,up_token,up_key,ctime,utime,note FROM "+TABLENAME2+" WHERE up_id>:up_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("up_id", up_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<User_external>(User_external.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<User_external>();
        }
    }

    //根据主键查询
    public User_external selectByKey(long up_id) {
        return selectByKey(up_id, TABLENAME);
    }

    //根据主键查询
    public User_external selectByKey(long up_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT up_id,ui_id,up_type,up_token,up_key,ctime,utime,note FROM "+TABLENAME2+" WHERE up_id=:up_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("up_id", up_id);
            List<User_external> list =  _np.query(sql, param, new BeanPropertyRowMapper<User_external>(User_external.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey up_id="+up_id,e);
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
    public List<User_external> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<User_external> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT up_id,ui_id,up_type,up_token,up_key,ctime,utime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<User_external>(User_external.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<User_external>();
        }
    }

    //修改数据
    public int updateByKey(User_external bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(User_external bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,up_type=:up_type,up_token=:up_token,up_key=:up_key,ctime=:ctime,utime=:utime,note=:note WHERE up_id=:up_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<User_external> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<User_external> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,up_type=?,up_token=?,up_key=?,ctime=?,utime=?,note=? WHERE up_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_external bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setInt(2, bean.up_type);
                    ps.setString(3, bean.up_token);
                    ps.setString(4, bean.up_key);
                    ps.setLong(5, bean.ctime);
                    ps.setLong(6, bean.utime);
                    ps.setString(7, bean.note);
                    ps.setLong(8, bean.up_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long up_id) throws SQLException{
        return deleteByKey(up_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long up_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE up_id=:up_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("up_id", up_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE up_id=?";
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
                 "	`up_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`ui_id`  BIGINT(20) NOT NULL COMMENT '//bigint(20)    用户标识关联user_info表里面的用户uuid'," +
                 "	`up_type`  INT(11) COMMENT '//int(11)    用户账户类型0微信用户1新浪账户2腾讯账户3人人账户4开心账户5天涯账户6FACEBOOK'," +
                 "	`up_token`  TINYTEXT COMMENT '//varchar(500)    外部TOKEN'," +
                 "	`up_key`  TINYTEXT COMMENT '//varchar(500)    外部主键'," +
                 "	`ctime`  BIGINT(20) COMMENT '//bigint(20)    '," +
                 "	`utime`  BIGINT(20) COMMENT '//bigint(20)    '," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    '," +
                 "	PRIMARY KEY (`up_id`)" +
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
