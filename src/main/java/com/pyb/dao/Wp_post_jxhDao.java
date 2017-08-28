package com.pyb.dao;

import com.highbeauty.text.EasyTemplate;
import com.pyb.bean.Wp_post_jxh;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//wp_post_jxh

@Repository("wp_post_jxhDao")
public class Wp_post_jxhDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wp_post_jxhDao.class);



    private  String TABLE = "wp_post_jxh";

    private  String TABLENAME = "wp_post_jxh";

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


    private  String[] carrays ={"id","post_id","category_id","category_code","url","title","date_time","url_status","content","father_url","note"};
    private  String coulmns ="id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note";
    private  String coulmns2 ="post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note";

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
    public int insert(Wp_post_jxh bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wp_post_jxh bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note) VALUES (:post_id,:category_id,:category_code,:url,:title,:date_time,:url_status,:content,:father_url,:note)";
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
    public int insert_primarykey(Wp_post_jxh bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wp_post_jxh bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note) VALUES (:id,:post_id,:category_id,:category_code,:url,:title,:date_time,:url_status,:content,:father_url,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wp_post_jxh> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wp_post_jxh> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note) VALUES (?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_post_jxh bean = beans.get(i);
                    ps.setLong(1, bean.post_id);
                    ps.setLong(2, bean.category_id);
                    ps.setString(3, bean.category_code);
                    ps.setString(4, bean.url);
                    ps.setString(5, bean.title);
                    ps.setTimestamp(6, new Timestamp(bean.date_time.getTime()));
                    ps.setInt(7, bean.url_status);
                    ps.setString(8, bean.content);
                    ps.setString(9, bean.father_url);
                    ps.setString(10, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wp_post_jxh> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wp_post_jxh> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note FROM "+TABLENAME2+" ORDER BY id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_post_jxh>(Wp_post_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wp_post_jxh>();
        }
    }

    //查询最新数据
    public List<Wp_post_jxh> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wp_post_jxh> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note FROM "+TABLENAME2+" ORDER BY id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_post_jxh>(Wp_post_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wp_post_jxh>();
        }
    }

    //根据主键查询
    public List<Wp_post_jxh> selectGtKey(long id) {
        return selectGtKey(id, TABLENAME);
    }

    //根据主键查询
    public List<Wp_post_jxh> selectGtKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note FROM "+TABLENAME2+" WHERE id>:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wp_post_jxh>(Wp_post_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wp_post_jxh>();
        }
    }

    //根据主键查询
    public Wp_post_jxh selectByKey(long id) {
        return selectByKey(id, TABLENAME);
    }

    //根据主键查询
    public Wp_post_jxh selectByKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note FROM "+TABLENAME2+" WHERE id=:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            List<Wp_post_jxh> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wp_post_jxh>(Wp_post_jxh.class));
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
    public List<Wp_post_jxh> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wp_post_jxh> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT id,post_id,category_id,category_code,url,title,date_time,url_status,content,father_url,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wp_post_jxh>(Wp_post_jxh.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wp_post_jxh>();
        }
    }

    //修改数据
    public int updateByKey(Wp_post_jxh bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wp_post_jxh bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET post_id=:post_id,category_id=:category_id,category_code=:category_code,url=:url,title=:title,date_time=:date_time,url_status=:url_status,content=:content,father_url=:father_url,note=:note WHERE id=:id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_post_jxh> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_post_jxh> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET post_id=?,category_id=?,category_code=?,url=?,title=?,date_time=?,url_status=?,content=?,father_url=?,note=? WHERE id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_post_jxh bean = beans.get(i);
                    ps.setLong(1, bean.post_id);
                    ps.setLong(2, bean.category_id);
                    ps.setString(3, bean.category_code);
                    ps.setString(4, bean.url);
                    ps.setString(5, bean.title);
                    ps.setTimestamp(6, new Timestamp(bean.date_time.getTime()));
                    ps.setInt(7, bean.url_status);
                    ps.setString(8, bean.content);
                    ps.setString(9, bean.father_url);
                    ps.setString(10, bean.note);
                    ps.setLong(11, bean.id);
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
                 "	`id`  BIGINT UNSIGNED(11) NOT NULL AUTO_INCREMENT COMMENT '//bigint(11) unsigned    '," +
                 "	`post_id`  BIGINT UNSIGNED(11) NOT NULL COMMENT '//bigint(11) unsigned    '," +
                 "	`category_id`  BIGINT UNSIGNED(11) NOT NULL COMMENT '//bigint(11) unsigned    '," +
                 "	`category_code`  VARCHAR(60) COMMENT '//varchar(60)    分类英文代码'," +
                 "	`url`  TINYTEXT NOT NULL COMMENT '//varchar(1000)    '," +
                 "	`title`  TINYTEXT COMMENT '//varchar(255)    标题'," +
                 "	`date_time`  DATETIME NOT NULL COMMENT '//datetime    时间'," +
                 "	`url_status`  INT(11) NOT NULL COMMENT '//int(11)    发布状态0：还没有发布1：已经发布2：删除'," +
                 "	`content`  LONGTEXT COMMENT '//longtext    内容'," +
                 "	`father_url`  TINYTEXT COMMENT '//varchar(1000)    上级的URL'," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    备注'," +
                 "	PRIMARY KEY (`id`)," +
                 "	UNIQUE KEY `title` (`title`)," +
                 "	UNIQUE KEY `url` (`url`)" +
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
