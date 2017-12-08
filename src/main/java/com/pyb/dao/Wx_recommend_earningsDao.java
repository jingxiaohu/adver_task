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

//wx_recommend_earnings

@Repository("wx_recommend_earningsDao")
public class Wx_recommend_earningsDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_recommend_earningsDao.class);



    private  String TABLE = "wx_recommend_earnings";

    private  String TABLENAME = "wx_recommend_earnings";

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


    private  String[] carrays ={"re_id","earnings_total","allow_drawings","drawings","unconfirmed_receiving","ctime","utime","note","ui_id","state","weixin_id","re_type"};
    private  String coulmns ="re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type";
    private  String coulmns2 ="earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type";

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
    public int insert(Wx_recommend_earnings bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_recommend_earnings bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type) VALUES (:earnings_total,:allow_drawings,:drawings,:unconfirmed_receiving,:ctime,:utime,:note,:ui_id,:state,:weixin_id,:re_type)";
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
    public int insert_primarykey(Wx_recommend_earnings bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_recommend_earnings bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type) VALUES (:re_id,:earnings_total,:allow_drawings,:drawings,:unconfirmed_receiving,:ctime,:utime,:note,:ui_id,:state,:weixin_id,:re_type)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_recommend_earnings> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_recommend_earnings> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_recommend_earnings bean = beans.get(i);
                    ps.setInt(1, bean.earnings_total);
                    ps.setInt(2, bean.allow_drawings);
                    ps.setInt(3, bean.drawings);
                    ps.setInt(4, bean.unconfirmed_receiving);
                    ps.setTimestamp(5, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(6, new Timestamp(bean.utime.getTime()));
                    ps.setString(7, bean.note);
                    ps.setLong(8, bean.ui_id);
                    ps.setInt(9, bean.state);
                    ps.setString(10, bean.weixin_id);
                    ps.setInt(11, bean.re_type);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_recommend_earnings> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_recommend_earnings> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type FROM "+TABLENAME2+" ORDER BY re_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_recommend_earnings>(Wx_recommend_earnings.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_recommend_earnings>();
        }
    }

    //查询最新数据
    public List<Wx_recommend_earnings> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_recommend_earnings> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type FROM "+TABLENAME2+" ORDER BY re_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_recommend_earnings>(Wx_recommend_earnings.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_recommend_earnings>();
        }
    }

    //根据主键查询
    public List<Wx_recommend_earnings> selectGtKey(long re_id) {
        return selectGtKey(re_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_recommend_earnings> selectGtKey(long re_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type FROM "+TABLENAME2+" WHERE re_id>:re_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("re_id", re_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_recommend_earnings>(Wx_recommend_earnings.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_recommend_earnings>();
        }
    }

    //根据主键查询
    public Wx_recommend_earnings selectByKey(long re_id) {
        return selectByKey(re_id, TABLENAME);
    }

    //根据主键查询
    public Wx_recommend_earnings selectByKey(long re_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type FROM "+TABLENAME2+" WHERE re_id=:re_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("re_id", re_id);
            List<Wx_recommend_earnings> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_recommend_earnings>(Wx_recommend_earnings.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey re_id="+re_id,e);
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
    public List<Wx_recommend_earnings> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_recommend_earnings> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT re_id,earnings_total,allow_drawings,drawings,unconfirmed_receiving,ctime,utime,note,ui_id,state,weixin_id,re_type FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_recommend_earnings>(Wx_recommend_earnings.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_recommend_earnings>();
        }
    }

    //修改数据
    public int updateByKey(Wx_recommend_earnings bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_recommend_earnings bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET earnings_total=:earnings_total,allow_drawings=:allow_drawings,drawings=:drawings,unconfirmed_receiving=:unconfirmed_receiving,ctime=:ctime,utime=:utime,note=:note,ui_id=:ui_id,state=:state,weixin_id=:weixin_id,re_type=:re_type WHERE re_id=:re_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_recommend_earnings> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_recommend_earnings> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET earnings_total=?,allow_drawings=?,drawings=?,unconfirmed_receiving=?,ctime=?,utime=?,note=?,ui_id=?,state=?,weixin_id=?,re_type=? WHERE re_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_recommend_earnings bean = beans.get(i);
                    ps.setInt(1, bean.earnings_total);
                    ps.setInt(2, bean.allow_drawings);
                    ps.setInt(3, bean.drawings);
                    ps.setInt(4, bean.unconfirmed_receiving);
                    ps.setTimestamp(5, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(6, new Timestamp(bean.utime.getTime()));
                    ps.setString(7, bean.note);
                    ps.setLong(8, bean.ui_id);
                    ps.setInt(9, bean.state);
                    ps.setString(10, bean.weixin_id);
                    ps.setInt(11, bean.re_type);
                    ps.setLong(12, bean.re_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long re_id) throws SQLException{
        return deleteByKey(re_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long re_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE re_id=:re_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("re_id", re_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE re_id=?";
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
                 "	`re_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`earnings_total`  INT(11) COMMENT '//int(11)    推荐人总累积收益'," +
                 "	`allow_drawings`  INT(11) COMMENT '//int(11)    可提现收益'," +
                 "	`drawings`  INT(11) COMMENT '//int(11)    成功提现收益'," +
                 "	`unconfirmed_receiving`  INT(11) COMMENT '//int(11)    待收货未经确认收益'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`utime`  TIMESTAMP COMMENT '//timestamp    修改时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    推荐合伙人用户ID'," +
                 "	`state`  INT(11) COMMENT '//int(11)    是否审核通过0：申请中待审核1：审核通过2：审核不通过'," +
                 "	`weixin_id`  VARCHAR(80) COMMENT '//varchar(80)    推荐合伙人对公众平台微信IDweixin_id'," +
                 "	`re_type`  INT(11) COMMENT '//int(11)    合伙人类型：0：普通推荐合伙人1：中级推荐合伙人2：高级推荐合伙人'," +
                 "	PRIMARY KEY (`re_id`)" +
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
