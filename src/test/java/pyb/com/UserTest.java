package pyb.com;

import apidoc.jxh.cn.InterfaceUtil;
import com.pyb.mvc.action.v1.user.param.Param_External_login;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 用户测试
 *
 * @author Peter Wu
 */
public class UserTest extends BaseWebTest {
	public String moduleName = "用户管理模块";

  /**
   * 用户发送验证码例子：
   * <pre>
   *   {"data":{"verify_list":"a6a23bd50f6a1e70ba93e4f4a2194f8b","resend_time":"120","tel":"251878350@qq.com"},"errorcode":"","errormsg":"发送成功!","errorno":"0"}
   * </pre>
   */
  @Test
  public void sendCode() throws Exception {
	String tel = "307881141@qq.com";
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("dtype", dtype);
    params.add("tel",tel );
    params.add("vclass", "1");//固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡
    params.add("type", 1+"");//类型（0:未指定 1:邮箱 2:手机）
    
    sign(params, "dtype", "tel", "vclass");
    
    
    
   MvcResult mvcResult = mockMvc.perform(post("/v1/sendcode").params(params))
        .andExpect(status().isOk()).andReturn();
    String result = mvcResult.getResponse().getContentAsString();
    System.err.println(result);
//    String result = "{\"result\":[{\"pi_name\":\"洪洋农贸市场地下车库\",\"carport_total\":120,\"carport_yet\":105,\"carport_space\":15,\"lng\":105.45148,\"lat\":28.88549,\"park_state\":\"warning\",\"pi_state\":1,\"juli\":1480.0},{\"pi_name\":\"万年场停车场\",\"carport_total\":3,\"carport_yet\":1,\"carport_space\":3,\"lng\":105.46148,\"lat\":28.89549,\"park_state\":\"free\",\"pi_state\":1,\"juli\":2959.0}]}";
//    String path = this.getClass().getResource(".").getPath();
//	  String path = basepath+"User.md";
//    InterfaceUtil.AddInterfacePred(path, moduleName, "用户发送验证码", "dtype+tel+vclass", "/v1/sendcode", 1, params, Param_sendcode.class,result);
  }

  
  
  /**
   * 用户重发送验证码例子：
   * <pre>
   * {"data":"","errorcode":"","errormsg":"请间隔120秒后发送验证码!","errorno":"1002"}
   * </pre>
   */
  @Test
  public void resendcode() throws Exception {
	    String tel = "251878350@qq.com";
	    String verify_list=DigestUtils.md5DigestAsHex((tel+"187992").getBytes());//由发送验证码接口或者重新发送验证码接口返回的verify_list参数的值  md5(tel+code)
		
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("dtype", dtype);
	    params.add("tel",tel );
	    params.add("vclass", "1");//固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡
	    params.add("verify_list",verify_list );//md5(tel+code)
	    params.add("type", 1+"");//类型（0:未指定 1:邮箱 2:手机）
	    
	    sign(params, "dtype", "tel", "vclass","verify_list");
    
    MvcResult mvcResult = mockMvc.perform(post("/v1/resendcode").params(params))
        .andExpect(status().isOk()).andReturn();
    System.err.println(mvcResult.getResponse().getContentAsString());
  }
  
  
  /**
   * 用户注册例子：
   * <pre>
   * {"data":{"ctime":1500180577424,"is_vip":0,"note":"","ui_avtar":"","ui_bind_tel":"251878350@qq.com","ui_email":"251878350@qq.com","ui_flag":2,"ui_id":1,"ui_lock":0,"ui_name":"","ui_nd":"2017071612493744156","ui_nickname":"m3pdkDN6","ui_password":"123456","ui_reg_type":1,"ui_release":0,"ui_sex":0,"ui_sign":0,"ui_task":0,"ui_tel":"251878350@qq.com","ui_tj":0,"ui_token":"78cd4ce76d37a0c0fc29ff4a6ba53ce2","ui_vc":0,"ui_wx":"","ui_zfb":"","utime":1500180577422},"errorcode":"","errormsg":"注册成功","errorno":"0"}
   * </pre>
   */
  @Test
  public void user_reg() throws Exception {
	String verify_code="364942";//用户验证码
	String verify_list="3382982e4fd4c6a9aeb2349627c25ab2";//由发送验证码接口或者重新发送验证码接口返回的verify_list参数的值  md5(tel+code)
	String tel = "251878350@qq.com";
	String password = "123456";
	String vclass = "1";
	String reg_type="1";//注册类型（0:未指定 1:邮箱 2:手机）
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("dtype", dtype);
    params.add("tel",tel );
    params.add("vclass", vclass);//固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡
    params.add("verify_list", DigestUtils.md5DigestAsHex((tel+verify_code).getBytes()));//md5(tel+code)
    params.add("verify_code", verify_code);
    params.add("password", DigestUtils.md5DigestAsHex(password.getBytes()));
    params.add("reg_type", reg_type);
    sign(params, "dtype", "tel", "vclass","verify_code","verify_list","password");
    
    MvcResult mvcResult = mockMvc.perform(post("/v1/reg").params(params))
        .andExpect(status().isOk()).andReturn();
    System.err.println(mvcResult.getResponse().getContentAsString());
  }
  
  
  /**
   * 用户登陆例子：
   * <pre>
   * {"data":{"ctime":1500180577000,"is_vip":0,"note":"","ui_avtar":"","ui_bind_tel":"251878350@qq.com","ui_email":"251878350@qq.com","ui_flag":2,"ui_id":1,"ui_lock":0,"ui_name":"","ui_nd":"2017071612493744156","ui_nickname":"m3pdkDN6","ui_password":"e10adc3949ba59abbe56e057f20f883e","ui_reg_type":1,"ui_release":0,"ui_sex":0,"ui_sign":0,"ui_task":0,"ui_tel":"251878350@qq.com","ui_tj":0,"ui_token":"78cd4ce76d37a0c0fc29ff4a6ba53ce2","ui_vc":0,"ui_wx":"","ui_zfb":"","utime":1500180577000},"errorcode":"","errormsg":"登录成功","errorno":"0"}
   * </pre>
   */
  @Test
  public void user_login() throws Exception {
	String tel = "251878350@qq.com";
	String password = "123456";
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("dtype", dtype);
    params.add("tel",tel );
    params.add("password", DigestUtils.md5DigestAsHex(password.getBytes()));
    sign(params, "dtype", "tel","password");
    
    MvcResult mvcResult = mockMvc.perform(post("/v1/login").params(params))
        .andExpect(status().isOk()).andReturn();
    System.err.println(mvcResult.getResponse().getContentAsString());
  }

    /**
     * 第三方用户登陆例子：
     * <pre>
     * {"data":{"ctime":1500180577000,"is_vip":0,"note":"","ui_avtar":"","ui_bind_tel":"251878350@qq.com","ui_email":"251878350@qq.com","ui_flag":2,"ui_id":1,"ui_lock":0,"ui_name":"","ui_nd":"2017071612493744156","ui_nickname":"m3pdkDN6","ui_password":"e10adc3949ba59abbe56e057f20f883e","ui_reg_type":1,"ui_release":0,"ui_sex":0,"ui_sign":0,"ui_task":0,"ui_tel":"251878350@qq.com","ui_tj":0,"ui_token":"78cd4ce76d37a0c0fc29ff4a6ba53ce2","ui_vc":0,"ui_wx":"","ui_zfb":"","utime":1500180577000},"errorcode":"","errormsg":"登录成功","errorno":"0"}
     * </pre>
     */
    @Test
    public void external_login() throws Exception {
         String avtar="";//头像
         String nickname="";//昵称
         int sex=0;//性别
        //第三方登录
         Integer up_type=4;//用户账户类型 来源0:未指定1:web2:android 3:ios 4:QQ 5:微信 6:新浪 7:阿里,
         String up_token="";//外部TOKEN
         String up_key="";//外部KEY
        MultiValueMap<String, String> params = getParams();
        params.add("avtar",avtar );
        params.add("nickname",nickname);
        params.add("sex",sex+"" );
        params.add("up_type",up_type+"");
        params.add("up_token",up_token );
        params.add("up_key",up_key);
        sign(params, "dtype", "up_type","up_token","up_key");

        MvcResult mvcResult = mockMvc.perform(post("/v1/external_login").params(params))
                .andExpect(status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.err.println(result);
        String path = this.getClass().getResource(".").getPath();
        path = path + "User.md";
        InterfaceUtil.AddInterfacePred(path, moduleName,
                "第三方用户登陆",
                "dtype+up_type+up_token+up_key",
                "/v1/external_login",
                2,
                params,
                Param_External_login.class,
                result);
    }
  
  /**
   * 用户修改属性例子：
   * <pre>
   * {"data":{"ctime":1500180577000,"is_vip":0,"note":"","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_26080.jpg","ui_bind_tel":"251878350@qq.com","ui_email":"251878350@qq.com","ui_flag":2,"ui_id":1,"ui_lock":0,"ui_name":"敬小虎","ui_nd":"2017071612493744156","ui_nickname":"小虎","ui_password":"e10adc3949ba59abbe56e057f20f883e","ui_reg_type":1,"ui_release":0,"ui_sex":1,"ui_sign":0,"ui_task":0,"ui_tel":"251878350@qq.com","ui_tj":0,"ui_token":"78cd4ce76d37a0c0fc29ff4a6ba53ce2","ui_vc":0,"ui_wx":"","ui_zfb":"","utime":1500180577000},"errorcode":"","errormsg":"更改用户基本信息成功","errorno":"0"}
   * </pre>
   */
  @Test
  public void change_userinfo() throws Exception {
	String sex = "1";//用户性别 0:未知 1:男 2:女
	String name = "敬小虎";//真实姓名
	String password = "123456";
	String ui_id="1";
	String nickname="小虎";
	String email = "251878350@qq.com";//备用邮箱
	
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("dtype", dtype);
    params.add("ui_id", ui_id);
    
    params.add("name",name );
    params.add("email",email );
    params.add("sex",sex );
    params.add("nickname",nickname );
    params.add("password", DigestUtils.md5DigestAsHex(password.getBytes()));
    sign(params, "dtype", "ui_id");
    //用户头像
    File file = new File("D:\\Camera\\IMG_20121202_213841.jpg");
    FileInputStream fis = new FileInputStream(file);
    MockMultipartFile avatar_file = new MockMultipartFile("avatar","IMG_20121202_213841.jpg","image/jpeg",fis);
    
    
    MvcResult mvcResult = mockMvc.perform(fileUpload("/v1/change_userinfo").file(avatar_file).params(params))
            .andExpect(status().isOk()).andReturn();
    System.err.println(mvcResult.getResponse().getContentAsString());
  }


  
  /**
   * 用户修改密码例子：
   * <pre>
   * {"data":{"ctime":1500180577000,"is_vip":0,"note":"","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_26080.jpg","ui_bind_tel":"251878350@qq.com","ui_email":"251878350@qq.com","ui_flag":2,"ui_id":1,"ui_lock":0,"ui_name":"敬小虎","ui_nd":"2017071612493744156","ui_nickname":"小虎","ui_password":"25d55ad283aa400af464c76d713c07ad","ui_reg_type":1,"ui_release":0,"ui_sex":1,"ui_sign":0,"ui_task":0,"ui_tel":"251878350@qq.com","ui_tj":0,"ui_token":"559a778edef011aeeaabc210de0e615e","ui_vc":0,"ui_wx":"","ui_zfb":"","utime":1500302818956},"errorcode":"","errormsg":"更改密码成功","errorno":"0"}
   * </pre>
   */
  @Test
  public void modify_password() throws Exception {
	String old_password = "123456";
	String new_password = "12345678";
	String ui_id="1";
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("dtype", dtype);
    params.add("ui_id", ui_id);
    
    params.add("old_password", DigestUtils.md5DigestAsHex(old_password.getBytes()));
    params.add("new_password", DigestUtils.md5DigestAsHex(new_password.getBytes()));
    sign(params, "dtype", "ui_id","old_password","new_password");
    
    MvcResult mvcResult = mockMvc.perform(post("/v1/modify_password").params(params))
        .andExpect(status().isOk()).andReturn();
    System.err.println(mvcResult.getResponse().getContentAsString());
  }
  
  
  /**
   * 获取用户基本信息例子：
   * <pre>
   * {"data":{"ctime":1500180577000,"is_vip":0,"note":"","ui_avtar":"http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_26080.jpg","ui_bind_tel":"251878350@qq.com","ui_email":"251878350@qq.com","ui_flag":2,"ui_id":1,"ui_lock":0,"ui_name":"敬小虎","ui_nd":"2017071612493744156","ui_nickname":"小虎","ui_password":"25d55ad283aa400af464c76d713c07ad","ui_reg_type":1,"ui_release":0,"ui_sex":1,"ui_sign":0,"ui_task":0,"ui_tel":"251878350@qq.com","ui_tj":0,"ui_token":"559a778edef011aeeaabc210de0e615e","ui_vc":0,"ui_wx":"","ui_zfb":"","utime":1500302819000},"errorcode":"","errormsg":"读取我的信息成功","errorno":"0"}
   * </pre>
   */
  @Test
  public void read_myinfo() throws Exception {
	String ui_id="1";
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("dtype", dtype);
    params.add("ui_id", ui_id);
    
    sign(params, "dtype", "ui_id");
    
    MvcResult mvcResult = mockMvc.perform(post("/v1/read_myinfo").params(params))
        .andExpect(status().isOk()).andReturn();
    System.err.println(mvcResult.getResponse().getContentAsString());
  }

}
