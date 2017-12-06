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

//admin_user

@Repository("admin_userDao")
public class Admin_userDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Admin_userDao.class);



    private  String TABLE = "admin_user";

    private  String TABLENAME = "admin_user";

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


    private  String[] carrays ={"au_id","au_nickname","au_loginname","au_password","au_state"};
    private  String coulmns ="au_id,au_nickname,au_loginname,au_password,au_state";
    private  String coulmns2 ="au_nickname,au_loginname,au_password,au_state";

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
    public int insert(Admin_user bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Admin_user bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (au_nickname,au_loginname,au_password,au_state) VALUES (:au_nickname,:au_loginname,:au_password,:au_state)";
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
    public int insert_primarykey(Admin_user bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Admin_user bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (au_id,au_nickname,au_loginname,au_password,au_state) VALUES (:au_id,:au_nickname,:au_loginname,:au_password,:au_state)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Admin_user> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Admin_user> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (au_nickname,au_loginname,au_password,au_state) VALUES (?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Admin_user bean = beans.get(i);
                    ps.setString(1, bean.au_nickname);
                    ps.setString(2, bean.au_loginname);
                    ps.setString(3, bean.au_password);
                    ps.setInt(4, bean.au_state);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Admin_user> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Admin_user> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT au_id,au_nickname,au_loginname,au_password,au_state FROM "+TABLENAME2+" ORDER BY au_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Admin_user>(Admin_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Admin_user>();
        }
    }

    //查询最新数据
    public List<Admin_user> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Admin_user> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT au_id,au_nickname,au_loginname,au_password,au_state FROM "+TABLENAME2+" ORDER BY au_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Admin_user>(Admin_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Admin_user>();
        }
    }

    //根据主键查询
    public List<Admin_user> selectGtKey(long au_id) {
        return selectGtKey(au_id, TABLENAME);
    }

    //根据主键查询
    public List<Admin_user> selectGtKey(long au_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT au_id,au_nickname,au_loginname,au_password,au_state FROM "+TABLENAME2+" WHERE au_id>:au_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("au_id", au_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Admin_user>(Admin_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Admin_user>();
        }
    }

    //根据主键查询
    public Admin_user selectByKey(long au_id) {
        return selectByKey(au_id, TABLENAME);
    }

    //根据主键查询
    public Admin_user selectByKey(long au_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT au_id,au_nickname,au_loginname,au_password,au_state FROM "+TABLENAME2+" WHERE au_id=:au_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("au_id", au_id);
            List<Admin_user> list =  _np.query(sql, param, new BeanPropertyRowMapper<Admin_user>(Admin_user.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey au_id="+au_id,e);
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
    public List<Admin_user> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Admin_user> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT au_id,au_nickname,au_loginname,au_password,au_state FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Admin_user>(Admin_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Admin_user>();
        }
    }

    //修改数据
    public int updateByKey(Admin_user bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Admin_user bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET au_nickname=:au_nickname,au_loginname=:au_loginname,au_password=:au_password,au_state=:au_state WHERE au_id=:au_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Admin_user> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Admin_user> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET au_nickname=?,au_loginname=?,au_password=?,au_state=? WHERE au_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Admin_user bean = beans.get(i);
                    ps.setString(1, bean.au_nickname);
                    ps.setString(2, bean.au_loginname);
                    ps.setString(3, bean.au_password);
                    ps.setInt(4, bean.au_state);
                    ps.setLong(5, bean.au_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long au_id) throws SQLException{
        return deleteByKey(au_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long au_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE au_id=:au_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("au_id", au_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE au_id=?";
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
                 "	`au_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`au_nickname`  VARCHAR(20) COMMENT '//varchar(20)    '," +
                 "	`au_loginname`  VARCHAR(30) NOT NULL COMMENT '//varchar(30)    目标对象关联user_info表里面的用户uuid'," +
                 "	`au_password`  VARCHAR(50) COMMENT '//varchar(50)    信息创建时间'," +
                 "	`au_state`  INT(11) COMMENT '//int(11)    '," +
                 "	PRIMARY KEY (`au_id`)" +
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
