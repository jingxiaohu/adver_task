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

//user_exchange

@Repository("user_exchangeDao")
public class User_exchangeDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(User_exchangeDao.class);



    private  String TABLE = "user_exchange";

    private  String TABLENAME = "user_exchange";

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


    private  String[] carrays ={"ue_id","ui_id","ue_time","ue_time_str","ue_state","us_id","us_name","ue_money","ue_desc","ue_zfb","ue_telephone","ue_cft","ui_vc_old","note"};
    private  String coulmns ="ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note";
    private  String coulmns2 ="ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note";

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
    public int insert(User_exchange bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(User_exchange bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note) VALUES (:ui_id,:ue_time,:ue_time_str,:ue_state,:us_id,:us_name,:ue_money,:ue_desc,:ue_zfb,:ue_telephone,:ue_cft,:ui_vc_old,:note)";
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
    public int insert_primarykey(User_exchange bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(User_exchange bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note) VALUES (:ue_id,:ui_id,:ue_time,:ue_time_str,:ue_state,:us_id,:us_name,:ue_money,:ue_desc,:ue_zfb,:ue_telephone,:ue_cft,:ui_vc_old,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<User_exchange> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<User_exchange> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_exchange bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setLong(2, bean.ue_time);
                    ps.setString(3, bean.ue_time_str);
                    ps.setInt(4, bean.ue_state);
                    ps.setLong(5, bean.us_id);
                    ps.setString(6, bean.us_name);
                    ps.setLong(7, bean.ue_money);
                    ps.setString(8, bean.ue_desc);
                    ps.setString(9, bean.ue_zfb);
                    ps.setString(10, bean.ue_telephone);
                    ps.setString(11, bean.ue_cft);
                    ps.setLong(12, bean.ui_vc_old);
                    ps.setString(13, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<User_exchange> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<User_exchange> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note FROM "+TABLENAME2+" ORDER BY ue_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_exchange>(User_exchange.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<User_exchange>();
        }
    }

    //查询最新数据
    public List<User_exchange> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<User_exchange> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note FROM "+TABLENAME2+" ORDER BY ue_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_exchange>(User_exchange.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<User_exchange>();
        }
    }

    //根据主键查询
    public List<User_exchange> selectGtKey(long ue_id) {
        return selectGtKey(ue_id, TABLENAME);
    }

    //根据主键查询
    public List<User_exchange> selectGtKey(long ue_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note FROM "+TABLENAME2+" WHERE ue_id>:ue_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ue_id", ue_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<User_exchange>(User_exchange.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<User_exchange>();
        }
    }

    //根据主键查询
    public User_exchange selectByKey(long ue_id) {
        return selectByKey(ue_id, TABLENAME);
    }

    //根据主键查询
    public User_exchange selectByKey(long ue_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note FROM "+TABLENAME2+" WHERE ue_id=:ue_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ue_id", ue_id);
            List<User_exchange> list =  _np.query(sql, param, new BeanPropertyRowMapper<User_exchange>(User_exchange.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ue_id="+ue_id,e);
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
    public List<User_exchange> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<User_exchange> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ue_id,ui_id,ue_time,ue_time_str,ue_state,us_id,us_name,ue_money,ue_desc,ue_zfb,ue_telephone,ue_cft,ui_vc_old,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<User_exchange>(User_exchange.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<User_exchange>();
        }
    }

    //修改数据
    public int updateByKey(User_exchange bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(User_exchange bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,ue_time=:ue_time,ue_time_str=:ue_time_str,ue_state=:ue_state,us_id=:us_id,us_name=:us_name,ue_money=:ue_money,ue_desc=:ue_desc,ue_zfb=:ue_zfb,ue_telephone=:ue_telephone,ue_cft=:ue_cft,ui_vc_old=:ui_vc_old,note=:note WHERE ue_id=:ue_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<User_exchange> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<User_exchange> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,ue_time=?,ue_time_str=?,ue_state=?,us_id=?,us_name=?,ue_money=?,ue_desc=?,ue_zfb=?,ue_telephone=?,ue_cft=?,ui_vc_old=?,note=? WHERE ue_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_exchange bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setLong(2, bean.ue_time);
                    ps.setString(3, bean.ue_time_str);
                    ps.setInt(4, bean.ue_state);
                    ps.setLong(5, bean.us_id);
                    ps.setString(6, bean.us_name);
                    ps.setLong(7, bean.ue_money);
                    ps.setString(8, bean.ue_desc);
                    ps.setString(9, bean.ue_zfb);
                    ps.setString(10, bean.ue_telephone);
                    ps.setString(11, bean.ue_cft);
                    ps.setLong(12, bean.ui_vc_old);
                    ps.setString(13, bean.note);
                    ps.setLong(14, bean.ue_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ue_id) throws SQLException{
        return deleteByKey(ue_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ue_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ue_id=:ue_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ue_id", ue_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ue_id=?";
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
                 "	`ue_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`ue_time`  BIGINT(20) COMMENT '//bigint(20)    创建时间'," +
                 "	`ue_time_str`  VARCHAR(60) COMMENT '//varchar(60)    '," +
                 "	`ue_state`  INT(11) COMMENT '//int(11)    兑换状态：0未兑换1已兑换'," +
                 "	`us_id`  BIGINT(20) COMMENT '//bigint(20)    兑换种类0：电话充值1：Q币'," +
                 "	`us_name`  VARCHAR(100) COMMENT '//varchar(100)    兑换礼物名称'," +
                 "	`ue_money`  BIGINT(20) COMMENT '//bigint(20)    兑换消耗的牛币'," +
                 "	`ue_desc`  VARCHAR(200) COMMENT '//varchar(200)    描述'," +
                 "	`ue_zfb`  VARCHAR(100) COMMENT '//varchar(100)    支付宝'," +
                 "	`ue_telephone`  VARCHAR(11) COMMENT '//varchar(11)    电话号码'," +
                 "	`ue_cft`  VARCHAR(30) COMMENT '//varchar(30)    财付通'," +
                 "	`ui_vc_old`  BIGINT(20) COMMENT '//bigint(20)    用户兑换前的牛币总数'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	PRIMARY KEY (`ue_id`)" +
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
