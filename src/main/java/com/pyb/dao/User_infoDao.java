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

//user_info

@Repository("user_infoDao")
public class User_infoDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(User_infoDao.class);



    private  String TABLE = "user_info";

    private  String TABLENAME = "user_info";

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


    private  String[] carrays ={"ui_id","ui_nd","ui_token","ui_tel","ui_password","ui_sex","ui_avtar","ui_bind_tel","ui_name","ui_zfb","ui_wx","ui_vc","ui_sign","ui_tj","ui_lock","ctime","utime","note","ui_release","ui_task","is_vip","ui_nickname","ui_flag","ui_email","ui_reg_type"};
    private  String coulmns ="ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type";
    private  String coulmns2 ="ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type";

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
    public int insert(User_info bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(User_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type) VALUES (:ui_nd,:ui_token,:ui_tel,:ui_password,:ui_sex,:ui_avtar,:ui_bind_tel,:ui_name,:ui_zfb,:ui_wx,:ui_vc,:ui_sign,:ui_tj,:ui_lock,:ctime,:utime,:note,:ui_release,:ui_task,:is_vip,:ui_nickname,:ui_flag,:ui_email,:ui_reg_type)";
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
    public int insert_primarykey(User_info bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(User_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type) VALUES (:ui_id,:ui_nd,:ui_token,:ui_tel,:ui_password,:ui_sex,:ui_avtar,:ui_bind_tel,:ui_name,:ui_zfb,:ui_wx,:ui_vc,:ui_sign,:ui_tj,:ui_lock,:ctime,:utime,:note,:ui_release,:ui_task,:is_vip,:ui_nickname,:ui_flag,:ui_email,:ui_reg_type)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<User_info> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<User_info> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_info bean = beans.get(i);
                    ps.setString(1, bean.ui_nd);
                    ps.setString(2, bean.ui_token);
                    ps.setString(3, bean.ui_tel);
                    ps.setString(4, bean.ui_password);
                    ps.setInt(5, bean.ui_sex);
                    ps.setString(6, bean.ui_avtar);
                    ps.setString(7, bean.ui_bind_tel);
                    ps.setString(8, bean.ui_name);
                    ps.setString(9, bean.ui_zfb);
                    ps.setString(10, bean.ui_wx);
                    ps.setInt(11, bean.ui_vc);
                    ps.setInt(12, bean.ui_sign);
                    ps.setInt(13, bean.ui_tj);
                    ps.setInt(14, bean.ui_lock);
                    ps.setTimestamp(15, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(16, new Timestamp(bean.utime.getTime()));
                    ps.setString(17, bean.note);
                    ps.setInt(18, bean.ui_release);
                    ps.setInt(19, bean.ui_task);
                    ps.setInt(20, bean.is_vip);
                    ps.setString(21, bean.ui_nickname);
                    ps.setInt(22, bean.ui_flag);
                    ps.setString(23, bean.ui_email);
                    ps.setInt(24, bean.ui_reg_type);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<User_info> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<User_info> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type FROM "+TABLENAME2+" ORDER BY ui_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_info>(User_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<User_info>();
        }
    }

    //查询最新数据
    public List<User_info> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<User_info> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type FROM "+TABLENAME2+" ORDER BY ui_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<User_info>(User_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<User_info>();
        }
    }

    //根据主键查询
    public List<User_info> selectGtKey(long ui_id) {
        return selectGtKey(ui_id, TABLENAME);
    }

    //根据主键查询
    public List<User_info> selectGtKey(long ui_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type FROM "+TABLENAME2+" WHERE ui_id>:ui_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ui_id", ui_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<User_info>(User_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<User_info>();
        }
    }

    //根据主键查询
    public User_info selectByKey(long ui_id) {
        return selectByKey(ui_id, TABLENAME);
    }

    //根据主键查询
    public User_info selectByKey(long ui_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type FROM "+TABLENAME2+" WHERE ui_id=:ui_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ui_id", ui_id);
            List<User_info> list =  _np.query(sql, param, new BeanPropertyRowMapper<User_info>(User_info.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ui_id="+ui_id,e);
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
    public List<User_info> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<User_info> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ui_id,ui_nd,ui_token,ui_tel,ui_password,ui_sex,ui_avtar,ui_bind_tel,ui_name,ui_zfb,ui_wx,ui_vc,ui_sign,ui_tj,ui_lock,ctime,utime,note,ui_release,ui_task,is_vip,ui_nickname,ui_flag,ui_email,ui_reg_type FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<User_info>(User_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<User_info>();
        }
    }

    //修改数据
    public int updateByKey(User_info bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(User_info bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_nd=:ui_nd,ui_token=:ui_token,ui_tel=:ui_tel,ui_password=:ui_password,ui_sex=:ui_sex,ui_avtar=:ui_avtar,ui_bind_tel=:ui_bind_tel,ui_name=:ui_name,ui_zfb=:ui_zfb,ui_wx=:ui_wx,ui_vc=:ui_vc,ui_sign=:ui_sign,ui_tj=:ui_tj,ui_lock=:ui_lock,ctime=:ctime,utime=:utime,note=:note,ui_release=:ui_release,ui_task=:ui_task,is_vip=:is_vip,ui_nickname=:ui_nickname,ui_flag=:ui_flag,ui_email=:ui_email,ui_reg_type=:ui_reg_type WHERE ui_id=:ui_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<User_info> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<User_info> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_nd=?,ui_token=?,ui_tel=?,ui_password=?,ui_sex=?,ui_avtar=?,ui_bind_tel=?,ui_name=?,ui_zfb=?,ui_wx=?,ui_vc=?,ui_sign=?,ui_tj=?,ui_lock=?,ctime=?,utime=?,note=?,ui_release=?,ui_task=?,is_vip=?,ui_nickname=?,ui_flag=?,ui_email=?,ui_reg_type=? WHERE ui_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User_info bean = beans.get(i);
                    ps.setString(1, bean.ui_nd);
                    ps.setString(2, bean.ui_token);
                    ps.setString(3, bean.ui_tel);
                    ps.setString(4, bean.ui_password);
                    ps.setInt(5, bean.ui_sex);
                    ps.setString(6, bean.ui_avtar);
                    ps.setString(7, bean.ui_bind_tel);
                    ps.setString(8, bean.ui_name);
                    ps.setString(9, bean.ui_zfb);
                    ps.setString(10, bean.ui_wx);
                    ps.setInt(11, bean.ui_vc);
                    ps.setInt(12, bean.ui_sign);
                    ps.setInt(13, bean.ui_tj);
                    ps.setInt(14, bean.ui_lock);
                    ps.setTimestamp(15, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(16, new Timestamp(bean.utime.getTime()));
                    ps.setString(17, bean.note);
                    ps.setInt(18, bean.ui_release);
                    ps.setInt(19, bean.ui_task);
                    ps.setInt(20, bean.is_vip);
                    ps.setString(21, bean.ui_nickname);
                    ps.setInt(22, bean.ui_flag);
                    ps.setString(23, bean.ui_email);
                    ps.setInt(24, bean.ui_reg_type);
                    ps.setLong(25, bean.ui_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ui_id) throws SQLException{
        return deleteByKey(ui_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ui_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ui_id=:ui_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ui_id", ui_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ui_id=?";
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
                 "	`ui_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ui_nd`  VARCHAR(80) NOT NULL COMMENT '//varchar(80)    用户nd'," +
                 "	`ui_token`  VARCHAR(80) NOT NULL COMMENT '//varchar(80)    用户登陆token'," +
                 "	`ui_tel`  VARCHAR(20) NOT NULL COMMENT '//varchar(20)    用户账号（手机号码）'," +
                 "	`ui_password`  VARCHAR(65) NOT NULL COMMENT '//varchar(65)    用户密码'," +
                 "	`ui_sex`  INT(11) NOT NULL COMMENT '//int(11)    用户性别0:未知1:男2:女'," +
                 "	`ui_avtar`  TINYTEXT NOT NULL COMMENT '//varchar(255)    用户头像'," +
                 "	`ui_bind_tel`  VARCHAR(20) NOT NULL COMMENT '//varchar(20)    用户绑定手机号码'," +
                 "	`ui_name`  VARCHAR(60) COMMENT '//varchar(60)    用户真实姓名'," +
                 "	`ui_zfb`  VARCHAR(60) NOT NULL COMMENT '//varchar(60)    用户支付宝账号'," +
                 "	`ui_wx`  VARCHAR(60) NOT NULL COMMENT '//varchar(60)    用户微信账号'," +
                 "	`ui_vc`  INT(11) NOT NULL COMMENT '//int(11)    用户虚拟币'," +
                 "	`ui_sign`  INT(11) NOT NULL COMMENT '//int(11)    累计签到天数'," +
                 "	`ui_tj`  INT(11) NOT NULL COMMENT '//int(11)    推荐有效好友数'," +
                 "	`ui_lock`  INT(11) NOT NULL COMMENT '//int(11)    是否锁定(0:有效用户1:非法用户)'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`utime`  DATETIME COMMENT '//datetime    更新时间'," +
                 "	`note`  VARCHAR(100) NOT NULL COMMENT '//varchar(100)    备注'," +
                 "	`ui_release`  INT(11) NOT NULL COMMENT '//int(11)    已发任务数'," +
                 "	`ui_task`  INT(11) NOT NULL COMMENT '//int(11)    已做任务数'," +
                 "	`is_vip`  INT(11) NOT NULL COMMENT '//int(11)    是否是VIP'," +
                 "	`ui_nickname`  VARCHAR(60) COMMENT '//varchar(60)    用户昵称'," +
                 "	`ui_flag`  INT(11) COMMENT '//int(11)    注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里'," +
                 "	`ui_email`  VARCHAR(100) COMMENT '//varchar(100)    保密邮箱'," +
                 "	`ui_reg_type`  INT(11) COMMENT '//int(11)    注册类型（0:未指定1:邮箱2:手机）'," +
                 "	PRIMARY KEY (`ui_id`)" +
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
