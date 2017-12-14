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

//wx_order_goods

@Repository("wx_order_goodsDao")
public class Wx_order_goodsDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_order_goodsDao.class);



    private  String TABLE = "wx_order_goods";

    private  String TABLENAME = "wx_order_goods";

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


    private  String[] carrays ={"og_id","ui_id","order_id","g_id","price","num","subtotal","freight_price","money","g_name","g_logo_url","clothing","gt_id","is_del","ctime","note"};
    private  String coulmns ="og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note";
    private  String coulmns2 ="ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note";

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
    public int insert(Wx_order_goods bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_order_goods bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note) VALUES (:ui_id,:order_id,:g_id,:price,:num,:subtotal,:freight_price,:money,:g_name,:g_logo_url,:clothing,:gt_id,:is_del,:ctime,:note)";
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
    public int insert_primarykey(Wx_order_goods bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_order_goods bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note) VALUES (:og_id,:ui_id,:order_id,:g_id,:price,:num,:subtotal,:freight_price,:money,:g_name,:g_logo_url,:clothing,:gt_id,:is_del,:ctime,:note)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_order_goods> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_order_goods> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_order_goods bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.order_id);
                    ps.setLong(3, bean.g_id);
                    ps.setInt(4, bean.price);
                    ps.setInt(5, bean.num);
                    ps.setInt(6, bean.subtotal);
                    ps.setInt(7, bean.freight_price);
                    ps.setInt(8, bean.money);
                    ps.setString(9, bean.g_name);
                    ps.setString(10, bean.g_logo_url);
                    ps.setString(11, bean.clothing);
                    ps.setLong(12, bean.gt_id);
                    ps.setInt(13, bean.is_del);
                    ps.setTimestamp(14, new Timestamp(bean.ctime.getTime()));
                    ps.setString(15, bean.note);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_order_goods> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_order_goods> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note FROM "+TABLENAME2+" ORDER BY og_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_order_goods>(Wx_order_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_order_goods>();
        }
    }

    //查询最新数据
    public List<Wx_order_goods> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_order_goods> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note FROM "+TABLENAME2+" ORDER BY og_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_order_goods>(Wx_order_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_order_goods>();
        }
    }

    //根据主键查询
    public List<Wx_order_goods> selectGtKey(long og_id) {
        return selectGtKey(og_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_order_goods> selectGtKey(long og_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note FROM "+TABLENAME2+" WHERE og_id>:og_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("og_id", og_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_order_goods>(Wx_order_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_order_goods>();
        }
    }

    //根据主键查询
    public Wx_order_goods selectByKey(long og_id) {
        return selectByKey(og_id, TABLENAME);
    }

    //根据主键查询
    public Wx_order_goods selectByKey(long og_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note FROM "+TABLENAME2+" WHERE og_id=:og_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("og_id", og_id);
            List<Wx_order_goods> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_order_goods>(Wx_order_goods.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey og_id="+og_id,e);
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
    public List<Wx_order_goods> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_order_goods> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT og_id,ui_id,order_id,g_id,price,num,subtotal,freight_price,money,g_name,g_logo_url,clothing,gt_id,is_del,ctime,note FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_order_goods>(Wx_order_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_order_goods>();
        }
    }

    //修改数据
    public int updateByKey(Wx_order_goods bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_order_goods bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=:ui_id,order_id=:order_id,g_id=:g_id,price=:price,num=:num,subtotal=:subtotal,freight_price=:freight_price,money=:money,g_name=:g_name,g_logo_url=:g_logo_url,clothing=:clothing,gt_id=:gt_id,is_del=:is_del,ctime=:ctime,note=:note WHERE og_id=:og_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_order_goods> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_order_goods> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET ui_id=?,order_id=?,g_id=?,price=?,num=?,subtotal=?,freight_price=?,money=?,g_name=?,g_logo_url=?,clothing=?,gt_id=?,is_del=?,ctime=?,note=? WHERE og_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_order_goods bean = beans.get(i);
                    ps.setLong(1, bean.ui_id);
                    ps.setString(2, bean.order_id);
                    ps.setLong(3, bean.g_id);
                    ps.setInt(4, bean.price);
                    ps.setInt(5, bean.num);
                    ps.setInt(6, bean.subtotal);
                    ps.setInt(7, bean.freight_price);
                    ps.setInt(8, bean.money);
                    ps.setString(9, bean.g_name);
                    ps.setString(10, bean.g_logo_url);
                    ps.setString(11, bean.clothing);
                    ps.setLong(12, bean.gt_id);
                    ps.setInt(13, bean.is_del);
                    ps.setTimestamp(14, new Timestamp(bean.ctime.getTime()));
                    ps.setString(15, bean.note);
                    ps.setLong(16, bean.og_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long og_id) throws SQLException{
        return deleteByKey(og_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long og_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE og_id=:og_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("og_id", og_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE og_id=?";
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
                 "	`og_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`order_id`  VARCHAR(80) COMMENT '//varchar(80)    订单号'," +
                 "	`g_id`  BIGINT(20) COMMENT '//bigint(20)    商品表主键ID'," +
                 "	`price`  INT(11) COMMENT '//int(11)    商品单价'," +
                 "	`num`  INT(11) COMMENT '//int(11)    商品数量'," +
                 "	`subtotal`  INT(11) COMMENT '//int(11)    商品小计金额单位分'," +
                 "	`freight_price`  INT(11) COMMENT '//int(11)    运费单位分'," +
                 "	`money`  INT(11) COMMENT '//int(11)    实付金额（含运费）单位分'," +
                 "	`g_name`  VARCHAR(150) COMMENT '//varchar(150)    商品名称'," +
                 "	`g_logo_url`  VARCHAR(200) COMMENT '//varchar(200)    商品logo图片'," +
                 "	`clothing`  TINYTEXT COMMENT '//varchar(255)    服装类商品尺码颜色JSON{'size':[120,130,140,150],'color':['黄色','红色','蓝色']}'," +
                 "	`gt_id`  BIGINT(20) COMMENT '//bigint(20)    商品类型ID'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除:0：不删除1：删除'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	PRIMARY KEY (`og_id`)" +
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
