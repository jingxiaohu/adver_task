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

//user_task

@Repository("user_taskDao")
public class User_taskDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(User_taskDao.class);



    private  String TABLE = "user_task";

    private  String TABLENAME = "user_task";

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


    private  String[] carrays ={"ut_id","ut_nd","ti_id","ti_nd","ui_id","ui_nd","ut_code","ut_sign","ut_sate","ut_money","ctime","note","type","deal_state"};
    private  String coulmns ="ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state";
    private  String coulmns2 ="ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state";

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
    public int insert(User_task bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(User_task bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state) VALUES (:ut_nd,:ti_id,:ti_nd,:ui_id,:ui_nd,:ut_code,:ut_sign,:ut_sate,:ut_money,:ctime,:note,:type,:deal_state)";
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
    public int insert_primarykey(User_task bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(User_task bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state) VALUES (:ut_id,:ut_nd,:ti_id,:ti_nd,:ui_id,:ui_nd,:ut_code,:ut_sign,:ut_sate,:ut_money,:ctime,:note,:type,:deal_state)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<User_task> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<User_task> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_task bean = beans.get(i);
                    ps.setString(1, bean.ut_nd);
                    ps.setLong(2, bean.ti_id);
                    ps.setString(3, bean.ti_nd);
                    ps.setLong(4, bean.ui_id);
                    ps.setString(5, bean.ui_nd);
                    ps.setString(6, bean.ut_code);
                    ps.setString(7, bean.ut_sign);
                    ps.setInt(8, bean.ut_sate);
                    ps.setInt(9, bean.ut_money);
                    ps.setTimestamp(10, new Timestamp(bean.ctime.getTime()));
                    ps.setString(11, bean.note);
                    ps.setInt(12, bean.type);
                    ps.setInt(13, bean.deal_state);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<User_task> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<User_task> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state FROM "+TABLENAME2+" ORDER BY ut_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_task>(User_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<User_task>();
        }
    }

    //查询最新数据
    public List<User_task> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<User_task> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state FROM "+TABLENAME2+" ORDER BY ut_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_task>(User_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<User_task>();
        }
    }

    //根据主键查询
    public List<User_task> selectGtKey(long ut_id) {
        return selectGtKey(ut_id, TABLENAME);
    }

    //根据主键查询
    public List<User_task> selectGtKey(long ut_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state FROM "+TABLENAME2+" WHERE ut_id>:ut_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ut_id", ut_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<User_task>(User_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<User_task>();
        }
    }

    //根据主键查询
    public User_task selectByKey(long ut_id) {
        return selectByKey(ut_id, TABLENAME);
    }

    //根据主键查询
    public User_task selectByKey(long ut_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state FROM "+TABLENAME2+" WHERE ut_id=:ut_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ut_id", ut_id);
            List<User_task> list =  _np.query(sql, param, new BeanPropertyRowMapper<User_task>(User_task.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ut_id="+ut_id,e);
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
    public List<User_task> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<User_task> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ut_id,ut_nd,ti_id,ti_nd,ui_id,ui_nd,ut_code,ut_sign,ut_sate,ut_money,ctime,note,type,deal_state FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<User_task>(User_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<User_task>();
        }
    }

    //修改数据
    public int updateByKey(User_task bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(User_task bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ut_nd=:ut_nd,ti_id=:ti_id,ti_nd=:ti_nd,ui_id=:ui_id,ui_nd=:ui_nd,ut_code=:ut_code,ut_sign=:ut_sign,ut_sate=:ut_sate,ut_money=:ut_money,ctime=:ctime,note=:note,type=:type,deal_state=:deal_state WHERE ut_id=:ut_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<User_task> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<User_task> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ut_nd=?,ti_id=?,ti_nd=?,ui_id=?,ui_nd=?,ut_code=?,ut_sign=?,ut_sate=?,ut_money=?,ctime=?,note=?,type=?,deal_state=? WHERE ut_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_task bean = beans.get(i);
                    ps.setString(1, bean.ut_nd);
                    ps.setLong(2, bean.ti_id);
                    ps.setString(3, bean.ti_nd);
                    ps.setLong(4, bean.ui_id);
                    ps.setString(5, bean.ui_nd);
                    ps.setString(6, bean.ut_code);
                    ps.setString(7, bean.ut_sign);
                    ps.setInt(8, bean.ut_sate);
                    ps.setInt(9, bean.ut_money);
                    ps.setTimestamp(10, new Timestamp(bean.ctime.getTime()));
                    ps.setString(11, bean.note);
                    ps.setInt(12, bean.type);
                    ps.setInt(13, bean.deal_state);
                    ps.setLong(14, bean.ut_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ut_id) throws SQLException{
        return deleteByKey(ut_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ut_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ut_id=:ut_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ut_id", ut_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ut_id=?";
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
                 "	`ut_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ut_nd`  VARCHAR(80) COMMENT '//varchar(80)    nd'," +
                 "	`ti_id`  BIGINT(20) COMMENT '//bigint(20)    任务主键ID'," +
                 "	`ti_nd`  VARCHAR(80) COMMENT '//varchar(80)    任务nd'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`ui_nd`  VARCHAR(80) COMMENT '//varchar(80)    用户nd'," +
                 "	`ut_code`  VARCHAR(60) COMMENT '//varchar(60)    提交的验证码'," +
                 "	`ut_sign`  TINYTEXT COMMENT '//varchar(255)    提交的验证信息'," +
                 "	`ut_sate`  INT(11) COMMENT '//int(11)    是否验证成功（0:没有1:成功）'," +
                 "	`ut_money`  INT(11) COMMENT '//int(11)    获取金额'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	`type`  INT(11) COMMENT '//int(11)    任务类型（0:普通任务1:游戏任务）'," +
                 "	`deal_state`  INT(11) COMMENT '//int(11)    是否已经处理（0:没有1:处理成功2:处理失败）'," +
                 "	PRIMARY KEY (`ut_id`)" +
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
