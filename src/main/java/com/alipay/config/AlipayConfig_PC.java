package com.alipay.config;
import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig_PC
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig_PC {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016042501335250";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHiu16KGSOKgluiA8LpLddljHeCaCJWwExcg+UDLHZiiVZGrRtZxjsIsS9y0kdXDWET5S8pz0bohEVvIUiW5JgQqk601hoz7cjsSmR0ExIa3HeFq/h7JWfQXsqngWOwdK0fi6G5vZ+f9uVO18o9FHDO0ER6nSxk7f0B5SkmUTZxAwxEuV4EiBbHoalPscBvVoxGHHiw4FKO7iTIUg4H/E2tUS2eWjfTwAbvpO12olQNYnVcYGkTwqikYOrOAkoFbd33c56REucQfzT1euloZIM+GqVTvOoHj6xOEmHW3TnSdXLmWztNc5xb1bzgCO/7fnKw7p/+GRcIQQigAVC6v5tAgMBAAECggEAJGPFLCXKEWzxyU4YE/0uCZ84Vi9pfVcEc/z2d74MxaXULx7/T9v9EfCnt3jrcUl/SL2A5kFUI6YYRiit6bKCEvvyqUtykfkqZxe6XF57DHpkQMcAg3xcEzymT6PLRC9/XVv/K9K4XPAAyQj+nGUzymGPL7sthztsiMS8QJCxrnERMi0Zygu7xBBr54wiP84bWQCApi8NzhaJXcTemcndf1bIf91U9MdGu36tibQzVvtF0tJiKv63+v8hKt2vbDFzkforS8N26/hToLzhsK9RiZm1xxcDos+aE7NmkebWKnamenGWeEKWWXpX6zMHnw3n1GHuDQzoFdW7Dm4IWPM99QKBgQDg8wRtNhUeyFF/b/I4LxX+4DdsMD9is1lFx+LuVZvK5UKzMxsjhAIvfL4HovcDWHAythOX3/6pkvN8w+RSyzyuZlh/7tKu8hoPmbu8tW1sfH6vfoM7AiSJpeKtB1/eYDEzA1EBnAoVrr7ryMptX3ylwYF63gRVNwIrQRDCin1vDwKBgQCaQJG8lJuZceqFR+STMEoqFBuH/lLiQ8W4jgP1TvoDANpwtX54xfWvP2fGqM+/8gAUcL1bzQ9XxJkXnwSHgA9D4t0urp0XOV0rYcHNjLanPvrLchj0WQxchSpsmSmFIvf5D18H0I01qvLcXolEGmD2L+fu1sxOxiwtGxfkwmo6wwKBgQCxlCaycDdMDacIiz8Ty1f51NbruUrQh/S5eYpTy5EpIsL85CNQbi2rfzYkoSmOooov/jyJcHKBO1ir7ZiZI4fLxU+n7sizArxABISH/FFdiwoXUDAYrSBa6XGAVon/6r/sHXodYyky5LgjOmdS4EZuM8wbSpjxDHPR4ZNxgBJ1UQKBgGqs2tzK/SzKLkEMLhRoofGlxEBxbsqRygxPEoe0nYw0K90kdxl49ebDd7ZYiowZBVsdeKcjEkhFawZ973jx5ByzqPkewv8LqdZVndzUQoE5OeI2vvFFIBpf8a324lLzkwBIVBUocm+6EIi8TDuv7nxzNvfizppvzJ9JDGYk2ahXAoGAZ3rvOzynpKpr5URe6rGDj2TqLGxYWj7PxEcAmU4zXQz7HOAI4f/OYm/sdtwVsCht0b0PVx7Q3MGiIIu2LTCNCWNzhFFobtRdk3uHBiawdfFUy6ylMiE9qwqlKrGTWeykhIIkRmBRYxpxHMyoaAf70UlnGR0xkc8BblVRAYnNw1M=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjqDJh/7P5FE8kF9BR1M+2YLvga0eYPMOdz31WTvYAJjeGFQP5gTOCUe34KSJGi8+OSNmLmEJnswgH9QZ7VhQlnKcBTH++b9ShRUBFPjgCPG/MZ7tVeKPTHpwjIzmXrJDC8NeKn2ABe9c6tOqeK0yjj67GBV+egSbMwD7akpntf5pKad/me4Fr3BpUODjwdQ5YrtKUsdTCed7MKrMmtW2adYWAlx0IanAxnf6QoBkwQ01uhNm5d++wkT1g99aOUcB3SGu7UovuZh9T7pU483qEQ3bGNTt8/Uvlb1A0qAdbfqZgRTS31NIQINcApq+ChM7rj4/4V52DpkeNSP2NUh1iwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\temp";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

