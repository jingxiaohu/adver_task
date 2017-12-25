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

//wx_user_withdraw

@Repository("wx_user_withdrawDao")
public class Wx_user_withdrawDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_user_withdrawDao.class);



    private  String TABLE = "wx_user_withdraw";

    private  String TABLENAME = "wx_user_withdraw";

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


    private  String[] carrays ={"uw_id","ui_id","money","telephone","weixin_no","snap_json","state","is_del","remit_time","ctime","note"};
    private  String coulmns ="uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note";
    private  String coulmns2 ="ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note";

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
    public int insert(Wx_user_withdraw bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_user_withdraw bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note) VALUES (:ui_id,:money,:telephone,:weixin_no,:snap_json,:state,:is_del,:remit_time,:ctime,:note)";
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
    public int insert_primarykey(Wx_user_withdraw bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_user_withdraw bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note) VALUES (:uw_id,:ui_id,:money,:telephone,:weixin_no,:snap_json,:state,:is_del,:remit_time,:ctime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_user_withdraw> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_user_withdraw> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note) VALUES (?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_user_withdraw bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setInt(2, bean.money);
                    ps.setString(3, bean.telephone);
                    ps.setString(4, bean.weixin_no);
                    ps.setString(5, bean.snap_json);
                    ps.setInt(6, bean.state);
                    ps.setInt(7, bean.is_del);
                    ps.setTimestamp(8, new Timestamp(bean.remit_time.getTime()));
                    ps.setTimestamp(9, new Timestamp(bean.ctime.getTime()));
                    ps.setString(10, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_user_withdraw> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_user_withdraw> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note FROM "+TABLENAME2+" ORDER BY uw_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_user_withdraw>(Wx_user_withdraw.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_user_withdraw>();
        }
    }

    //查询最新数据
    public List<Wx_user_withdraw> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_user_withdraw> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note FROM "+TABLENAME2+" ORDER BY uw_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_user_withdraw>(Wx_user_withdraw.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_user_withdraw>();
        }
    }

    //根据主键查询
    public List<Wx_user_withdraw> selectGtKey(long uw_id) {
        return selectGtKey(uw_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_user_withdraw> selectGtKey(long uw_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note FROM "+TABLENAME2+" WHERE uw_id>:uw_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("uw_id", uw_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_user_withdraw>(Wx_user_withdraw.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_user_withdraw>();
        }
    }

    //根据主键查询
    public Wx_user_withdraw selectByKey(long uw_id) {
        return selectByKey(uw_id, TABLENAME);
    }

    //根据主键查询
    public Wx_user_withdraw selectByKey(long uw_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note FROM "+TABLENAME2+" WHERE uw_id=:uw_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("uw_id", uw_id);
            List<Wx_user_withdraw> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_user_withdraw>(Wx_user_withdraw.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey uw_id="+uw_id,e);
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
    public List<Wx_user_withdraw> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_user_withdraw> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT uw_id,ui_id,money,telephone,weixin_no,snap_json,state,is_del,remit_time,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_user_withdraw>(Wx_user_withdraw.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_user_withdraw>();
        }
    }

    //修改数据
    public int updateByKey(Wx_user_withdraw bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_user_withdraw bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,money=:money,telephone=:telephone,weixin_no=:weixin_no,snap_json=:snap_json,state=:state,is_del=:is_del,remit_time=:remit_time,ctime=:ctime,note=:note WHERE uw_id=:uw_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_user_withdraw> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_user_withdraw> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,money=?,telephone=?,weixin_no=?,snap_json=?,state=?,is_del=?,remit_time=?,ctime=?,note=? WHERE uw_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_user_withdraw bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setInt(2, bean.money);
                    ps.setString(3, bean.telephone);
                    ps.setString(4, bean.weixin_no);
                    ps.setString(5, bean.snap_json);
                    ps.setInt(6, bean.state);
                    ps.setInt(7, bean.is_del);
                    ps.setTimestamp(8, new Timestamp(bean.remit_time.getTime()));
                    ps.setTimestamp(9, new Timestamp(bean.ctime.getTime()));
                    ps.setString(10, bean.note);
                    ps.setLong(11, bean.uw_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long uw_id) throws SQLException{
        return deleteByKey(uw_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long uw_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE uw_id=:uw_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("uw_id", uw_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE uw_id=?";
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
                 "	`uw_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户id'," +
                 "	`money`  INT(11) COMMENT '//int(11)    提现金额(单位分)'," +
                 "	`telephone`  VARCHAR(30) COMMENT '//varchar(30)    用户手机号码'," +
                 "	`weixin_no`  VARCHAR(60) COMMENT '//varchar(60)    用户微信号码'," +
                 "	`snap_json`  TINYTEXT COMMENT '//varchar(1000)    提现前快照JSON字符串'," +
                 "	`state`  INT(11) COMMENT '//int(11)    打款状态(0:未打款1：打款成功2：打款失败信息不吻合)'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除(0:不删除1：删除)'," +
                 "	`remit_time`  TIMESTAMP NOT NULL COMMENT '//timestamp    打款处理时间'," +
                 "	`ctime`  TIMESTAMP NOT NULL COMMENT '//timestamp    创建时间'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	PRIMARY KEY (`uw_id`)" +
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
