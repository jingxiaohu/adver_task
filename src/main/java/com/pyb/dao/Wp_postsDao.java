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

//wp_posts

@Repository("wp_postsDao")
public class Wp_postsDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wp_postsDao.class);



    private  String TABLE = "wp_posts";

    private  String TABLENAME = "wp_posts";

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


    private  String[] carrays ={"ID","post_author","post_date","post_date_gmt","post_content","post_title","post_excerpt","post_status","comment_status","ping_status","post_password","post_name","to_ping","pinged","post_modified","post_modified_gmt","post_content_filtered","post_parent","guid","menu_order","post_type","post_mime_type","comment_count"};
    private  String coulmns ="ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count";
    private  String coulmns2 ="post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count";

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
    public int insert(Wp_posts bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wp_posts bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count) VALUES (:post_author,:post_date,:post_date_gmt,:post_content,:post_title,:post_excerpt,:post_status,:comment_status,:ping_status,:post_password,:post_name,:to_ping,:pinged,:post_modified,:post_modified_gmt,:post_content_filtered,:post_parent,:guid,:menu_order,:post_type,:post_mime_type,:comment_count)";
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
    public int insert_primarykey(Wp_posts bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wp_posts bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count) VALUES (:ID,:post_author,:post_date,:post_date_gmt,:post_content,:post_title,:post_excerpt,:post_status,:comment_status,:ping_status,:post_password,:post_name,:to_ping,:pinged,:post_modified,:post_modified_gmt,:post_content_filtered,:post_parent,:guid,:menu_order,:post_type,:post_mime_type,:comment_count)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wp_posts> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wp_posts> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_posts bean = beans.get(i);
                    ps.setLong(1, bean.post_author);
                    ps.setTimestamp(2, new Timestamp(bean.post_date.getTime()));
                    ps.setTimestamp(3, new Timestamp(bean.post_date_gmt.getTime()));
                    ps.setString(4, bean.post_content);
                    ps.setString(5, bean.post_title);
                    ps.setString(6, bean.post_excerpt);
                    ps.setString(7, bean.post_status);
                    ps.setString(8, bean.comment_status);
                    ps.setString(9, bean.ping_status);
                    ps.setString(10, bean.post_password);
                    ps.setString(11, bean.post_name);
                    ps.setString(12, bean.to_ping);
                    ps.setString(13, bean.pinged);
                    ps.setTimestamp(14, new Timestamp(bean.post_modified.getTime()));
                    ps.setTimestamp(15, new Timestamp(bean.post_modified_gmt.getTime()));
                    ps.setString(16, bean.post_content_filtered);
                    ps.setLong(17, bean.post_parent);
                    ps.setString(18, bean.guid);
                    ps.setInt(19, bean.menu_order);
                    ps.setString(20, bean.post_type);
                    ps.setString(21, bean.post_mime_type);
                    ps.setLong(22, bean.comment_count);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wp_posts> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wp_posts> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count FROM "+TABLENAME2+" ORDER BY ID";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_posts>(Wp_posts.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wp_posts>();
        }
    }

    //查询最新数据
    public List<Wp_posts> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wp_posts> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count FROM "+TABLENAME2+" ORDER BY ID DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wp_posts>(Wp_posts.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wp_posts>();
        }
    }

    //根据主键查询
    public List<Wp_posts> selectGtKey(long ID) {
        return selectGtKey(ID, TABLENAME);
    }

    //根据主键查询
    public List<Wp_posts> selectGtKey(long ID, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count FROM "+TABLENAME2+" WHERE ID>:ID";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ID", ID);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wp_posts>(Wp_posts.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wp_posts>();
        }
    }

    //根据主键查询
    public Wp_posts selectByKey(long ID) {
        return selectByKey(ID, TABLENAME);
    }

    //根据主键查询
    public Wp_posts selectByKey(long ID, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count FROM "+TABLENAME2+" WHERE ID=:ID";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ID", ID);
            List<Wp_posts> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wp_posts>(Wp_posts.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ID="+ID,e);
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
    public List<Wp_posts> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wp_posts> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ID,post_author,post_date,post_date_gmt,post_content,post_title,post_excerpt,post_status,comment_status,ping_status,post_password,post_name,to_ping,pinged,post_modified,post_modified_gmt,post_content_filtered,post_parent,guid,menu_order,post_type,post_mime_type,comment_count FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wp_posts>(Wp_posts.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wp_posts>();
        }
    }

    //修改数据
    public int updateByKey(Wp_posts bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wp_posts bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET post_author=:post_author,post_date=:post_date,post_date_gmt=:post_date_gmt,post_content=:post_content,post_title=:post_title,post_excerpt=:post_excerpt,post_status=:post_status,comment_status=:comment_status,ping_status=:ping_status,post_password=:post_password,post_name=:post_name,to_ping=:to_ping,pinged=:pinged,post_modified=:post_modified,post_modified_gmt=:post_modified_gmt,post_content_filtered=:post_content_filtered,post_parent=:post_parent,guid=:guid,menu_order=:menu_order,post_type=:post_type,post_mime_type=:post_mime_type,comment_count=:comment_count WHERE ID=:ID";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_posts> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wp_posts> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET post_author=?,post_date=?,post_date_gmt=?,post_content=?,post_title=?,post_excerpt=?,post_status=?,comment_status=?,ping_status=?,post_password=?,post_name=?,to_ping=?,pinged=?,post_modified=?,post_modified_gmt=?,post_content_filtered=?,post_parent=?,guid=?,menu_order=?,post_type=?,post_mime_type=?,comment_count=? WHERE ID=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wp_posts bean = beans.get(i);
                    ps.setLong(1, bean.post_author);
                    ps.setTimestamp(2, new Timestamp(bean.post_date.getTime()));
                    ps.setTimestamp(3, new Timestamp(bean.post_date_gmt.getTime()));
                    ps.setString(4, bean.post_content);
                    ps.setString(5, bean.post_title);
                    ps.setString(6, bean.post_excerpt);
                    ps.setString(7, bean.post_status);
                    ps.setString(8, bean.comment_status);
                    ps.setString(9, bean.ping_status);
                    ps.setString(10, bean.post_password);
                    ps.setString(11, bean.post_name);
                    ps.setString(12, bean.to_ping);
                    ps.setString(13, bean.pinged);
                    ps.setTimestamp(14, new Timestamp(bean.post_modified.getTime()));
                    ps.setTimestamp(15, new Timestamp(bean.post_modified_gmt.getTime()));
                    ps.setString(16, bean.post_content_filtered);
                    ps.setLong(17, bean.post_parent);
                    ps.setString(18, bean.guid);
                    ps.setInt(19, bean.menu_order);
                    ps.setString(20, bean.post_type);
                    ps.setString(21, bean.post_mime_type);
                    ps.setLong(22, bean.comment_count);
                    ps.setLong(23, bean.ID);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ID) throws SQLException{
        return deleteByKey(ID, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ID, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ID=:ID";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ID", ID);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ID=?";
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
                 "	`ID`  BIGINT UNSIGNED(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20) unsigned    '," +
                 "	`post_author`  BIGINT UNSIGNED(20) NOT NULL COMMENT '//bigint(20) unsigned    '," +
                 "	`post_date`  DATETIME NOT NULL COMMENT '//datetime    '," +
                 "	`post_date_gmt`  DATETIME NOT NULL COMMENT '//datetime    '," +
                 "	`post_content`  MEDIUMTEXT NOT NULL COMMENT '//longtext    '," +
                 "	`post_title`  TINYTEXT NOT NULL COMMENT '//text    '," +
                 "	`post_excerpt`  TINYTEXT NOT NULL COMMENT '//text    '," +
                 "	`post_status`  VARCHAR(20) NOT NULL COMMENT '//varchar(20)    '," +
                 "	`comment_status`  VARCHAR(20) NOT NULL COMMENT '//varchar(20)    '," +
                 "	`ping_status`  VARCHAR(20) NOT NULL COMMENT '//varchar(20)    '," +
                 "	`post_password`  TINYTEXT NOT NULL COMMENT '//varchar(255)    '," +
                 "	`post_name`  VARCHAR(200) NOT NULL COMMENT '//varchar(200)    '," +
                 "	`to_ping`  TINYTEXT NOT NULL COMMENT '//text    '," +
                 "	`pinged`  TINYTEXT NOT NULL COMMENT '//text    '," +
                 "	`post_modified`  DATETIME NOT NULL COMMENT '//datetime    '," +
                 "	`post_modified_gmt`  DATETIME NOT NULL COMMENT '//datetime    '," +
                 "	`post_content_filtered`  MEDIUMTEXT NOT NULL COMMENT '//longtext    '," +
                 "	`post_parent`  BIGINT UNSIGNED(20) NOT NULL COMMENT '//bigint(20) unsigned    '," +
                 "	`guid`  TINYTEXT NOT NULL COMMENT '//varchar(255)    '," +
                 "	`menu_order`  INT(11) NOT NULL COMMENT '//int(11)    '," +
                 "	`post_type`  VARCHAR(20) NOT NULL COMMENT '//varchar(20)    '," +
                 "	`post_mime_type`  VARCHAR(100) NOT NULL COMMENT '//varchar(100)    '," +
                 "	`comment_count`  BIGINT(20) NOT NULL COMMENT '//bigint(20)    '," +
                 "	PRIMARY KEY (`ID`)," +
                 "	KEY `post_author` (`post_author`)," +
                 "	KEY `post_name` (`post_name`)," +
                 "	KEY `post_parent` (`post_parent`)," +
                 "	KEY `type_status_date` (`post_type`)," +
                 "	KEY `type_status_date` (`post_status`)," +
                 "	KEY `type_status_date` (`post_date`)," +
                 "	KEY `type_status_date` (`ID`)" +
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
