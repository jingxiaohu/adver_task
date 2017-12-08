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

//wx_goods

@Repository("wx_goodsDao")
public class Wx_goodsDao extends BaseDao{

    Logger log = LoggerFactory.getLogger(Wx_goodsDao.class);



    private  String TABLE = "wx_goods";

    private  String TABLENAME = "wx_goods";

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


    private  String[] carrays ={"g_id","name","price_new","price_old","express_price","stock_num","dimension","market_num","evaluate_num","hp_num","zp_num","cp_num","st_num","logo_url","banner_urls","intro","src_intro","hp_percent","express","is_bestseller","is_timelimit","is_recommend","is_promotion","is_postage","is_new","gt_id","is_show","is_putaway","order_num","order_pay_num","is_sellout","modify_admin_id","create_admin_id","ctime","utime","note","is_del","clothing"};
    private  String coulmns ="g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing";
    private  String coulmns2 ="name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing";

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
    public int insert(Wx_goods bean) throws SQLException{
        return insert(bean, TABLENAME);
    }

    //添加数据
    public int insert(Wx_goods bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing) VALUES (:name,:price_new,:price_old,:express_price,:stock_num,:dimension,:market_num,:evaluate_num,:hp_num,:zp_num,:cp_num,:st_num,:logo_url,:banner_urls,:intro,:src_intro,:hp_percent,:express,:is_bestseller,:is_timelimit,:is_recommend,:is_promotion,:is_postage,:is_new,:gt_id,:is_show,:is_putaway,:order_num,:order_pay_num,:is_sellout,:modify_admin_id,:create_admin_id,:ctime,:utime,:note,:is_del,:clothing)";
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
    public int insert_primarykey(Wx_goods bean) throws SQLException{
        return insert_primarykey(bean, TABLENAME);
    }

    //添加数据
    public int insert_primarykey(Wx_goods bean, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing) VALUES (:g_id,:name,:price_new,:price_old,:express_price,:stock_num,:dimension,:market_num,:evaluate_num,:hp_num,:zp_num,:cp_num,:st_num,:logo_url,:banner_urls,:intro,:src_intro,:hp_percent,:express,:is_bestseller,:is_timelimit,:is_recommend,:is_promotion,:is_postage,:is_new,:gt_id,:is_show,:is_putaway,:order_num,:order_pay_num,:is_sellout,:modify_admin_id,:create_admin_id,:ctime,:utime,:note,:is_del,:clothing)";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("insert_primarykey", e);
            throw new SQLException("insert2 is error", e);
        }
    }

    //批量添加数据
    public int[] insert(List<Wx_goods> beans) throws SQLException{
        return insert(beans, TABLENAME);
    }

    //批量添加数据
    public int[] insert(final List<Wx_goods> beans, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "INSERT INTO "+TABLENAME2+" (name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods bean = beans.get(i);
                    ps.setString(1, bean.name);
                    ps.setInt(2, bean.price_new);
                    ps.setInt(3, bean.price_old);
                    ps.setString(4, bean.express_price);
                    ps.setInt(5, bean.stock_num);
                    ps.setString(6, bean.dimension);
                    ps.setInt(7, bean.market_num);
                    ps.setInt(8, bean.evaluate_num);
                    ps.setInt(9, bean.hp_num);
                    ps.setInt(10, bean.zp_num);
                    ps.setInt(11, bean.cp_num);
                    ps.setInt(12, bean.st_num);
                    ps.setString(13, bean.logo_url);
                    ps.setString(14, bean.banner_urls);
                    ps.setString(15, bean.intro);
                    ps.setString(16, bean.src_intro);
                    ps.setString(17, bean.hp_percent);
                    ps.setString(18, bean.express);
                    ps.setInt(19, bean.is_bestseller);
                    ps.setInt(20, bean.is_timelimit);
                    ps.setInt(21, bean.is_recommend);
                    ps.setInt(22, bean.is_promotion);
                    ps.setInt(23, bean.is_postage);
                    ps.setInt(24, bean.is_new);
                    ps.setLong(25, bean.gt_id);
                    ps.setInt(26, bean.is_show);
                    ps.setInt(27, bean.is_putaway);
                    ps.setInt(28, bean.order_num);
                    ps.setInt(29, bean.order_pay_num);
                    ps.setInt(30, bean.is_sellout);
                    ps.setLong(31, bean.modify_admin_id);
                    ps.setLong(32, bean.create_admin_id);
                    ps.setTimestamp(33, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(34, new Timestamp(bean.utime.getTime()));
                    ps.setString(35, bean.note);
                    ps.setInt(36, bean.is_del);
                    ps.setString(37, bean.clothing);
                }
            });
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("int[] insert", e);
            throw new SQLException("insert is error", e);
        }
    }

    //查询所有数据
    public List<Wx_goods> selectAll() {
        return selectAll(TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods> selectAll(String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing FROM "+TABLENAME2+" ORDER BY g_id";
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods>(Wx_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectAll", e);
            return new ArrayList<Wx_goods>();
        }
    }

    //查询最新数据
    public List<Wx_goods> selectLast(int num) {
        return selectLast(num, TABLENAME);
    }

    //查询所有数据
    public List<Wx_goods> selectLast(int num ,String TABLENAME2) {
        String sql;
        try{
            sql = "SELECT g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing FROM "+TABLENAME2+" ORDER BY g_id DESC LIMIT "+num+"" ;
            return _np.getJdbcOperations().query(sql, new BeanPropertyRowMapper<Wx_goods>(Wx_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectLast", e);
            return new ArrayList<Wx_goods>();
        }
    }

    //根据主键查询
    public List<Wx_goods> selectGtKey(long g_id) {
        return selectGtKey(g_id, TABLENAME);
    }

    //根据主键查询
    public List<Wx_goods> selectGtKey(long g_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing FROM "+TABLENAME2+" WHERE g_id>:g_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("g_id", g_id);
            return _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods>(Wx_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectGtKey", e);
            return new ArrayList<Wx_goods>();
        }
    }

    //根据主键查询
    public Wx_goods selectByKey(long g_id) {
        return selectByKey(g_id, TABLENAME);
    }

    //根据主键查询
    public Wx_goods selectByKey(long g_id, String TABLENAME2) {
        String sql;
        try{
            sql="SELECT g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing FROM "+TABLENAME2+" WHERE g_id=:g_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("g_id", g_id);
            List<Wx_goods> list =  _np.query(sql, param, new BeanPropertyRowMapper<Wx_goods>(Wx_goods.class));
            return (list == null || list.size() == 0) ? null : list.get(0);
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByKey g_id="+g_id,e);
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
    public List<Wx_goods> selectByPage(int begin, int num) {
        return selectByPage(begin, num, TABLENAME);
    }

    //分页查询
    public List<Wx_goods> selectByPage(int begin, int num, String TABLENAME2) {
        try{
            String sql;
            sql = "SELECT g_id,name,price_new,price_old,express_price,stock_num,dimension,market_num,evaluate_num,hp_num,zp_num,cp_num,st_num,logo_url,banner_urls,intro,src_intro,hp_percent,express,is_bestseller,is_timelimit,is_recommend,is_promotion,is_postage,is_new,gt_id,is_show,is_putaway,order_num,order_pay_num,is_sellout,modify_admin_id,create_admin_id,ctime,utime,note,is_del,clothing FROM "+TABLENAME2+" LIMIT "+begin+", "+num+"";
            return _np.getJdbcOperations().query(sql,new BeanPropertyRowMapper<Wx_goods>(Wx_goods.class));
        }catch(Exception e){
            //createTable(TABLENAME2);
            log.error("selectByPage",e);
            return new ArrayList<Wx_goods>();
        }
    }

    //修改数据
    public int updateByKey(Wx_goods bean) {
        return updateByKey(bean, TABLENAME);
    }

    //修改数据
    public int updateByKey(Wx_goods bean, String TABLENAME2) {
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET name=:name,price_new=:price_new,price_old=:price_old,express_price=:express_price,stock_num=:stock_num,dimension=:dimension,market_num=:market_num,evaluate_num=:evaluate_num,hp_num=:hp_num,zp_num=:zp_num,cp_num=:cp_num,st_num=:st_num,logo_url=:logo_url,banner_urls=:banner_urls,intro=:intro,src_intro=:src_intro,hp_percent=:hp_percent,express=:express,is_bestseller=:is_bestseller,is_timelimit=:is_timelimit,is_recommend=:is_recommend,is_promotion=:is_promotion,is_postage=:is_postage,is_new=:is_new,gt_id=:gt_id,is_show=:is_show,is_putaway=:is_putaway,order_num=:order_num,order_pay_num=:order_pay_num,is_sellout=:is_sellout,modify_admin_id=:modify_admin_id,create_admin_id=:create_admin_id,ctime=:ctime,utime=:utime,note=:note,is_del=:is_del,clothing=:clothing WHERE g_id=:g_id";
            SqlParameterSource ps = new BeanPropertySqlParameterSource(bean);
            return _np.update(sql, ps);
        }catch(Exception e){
            log.error("updateByKey",e);
            return 0;
        }
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods> beans) throws SQLException{
        return updateByKey(beans, TABLENAME);
    }

    //批量修改数据
    public int[] updateByKey (final List<Wx_goods> beans, String TABLENAME2) throws SQLException{
        try{
            String sql;
            sql = "UPDATE "+TABLENAME2+" SET name=?,price_new=?,price_old=?,express_price=?,stock_num=?,dimension=?,market_num=?,evaluate_num=?,hp_num=?,zp_num=?,cp_num=?,st_num=?,logo_url=?,banner_urls=?,intro=?,src_intro=?,hp_percent=?,express=?,is_bestseller=?,is_timelimit=?,is_recommend=?,is_promotion=?,is_postage=?,is_new=?,gt_id=?,is_show=?,is_putaway=?,order_num=?,order_pay_num=?,is_sellout=?,modify_admin_id=?,create_admin_id=?,ctime=?,utime=?,note=?,is_del=?,clothing=? WHERE g_id=?";
            return _np.getJdbcOperations().batchUpdate(sql, new BatchPreparedStatementSetter() {
                //@Override
                public int getBatchSize() {
                    return beans.size();
                }
                //@Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Wx_goods bean = beans.get(i);
                    ps.setString(1, bean.name);
                    ps.setInt(2, bean.price_new);
                    ps.setInt(3, bean.price_old);
                    ps.setString(4, bean.express_price);
                    ps.setInt(5, bean.stock_num);
                    ps.setString(6, bean.dimension);
                    ps.setInt(7, bean.market_num);
                    ps.setInt(8, bean.evaluate_num);
                    ps.setInt(9, bean.hp_num);
                    ps.setInt(10, bean.zp_num);
                    ps.setInt(11, bean.cp_num);
                    ps.setInt(12, bean.st_num);
                    ps.setString(13, bean.logo_url);
                    ps.setString(14, bean.banner_urls);
                    ps.setString(15, bean.intro);
                    ps.setString(16, bean.src_intro);
                    ps.setString(17, bean.hp_percent);
                    ps.setString(18, bean.express);
                    ps.setInt(19, bean.is_bestseller);
                    ps.setInt(20, bean.is_timelimit);
                    ps.setInt(21, bean.is_recommend);
                    ps.setInt(22, bean.is_promotion);
                    ps.setInt(23, bean.is_postage);
                    ps.setInt(24, bean.is_new);
                    ps.setLong(25, bean.gt_id);
                    ps.setInt(26, bean.is_show);
                    ps.setInt(27, bean.is_putaway);
                    ps.setInt(28, bean.order_num);
                    ps.setInt(29, bean.order_pay_num);
                    ps.setInt(30, bean.is_sellout);
                    ps.setLong(31, bean.modify_admin_id);
                    ps.setLong(32, bean.create_admin_id);
                    ps.setTimestamp(33, new Timestamp(bean.ctime.getTime()));
                    ps.setTimestamp(34, new Timestamp(bean.utime.getTime()));
                    ps.setString(35, bean.note);
                    ps.setInt(36, bean.is_del);
                    ps.setString(37, bean.clothing);
                    ps.setLong(38, bean.g_id);
                }
            });
        }catch(Exception e){
            log.error("int[] updateByKey",e);
            throw new SQLException("updateByKey is error", e);
        }
    }

    //删除单条数据
    public int deleteByKey(long g_id) throws SQLException{
        return deleteByKey(g_id, TABLENAME);
    }

    //删除单条数据
    public int deleteByKey(long g_id, String TABLENAME2) throws SQLException{
        String sql;
        try{
            sql = "DELETE FROM "+TABLENAME2+" WHERE g_id=:g_id";
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("g_id", g_id);
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
            sql = "DELETE FROM "+TABLENAME2+" WHERE g_id=?";
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
                 "	`g_id`  BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '//bigint(20)    主键ID'," +
                 "	`name`  VARCHAR(60) COMMENT '//varchar(60)    商品名称'," +
                 "	`price_new`  INT(11) COMMENT '//int(11)    商品卖价单位分'," +
                 "	`price_old`  INT(11) COMMENT '//int(11)    商品原价单位分'," +
                 "	`express_price`  VARCHAR(40) COMMENT '//varchar(40)    快递费用（区间）'," +
                 "	`stock_num`  INT(11) COMMENT '//int(11)    商品库存数量'," +
                 "	`dimension`  VARCHAR(20) COMMENT '//varchar(20)    商品量纲单位'," +
                 "	`market_num`  INT(11) COMMENT '//int(11)    商品销量'," +
                 "	`evaluate_num`  INT(11) COMMENT '//int(11)    评价总数量'," +
                 "	`hp_num`  INT(11) COMMENT '//int(11)    好评数量'," +
                 "	`zp_num`  INT(11) COMMENT '//int(11)    中评数量'," +
                 "	`cp_num`  INT(11) COMMENT '//int(11)    差评数量'," +
                 "	`st_num`  INT(11) COMMENT '//int(11)    晒图数量'," +
                 "	`logo_url`  VARCHAR(100) COMMENT '//varchar(100)    商品LOGO图片'," +
                 "	`banner_urls`  TINYTEXT COMMENT '//varchar(1000)    商品banner轮播图URL集合逗号分割'," +
                 "	`intro`  TINYTEXT COMMENT '//varchar(500)    商品简介'," +
                 "	`src_intro`  TINYTEXT COMMENT '//varchar(500)    商品来源简介'," +
                 "	`hp_percent`  VARCHAR(20) COMMENT '//varchar(20)    好评百分比(例如98%)'," +
                 "	`express`  VARCHAR(30) COMMENT '//varchar(30)    选定快递公司名称'," +
                 "	`is_bestseller`  INT(11) COMMENT '//int(11)    是否是热卖品0：不是1：是'," +
                 "	`is_timelimit`  INT(11) COMMENT '//int(11)    是否是限时抢购0：不限时1：限时'," +
                 "	`is_recommend`  INT(11) COMMENT '//int(11)    是否是推荐商品0：不是1：是'," +
                 "	`is_promotion`  INT(11) COMMENT '//int(11)    是否是促销商品0：不是1：是'," +
                 "	`is_postage`  INT(11) COMMENT '//int(11)    是否卖家包邮0：不是1：是'," +
                 "	`is_new`  INT(11) COMMENT '//int(11)    是否是新品上市0：不是1：是'," +
                 "	`gt_id`  BIGINT(20) COMMENT '//bigint(20)    商品所属类型表外键ID'," +
                 "	`is_show`  INT(11) COMMENT '//int(11)    是否显示0：不显示1：显示'," +
                 "	`is_putaway`  INT(11) COMMENT '//int(11)    是否正式上架购买0：不1：是'," +
                 "	`order_num`  INT(11) COMMENT '//int(11)    下单数量'," +
                 "	`order_pay_num`  INT(11) COMMENT '//int(11)    下单且支付数量'," +
                 "	`is_sellout`  INT(11) COMMENT '//int(11)    是否已售完0：不是1:是'," +
                 "	`modify_admin_id`  BIGINT(20) COMMENT '//bigint(20)    最后修改人员'," +
                 "	`create_admin_id`  BIGINT(20) COMMENT '//bigint(20)    商品创建人员'," +
                 "	`ctime`  TIMESTAMP COMMENT '//timestamp    创建时间'," +
                 "	`utime`  TIMESTAMP COMMENT '//timestamp    修改时间'," +
                 "	`note`  VARCHAR(60) COMMENT '//varchar(60)    备注'," +
                 "	`is_del`  INT(11) COMMENT '//int(11)    是否逻辑删除:0：不删除1：删除'," +
                 "	`clothing`  TINYTEXT COMMENT '//varchar(255)    服装类商品尺码颜色JSON{'size':[120,130,140,150],'color':['黄色','红色','蓝色']}'," +
                 "	PRIMARY KEY (`g_id`)" +
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
