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

//wx_goods_order

@Repository("wx_goods_orderDao")
public class Wx_goods_orderDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_goods_orderDao.class);



    private  String TABLE = "wx_goods_order";

    private  String TABLENAME = "wx_goods_order";

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


    private  String[] carrays ={"go_id","order_id","g_id","ui_id","price","num","express_info","express_time","address","name","telephone","subtotal","freight_price","money","ctime","ptime","stime","is_after_sale","is_pay","state","is_send","is_evaluate","note","is_del","recommend_id","g_name","g_logo_url","transaction_id","clothing","gt_id"};
    private  String coulmns ="go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id";
    private  String coulmns2 ="order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id";

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
    public int insert(Wx_goods_order bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_goods_order bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id) VALUES (:order_id,:g_id,:ui_id,:price,:num,:express_info,:express_time,:address,:name,:telephone,:subtotal,:freight_price,:money,:ctime,:ptime,:stime,:is_after_sale,:is_pay,:state,:is_send,:is_evaluate,:note,:is_del,:recommend_id,:g_name,:g_logo_url,:transaction_id,:clothing,:gt_id)";
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
    public int insert_primarykey(Wx_goods_order bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_goods_order bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id) VALUES (:go_id,:order_id,:g_id,:ui_id,:price,:num,:express_info,:express_time,:address,:name,:telephone,:subtotal,:freight_price,:money,:ctime,:ptime,:stime,:is_after_sale,:is_pay,:state,:is_send,:is_evaluate,:note,:is_del,:recommend_id,:g_name,:g_logo_url,:transaction_id,:clothing,:gt_id)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_goods_order> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_goods_order> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods_order bean = beans.get(i);
                    ps.setString(1, bean.order_id);
                    ps.setLong(2, bean.g_id);
                    ps.setLong(3, bean.ui_id);
                    ps.setInt(4, bean.price);
                    ps.setInt(5, bean.num);
                    ps.setString(6, bean.express_info);
                    ps.setTimestamp(7, new Timestamp(bean.express_time.getTime()));
                    ps.setString(8, bean.address);
                    ps.setString(9, bean.name);
                    ps.setString(10, bean.telephone);
                    ps.setInt(11, bean.subtotal);
                    ps.setInt(12, bean.freight_price);
                    ps.setInt(13, bean.money);
                    ps.setTimestamp(14, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(15, new Timestamp(bean.ptime.getTime()));
                    ps.setTimestamp(16, new Timestamp(bean.stime.getTime()));
                    ps.setInt(17, bean.is_after_sale);
                    ps.setInt(18, bean.is_pay);
                    ps.setInt(19, bean.state);
                    ps.setInt(20, bean.is_send);
                    ps.setInt(21, bean.is_evaluate);
                    ps.setString(22, bean.note);
                    ps.setInt(23, bean.is_del);
                    ps.setLong(24, bean.recommend_id);
                    ps.setString(25, bean.g_name);
                    ps.setString(26, bean.g_logo_url);
                    ps.setString(27, bean.transaction_id);
                    ps.setString(28, bean.clothing);
                    ps.setLong(29, bean.gt_id);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_goods_order> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods_order> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id FROM "+TABLENAME2+" ORDER BY go_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods_order>(Wx_goods_order.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_goods_order>();
        }
    }

    //查询最新数据
    public List<Wx_goods_order> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods_order> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id FROM "+TABLENAME2+" ORDER BY go_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods_order>(Wx_goods_order.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_goods_order>();
        }
    }

    //根据主键查询
    public List<Wx_goods_order> selectGtKey(long go_id) {
        return selectGtKey(go_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_goods_order> selectGtKey(long go_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id FROM "+TABLENAME2+" WHERE go_id>:go_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("go_id", go_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods_order>(Wx_goods_order.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_goods_order>();
        }
    }

    //根据主键查询
    public Wx_goods_order selectByKey(long go_id) {
        return selectByKey(go_id, TABLENAME);
    }

    //根据主键查询
    public Wx_goods_order selectByKey(long go_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id FROM "+TABLENAME2+" WHERE go_id=:go_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("go_id", go_id);
            List<Wx_goods_order> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods_order>(Wx_goods_order.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey go_id="+go_id,e);
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
    public List<Wx_goods_order> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_goods_order> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT go_id,order_id,g_id,ui_id,price,num,express_info,express_time,address,name,telephone,subtotal,freight_price,money,ctime,ptime,stime,is_after_sale,is_pay,state,is_send,is_evaluate,note,is_del,recommend_id,g_name,g_logo_url,transaction_id,clothing,gt_id FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_goods_order>(Wx_goods_order.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_goods_order>();
        }
    }

    //修改数据
    public int updateByKey(Wx_goods_order bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_goods_order bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET order_id=:order_id,g_id=:g_id,ui_id=:ui_id,price=:price,num=:num,express_info=:express_info,express_time=:express_time,address=:address,name=:name,telephone=:telephone,subtotal=:subtotal,freight_price=:freight_price,money=:money,ctime=:ctime,ptime=:ptime,stime=:stime,is_after_sale=:is_after_sale,is_pay=:is_pay,state=:state,is_send=:is_send,is_evaluate=:is_evaluate,note=:note,is_del=:is_del,recommend_id=:recommend_id,g_name=:g_name,g_logo_url=:g_logo_url,transaction_id=:transaction_id,clothing=:clothing,gt_id=:gt_id WHERE go_id=:go_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods_order> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods_order> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET order_id=?,g_id=?,ui_id=?,price=?,num=?,express_info=?,express_time=?,address=?,name=?,telephone=?,subtotal=?,freight_price=?,money=?,ctime=?,ptime=?,stime=?,is_after_sale=?,is_pay=?,state=?,is_send=?,is_evaluate=?,note=?,is_del=?,recommend_id=?,g_name=?,g_logo_url=?,transaction_id=?,clothing=?,gt_id=? WHERE go_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods_order bean = beans.get(i);
                    ps.setString(1, bean.order_id);
                    ps.setLong(2, bean.g_id);
                    ps.setLong(3, bean.ui_id);
                    ps.setInt(4, bean.price);
                    ps.setInt(5, bean.num);
                    ps.setString(6, bean.express_info);
                    ps.setTimestamp(7, new Timestamp(bean.express_time.getTime()));
                    ps.setString(8, bean.address);
                    ps.setString(9, bean.name);
                    ps.setString(10, bean.telephone);
                    ps.setInt(11, bean.subtotal);
                    ps.setInt(12, bean.freight_price);
                    ps.setInt(13, bean.money);
                    ps.setTimestamp(14, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(15, new Timestamp(bean.ptime.getTime()));
                    ps.setTimestamp(16, new Timestamp(bean.stime.getTime()));
                    ps.setInt(17, bean.is_after_sale);
                    ps.setInt(18, bean.is_pay);
                    ps.setInt(19, bean.state);
                    ps.setInt(20, bean.is_send);
                    ps.setInt(21, bean.is_evaluate);
                    ps.setString(22, bean.note);
                    ps.setInt(23, bean.is_del);
                    ps.setLong(24, bean.recommend_id);
                    ps.setString(25, bean.g_name);
                    ps.setString(26, bean.g_logo_url);
                    ps.setString(27, bean.transaction_id);
                    ps.setString(28, bean.clothing);
                    ps.setLong(29, bean.gt_id);
                    ps.setLong(30, bean.go_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long go_id) throws SQLException{
        return deleteByKey(go_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long go_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE go_id=:go_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("go_id", go_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE go_id=?";
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
                 "	`go_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`order_id`  VARCHAR(80) COMMENT '//varchar(80)    订单号'," +
                 "	`g_id`  BIGINT(20) COMMENT '//bigint(20)    商品表主键ID'," +
                 "	`ui_id`  BIGINT(20) COMMENT '//bigint(20)    用户ID'," +
                 "	`price`  INT(11) COMMENT '//int(11)    商品单价'," +
                 "	`num`  INT(11) COMMENT '//int(11)    商品数量'," +
                 "	`express_info`  TINYTEXT COMMENT '//varchar(255)    快递信息（例如：已经签收收发室代收投递员：宋李鹏15608194018）'," +
                 "	`express_time`  TIMESTAMP COMMENT '//timestamp    快递签收时间（2017-12-0116：49：35）'," +
                 "	`address`  TINYTEXT COMMENT '//varchar(255)    收货地址（四川省成都市青羊区四川省成都市青羊区金丝街22号）'," +
                 "	`name`  VARCHAR(30) COMMENT '//varchar(30)    收货人姓名'," +
                 "	`telephone`  VARCHAR(20) COMMENT '//varchar(20)    收货人手机号码'," +
                 "	`subtotal`  INT(11) COMMENT '//int(11)    商品小计金额单位分'," +
                 "	`freight_price`  INT(11) COMMENT '//int(11)    运费单位分'," +
                 "	`money`  INT(11) COMMENT '//int(11)    实付金额（含运费）单位分'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`ptime`  TIMESTAMP COMMENT '//timestamp    支付时间'," +
                 "	`stime`  TIMESTAMP COMMENT '//timestamp    发货时间'," +
                 "	`is_after_sale`  INT(11) COMMENT '//int(11)    是否申请了售后0：没有1：有'," +
                 "	`is_pay`  INT(11) COMMENT '//int(11)    是否支付成功0：没有1：支付成功'," +
                 "	`state`  INT(11) COMMENT '//int(11)    订单状态0：待付款1：待发货2：待收货3：已完成'," +
                 "	`is_send`  INT(11) COMMENT '//int(11)    卖家是否发货0：没有1：已经发货'," +
                 "	`is_evaluate`  INT(11) COMMENT '//int(11)    是否待评价0：待评价1：已评价'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除:0：不删除1：删除'," +
                 "	`recommend_id`  BIGINT(20) COMMENT '//bigint(20)    我的推荐人用户ID'," +
                 "	`g_name`  VARCHAR(150) COMMENT '//varchar(150)    商品名称'," +
                 "	`g_logo_url`  VARCHAR(200) COMMENT '//varchar(200)    商品logo图片'," +
                 "	`transaction_id`  VARCHAR(100) COMMENT '//varchar(100)    第三方交易单号'," +
                 "	`clothing`  TINYTEXT COMMENT '//varchar(255)    服装类商品尺码颜色JSON{'size':[120,130,140,150],'color':['黄色','红色','蓝色']}'," +
                 "	`gt_id`  BIGINT(20) COMMENT '//bigint(20)    商品类型ID'," +
                 "	PRIMARY KEY (`go_id`)" +
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
