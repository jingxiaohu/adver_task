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


    private  String[] carrays ={"ue_id","ue_nd","ui_id","ui_nd","ue_type","ue_name","ue_money","rest_money","ctime","note"};
    private  String coulmns ="ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note";
    private  String coulmns2 ="ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note";

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
            sql = "INSERT INTO "+TABLENAME2+" (ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note) VALUES (:ue_nd,:ui_id,:ui_nd,:ue_type,:ue_name,:ue_money,:rest_money,:ctime,:note)";
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
            sql = "INSERT INTO "+TABLENAME2+" (ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note) VALUES (:ue_id,:ue_nd,:ui_id,:ui_nd,:ue_type,:ue_name,:ue_money,:rest_money,:ctime,:note)";
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
            sql = "INSERT INTO "+TABLENAME2+" (ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note) VALUES (?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_exchange bean = beans.get(i);
                    ps.setString(1, bean.ue_nd);
                    ps.setLong(2, bean.ui_id);
                    ps.setString(3, bean.ui_nd);
                    ps.setInt(4, bean.ue_type);
                    ps.setString(5, bean.ue_name);
                    ps.setInt(6, bean.ue_money);
                    ps.setInt(7, bean.rest_money);
                    ps.setTimestamp(8, new Timestamp(bean.ctime.getTime()));
                    ps.setString(9, bean.note);
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
            sql = "SELECT ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note FROM "+TABLENAME2+" ORDER BY ue_id";
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
            sql = "SELECT ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note FROM "+TABLENAME2+" ORDER BY ue_id DESC LIMIT "+num+"" ;
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
            sql="SELECT ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note FROM "+TABLENAME2+" WHERE ue_id>:ue_id";
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
            sql="SELECT ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note FROM "+TABLENAME2+" WHERE ue_id=:ue_id";
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
            sql = "SELECT ue_id,ue_nd,ui_id,ui_nd,ue_type,ue_name,ue_money,rest_money,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
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
            sql = "UPDATE "+TABLENAME2+" SET ue_nd=:ue_nd,ui_id=:ui_id,ui_nd=:ui_nd,ue_type=:ue_type,ue_name=:ue_name,ue_money=:ue_money,rest_money=:rest_money,ctime=:ctime,note=:note WHERE ue_id=:ue_id";
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
            sql = "UPDATE "+TABLENAME2+" SET ue_nd=?,ui_id=?,ui_nd=?,ue_type=?,ue_name=?,ue_money=?,rest_money=?,ctime=?,note=? WHERE ue_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_exchange bean = beans.get(i);
                    ps.setString(1, bean.ue_nd);
                    ps.setLong(2, bean.ui_id);
                    ps.setString(3, bean.ui_nd);
                    ps.setInt(4, bean.ue_type);
                    ps.setString(5, bean.ue_name);
                    ps.setInt(6, bean.ue_money);
                    ps.setInt(7, bean.rest_money);
                    ps.setTimestamp(8, new Timestamp(bean.ctime.getTime()));
                    ps.setString(9, bean.note);
                    ps.setLong(10, bean.ue_id);
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
                 "	`ue_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ue_nd`  VARCHAR(80) COMMENT '//varchar(80)    兑换提现表ND'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户主键ID'," +
                 "	`ui_nd`  VARCHAR(80) COMMENT '//varchar(80)    用户ND'," +
                 "	`ue_type`  INT(11) COMMENT '//int(11)    类型（0:提现1:电话充值2:充值Q币）'," +
                 "	`ue_name`  VARCHAR(80) COMMENT '//varchar(80)    兑换或者提现名称'," +
                 "	`ue_money`  INT(11) COMMENT '//int(11)    兑换或者提现金额（单位分）'," +
                 "	`rest_money`  INT(11) COMMENT '//int(11)    兑换后剩余金额(单位分)'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
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
