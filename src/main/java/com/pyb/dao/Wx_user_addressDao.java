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

//wx_user_address

@Repository("wx_user_addressDao")
public class Wx_user_addressDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_user_addressDao.class);



    private  String TABLE = "wx_user_address";

    private  String TABLENAME = "wx_user_address";

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


    private  String[] carrays ={"ua_id","ui_id","name","telephone","area","address","ctime","note"};
    private  String coulmns ="ua_id,ui_id,name,telephone,area,address,ctime,note";
    private  String coulmns2 ="ui_id,name,telephone,area,address,ctime,note";

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
    public int insert(Wx_user_address bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_user_address bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,name,telephone,area,address,ctime,note) VALUES (:ui_id,:name,:telephone,:area,:address,:ctime,:note)";
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
    public int insert_primarykey(Wx_user_address bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_user_address bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ua_id,ui_id,name,telephone,area,address,ctime,note) VALUES (:ua_id,:ui_id,:name,:telephone,:area,:address,:ctime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_user_address> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_user_address> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,name,telephone,area,address,ctime,note) VALUES (?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_user_address bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.name);
                    ps.setString(3, bean.telephone);
                    ps.setString(4, bean.area);
                    ps.setString(5, bean.address);
                    ps.setTimestamp(6, new Timestamp(bean.ctime.getTime()));
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
    public List<Wx_user_address> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_user_address> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ua_id,ui_id,name,telephone,area,address,ctime,note FROM "+TABLENAME2+" ORDER BY ua_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_user_address>(Wx_user_address.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_user_address>();
        }
    }

    //查询最新数据
    public List<Wx_user_address> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_user_address> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ua_id,ui_id,name,telephone,area,address,ctime,note FROM "+TABLENAME2+" ORDER BY ua_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_user_address>(Wx_user_address.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_user_address>();
        }
    }

    //根据主键查询
    public List<Wx_user_address> selectGtKey(long ua_id) {
        return selectGtKey(ua_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_user_address> selectGtKey(long ua_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ua_id,ui_id,name,telephone,area,address,ctime,note FROM "+TABLENAME2+" WHERE ua_id>:ua_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ua_id", ua_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_user_address>(Wx_user_address.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_user_address>();
        }
    }

    //根据主键查询
    public Wx_user_address selectByKey(long ua_id) {
        return selectByKey(ua_id, TABLENAME);
    }

    //根据主键查询
    public Wx_user_address selectByKey(long ua_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ua_id,ui_id,name,telephone,area,address,ctime,note FROM "+TABLENAME2+" WHERE ua_id=:ua_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ua_id", ua_id);
            List<Wx_user_address> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_user_address>(Wx_user_address.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ua_id="+ua_id,e);
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
    public List<Wx_user_address> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_user_address> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ua_id,ui_id,name,telephone,area,address,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_user_address>(Wx_user_address.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_user_address>();
        }
    }

    //修改数据
    public int updateByKey(Wx_user_address bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_user_address bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,name=:name,telephone=:telephone,area=:area,address=:address,ctime=:ctime,note=:note WHERE ua_id=:ua_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_user_address> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_user_address> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,name=?,telephone=?,area=?,address=?,ctime=?,note=? WHERE ua_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_user_address bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.name);
                    ps.setString(3, bean.telephone);
                    ps.setString(4, bean.area);
                    ps.setString(5, bean.address);
                    ps.setTimestamp(6, new Timestamp(bean.ctime.getTime()));
                    ps.setString(7, bean.note);
                    ps.setLong(8, bean.ua_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ua_id) throws SQLException{
        return deleteByKey(ua_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ua_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ua_id=:ua_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ua_id", ua_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ua_id=?";
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
                 "	`ua_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`name`  VARCHAR(60) COMMENT '//varchar(60)    收件人'," +
                 "	`telephone`  VARCHAR(30) COMMENT '//varchar(30)    联系电话'," +
                 "	`area`  VARCHAR(80) COMMENT '//varchar(80)    所在地区（四川省成都市龙泉驿区）'," +
                 "	`address`  VARCHAR(200) COMMENT '//varchar(200)    详细地址'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	PRIMARY KEY (`ua_id`)" +
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
