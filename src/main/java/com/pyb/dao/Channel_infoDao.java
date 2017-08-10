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

//channel_info

@Repository("channel_infoDao")
public class Channel_infoDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Channel_infoDao.class);



    private  String TABLE = "channel_info";

    private  String TABLENAME = "channel_info";

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


    private  String[] carrays ={"ci_id","ci_name","ui_id","ctime","is_show","ci_type","ci_sort","note"};
    private  String coulmns ="ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note";
    private  String coulmns2 ="ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note";

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
    public int insert(Channel_info bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Channel_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note) VALUES (:ci_name,:ui_id,:ctime,:is_show,:ci_type,:ci_sort,:note)";
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
    public int insert_primarykey(Channel_info bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Channel_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note) VALUES (:ci_id,:ci_name,:ui_id,:ctime,:is_show,:ci_type,:ci_sort,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Channel_info> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Channel_info> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note) VALUES (?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Channel_info bean = beans.get(i);
                    ps.setString(1, bean.ci_name);
                    ps.setLong(2, bean.ui_id);
                    ps.setTimestamp(3, new Timestamp(bean.ctime.getTime()));
                    ps.setInt(4, bean.is_show);
                    ps.setInt(5, bean.ci_type);
                    ps.setInt(6, bean.ci_sort);
                    ps.setString(7, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Channel_info> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Channel_info> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note FROM "+TABLENAME2+" ORDER BY ci_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Channel_info>(Channel_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Channel_info>();
        }
    }

    //查询最新数据
    public List<Channel_info> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Channel_info> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note FROM "+TABLENAME2+" ORDER BY ci_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Channel_info>(Channel_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Channel_info>();
        }
    }

    //根据主键查询
    public List<Channel_info> selectGtKey(long ci_id) {
        return selectGtKey(ci_id, TABLENAME);
    }

    //根据主键查询
    public List<Channel_info> selectGtKey(long ci_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note FROM "+TABLENAME2+" WHERE ci_id>:ci_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ci_id", ci_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Channel_info>(Channel_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Channel_info>();
        }
    }

    //根据主键查询
    public Channel_info selectByKey(long ci_id) {
        return selectByKey(ci_id, TABLENAME);
    }

    //根据主键查询
    public Channel_info selectByKey(long ci_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note FROM "+TABLENAME2+" WHERE ci_id=:ci_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ci_id", ci_id);
            List<Channel_info> list =  _np.query(sql, param, new BeanPropertyRowMapper<Channel_info>(Channel_info.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ci_id="+ci_id,e);
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
    public List<Channel_info> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Channel_info> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ci_id,ci_name,ui_id,ctime,is_show,ci_type,ci_sort,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Channel_info>(Channel_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Channel_info>();
        }
    }

    //修改数据
    public int updateByKey(Channel_info bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Channel_info bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ci_name=:ci_name,ui_id=:ui_id,ctime=:ctime,is_show=:is_show,ci_type=:ci_type,ci_sort=:ci_sort,note=:note WHERE ci_id=:ci_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Channel_info> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Channel_info> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ci_name=?,ui_id=?,ctime=?,is_show=?,ci_type=?,ci_sort=?,note=? WHERE ci_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Channel_info bean = beans.get(i);
                    ps.setString(1, bean.ci_name);
                    ps.setLong(2, bean.ui_id);
                    ps.setTimestamp(3, new Timestamp(bean.ctime.getTime()));
                    ps.setInt(4, bean.is_show);
                    ps.setInt(5, bean.ci_type);
                    ps.setInt(6, bean.ci_sort);
                    ps.setString(7, bean.note);
                    ps.setLong(8, bean.ci_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ci_id) throws SQLException{
        return deleteByKey(ci_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ci_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ci_id=:ci_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ci_id", ci_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ci_id=?";
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
                 "	`ci_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`ci_name`  VARCHAR(100) COMMENT '//varchar(100)    频道名称'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    创建人用户ID'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`is_show`  INT(11) COMMENT '//int(11)    是否显示0:显示1：不显示'," +
                 "	`ci_type`  INT(11) COMMENT '//int(11)    频道类型:0免费1：收费'," +
                 "	`ci_sort`  INT(11) COMMENT '//int(11)    排序权重比逆序'," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    '," +
                 "	PRIMARY KEY (`ci_id`)" +
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
