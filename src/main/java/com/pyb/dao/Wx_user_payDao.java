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

//wx_user_pay

@Repository("wx_user_payDao")
public class Wx_user_payDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_user_payDao.class);



    private  String TABLE = "wx_user_pay";

    private  String TABLENAME = "wx_user_pay";

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


    private  String[] carrays ={"id","order_id","transaction_id","type","version_code","system_type","return_url","ui_id","ui_nd","tel","money","act_type","ctime","utime","etime","state","ip","referer","subject","car_order_id","note","is_del"};
    private  String coulmns ="id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del";
    private  String coulmns2 ="order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del";

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
    public int insert(Wx_user_pay bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_user_pay bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del) VALUES (:order_id,:transaction_id,:type,:version_code,:system_type,:return_url,:ui_id,:ui_nd,:tel,:money,:act_type,:ctime,:utime,:etime,:state,:ip,:referer,:subject,:car_order_id,:note,:is_del)";
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
    public int insert_primarykey(Wx_user_pay bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_user_pay bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del) VALUES (:id,:order_id,:transaction_id,:type,:version_code,:system_type,:return_url,:ui_id,:ui_nd,:tel,:money,:act_type,:ctime,:utime,:etime,:state,:ip,:referer,:subject,:car_order_id,:note,:is_del)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_user_pay> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_user_pay> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_user_pay bean = beans.get(i);
                    ps.setString(1, bean.order_id);
                    ps.setString(2, bean.transaction_id);
                    ps.setInt(3, bean.type);
                    ps.setInt(4, bean.version_code);
                    ps.setInt(5, bean.system_type);
                    ps.setString(6, bean.return_url);
                    ps.setLong(7, bean.ui_id);
                    ps.setString(8, bean.ui_nd);
                    ps.setString(9, bean.tel);
                    ps.setInt(10, bean.money);
                    ps.setInt(11, bean.act_type);
                    ps.setTimestamp(12, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(13, new Timestamp(bean.utime.getTime()));
                    ps.setTimestamp(14, new Timestamp(bean.etime.getTime()));
                    ps.setInt(15, bean.state);
                    ps.setString(16, bean.ip);
                    ps.setString(17, bean.referer);
                    ps.setString(18, bean.subject);
                    ps.setString(19, bean.car_order_id);
                    ps.setString(20, bean.note);
                    ps.setInt(21, bean.is_del);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_user_pay> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_user_pay> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del FROM "+TABLENAME2+" ORDER BY id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_user_pay>(Wx_user_pay.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_user_pay>();
        }
    }

    //查询最新数据
    public List<Wx_user_pay> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_user_pay> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del FROM "+TABLENAME2+" ORDER BY id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_user_pay>(Wx_user_pay.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_user_pay>();
        }
    }

    //根据主键查询
    public List<Wx_user_pay> selectGtKey(long id) {
        return selectGtKey(id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_user_pay> selectGtKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del FROM "+TABLENAME2+" WHERE id>:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_user_pay>(Wx_user_pay.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_user_pay>();
        }
    }

    //根据主键查询
    public Wx_user_pay selectByKey(long id) {
        return selectByKey(id, TABLENAME);
    }

    //根据主键查询
    public Wx_user_pay selectByKey(long id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del FROM "+TABLENAME2+" WHERE id=:id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("id", id);
            List<Wx_user_pay> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_user_pay>(Wx_user_pay.class));
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
    public List<Wx_user_pay> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_user_pay> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT id,order_id,transaction_id,type,version_code,system_type,return_url,ui_id,ui_nd,tel,money,act_type,ctime,utime,etime,state,ip,referer,subject,car_order_id,note,is_del FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_user_pay>(Wx_user_pay.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_user_pay>();
        }
    }

    //修改数据
    public int updateByKey(Wx_user_pay bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_user_pay bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET order_id=:order_id,transaction_id=:transaction_id,type=:type,version_code=:version_code,system_type=:system_type,return_url=:return_url,ui_id=:ui_id,ui_nd=:ui_nd,tel=:tel,money=:money,act_type=:act_type,ctime=:ctime,utime=:utime,etime=:etime,state=:state,ip=:ip,referer=:referer,subject=:subject,car_order_id=:car_order_id,note=:note,is_del=:is_del WHERE id=:id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_user_pay> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_user_pay> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET order_id=?,transaction_id=?,type=?,version_code=?,system_type=?,return_url=?,ui_id=?,ui_nd=?,tel=?,money=?,act_type=?,ctime=?,utime=?,etime=?,state=?,ip=?,referer=?,subject=?,car_order_id=?,note=?,is_del=? WHERE id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_user_pay bean = beans.get(i);
                    ps.setString(1, bean.order_id);
                    ps.setString(2, bean.transaction_id);
                    ps.setInt(3, bean.type);
                    ps.setInt(4, bean.version_code);
                    ps.setInt(5, bean.system_type);
                    ps.setString(6, bean.return_url);
                    ps.setLong(7, bean.ui_id);
                    ps.setString(8, bean.ui_nd);
                    ps.setString(9, bean.tel);
                    ps.setInt(10, bean.money);
                    ps.setInt(11, bean.act_type);
                    ps.setTimestamp(12, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(13, new Timestamp(bean.utime.getTime()));
                    ps.setTimestamp(14, new Timestamp(bean.etime.getTime()));
                    ps.setInt(15, bean.state);
                    ps.setString(16, bean.ip);
                    ps.setString(17, bean.referer);
                    ps.setString(18, bean.subject);
                    ps.setString(19, bean.car_order_id);
                    ps.setString(20, bean.note);
                    ps.setInt(21, bean.is_del);
                    ps.setLong(22, bean.id);
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
                 "	`order_id`  VARCHAR(100) COMMENT '//varchar(100)    我的订单'," +
                 "	`transaction_id`  VARCHAR(100) COMMENT '//varchar(100)    第三方事物单号'," +
                 "	`type`  INT(11) COMMENT '//int(11)    支付类型1:支付宝2：微信3：银联4：钱包5:龙支付'," +
                 "	`version_code`  INT(11) COMMENT '//int(11)    当前手机APP版本号'," +
                 "	`system_type`  INT(11) COMMENT '//int(11)    操作系统类型（IOSAndroidweb）1:android2:IOS3:web4:PDA'," +
                 "	`return_url`  TINYTEXT COMMENT '//varchar(255)    前置页面跳转URL'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    '," +
                 "	`ui_nd`  VARCHAR(100) COMMENT '//varchar(100)    '," +
                 "	`tel`  VARCHAR(20) COMMENT '//varchar(20)    用户电话号码'," +
                 "	`money`  INT(11) COMMENT '//int(11)    '," +
                 "	`act_type`  INT(11) COMMENT '//int(11)    行为类型1：充值2：普通订单支付3：租赁订单支付'," +
                 "	`ctime`  TIMESTAMP NOT NULL COMMENT '//timestamp    创建时间'," +
                 "	`utime`  TIMESTAMP NOT NULL COMMENT '//timestamp    第三方回调时间'," +
                 "	`etime`  TIMESTAMP NOT NULL COMMENT '//timestamp    订单失效时间'," +
                 "	`state`  INT(11) COMMENT '//int(11)    交易状态(0:未支付1：已支付2：支付失败)'," +
                 "	`ip`  VARCHAR(100) COMMENT '//varchar(100)    IP地址'," +
                 "	`referer`  TINYTEXT COMMENT '//varchar(255)    第三方回调referer'," +
                 "	`subject`  VARCHAR(200) COMMENT '//varchar(200)    商品名称'," +
                 "	`car_order_id`  TEXT COMMENT '//text    停车订单号如果多个中间逗号分割例如（a123,b123,c123）'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除（0：不删除1：删除）'," +
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
