package pyb.com.spider;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    //判断，返回布尔值
    public static boolean isMobileNO(String mobiles) {
//			Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,1,3,5-9])|(17[0,1,3,5-9]))\\d{8}$");
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    @Test
    public void dd(){
        System.out.println(isMobileNO("17111111111"));
    }
}
