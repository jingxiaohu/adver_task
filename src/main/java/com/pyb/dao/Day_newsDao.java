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

//day_news

@Repository("day_newsDao")
public class Day_newsDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Day_newsDao.class);



    private  String TABLE = "day_news";

    private  String TABLENAME = "day_news";

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


    private  String[] carrays ={"dn_id","title","content_or_url","bk_type","is_show","ctime","read_count","bk_zan","bk_sort","note","source_name","md5","type"};
    private  String coulmns ="dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type";
    private  String coulmns2 ="title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type";

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
    public int insert(Day_news bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Day_news bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type) VALUES (:title,:content_or_url,:bk_type,:is_show,:ctime,:read_count,:bk_zan,:bk_sort,:note,:source_name,:md5,:type)";
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
    public int insert_primarykey(Day_news bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Day_news bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type) VALUES (:dn_id,:title,:content_or_url,:bk_type,:is_show,:ctime,:read_count,:bk_zan,:bk_sort,:note,:source_name,:md5,:type)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Day_news> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Day_news> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Day_news bean = beans.get(i);
                    ps.setString(1, bean.title);
                    ps.setString(2, bean.content_or_url);
                    ps.setInt(3, bean.bk_type);
                    ps.setInt(4, bean.is_show);
                    ps.setTimestamp(5, new Timestamp(bean.ctime.getTime()));
                    ps.setLong(6, bean.read_count);
                    ps.setLong(7, bean.bk_zan);
                    ps.setLong(8, bean.bk_sort);
                    ps.setString(9, bean.note);
                    ps.setString(10, bean.source_name);
                    ps.setString(11, bean.md5);
                    ps.setInt(12, bean.type);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Day_news> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Day_news> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type FROM "+TABLENAME2+" ORDER BY dn_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Day_news>(Day_news.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Day_news>();
        }
    }

    //查询最新数据
    public List<Day_news> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Day_news> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type FROM "+TABLENAME2+" ORDER BY dn_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Day_news>(Day_news.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Day_news>();
        }
    }

    //根据主键查询
    public List<Day_news> selectGtKey(long dn_id) {
        return selectGtKey(dn_id, TABLENAME);
    }

    //根据主键查询
    public List<Day_news> selectGtKey(long dn_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type FROM "+TABLENAME2+" WHERE dn_id>:dn_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("dn_id", dn_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Day_news>(Day_news.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Day_news>();
        }
    }

    //根据主键查询
    public Day_news selectByKey(long dn_id) {
        return selectByKey(dn_id, TABLENAME);
    }

    //根据主键查询
    public Day_news selectByKey(long dn_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type FROM "+TABLENAME2+" WHERE dn_id=:dn_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("dn_id", dn_id);
            List<Day_news> list =  _np.query(sql, param, new BeanPropertyRowMapper<Day_news>(Day_news.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey dn_id="+dn_id,e);
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
    public List<Day_news> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Day_news> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT dn_id,title,content_or_url,bk_type,is_show,ctime,read_count,bk_zan,bk_sort,note,source_name,md5,type FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Day_news>(Day_news.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Day_news>();
        }
    }

    //修改数据
    public int updateByKey(Day_news bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Day_news bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET title=:title,content_or_url=:content_or_url,bk_type=:bk_type,is_show=:is_show,ctime=:ctime,read_count=:read_count,bk_zan=:bk_zan,bk_sort=:bk_sort,note=:note,source_name=:source_name,md5=:md5,type=:type WHERE dn_id=:dn_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Day_news> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Day_news> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET title=?,content_or_url=?,bk_type=?,is_show=?,ctime=?,read_count=?,bk_zan=?,bk_sort=?,note=?,source_name=?,md5=?,type=? WHERE dn_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Day_news bean = beans.get(i);
                    ps.setString(1, bean.title);
                    ps.setString(2, bean.content_or_url);
                    ps.setInt(3, bean.bk_type);
                    ps.setInt(4, bean.is_show);
                    ps.setTimestamp(5, new Timestamp(bean.ctime.getTime()));
                    ps.setLong(6, bean.read_count);
                    ps.setLong(7, bean.bk_zan);
                    ps.setLong(8, bean.bk_sort);
                    ps.setString(9, bean.note);
                    ps.setString(10, bean.source_name);
                    ps.setString(11, bean.md5);
                    ps.setInt(12, bean.type);
                    ps.setLong(13, bean.dn_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long dn_id) throws SQLException{
        return deleteByKey(dn_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long dn_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE dn_id=:dn_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("dn_id", dn_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE dn_id=?";
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
                 "	`dn_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`title`  TINYTEXT COMMENT '//varchar(255)    标题'," +
                 "	`content_or_url`  TEXT COMMENT '//text    内容或者URL'," +
                 "	`bk_type`  INT(11) COMMENT '//int(11)    类型（0：自己写的内容1：页面）'," +
                 "	`is_show`  INT(11) COMMENT '//int(11)    是否显示（0：显示1：不显示）'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`read_count`  BIGINT(20) COMMENT '//bigint(20)    浏览次数'," +
                 "	`bk_zan`  BIGINT(20) COMMENT '//bigint(20)    点赞次数'," +
                 "	`bk_sort`  BIGINT(20) COMMENT '//bigint(20)    权重比'," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    备注.'," +
                 "	`source_name`  VARCHAR(200) COMMENT '//varchar(200)    来源名称'," +
                 "	`md5`  VARCHAR(100) COMMENT '//varchar(100)    md5'," +
                 "	`type`  INT(11) COMMENT '//int(11)    所属板块类型(例如：个股评级)0:看盘消息1：个股评级2：机构解析3：板块解析4：市场研究5：行业研究6：数据资金'," +
                 "	PRIMARY KEY (`dn_id`)" +
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
