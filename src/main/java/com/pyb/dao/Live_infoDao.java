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

//live_info

@Repository("live_infoDao")
public class Live_infoDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Live_infoDao.class);



    private  String TABLE = "live_info";

    private  String TABLENAME = "live_info";

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


    private  String[] carrays ={"mi_id","ui_id","mi_title","mi_content","mi_type","mi_image","mi_flag","mi_day","mi_createtime","mi_area","ci_id","title_md5","uptime","note"};
    private  String coulmns ="mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note";
    private  String coulmns2 ="ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note";

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
    public int insert(Live_info bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Live_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note) VALUES (:ui_id,:mi_title,:mi_content,:mi_type,:mi_image,:mi_flag,:mi_day,:mi_createtime,:mi_area,:ci_id,:title_md5,:uptime,:note)";
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
    public int insert_primarykey(Live_info bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Live_info bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note) VALUES (:mi_id,:ui_id,:mi_title,:mi_content,:mi_type,:mi_image,:mi_flag,:mi_day,:mi_createtime,:mi_area,:ci_id,:title_md5,:uptime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Live_info> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Live_info> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Live_info bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.mi_title);
                    ps.setString(3, bean.mi_content);
                    ps.setString(4, bean.mi_type);
                    ps.setString(5, bean.mi_image);
                    ps.setInt(6, bean.mi_flag);
                    ps.setString(7, bean.mi_day);
                    ps.setTimestamp(8, new Timestamp(bean.mi_createtime.getTime()));
                    ps.setInt(9, bean.mi_area);
                    ps.setLong(10, bean.ci_id);
                    ps.setString(11, bean.title_md5);
                    ps.setString(12, bean.uptime);
                    ps.setString(13, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Live_info> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Live_info> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note FROM "+TABLENAME2+" ORDER BY mi_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Live_info>(Live_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Live_info>();
        }
    }

    //查询最新数据
    public List<Live_info> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Live_info> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note FROM "+TABLENAME2+" ORDER BY mi_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Live_info>(Live_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Live_info>();
        }
    }

    //根据主键查询
    public List<Live_info> selectGtKey(long mi_id) {
        return selectGtKey(mi_id, TABLENAME);
    }

    //根据主键查询
    public List<Live_info> selectGtKey(long mi_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note FROM "+TABLENAME2+" WHERE mi_id>:mi_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("mi_id", mi_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Live_info>(Live_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Live_info>();
        }
    }

    //根据主键查询
    public Live_info selectByKey(long mi_id) {
        return selectByKey(mi_id, TABLENAME);
    }

    //根据主键查询
    public Live_info selectByKey(long mi_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note FROM "+TABLENAME2+" WHERE mi_id=:mi_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("mi_id", mi_id);
            List<Live_info> list =  _np.query(sql, param, new BeanPropertyRowMapper<Live_info>(Live_info.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey mi_id="+mi_id,e);
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
    public List<Live_info> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Live_info> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT mi_id,ui_id,mi_title,mi_content,mi_type,mi_image,mi_flag,mi_day,mi_createtime,mi_area,ci_id,title_md5,uptime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Live_info>(Live_info.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Live_info>();
        }
    }

    //修改数据
    public int updateByKey(Live_info bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Live_info bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,mi_title=:mi_title,mi_content=:mi_content,mi_type=:mi_type,mi_image=:mi_image,mi_flag=:mi_flag,mi_day=:mi_day,mi_createtime=:mi_createtime,mi_area=:mi_area,ci_id=:ci_id,title_md5=:title_md5,uptime=:uptime,note=:note WHERE mi_id=:mi_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Live_info> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Live_info> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,mi_title=?,mi_content=?,mi_type=?,mi_image=?,mi_flag=?,mi_day=?,mi_createtime=?,mi_area=?,ci_id=?,title_md5=?,uptime=?,note=? WHERE mi_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Live_info bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.mi_title);
                    ps.setString(3, bean.mi_content);
                    ps.setString(4, bean.mi_type);
                    ps.setString(5, bean.mi_image);
                    ps.setInt(6, bean.mi_flag);
                    ps.setString(7, bean.mi_day);
                    ps.setTimestamp(8, new Timestamp(bean.mi_createtime.getTime()));
                    ps.setInt(9, bean.mi_area);
                    ps.setLong(10, bean.ci_id);
                    ps.setString(11, bean.title_md5);
                    ps.setString(12, bean.uptime);
                    ps.setString(13, bean.note);
                    ps.setLong(14, bean.mi_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long mi_id) throws SQLException{
        return deleteByKey(mi_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long mi_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE mi_id=:mi_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("mi_id", mi_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE mi_id=?";
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
                 "	`mi_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    '," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    创建用户'," +
                 "	`mi_title`  TINYTEXT COMMENT '//varchar(300)    消息标题'," +
                 "	`mi_content`  TEXT COMMENT '//text    消息内容'," +
                 "	`mi_type`  VARCHAR(10) COMMENT '//varchar(10)    标记消息类型0:原创1:评论'," +
                 "	`mi_image`  VARCHAR(250) COMMENT '//varchar(250)    消息图片'," +
                 "	`mi_flag`  INT(11) COMMENT '//int(11)    信息来源的标记0Web1Android2Iphone3PC客服端4新浪5腾讯6人人'," +
                 "	`mi_day`  VARCHAR(30) COMMENT '//varchar(30)    年月日：2016-03-01'," +
                 "	`mi_createtime`  DATETIME COMMENT '//datetime    创建时间'," +
                 "	`mi_area`  INT(11) COMMENT '//int(11)    帖子发送目标地方：0自己看1：广播'," +
                 "	`ci_id`  BIGINT(20) COMMENT '//bigint(20)    房间号'," +
                 "	`title_md5`  VARCHAR(200) COMMENT '//varchar(200)    标题的MD5'," +
                 "	`uptime`  VARCHAR(60) COMMENT '//varchar(60)    抓取的更新时间'," +
                 "	`note`  TINYTEXT COMMENT '//varchar(255)    '," +
                 "	PRIMARY KEY (`mi_id`)" +
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
