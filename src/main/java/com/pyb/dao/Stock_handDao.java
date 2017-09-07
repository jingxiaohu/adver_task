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

//stock_hand

@Repository("stock_handDao")
public class Stock_handDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Stock_handDao.class);



    private  String TABLE = "stock_hand";

    private  String TABLENAME = "stock_hand";

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


    private  String[] carrays ={"id","s_name","s_code","s_price","s_time","s_type","s_hand","ctime","md5_str","note"};
    private  String coulmns ="id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note";
    private  String coulmns2 ="s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note";

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
    public int insert(Stock_hand bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Stock_hand bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note) VALUES (:s_name,:s_code,:s_price,:s_time,:s_type,:s_hand,:ctime,:md5_str,:note)";
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
    public int insert_primarykey(Stock_hand bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Stock_hand bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note) VALUES (:id,:s_name,:s_code,:s_price,:s_time,:s_type,:s_hand,:ctime,:md5_str,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Stock_hand> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Stock_hand> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note) VALUES (?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Stock_hand bean = beans.get(i);
                    ps.setString(1, bean.s_name);
                    ps.setString(2, bean.s_code);
                    ps.setString(3, bean.s_price);
                    ps.setString(4, bean.s_time);
                    ps.setString(5, bean.s_type);
                    ps.setInt(6, bean.s_hand);
                    ps.setTimestamp(7, new Timestamp(bean.ctime.getTime()));
                    ps.setString(8, bean.md5_str);
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
    public List<Stock_hand> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Stock_hand> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note FROM "+TABLENAME2+" ORDER BY id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Stock_hand>(Stock_hand.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Stock_hand>();
        }
    }

    //查询最新数据
    public List<Stock_hand> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Stock_hand> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note FROM "+TABLENAME2+" ORDER BY id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Stock_hand>(Stock_hand.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Stock_hand>();
        }
    }

    //根据主键查询
    public List<Stock_hand> selectGtKey(long id) {
        return selectGtKey(id, TABLENAME);
    }

    //根据主键查询
    public List<Stock_hand> selectGtKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note FROM "+TABLENAME2+" WHERE id>:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Stock_hand>(Stock_hand.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Stock_hand>();
        }
    }

    //根据主键查询
    public Stock_hand selectByKey(long id) {
        return selectByKey(id, TABLENAME);
    }

    //根据主键查询
    public Stock_hand selectByKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note FROM "+TABLENAME2+" WHERE id=:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            List<Stock_hand> list =  _np.query(sql, param, new BeanPropertyRowMapper<Stock_hand>(Stock_hand.class));
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
    public List<Stock_hand> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Stock_hand> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT id,s_name,s_code,s_price,s_time,s_type,s_hand,ctime,md5_str,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Stock_hand>(Stock_hand.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Stock_hand>();
        }
    }

    //修改数据
    public int updateByKey(Stock_hand bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Stock_hand bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET s_name=:s_name,s_code=:s_code,s_price=:s_price,s_time=:s_time,s_type=:s_type,s_hand=:s_hand,ctime=:ctime,md5_str=:md5_str,note=:note WHERE id=:id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Stock_hand> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Stock_hand> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET s_name=?,s_code=?,s_price=?,s_time=?,s_type=?,s_hand=?,ctime=?,md5_str=?,note=? WHERE id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Stock_hand bean = beans.get(i);
                    ps.setString(1, bean.s_name);
                    ps.setString(2, bean.s_code);
                    ps.setString(3, bean.s_price);
                    ps.setString(4, bean.s_time);
                    ps.setString(5, bean.s_type);
                    ps.setInt(6, bean.s_hand);
                    ps.setTimestamp(7, new Timestamp(bean.ctime.getTime()));
                    ps.setString(8, bean.md5_str);
                    ps.setString(9, bean.note);
                    ps.setLong(10, bean.id);
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
                 "	`id`  BIGINT UNSIGNED(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20) unsigned    '," +
                 "	`s_name`  VARCHAR(150) COMMENT '//varchar(150)    名称'," +
                 "	`s_code`  VARCHAR(100) COMMENT '//varchar(100)    代码'," +
                 "	`s_price`  VARCHAR(100) COMMENT '//varchar(100)    当时价格'," +
                 "	`s_time`  VARCHAR(100) COMMENT '//varchar(100)    当时时间'," +
                 "	`s_type`  TINYTEXT COMMENT '//varchar(255)    类型（buy:买sell:卖）'," +
                 "	`s_hand`  INT(11) COMMENT '//int(11)    手数'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`md5_str`  VARCHAR(100) COMMENT '//varchar(100)    对内容进行MD5进行签名'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
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
