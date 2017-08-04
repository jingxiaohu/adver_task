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

//task_info

@Repository("task_infoDao")
public class Task_infoDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Task_infoDao.class);



    private  String TABLE = "task_info";

    private  String TABLENAME = "task_info";

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


    private  String[] carrays ={"ti_id","ti_nd","ti_title","ti_money","ti_money_vip","ti_type","ti_first_url","ti_second_url","ti_third_url","ti_sign","ti_limit","ti_current","ti_starttime","ti_endtime","ti_model","ctime","note","ui_id","ui_nd","ti_open"};
    private  String coulmns ="ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open";
    private  String coulmns2 ="ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open";

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
    public int insert(Task_info bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Task_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open) VALUES (:ti_nd,:ti_title,:ti_money,:ti_money_vip,:ti_type,:ti_first_url,:ti_second_url,:ti_third_url,:ti_sign,:ti_limit,:ti_current,:ti_starttime,:ti_endtime,:ti_model,:ctime,:note,:ui_id,:ui_nd,:ti_open)";
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
    public int insert_primarykey(Task_info bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Task_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open) VALUES (:ti_id,:ti_nd,:ti_title,:ti_money,:ti_money_vip,:ti_type,:ti_first_url,:ti_second_url,:ti_third_url,:ti_sign,:ti_limit,:ti_current,:ti_starttime,:ti_endtime,:ti_model,:ctime,:note,:ui_id,:ui_nd,:ti_open)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Task_info> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Task_info> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Task_info bean = beans.get(i);
                    ps.setString(1, bean.ti_nd);
                    ps.setString(2, bean.ti_title);
                    ps.setInt(3, bean.ti_money);
                    ps.setInt(4, bean.ti_money_vip);
                    ps.setInt(5, bean.ti_type);
                    ps.setString(6, bean.ti_first_url);
                    ps.setBytes(7, bean.ti_second_url);
                    ps.setString(8, bean.ti_third_url);
                    ps.setString(9, bean.ti_sign);
                    ps.setInt(10, bean.ti_limit);
                    ps.setInt(11, bean.ti_current);
                    ps.setTimestamp(12, new Timestamp(bean.ti_starttime.getTime()));
                    ps.setTimestamp(13, new Timestamp(bean.ti_endtime.getTime()));
                    ps.setInt(14, bean.ti_model);
                    ps.setTimestamp(15, new Timestamp(bean.ctime.getTime()));
                    ps.setString(16, bean.note);
                    ps.setLong(17, bean.ui_id);
                    ps.setString(18, bean.ui_nd);
                    ps.setInt(19, bean.ti_open);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Task_info> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Task_info> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open FROM "+TABLENAME2+" ORDER BY ti_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Task_info>(Task_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Task_info>();
        }
    }

    //查询最新数据
    public List<Task_info> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Task_info> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open FROM "+TABLENAME2+" ORDER BY ti_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Task_info>(Task_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Task_info>();
        }
    }

    //根据主键查询
    public List<Task_info> selectGtKey(long ti_id) {
        return selectGtKey(ti_id, TABLENAME);
    }

    //根据主键查询
    public List<Task_info> selectGtKey(long ti_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open FROM "+TABLENAME2+" WHERE ti_id>:ti_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ti_id", ti_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Task_info>(Task_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Task_info>();
        }
    }

    //根据主键查询
    public Task_info selectByKey(long ti_id) {
        return selectByKey(ti_id, TABLENAME);
    }

    //根据主键查询
    public Task_info selectByKey(long ti_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open FROM "+TABLENAME2+" WHERE ti_id=:ti_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ti_id", ti_id);
            List<Task_info> list =  _np.query(sql, param, new BeanPropertyRowMapper<Task_info>(Task_info.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ti_id="+ti_id,e);
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
    public List<Task_info> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Task_info> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ti_id,ti_nd,ti_title,ti_money,ti_money_vip,ti_type,ti_first_url,ti_second_url,ti_third_url,ti_sign,ti_limit,ti_current,ti_starttime,ti_endtime,ti_model,ctime,note,ui_id,ui_nd,ti_open FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Task_info>(Task_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Task_info>();
        }
    }

    //修改数据
    public int updateByKey(Task_info bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Task_info bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ti_nd=:ti_nd,ti_title=:ti_title,ti_money=:ti_money,ti_money_vip=:ti_money_vip,ti_type=:ti_type,ti_first_url=:ti_first_url,ti_second_url=:ti_second_url,ti_third_url=:ti_third_url,ti_sign=:ti_sign,ti_limit=:ti_limit,ti_current=:ti_current,ti_starttime=:ti_starttime,ti_endtime=:ti_endtime,ti_model=:ti_model,ctime=:ctime,note=:note,ui_id=:ui_id,ui_nd=:ui_nd,ti_open=:ti_open WHERE ti_id=:ti_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Task_info> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Task_info> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ti_nd=?,ti_title=?,ti_money=?,ti_money_vip=?,ti_type=?,ti_first_url=?,ti_second_url=?,ti_third_url=?,ti_sign=?,ti_limit=?,ti_current=?,ti_starttime=?,ti_endtime=?,ti_model=?,ctime=?,note=?,ui_id=?,ui_nd=?,ti_open=? WHERE ti_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Task_info bean = beans.get(i);
                    ps.setString(1, bean.ti_nd);
                    ps.setString(2, bean.ti_title);
                    ps.setInt(3, bean.ti_money);
                    ps.setInt(4, bean.ti_money_vip);
                    ps.setInt(5, bean.ti_type);
                    ps.setString(6, bean.ti_first_url);
                    ps.setBytes(7, bean.ti_second_url);
                    ps.setString(8, bean.ti_third_url);
                    ps.setString(9, bean.ti_sign);
                    ps.setInt(10, bean.ti_limit);
                    ps.setInt(11, bean.ti_current);
                    ps.setTimestamp(12, new Timestamp(bean.ti_starttime.getTime()));
                    ps.setTimestamp(13, new Timestamp(bean.ti_endtime.getTime()));
                    ps.setInt(14, bean.ti_model);
                    ps.setTimestamp(15, new Timestamp(bean.ctime.getTime()));
                    ps.setString(16, bean.note);
                    ps.setLong(17, bean.ui_id);
                    ps.setString(18, bean.ui_nd);
                    ps.setInt(19, bean.ti_open);
                    ps.setLong(20, bean.ti_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ti_id) throws SQLException{
        return deleteByKey(ti_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ti_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ti_id=:ti_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ti_id", ti_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ti_id=?";
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
                 "	`ti_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ti_nd`  VARCHAR(80) COMMENT '//varchar(80)    任务nd'," +
                 "	`ti_title`  VARCHAR(100) COMMENT '//varchar(100)    任务标题'," +
                 "	`ti_money`  INT(11) COMMENT '//int(11)    任务普通奖励(虚拟币)'," +
                 "	`ti_money_vip`  INT(11) COMMENT '//int(11)    任务VIP奖励(虚拟币)'," +
                 "	`ti_type`  INT(11) COMMENT '//int(11)    任务类型(0:l浏览广告1:点击广告2:搜索广告3:注册广告4:商家问答)'," +
                 "	`ti_first_url`  TINYTEXT COMMENT '//varchar(255)    任务第一步网址'," +
                 "	`ti_second_url`  VARBINARY(255) COMMENT '//varbinary(255)    任务第二步内容步骤图片'," +
                 "	`ti_third_url`  TINYTEXT COMMENT '//varchar(255)    第三步需要提交的验证结果（网址或者文字）'," +
                 "	`ti_sign`  VARCHAR(60) COMMENT '//varchar(60)    任务验证码'," +
                 "	`ti_limit`  INT(11) COMMENT '//int(11)    限定参数人数'," +
                 "	`ti_current`  INT(11) COMMENT '//int(11)    当前参与人数'," +
                 "	`ti_starttime`  DATETIME COMMENT '//datetime    任务开启时间'," +
                 "	`ti_endtime`  DATETIME COMMENT '//datetime    任务结束时间'," +
                 "	`ti_model`  INT(11) COMMENT '//int(11)    任务投放类型(0:按时间1:按人数)'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    发布人用户ID'," +
                 "	`ui_nd`  VARCHAR(100) COMMENT '//varchar(100)    发布人用户ND'," +
                 "	`ti_open`  INT(11) COMMENT '//int(11)    是否开启(0:不开启1:开启)'," +
                 "	PRIMARY KEY (`ti_id`)" +
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
