package pyb.com;

import com.pyb.constants.Constants;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * web容器基础测试类
 *
 * @author Peter Wu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/config/spring/spring.xml","file:src/main/webapp/WEB-INF/config/spring/dispatcher-servlet.xml"})
public abstract class BaseWebTest {

  public static String basepath = "D:/my_java_project/wypyb_task/src/test/java/pyb/com/";

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private WebApplicationContext context;

  protected MockMvc mockMvc;


  @Before
  public void setup() throws Exception {
	  //MockMultipartHttpServletRequestBuilder
//    mockMvc = webAppContextSetup(context).build();
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }


  /**
   * 从什么设备发出的请求 0:android 1:ios  2:web
   */
  protected   String dtype = "1";//从什么设备发出的请求 0:未指定  1: web  2:android  3:ios  4:QQ 5:微信 6:新浪  7:阿里
  private String ui_id="1";//用户ID
  private String ui_nd="2017072815195331778";//用户UUID
  private int vnum=1;//当前内部版本号
  private String token="559a778edef011aeeaabc210de0e615e";//用户登陆后的令牌

  public  MultiValueMap<String, String> params = null;
  public MultiValueMap<String, String> getParams() {
    if(params == null){
      params = new LinkedMultiValueMap<>();
    }
    params.add("dtype",dtype);
    params.add("ui_id",ui_id);
    params.add("ui_nd",ui_nd);
    params.add("vnum",vnum+"");
    params.add("token",token);
    return params;
  }
  /**
   * @param requestParams 请求参数
   * @param paramNames 参与签名的参数名，为空表示所有非空字段
   */
  protected void sign(MultiValueMap<String, String> requestParams, String... paramNames) {
    List<String> values = new ArrayList<>();
    for (String key : requestParams.keySet()) {
      if ((ArrayUtils.isNotEmpty(paramNames) && !ArrayUtils.contains(paramNames, key))) {
        continue;
      }
      List<String> objects = requestParams.get(key);
      if (key.equalsIgnoreCase("sign")
          || key.equalsIgnoreCase("sign_type")) {
        continue;
      }

      for (String object : objects) {
        String str = String.valueOf(object);
        if (str != null && !str.equals("")) {
          try {
//            values.add(URLEncoder.encode(str, "UTF-8"));
        	  values.add(str);
          } catch (Exception ignored) {
            //			never throw
          }
        }
      }
    }
    Collections.sort(values);
    StringBuilder paramValue = new StringBuilder();
    for (Object param : values) {
      paramValue.append(param);
    }
    paramValue.append(Constants.SYSTEM_KEY_WEB);
    String paramStr = paramValue.toString();
    log.info("待签名字符串：{}", paramStr);
    String sign = DigestUtils.md5DigestAsHex(paramStr.getBytes());
    requestParams.add("sign", sign);
  }

}
