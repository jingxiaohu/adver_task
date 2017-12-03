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

//wx_goods_type

@Repository("wx_goods_typeDao")
public class Wx_goods_typeDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_goods_typeDao.class);



    private  String TABLE = "wx_goods_type";

    private  String TABLENAME = "wx_goods_type";

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


    private  String[] carrays ={"gt_id","gt_name","gt_code","ctime","note"};
    private  String coulmns ="gt_id,gt_name,gt_code,ctime,note";
    private  String coulmns2 ="gt_name,gt_code,ctime,note";

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
    public int insert(Wx_goods_type bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_goods_type bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gt_name,gt_code,ctime,note) VALUES (:gt_name,:gt_code,:ctime,:note)";
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
    public int insert_primarykey(Wx_goods_type bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_goods_type bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gt_id,gt_name,gt_code,ctime,note) VALUES (:gt_id,:gt_name,:gt_code,:ctime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_goods_type> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_goods_type> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gt_name,gt_code,ctime,note) VALUES (?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods_type bean = beans.get(i);
                    ps.setString(1, bean.gt_name);
                    ps.setString(2, bean.gt_code);
                    ps.setTimestamp(3, new Timestamp(bean.ctime.getTime()));
                    ps.setString(4, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_goods_type> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods_type> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT gt_id,gt_name,gt_code,ctime,note FROM "+TABLENAME2+" ORDER BY gt_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods_type>(Wx_goods_type.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_goods_type>();
        }
    }

    //查询最新数据
    public List<Wx_goods_type> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods_type> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT gt_id,gt_name,gt_code,ctime,note FROM "+TABLENAME2+" ORDER BY gt_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods_type>(Wx_goods_type.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_goods_type>();
        }
    }

    //根据主键查询
    public List<Wx_goods_type> selectGtKey(long gt_id) {
        return selectGtKey(gt_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_goods_type> selectGtKey(long gt_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT gt_id,gt_name,gt_code,ctime,note FROM "+TABLENAME2+" WHERE gt_id>:gt_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gt_id", gt_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods_type>(Wx_goods_type.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_goods_type>();
        }
    }

    //根据主键查询
    public Wx_goods_type selectByKey(long gt_id) {
        return selectByKey(gt_id, TABLENAME);
    }

    //根据主键查询
    public Wx_goods_type selectByKey(long gt_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT gt_id,gt_name,gt_code,ctime,note FROM "+TABLENAME2+" WHERE gt_id=:gt_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gt_id", gt_id);
            List<Wx_goods_type> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods_type>(Wx_goods_type.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey gt_id="+gt_id,e);
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
    public List<Wx_goods_type> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_goods_type> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT gt_id,gt_name,gt_code,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_goods_type>(Wx_goods_type.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_goods_type>();
        }
    }

    //修改数据
    public int updateByKey(Wx_goods_type bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_goods_type bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET gt_name=:gt_name,gt_code=:gt_code,ctime=:ctime,note=:note WHERE gt_id=:gt_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods_type> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods_type> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET gt_name=?,gt_code=?,ctime=?,note=? WHERE gt_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods_type bean = beans.get(i);
                    ps.setString(1, bean.gt_name);
                    ps.setString(2, bean.gt_code);
                    ps.setTimestamp(3, new Timestamp(bean.ctime.getTime()));
                    ps.setString(4, bean.note);
                    ps.setLong(5, bean.gt_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long gt_id) throws SQLException{
        return deleteByKey(gt_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long gt_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE gt_id=:gt_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gt_id", gt_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE gt_id=?";
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
                 "	`gt_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`gt_name`  VARCHAR(60) COMMENT '//varchar(60)    商品类型名称(例如：农产品)'," +
                 "	`gt_code`  VARCHAR(30) COMMENT '//varchar(30)    商品类型英文'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	PRIMARY KEY (`gt_id`)" +
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
