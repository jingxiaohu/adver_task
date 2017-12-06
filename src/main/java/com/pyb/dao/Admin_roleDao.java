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

//admin_role

@Repository("admin_roleDao")
public class Admin_roleDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Admin_roleDao.class);



    private  String TABLE = "admin_role";

    private  String TABLENAME = "admin_role";

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


    private  String[] carrays ={"ar_id","ri_id","au_id"};
    private  String coulmns ="ar_id,ri_id,au_id";
    private  String coulmns2 ="ri_id,au_id";

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
    public int insert(Admin_role bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Admin_role bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ri_id,au_id) VALUES (:ri_id,:au_id)";
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
    public int insert_primarykey(Admin_role bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Admin_role bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ar_id,ri_id,au_id) VALUES (:ar_id,:ri_id,:au_id)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Admin_role> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Admin_role> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ri_id,au_id) VALUES (?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Admin_role bean = beans.get(i);
                    ps.setLong(1, bean.ri_id);
                    ps.setLong(2, bean.au_id);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Admin_role> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Admin_role> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ar_id,ri_id,au_id FROM "+TABLENAME2+" ORDER BY ar_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Admin_role>(Admin_role.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Admin_role>();
        }
    }

    //查询最新数据
    public List<Admin_role> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Admin_role> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ar_id,ri_id,au_id FROM "+TABLENAME2+" ORDER BY ar_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Admin_role>(Admin_role.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Admin_role>();
        }
    }

    //根据主键查询
    public List<Admin_role> selectGtKey(long ar_id) {
        return selectGtKey(ar_id, TABLENAME);
    }

    //根据主键查询
    public List<Admin_role> selectGtKey(long ar_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ar_id,ri_id,au_id FROM "+TABLENAME2+" WHERE ar_id>:ar_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ar_id", ar_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Admin_role>(Admin_role.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Admin_role>();
        }
    }

    //根据主键查询
    public Admin_role selectByKey(long ar_id) {
        return selectByKey(ar_id, TABLENAME);
    }

    //根据主键查询
    public Admin_role selectByKey(long ar_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ar_id,ri_id,au_id FROM "+TABLENAME2+" WHERE ar_id=:ar_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ar_id", ar_id);
            List<Admin_role> list =  _np.query(sql, param, new BeanPropertyRowMapper<Admin_role>(Admin_role.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ar_id="+ar_id,e);
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
    public List<Admin_role> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Admin_role> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ar_id,ri_id,au_id FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Admin_role>(Admin_role.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Admin_role>();
        }
    }

    //修改数据
    public int updateByKey(Admin_role bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Admin_role bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ri_id=:ri_id,au_id=:au_id WHERE ar_id=:ar_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Admin_role> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Admin_role> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ri_id=?,au_id=? WHERE ar_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Admin_role bean = beans.get(i);
                    ps.setLong(1, bean.ri_id);
                    ps.setLong(2, bean.au_id);
                    ps.setLong(3, bean.ar_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ar_id) throws SQLException{
        return deleteByKey(ar_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ar_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ar_id=:ar_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ar_id", ar_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ar_id=?";
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
                 "	`ar_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`ri_id`  BIGINT(20) COMMENT '//bigint(20)    '," +
                 "	`au_id`  BIGINT(20) COMMENT '//bigint(20)    '," +
                 "	PRIMARY KEY (`ar_id`)," +
                 "	KEY `search_${TABLENAME}_index` (`ri_id`)," +
                 "	KEY `search_${TABLENAME}_index` (`au_id`)" +
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
