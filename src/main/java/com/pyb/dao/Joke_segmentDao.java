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

//joke_segment

@Repository("joke_segmentDao")
public class Joke_segmentDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Joke_segmentDao.class);



    private  String TABLE = "joke_segment";

    private  String TABLENAME = "joke_segment";

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


    private  String[] carrays ={"js_id","jc_id","content","is_show","title","js_type","is_title","is_spider","ctime","js_zan","read_count","note"};
    private  String coulmns ="js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note";
    private  String coulmns2 ="jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note";

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
    public int insert(Joke_segment bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Joke_segment bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note) VALUES (:jc_id,:content,:is_show,:title,:js_type,:is_title,:is_spider,:ctime,:js_zan,:read_count,:note)";
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
    public int insert_primarykey(Joke_segment bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Joke_segment bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note) VALUES (:js_id,:jc_id,:content,:is_show,:title,:js_type,:is_title,:is_spider,:ctime,:js_zan,:read_count,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Joke_segment> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Joke_segment> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Joke_segment bean = beans.get(i);
                    ps.setLong(1, bean.jc_id);
                    ps.setString(2, bean.content);
                    ps.setInt(3, bean.is_show);
                    ps.setString(4, bean.title);
                    ps.setInt(5, bean.js_type);
                    ps.setInt(6, bean.is_title);
                    ps.setInt(7, bean.is_spider);
                    ps.setTimestamp(8, new Timestamp(bean.ctime.getTime()));
                    ps.setLong(9, bean.js_zan);
                    ps.setLong(10, bean.read_count);
                    ps.setString(11, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Joke_segment> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Joke_segment> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note FROM "+TABLENAME2+" ORDER BY js_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Joke_segment>(Joke_segment.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Joke_segment>();
        }
    }

    //查询最新数据
    public List<Joke_segment> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Joke_segment> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note FROM "+TABLENAME2+" ORDER BY js_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Joke_segment>(Joke_segment.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Joke_segment>();
        }
    }

    //根据主键查询
    public List<Joke_segment> selectGtKey(long js_id) {
        return selectGtKey(js_id, TABLENAME);
    }

    //根据主键查询
    public List<Joke_segment> selectGtKey(long js_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note FROM "+TABLENAME2+" WHERE js_id>:js_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("js_id", js_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Joke_segment>(Joke_segment.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Joke_segment>();
        }
    }

    //根据主键查询
    public Joke_segment selectByKey(long js_id) {
        return selectByKey(js_id, TABLENAME);
    }

    //根据主键查询
    public Joke_segment selectByKey(long js_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note FROM "+TABLENAME2+" WHERE js_id=:js_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("js_id", js_id);
            List<Joke_segment> list =  _np.query(sql, param, new BeanPropertyRowMapper<Joke_segment>(Joke_segment.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey js_id="+js_id,e);
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
    public List<Joke_segment> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Joke_segment> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT js_id,jc_id,content,is_show,title,js_type,is_title,is_spider,ctime,js_zan,read_count,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Joke_segment>(Joke_segment.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Joke_segment>();
        }
    }

    //修改数据
    public int updateByKey(Joke_segment bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Joke_segment bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET jc_id=:jc_id,content=:content,is_show=:is_show,title=:title,js_type=:js_type,is_title=:is_title,is_spider=:is_spider,ctime=:ctime,js_zan=:js_zan,read_count=:read_count,note=:note WHERE js_id=:js_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Joke_segment> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Joke_segment> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET jc_id=?,content=?,is_show=?,title=?,js_type=?,is_title=?,is_spider=?,ctime=?,js_zan=?,read_count=?,note=? WHERE js_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Joke_segment bean = beans.get(i);
                    ps.setLong(1, bean.jc_id);
                    ps.setString(2, bean.content);
                    ps.setInt(3, bean.is_show);
                    ps.setString(4, bean.title);
                    ps.setInt(5, bean.js_type);
                    ps.setInt(6, bean.is_title);
                    ps.setInt(7, bean.is_spider);
                    ps.setTimestamp(8, new Timestamp(bean.ctime.getTime()));
                    ps.setLong(9, bean.js_zan);
                    ps.setLong(10, bean.read_count);
                    ps.setString(11, bean.note);
                    ps.setLong(12, bean.js_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long js_id) throws SQLException{
        return deleteByKey(js_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long js_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE js_id=:js_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("js_id", js_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE js_id=?";
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
                 "	`js_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`jc_id`  BIGINT(20) COMMENT '//bigint(20)    笑话分类ID'," +
                 "	`content`  TEXT COMMENT '//text    段子内容'," +
                 "	`is_show`  INT(11) COMMENT '//int(11)    是否显示(0:显示1：不显示)'," +
                 "	`title`  TINYTEXT COMMENT '//varchar(255)    段子标题'," +
                 "	`js_type`  INT(11) COMMENT '//int(11)    段子类型(0:爆笑男女1:冷笑话)'," +
                 "	`is_title`  INT(11) COMMENT '//int(11)    是否有标题(0:没有1：有)'," +
                 "	`is_spider`  INT(11) COMMENT '//int(11)    是否是抓取的段子(0:抓取1：自己添加)'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`js_zan`  BIGINT(20) COMMENT '//bigint(20)    点赞数'," +
                 "	`read_count`  BIGINT(20) COMMENT '//bigint(20)    浏览次数'," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    备注'," +
                 "	PRIMARY KEY (`js_id`)" +
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
