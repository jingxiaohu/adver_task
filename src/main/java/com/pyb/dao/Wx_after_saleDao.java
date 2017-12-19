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

//wx_after_sale

@Repository("wx_after_saleDao")
public class Wx_after_saleDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_after_saleDao.class);



    private  String TABLE = "wx_after_sale";

    private  String TABLENAME = "wx_after_sale";

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


    private  String[] carrays ={"as_id","type","sales_return","sales_return_intro","refund_money","img_urls","notice","allow_refund_money","refund_info","ctime","ui_id","order_id","g_id","dispose_type","dispose_state","note","is_del"};
    private  String coulmns ="as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del";
    private  String coulmns2 ="as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,order_id,g_id,dispose_type,dispose_state,note,is_del";

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
    public int insert(Wx_after_sale bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_after_sale bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,order_id,g_id,dispose_type,dispose_state,note,is_del) VALUES (:as_id,:type,:sales_return,:sales_return_intro,:refund_money,:img_urls,:notice,:allow_refund_money,:refund_info,:ctime,:order_id,:g_id,:dispose_type,:dispose_state,:note,:is_del)";
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
    public int insert_primarykey(Wx_after_sale bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_after_sale bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del) VALUES (:as_id,:type,:sales_return,:sales_return_intro,:refund_money,:img_urls,:notice,:allow_refund_money,:refund_info,:ctime,:ui_id,:order_id,:g_id,:dispose_type,:dispose_state,:note,:is_del)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_after_sale> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_after_sale> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,order_id,g_id,dispose_type,dispose_state,note,is_del) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_after_sale bean = beans.get(i);
                    ps.setLong(0, bean.as_id);
                    ps.setInt(1, bean.type);
                    ps.setInt(2, bean.sales_return);
                    ps.setString(3, bean.sales_return_intro);
                    ps.setInt(4, bean.refund_money);
                    ps.setString(5, bean.img_urls);
                    ps.setString(6, bean.notice);
                    ps.setInt(7, bean.allow_refund_money);
                    ps.setString(8, bean.refund_info);
                    ps.setTimestamp(9, new Timestamp(bean.ctime.getTime()));
                    ps.setString(11, bean.order_id);
                    ps.setLong(12, bean.g_id);
                    ps.setInt(13, bean.dispose_type);
                    ps.setInt(14, bean.dispose_state);
                    ps.setString(15, bean.note);
                    ps.setInt(16, bean.is_del);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_after_sale> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_after_sale> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del FROM "+TABLENAME2+" ORDER BY ui_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_after_sale>(Wx_after_sale.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_after_sale>();
        }
    }

    //查询最新数据
    public List<Wx_after_sale> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_after_sale> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del FROM "+TABLENAME2+" ORDER BY ui_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_after_sale>(Wx_after_sale.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_after_sale>();
        }
    }

    //根据主键查询
    public List<Wx_after_sale> selectGtKey(long ui_id) {
        return selectGtKey(ui_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_after_sale> selectGtKey(long ui_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del FROM "+TABLENAME2+" WHERE ui_id>:ui_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ui_id", ui_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_after_sale>(Wx_after_sale.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_after_sale>();
        }
    }

    //根据主键查询
    public Wx_after_sale selectByKey(long ui_id) {
        return selectByKey(ui_id, TABLENAME);
    }

    //根据主键查询
    public Wx_after_sale selectByKey(long ui_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del FROM "+TABLENAME2+" WHERE ui_id=:ui_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("ui_id", ui_id);
            List<Wx_after_sale> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_after_sale>(Wx_after_sale.class));
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
    public List<Wx_after_sale> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_after_sale> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT as_id,type,sales_return,sales_return_intro,refund_money,img_urls,notice,allow_refund_money,refund_info,ctime,ui_id,order_id,g_id,dispose_type,dispose_state,note,is_del FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_after_sale>(Wx_after_sale.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_after_sale>();
        }
    }

    //修改数据
    public int updateByKey(Wx_after_sale bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_after_sale bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET as_id=:as_id,type=:type,sales_return=:sales_return,sales_return_intro=:sales_return_intro,refund_money=:refund_money,img_urls=:img_urls,notice=:notice,allow_refund_money=:allow_refund_money,refund_info=:refund_info,ctime=:ctime,order_id=:order_id,g_id=:g_id,dispose_type=:dispose_type,dispose_state=:dispose_state,note=:note,is_del=:is_del WHERE ui_id=:ui_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_after_sale> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_after_sale> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET as_id=?,type=?,sales_return=?,sales_return_intro=?,refund_money=?,img_urls=?,notice=?,allow_refund_money=?,refund_info=?,ctime=?,order_id=?,g_id=?,dispose_type=?,dispose_state=?,note=?,is_del=? WHERE ui_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_after_sale bean = beans.get(i);
                    ps.setLong(0, bean.as_id);
                    ps.setInt(1, bean.type);
                    ps.setInt(2, bean.sales_return);
                    ps.setString(3, bean.sales_return_intro);
                    ps.setInt(4, bean.refund_money);
                    ps.setString(5, bean.img_urls);
                    ps.setString(6, bean.notice);
                    ps.setInt(7, bean.allow_refund_money);
                    ps.setString(8, bean.refund_info);
                    ps.setTimestamp(9, new Timestamp(bean.ctime.getTime()));
                    ps.setString(11, bean.order_id);
                    ps.setLong(12, bean.g_id);
                    ps.setInt(13, bean.dispose_type);
                    ps.setInt(14, bean.dispose_state);
                    ps.setString(15, bean.note);
                    ps.setInt(16, bean.is_del);
                    ps.setLong(17, bean.ui_id);
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
                 "	`as_id`  BIGINT(20) COMMENT '//bigint(20)    '," +
                 "	`type`  INT(11) COMMENT '//int(11)    处理方式0：未指定1：退货退款2：换货3：退款（仅退款不退货）'," +
                 "	`sales_return`  INT(11) COMMENT '//int(11)    退货原因：0：未指定1：不想要了2：卖家缺货3：拍错了/订单信息错误4:其它'," +
                 "	`sales_return_intro`  TINYTEXT COMMENT '//varchar(500)    退款说明（选填）'," +
                 "	`refund_money`  INT(11) COMMENT '//int(11)    退款金额单位分'," +
                 "	`img_urls`  TINYTEXT COMMENT '//varchar(600)    上传凭证（图片集）'," +
                 "	`notice`  VARCHAR(150) COMMENT '//varchar(150)    提示信息（例如：你可以退款的最大金额为41.90）'," +
                 "	`allow_refund_money`  INT(11) COMMENT '//int(11)    允许退款最大金额单位分'," +
                 "	`refund_info`  TINYTEXT COMMENT '//varchar(500)    退款系统文字提示'," +
                 "	`ctime`  TIMESTAMP NOT NULL COMMENT '//timestamp    创建时间'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`order_id`  VARCHAR(80) COMMENT '//varchar(80)    订单号'," +
                 "	`g_id`  BIGINT(20) COMMENT '//bigint(20)    商品ID'," +
                 "	`dispose_type`  INT(11) COMMENT '//int(11)    处理状态：0：未处理1：已经查看不予处理2：已经查看预给予退款处理3：已经查看预给予退款退货处理4：已经看预给予换货处理'," +
                 "	`dispose_state`  INT(11) COMMENT '//int(11)    处理退款进度：0：无1：已经调用微信支付退款完毕2：已经调用微信支付退款且退货完毕3：已经进行换货处理完毕'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除:0：不删除1：删除'," +
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
