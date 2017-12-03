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

//wx_evaluate

@Repository("wx_evaluateDao")
public class Wx_evaluateDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_evaluateDao.class);



    private  String TABLE = "wx_evaluate";

    private  String TABLENAME = "wx_evaluate";

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


    private  String[] carrays ={"e_id","order_id","g_id","ui_id","nickname","avatar","content","father_e_id","big_img_url","small_img_url","is_show","type","img_num","ctime","note","is_del"};
    private  String coulmns ="e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del";
    private  String coulmns2 ="order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del";

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
    public int insert(Wx_evaluate bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_evaluate bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del) VALUES (:order_id,:g_id,:ui_id,:nickname,:avatar,:content,:father_e_id,:big_img_url,:small_img_url,:is_show,:type,:img_num,:ctime,:note,:is_del)";
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
    public int insert_primarykey(Wx_evaluate bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_evaluate bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del) VALUES (:e_id,:order_id,:g_id,:ui_id,:nickname,:avatar,:content,:father_e_id,:big_img_url,:small_img_url,:is_show,:type,:img_num,:ctime,:note,:is_del)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_evaluate> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_evaluate> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_evaluate bean = beans.get(i);
                    ps.setString(1, bean.order_id);
                    ps.setLong(2, bean.g_id);
                    ps.setLong(3, bean.ui_id);
                    ps.setString(4, bean.nickname);
                    ps.setString(5, bean.avatar);
                    ps.setString(6, bean.content);
                    ps.setLong(7, bean.father_e_id);
                    ps.setString(8, bean.big_img_url);
                    ps.setString(9, bean.small_img_url);
                    ps.setInt(10, bean.is_show);
                    ps.setInt(11, bean.type);
                    ps.setInt(12, bean.img_num);
                    ps.setTimestamp(13, new Timestamp(bean.ctime.getTime()));
                    ps.setString(14, bean.note);
                    ps.setInt(15, bean.is_del);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_evaluate> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_evaluate> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del FROM "+TABLENAME2+" ORDER BY e_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_evaluate>(Wx_evaluate.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_evaluate>();
        }
    }

    //查询最新数据
    public List<Wx_evaluate> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_evaluate> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del FROM "+TABLENAME2+" ORDER BY e_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_evaluate>(Wx_evaluate.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_evaluate>();
        }
    }

    //根据主键查询
    public List<Wx_evaluate> selectGtKey(long e_id) {
        return selectGtKey(e_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_evaluate> selectGtKey(long e_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del FROM "+TABLENAME2+" WHERE e_id>:e_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("e_id", e_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_evaluate>(Wx_evaluate.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_evaluate>();
        }
    }

    //根据主键查询
    public Wx_evaluate selectByKey(long e_id) {
        return selectByKey(e_id, TABLENAME);
    }

    //根据主键查询
    public Wx_evaluate selectByKey(long e_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del FROM "+TABLENAME2+" WHERE e_id=:e_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("e_id", e_id);
            List<Wx_evaluate> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_evaluate>(Wx_evaluate.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey e_id="+e_id,e);
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
    public List<Wx_evaluate> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_evaluate> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT e_id,order_id,g_id,ui_id,nickname,avatar,content,father_e_id,big_img_url,small_img_url,is_show,type,img_num,ctime,note,is_del FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_evaluate>(Wx_evaluate.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_evaluate>();
        }
    }

    //修改数据
    public int updateByKey(Wx_evaluate bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_evaluate bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET order_id=:order_id,g_id=:g_id,ui_id=:ui_id,nickname=:nickname,avatar=:avatar,content=:content,father_e_id=:father_e_id,big_img_url=:big_img_url,small_img_url=:small_img_url,is_show=:is_show,type=:type,img_num=:img_num,ctime=:ctime,note=:note,is_del=:is_del WHERE e_id=:e_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_evaluate> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_evaluate> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET order_id=?,g_id=?,ui_id=?,nickname=?,avatar=?,content=?,father_e_id=?,big_img_url=?,small_img_url=?,is_show=?,type=?,img_num=?,ctime=?,note=?,is_del=? WHERE e_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_evaluate bean = beans.get(i);
                    ps.setString(1, bean.order_id);
                    ps.setLong(2, bean.g_id);
                    ps.setLong(3, bean.ui_id);
                    ps.setString(4, bean.nickname);
                    ps.setString(5, bean.avatar);
                    ps.setString(6, bean.content);
                    ps.setLong(7, bean.father_e_id);
                    ps.setString(8, bean.big_img_url);
                    ps.setString(9, bean.small_img_url);
                    ps.setInt(10, bean.is_show);
                    ps.setInt(11, bean.type);
                    ps.setInt(12, bean.img_num);
                    ps.setTimestamp(13, new Timestamp(bean.ctime.getTime()));
                    ps.setString(14, bean.note);
                    ps.setInt(15, bean.is_del);
                    ps.setLong(16, bean.e_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long e_id) throws SQLException{
        return deleteByKey(e_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long e_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE e_id=:e_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("e_id", e_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE e_id=?";
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
                 "	`e_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`order_id`  VARCHAR(80) COMMENT '//varchar(80)    订单号'," +
                 "	`g_id`  BIGINT(20) COMMENT '//bigint(20)    商品主键ID'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`nickname`  VARCHAR(60) COMMENT '//varchar(60)    用户昵称'," +
                 "	`avatar`  VARCHAR(150) COMMENT '//varchar(150)    用户头像'," +
                 "	`content`  TINYTEXT COMMENT '//varchar(255)    评价内容'," +
                 "	`father_e_id`  BIGINT(20) COMMENT '//bigint(20)    追加父评价ID'," +
                 "	`big_img_url`  TINYTEXT COMMENT '//varchar(500)    大图片URL逗号分割'," +
                 "	`small_img_url`  TINYTEXT COMMENT '//varchar(500)    小图片URL逗号分割'," +
                 "	`is_show`  INT(11) COMMENT '//int(11)    是否显示0：显示1：不显示'," +
                 "	`type`  INT(11) COMMENT '//int(11)    评价类型0：好评1：中评2：差评'," +
                 "	`img_num`  INT(11) COMMENT '//int(11)    图片张数'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除:0：不删除1：删除'," +
                 "	PRIMARY KEY (`e_id`)" +
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
