package com.pyb.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * app 属性
 *
 * @author Peter Wu
 */
@Component
public class AppProperties {


  private static String domain;
  private static String baseDir;

  @Value("${app.domain}")
  public void setDomain(String domain) {
    AppProperties.domain = domain;
  }

  @Value("${app.baseDir}")
  public void setBaseDir(String baseDir) {
    AppProperties.baseDir = baseDir;
  }

  /**
   * @return APP服务器访问域名
   */
  public static String getDomain() {
    return domain;
  }

  /**
   * @return 访问根地址
   */
  public static String getBaseUrl() {
    return "http://" + domain + "/file/";
  }

  /**
   * @return 文件存放的根地址
   */
  public static String getBaseDir() {
    return baseDir;
  }
}
