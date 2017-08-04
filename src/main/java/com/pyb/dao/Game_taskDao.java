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

//game_task

@Repository("game_taskDao")
public class Game_taskDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Game_taskDao.class);



    private  String TABLE = "game_task";

    private  String TABLENAME = "game_task";

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


    private  String[] carrays ={"gt_id","gt_nd","gt_type","gt_name","gt_money","gt_seller","gt_log_url","gt_rebate","gt_server","gt_detail_url","gt_people","gt_browse","gt_order","gt_real_money","endtime","gt_open","ctime","note"};
    private  String coulmns ="gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note";
    private  String coulmns2 ="gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note";

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
    public int insert(Game_task bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Game_task bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note) VALUES (:gt_nd,:gt_type,:gt_name,:gt_money,:gt_seller,:gt_log_url,:gt_rebate,:gt_server,:gt_detail_url,:gt_people,:gt_browse,:gt_order,:gt_real_money,:endtime,:gt_open,:ctime,:note)";
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
    public int insert_primarykey(Game_task bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Game_task bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note) VALUES (:gt_id,:gt_nd,:gt_type,:gt_name,:gt_money,:gt_seller,:gt_log_url,:gt_rebate,:gt_server,:gt_detail_url,:gt_people,:gt_browse,:gt_order,:gt_real_money,:endtime,:gt_open,:ctime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Game_task> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Game_task> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Game_task bean = beans.get(i);
                    ps.setString(1, bean.gt_nd);
                    ps.setInt(2, bean.gt_type);
                    ps.setString(3, bean.gt_name);
                    ps.setInt(4, bean.gt_money);
                    ps.setString(5, bean.gt_seller);
                    ps.setString(6, bean.gt_log_url);
                    ps.setInt(7, bean.gt_rebate);
                    ps.setString(8, bean.gt_server);
                    ps.setString(9, bean.gt_detail_url);
                    ps.setInt(10, bean.gt_people);
                    ps.setInt(11, bean.gt_browse);
                    ps.setInt(12, bean.gt_order);
                    ps.setInt(13, bean.gt_real_money);
                    ps.setTimestamp(14, new Timestamp(bean.endtime.getTime()));
                    ps.setInt(15, bean.gt_open);
                    ps.setTimestamp(16, new Timestamp(bean.ctime.getTime()));
                    ps.setString(17, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Game_task> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Game_task> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note FROM "+TABLENAME2+" ORDER BY gt_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Game_task>(Game_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Game_task>();
        }
    }

    //查询最新数据
    public List<Game_task> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Game_task> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note FROM "+TABLENAME2+" ORDER BY gt_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Game_task>(Game_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Game_task>();
        }
    }

    //根据主键查询
    public List<Game_task> selectGtKey(long gt_id) {
        return selectGtKey(gt_id, TABLENAME);
    }

    //根据主键查询
    public List<Game_task> selectGtKey(long gt_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note FROM "+TABLENAME2+" WHERE gt_id>:gt_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gt_id", gt_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Game_task>(Game_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Game_task>();
        }
    }

    //根据主键查询
    public Game_task selectByKey(long gt_id) {
        return selectByKey(gt_id, TABLENAME);
    }

    //根据主键查询
    public Game_task selectByKey(long gt_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note FROM "+TABLENAME2+" WHERE gt_id=:gt_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gt_id", gt_id);
            List<Game_task> list =  _np.query(sql, param, new BeanPropertyRowMapper<Game_task>(Game_task.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey gt_id="+gt_id,e);
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
    public List<Game_task> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Game_task> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT gt_id,gt_nd,gt_type,gt_name,gt_money,gt_seller,gt_log_url,gt_rebate,gt_server,gt_detail_url,gt_people,gt_browse,gt_order,gt_real_money,endtime,gt_open,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Game_task>(Game_task.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Game_task>();
        }
    }

    //修改数据
    public int updateByKey(Game_task bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Game_task bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET gt_nd=:gt_nd,gt_type=:gt_type,gt_name=:gt_name,gt_money=:gt_money,gt_seller=:gt_seller,gt_log_url=:gt_log_url,gt_rebate=:gt_rebate,gt_server=:gt_server,gt_detail_url=:gt_detail_url,gt_people=:gt_people,gt_browse=:gt_browse,gt_order=:gt_order,gt_real_money=:gt_real_money,endtime=:endtime,gt_open=:gt_open,ctime=:ctime,note=:note WHERE gt_id=:gt_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Game_task> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Game_task> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET gt_nd=?,gt_type=?,gt_name=?,gt_money=?,gt_seller=?,gt_log_url=?,gt_rebate=?,gt_server=?,gt_detail_url=?,gt_people=?,gt_browse=?,gt_order=?,gt_real_money=?,endtime=?,gt_open=?,ctime=?,note=? WHERE gt_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Game_task bean = beans.get(i);
                    ps.setString(1, bean.gt_nd);
                    ps.setInt(2, bean.gt_type);
                    ps.setString(3, bean.gt_name);
                    ps.setInt(4, bean.gt_money);
                    ps.setString(5, bean.gt_seller);
                    ps.setString(6, bean.gt_log_url);
                    ps.setInt(7, bean.gt_rebate);
                    ps.setString(8, bean.gt_server);
                    ps.setString(9, bean.gt_detail_url);
                    ps.setInt(10, bean.gt_people);
                    ps.setInt(11, bean.gt_browse);
                    ps.setInt(12, bean.gt_order);
                    ps.setInt(13, bean.gt_real_money);
                    ps.setTimestamp(14, new Timestamp(bean.endtime.getTime()));
                    ps.setInt(15, bean.gt_open);
                    ps.setTimestamp(16, new Timestamp(bean.ctime.getTime()));
                    ps.setString(17, bean.note);
                    ps.setLong(18, bean.gt_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long gt_id) throws SQLException{
        return deleteByKey(gt_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long gt_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE gt_id=:gt_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("gt_id", gt_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE gt_id=?";
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
                 "	`gt_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`gt_nd`  VARCHAR(80) COMMENT '//varchar(80)    唯一标识ND'," +
                 "	`gt_type`  INT(11) COMMENT '//int(11)    游戏类型(0:未知1:网页游戏2::手游3:棋牌游戏)'," +
                 "	`gt_name`  VARCHAR(100) COMMENT '//varchar(100)    游戏名称'," +
                 "	`gt_money`  INT(11) COMMENT '//int(11)    试玩可获取金额（单位分）'," +
                 "	`gt_seller`  VARCHAR(80) COMMENT '//varchar(80)    游戏运营商家名称'," +
                 "	`gt_log_url`  TINYTEXT COMMENT '//varchar(255)    log缩略图URL'," +
                 "	`gt_rebate`  INT(11) COMMENT '//int(11)    充值返利百分比（整数例如18就是百分之18）'," +
                 "	`gt_server`  VARCHAR(100) COMMENT '//varchar(100)    所在服名称（例如：5服或者专区）'," +
                 "	`gt_detail_url`  TINYTEXT COMMENT '//varchar(255)    游戏试玩详情页面URL'," +
                 "	`gt_people`  INT(11) COMMENT '//int(11)    参与人数'," +
                 "	`gt_browse`  INT(11) COMMENT '//int(11)    浏览人数'," +
                 "	`gt_order`  INT(11) COMMENT '//int(11)    权重比'," +
                 "	`gt_real_money`  INT(11) COMMENT '//int(11)    接游戏金额单位分（自己看）'," +
                 "	`endtime`  DATETIME COMMENT '//datetime    结束投放时间'," +
                 "	`gt_open`  INT(11) COMMENT '//int(11)    是否开启（0:不开启1:开启）'," +
                 "	`ctime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`note`  VARCHAR(100) COMMENT '//varchar(100)    备注'," +
                 "	PRIMARY KEY (`gt_id`)" +
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
