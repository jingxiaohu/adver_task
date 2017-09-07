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

//stock_info

@Repository("stock_infoDao")
public class Stock_infoDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Stock_infoDao.class);



    private  String TABLE = "stock_info";

    private  String TABLENAME = "stock_info";

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


    private  String[] carrays ={"sid","stock_name","stock_code","stock_type","stock_pinyin","stock_t_price","stock_y_price","ctime","note"};
    private  String coulmns ="sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note";
    private  String coulmns2 ="stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note";

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
    public int insert(Stock_info bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Stock_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note) VALUES (:stock_name,:stock_code,:stock_type,:stock_pinyin,:stock_t_price,:stock_y_price,:ctime,:note)";
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
    public int insert_primarykey(Stock_info bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Stock_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note) VALUES (:sid,:stock_name,:stock_code,:stock_type,:stock_pinyin,:stock_t_price,:stock_y_price,:ctime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Stock_info> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Stock_info> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note) VALUES (?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Stock_info bean = beans.get(i);
                    ps.setString(1, bean.stock_name);
                    ps.setString(2, bean.stock_code);
                    ps.setString(3, bean.stock_type);
                    ps.setString(4, bean.stock_pinyin);
                    ps.setString(5, bean.stock_t_price);
                    ps.setString(6, bean.stock_y_price);
                    ps.setTimestamp(7, new Timestamp(bean.ctime.getTime()));
                    ps.setString(8, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Stock_info> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Stock_info> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note FROM "+TABLENAME2+" ORDER BY sid";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Stock_info>(Stock_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Stock_info>();
        }
    }

    //查询最新数据
    public List<Stock_info> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Stock_info> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note FROM "+TABLENAME2+" ORDER BY sid DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Stock_info>(Stock_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Stock_info>();
        }
    }

    //根据主键查询
    public List<Stock_info> selectGtKey(long sid) {
        return selectGtKey(sid, TABLENAME);
    }

    //根据主键查询
    public List<Stock_info> selectGtKey(long sid, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note FROM "+TABLENAME2+" WHERE sid>:sid";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("sid", sid);
            return _np.query(sql, param, new BeanPropertyRowMapper<Stock_info>(Stock_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Stock_info>();
        }
    }

    //根据主键查询
    public Stock_info selectByKey(long sid) {
        return selectByKey(sid, TABLENAME);
    }

    //根据主键查询
    public Stock_info selectByKey(long sid, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note FROM "+TABLENAME2+" WHERE sid=:sid";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("sid", sid);
            List<Stock_info> list =  _np.query(sql, param, new BeanPropertyRowMapper<Stock_info>(Stock_info.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey sid="+sid,e);
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
    public List<Stock_info> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Stock_info> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT sid,stock_name,stock_code,stock_type,stock_pinyin,stock_t_price,stock_y_price,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Stock_info>(Stock_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Stock_info>();
        }
    }

    //修改数据
    public int updateByKey(Stock_info bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Stock_info bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET stock_name=:stock_name,stock_code=:stock_code,stock_type=:stock_type,stock_pinyin=:stock_pinyin,stock_t_price=:stock_t_price,stock_y_price=:stock_y_price,ctime=:ctime,note=:note WHERE sid=:sid";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Stock_info> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Stock_info> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET stock_name=?,stock_code=?,stock_type=?,stock_pinyin=?,stock_t_price=?,stock_y_price=?,ctime=?,note=? WHERE sid=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Stock_info bean = beans.get(i);
                    ps.setString(1, bean.stock_name);
                    ps.setString(2, bean.stock_code);
                    ps.setString(3, bean.stock_type);
                    ps.setString(4, bean.stock_pinyin);
                    ps.setString(5, bean.stock_t_price);
                    ps.setString(6, bean.stock_y_price);
                    ps.setTimestamp(7, new Timestamp(bean.ctime.getTime()));
                    ps.setString(8, bean.note);
                    ps.setLong(9, bean.sid);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long sid) throws SQLException{
        return deleteByKey(sid, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long sid, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE sid=:sid";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("sid", sid);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE sid=?";
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
                 "	`sid`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`stock_name`  VARCHAR(100) COMMENT '//varchar(100)    '," +
                 "	`stock_code`  VARCHAR(100) COMMENT '//varchar(100)    '," +
                 "	`stock_type`  VARCHAR(30) COMMENT '//varchar(30)    上海：sh深圳：sz'," +
                 "	`stock_pinyin`  VARCHAR(60) COMMENT '//varchar(60)    '," +
                 "	`stock_t_price`  VARCHAR(100) COMMENT '//varchar(100)    最新价'," +
                 "	`stock_y_price`  VARCHAR(100) COMMENT '//varchar(100)    昨天的价格'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    '," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    '," +
                 "	PRIMARY KEY (`sid`)" +
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
