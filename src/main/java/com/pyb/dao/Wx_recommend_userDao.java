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

//wx_recommend_user

@Repository("wx_recommend_userDao")
public class Wx_recommend_userDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_recommend_userDao.class);



    private  String TABLE = "wx_recommend_user";

    private  String TABLENAME = "wx_recommend_user";

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


    private  String[] carrays ={"ru_id","recommend_id","recommended_id","recommended_nickname","avatar","money","ctime","is_del","note"};
    private  String coulmns ="ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note";
    private  String coulmns2 ="recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note";

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
    public int insert(Wx_recommend_user bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_recommend_user bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note) VALUES (:recommend_id,:recommended_id,:recommended_nickname,:avatar,:money,:ctime,:is_del,:note)";
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
    public int insert_primarykey(Wx_recommend_user bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_recommend_user bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note) VALUES (:ru_id,:recommend_id,:recommended_id,:recommended_nickname,:avatar,:money,:ctime,:is_del,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_recommend_user> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_recommend_user> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note) VALUES (?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_recommend_user bean = beans.get(i);
                    ps.setLong(1, bean.recommend_id);
                    ps.setLong(2, bean.recommended_id);
                    ps.setString(3, bean.recommended_nickname);
                    ps.setString(4, bean.avatar);
                    ps.setInt(5, bean.money);
                    ps.setTimestamp(6, new Timestamp(bean.ctime.getTime()));
                    ps.setInt(7, bean.is_del);
                    ps.setString(8, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_recommend_user> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_recommend_user> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note FROM "+TABLENAME2+" ORDER BY ru_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_recommend_user>(Wx_recommend_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_recommend_user>();
        }
    }

    //查询最新数据
    public List<Wx_recommend_user> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_recommend_user> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note FROM "+TABLENAME2+" ORDER BY ru_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_recommend_user>(Wx_recommend_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_recommend_user>();
        }
    }

    //根据主键查询
    public List<Wx_recommend_user> selectGtKey(long ru_id) {
        return selectGtKey(ru_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_recommend_user> selectGtKey(long ru_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note FROM "+TABLENAME2+" WHERE ru_id>:ru_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ru_id", ru_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_recommend_user>(Wx_recommend_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_recommend_user>();
        }
    }

    //根据主键查询
    public Wx_recommend_user selectByKey(long ru_id) {
        return selectByKey(ru_id, TABLENAME);
    }

    //根据主键查询
    public Wx_recommend_user selectByKey(long ru_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note FROM "+TABLENAME2+" WHERE ru_id=:ru_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ru_id", ru_id);
            List<Wx_recommend_user> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_recommend_user>(Wx_recommend_user.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey ru_id="+ru_id,e);
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
    public List<Wx_recommend_user> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_recommend_user> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT ru_id,recommend_id,recommended_id,recommended_nickname,avatar,money,ctime,is_del,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_recommend_user>(Wx_recommend_user.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_recommend_user>();
        }
    }

    //修改数据
    public int updateByKey(Wx_recommend_user bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_recommend_user bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET recommend_id=:recommend_id,recommended_id=:recommended_id,recommended_nickname=:recommended_nickname,avatar=:avatar,money=:money,ctime=:ctime,is_del=:is_del,note=:note WHERE ru_id=:ru_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_recommend_user> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_recommend_user> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET recommend_id=?,recommended_id=?,recommended_nickname=?,avatar=?,money=?,ctime=?,is_del=?,note=? WHERE ru_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_recommend_user bean = beans.get(i);
                    ps.setLong(1, bean.recommend_id);
                    ps.setLong(2, bean.recommended_id);
                    ps.setString(3, bean.recommended_nickname);
                    ps.setString(4, bean.avatar);
                    ps.setInt(5, bean.money);
                    ps.setTimestamp(6, new Timestamp(bean.ctime.getTime()));
                    ps.setInt(7, bean.is_del);
                    ps.setString(8, bean.note);
                    ps.setLong(9, bean.ru_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long ru_id) throws SQLException{
        return deleteByKey(ru_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long ru_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE ru_id=:ru_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ru_id", ru_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE ru_id=?";
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
                 "	`ru_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`recommend_id`  BIGINT(20) COMMENT '//bigint(20)    推荐人用户ID'," +
                 "	`recommended_id`  BIGINT(20) COMMENT '//bigint(20)    被推荐人用户ID'," +
                 "	`recommended_nickname`  VARCHAR(60) COMMENT '//varchar(60)    被推荐人用户昵称'," +
                 "	`avatar`  VARCHAR(200) COMMENT '//varchar(200)    被推荐人头像'," +
                 "	`money`  INT(11) COMMENT '//int(11)    被推荐人贡献给推荐人收益单位分'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除0：不1：是'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	PRIMARY KEY (`ru_id`)" +
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
