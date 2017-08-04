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

//pay_park

@Repository("pay_parkDao")
public class Pay_parkDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Pay_parkDao.class);



    private  String TABLE = "pay_park";

    private  String TABLENAME = "pay_park";

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


    private  String[] carrays ={"id","ui_id","ui_nd","ui_tel","order_type","num","money","pp_state","pay_source","my_order","pp_versioncode","phone_type","allege_state","is_del","ai_id","ai_money","ai_effect","up_orderid","ctime","utime","note"};
    private  String coulmns ="id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note";
    private  String coulmns2 ="ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note";

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
    public int insert(Pay_park bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Pay_park bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note) VALUES (:ui_id,:ui_nd,:ui_tel,:order_type,:num,:money,:pp_state,:pay_source,:my_order,:pp_versioncode,:phone_type,:allege_state,:is_del,:ai_id,:ai_money,:ai_effect,:up_orderid,:ctime,:utime,:note)";
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
    public int insert_primarykey(Pay_park bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Pay_park bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note) VALUES (:id,:ui_id,:ui_nd,:ui_tel,:order_type,:num,:money,:pp_state,:pay_source,:my_order,:pp_versioncode,:phone_type,:allege_state,:is_del,:ai_id,:ai_money,:ai_effect,:up_orderid,:ctime,:utime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Pay_park> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Pay_park> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Pay_park bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.ui_nd);
                    ps.setString(3, bean.ui_tel);
                    ps.setInt(4, bean.order_type);
                    ps.setInt(5, bean.num);
                    ps.setInt(6, bean.money);
                    ps.setInt(7, bean.pp_state);
                    ps.setInt(8, bean.pay_source);
                    ps.setString(9, bean.my_order);
                    ps.setString(10, bean.pp_versioncode);
                    ps.setInt(11, bean.phone_type);
                    ps.setInt(12, bean.allege_state);
                    ps.setInt(13, bean.is_del);
                    ps.setLong(14, bean.ai_id);
                    ps.setInt(15, bean.ai_money);
                    ps.setInt(16, bean.ai_effect);
                    ps.setString(17, bean.up_orderid);
                    ps.setTimestamp(18, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(19, new Timestamp(bean.utime.getTime()));
                    ps.setString(20, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Pay_park> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Pay_park> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note FROM "+TABLENAME2+" ORDER BY id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Pay_park>(Pay_park.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Pay_park>();
        }
    }

    //查询最新数据
    public List<Pay_park> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Pay_park> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note FROM "+TABLENAME2+" ORDER BY id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Pay_park>(Pay_park.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Pay_park>();
        }
    }

    //根据主键查询
    public List<Pay_park> selectGtKey(long id) {
        return selectGtKey(id, TABLENAME);
    }

    //根据主键查询
    public List<Pay_park> selectGtKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note FROM "+TABLENAME2+" WHERE id>:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Pay_park>(Pay_park.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Pay_park>();
        }
    }

    //根据主键查询
    public Pay_park selectByKey(long id) {
        return selectByKey(id, TABLENAME);
    }

    //根据主键查询
    public Pay_park selectByKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note FROM "+TABLENAME2+" WHERE id=:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            List<Pay_park> list =  _np.query(sql, param, new BeanPropertyRowMapper<Pay_park>(Pay_park.class));
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
    public List<Pay_park> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Pay_park> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT id,ui_id,ui_nd,ui_tel,order_type,num,money,pp_state,pay_source,my_order,pp_versioncode,phone_type,allege_state,is_del,ai_id,ai_money,ai_effect,up_orderid,ctime,utime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Pay_park>(Pay_park.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Pay_park>();
        }
    }

    //修改数据
    public int updateByKey(Pay_park bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Pay_park bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,ui_nd=:ui_nd,ui_tel=:ui_tel,order_type=:order_type,num=:num,money=:money,pp_state=:pp_state,pay_source=:pay_source,my_order=:my_order,pp_versioncode=:pp_versioncode,phone_type=:phone_type,allege_state=:allege_state,is_del=:is_del,ai_id=:ai_id,ai_money=:ai_money,ai_effect=:ai_effect,up_orderid=:up_orderid,ctime=:ctime,utime=:utime,note=:note WHERE id=:id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Pay_park> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Pay_park> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,ui_nd=?,ui_tel=?,order_type=?,num=?,money=?,pp_state=?,pay_source=?,my_order=?,pp_versioncode=?,phone_type=?,allege_state=?,is_del=?,ai_id=?,ai_money=?,ai_effect=?,up_orderid=?,ctime=?,utime=?,note=? WHERE id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Pay_park bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.ui_nd);
                    ps.setString(3, bean.ui_tel);
                    ps.setInt(4, bean.order_type);
                    ps.setInt(5, bean.num);
                    ps.setInt(6, bean.money);
                    ps.setInt(7, bean.pp_state);
                    ps.setInt(8, bean.pay_source);
                    ps.setString(9, bean.my_order);
                    ps.setString(10, bean.pp_versioncode);
                    ps.setInt(11, bean.phone_type);
                    ps.setInt(12, bean.allege_state);
                    ps.setInt(13, bean.is_del);
                    ps.setLong(14, bean.ai_id);
                    ps.setInt(15, bean.ai_money);
                    ps.setInt(16, bean.ai_effect);
                    ps.setString(17, bean.up_orderid);
                    ps.setTimestamp(18, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(19, new Timestamp(bean.utime.getTime()));
                    ps.setString(20, bean.note);
                    ps.setLong(21, bean.id);
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
                 "	`id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`ui_nd`  VARCHAR(100) COMMENT '//varchar(100)    用户唯一标识uuid'," +
                 "	`ui_tel`  VARCHAR(100) COMMENT '//varchar(100)    用户电话号码'," +
                 "	`order_type`  INT(11) COMMENT '//int(11)    下单类型0:未指定1：每天短线牛股2：中线股'," +
                 "	`num`  INT(11) COMMENT '//int(11)    股票只数'," +
                 "	`money`  INT(11) COMMENT '//int(11)    支付金额（单位分）'," +
                 "	`pp_state`  INT(11) COMMENT '//int(11)    支付状态0:未支付1：已经支付'," +
                 "	`pay_source`  INT(11) COMMENT '//int(11)    支付类型0：现金支付1:支付宝2：微信3：银联4：钱包5:龙支付6:ETC快捷支付7：扫脸支付'," +
                 "	`my_order`  VARCHAR(80) COMMENT '//varchar(80)    我们的订单号'," +
                 "	`pp_versioncode`  VARCHAR(30) COMMENT '//varchar(30)    当前APPSDK版本号（内部升级版本代号）'," +
                 "	`phone_type`  INT(11) COMMENT '//int(11)    手机类型0:android1：IOS'," +
                 "	`allege_state`  INT(11) COMMENT '//int(11)    申述状态0:未申述1：申述中2：申述失败3：申述成功'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    删除状态0:正常1：假删除'," +
                 "	`ai_id`  BIGINT(20) COMMENT '//bigint(20)    活动ID'," +
                 "	`ai_money`  INT(11) COMMENT '//int(11)    活动优惠金额（单位分）'," +
                 "	`ai_effect`  INT(11) COMMENT '//int(11)    活动优惠是否生效（0：没有1：生效）'," +
                 "	`up_orderid`  VARCHAR(80) COMMENT '//varchar(80)    第三方支付user_pay中的流水单号(订单支付'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    下单时间'," +
                 "	`utime`  DATETIME COMMENT '//datetime    更新支付状态时间'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	PRIMARY KEY (`id`)" +
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
