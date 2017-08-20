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

//wp_term_taxonomy

@Repository("wp_term_taxonomyDao")
public class Wp_term_taxonomyDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wp_term_taxonomyDao.class);



    private  String TABLE = "wp_term_taxonomy";

    private  String TABLENAME = "wp_term_taxonomy";

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


    private  String[] carrays ={"term_taxonomy_id","term_id","taxonomy","description","parent","count"};
    private  String coulmns ="term_taxonomy_id,term_id,taxonomy,description,parent,count";
    private  String coulmns2 ="term_id,taxonomy,description,parent,count";

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
    public int insert(Wp_term_taxonomy bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wp_term_taxonomy bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (term_id,taxonomy,description,parent,count) VALUES (:term_id,:taxonomy,:description,:parent,:count)";
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
    public int insert_primarykey(Wp_term_taxonomy bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wp_term_taxonomy bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (term_taxonomy_id,term_id,taxonomy,description,parent,count) VALUES (:term_taxonomy_id,:term_id,:taxonomy,:description,:parent,:count)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wp_term_taxonomy> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wp_term_taxonomy> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (term_id,taxonomy,description,parent,count) VALUES (?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_term_taxonomy bean = beans.get(i);
                    ps.setLong(1, bean.term_id);
                    ps.setString(2, bean.taxonomy);
                    ps.setString(3, bean.description);
                    ps.setLong(4, bean.parent);
                    ps.setLong(5, bean.count);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wp_term_taxonomy> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wp_term_taxonomy> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT term_taxonomy_id,term_id,taxonomy,description,parent,count FROM "+TABLENAME2+" ORDER BY term_taxonomy_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_term_taxonomy>(Wp_term_taxonomy.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wp_term_taxonomy>();
        }
    }

    //查询最新数据
    public List<Wp_term_taxonomy> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wp_term_taxonomy> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT term_taxonomy_id,term_id,taxonomy,description,parent,count FROM "+TABLENAME2+" ORDER BY term_taxonomy_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_term_taxonomy>(Wp_term_taxonomy.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wp_term_taxonomy>();
        }
    }

    //根据主键查询
    public List<Wp_term_taxonomy> selectGtKey(long term_taxonomy_id) {
        return selectGtKey(term_taxonomy_id, TABLENAME);
    }

    //根据主键查询
    public List<Wp_term_taxonomy> selectGtKey(long term_taxonomy_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT term_taxonomy_id,term_id,taxonomy,description,parent,count FROM "+TABLENAME2+" WHERE term_taxonomy_id>:term_taxonomy_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("term_taxonomy_id", term_taxonomy_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wp_term_taxonomy>(Wp_term_taxonomy.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wp_term_taxonomy>();
        }
    }

    //根据主键查询
    public Wp_term_taxonomy selectByKey(long term_taxonomy_id) {
        return selectByKey(term_taxonomy_id, TABLENAME);
    }

    //根据主键查询
    public Wp_term_taxonomy selectByKey(long term_taxonomy_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT term_taxonomy_id,term_id,taxonomy,description,parent,count FROM "+TABLENAME2+" WHERE term_taxonomy_id=:term_taxonomy_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("term_taxonomy_id", term_taxonomy_id);
            List<Wp_term_taxonomy> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wp_term_taxonomy>(Wp_term_taxonomy.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey term_taxonomy_id="+term_taxonomy_id,e);
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
    public List<Wp_term_taxonomy> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wp_term_taxonomy> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT term_taxonomy_id,term_id,taxonomy,description,parent,count FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wp_term_taxonomy>(Wp_term_taxonomy.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wp_term_taxonomy>();
        }
    }

    //修改数据
    public int updateByKey(Wp_term_taxonomy bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wp_term_taxonomy bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET term_id=:term_id,taxonomy=:taxonomy,description=:description,parent=:parent,count=:count WHERE term_taxonomy_id=:term_taxonomy_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_term_taxonomy> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_term_taxonomy> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET term_id=?,taxonomy=?,description=?,parent=?,count=? WHERE term_taxonomy_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_term_taxonomy bean = beans.get(i);
                    ps.setLong(1, bean.term_id);
                    ps.setString(2, bean.taxonomy);
                    ps.setString(3, bean.description);
                    ps.setLong(4, bean.parent);
                    ps.setLong(5, bean.count);
                    ps.setLong(6, bean.term_taxonomy_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long term_taxonomy_id) throws SQLException{
        return deleteByKey(term_taxonomy_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long term_taxonomy_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE term_taxonomy_id=:term_taxonomy_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("term_taxonomy_id", term_taxonomy_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE term_taxonomy_id=?";
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
                 "	`term_taxonomy_id`  BIGINT UNSIGNED(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20) unsigned    '," +
                 "	`term_id`  BIGINT UNSIGNED(20) NOT NULL COMMENT '//bigint(20) unsigned    '," +
                 "	`taxonomy`  VARCHAR(32) NOT NULL COMMENT '//varchar(32)    '," +
                 "	`description`  MEDIUMTEXT NOT NULL COMMENT '//longtext    '," +
                 "	`parent`  BIGINT UNSIGNED(20) NOT NULL COMMENT '//bigint(20) unsigned    '," +
                 "	`count`  BIGINT(20) NOT NULL COMMENT '//bigint(20)    '," +
                 "	PRIMARY KEY (`term_taxonomy_id`)," +
                 "	UNIQUE KEY `term_id_taxonomy` (`term_id`)," +
                 "	UNIQUE KEY `term_id_taxonomy` (`taxonomy`)," +
                 "	KEY `taxonomy` (`taxonomy`)" +
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
