##四川拼一把内部接口在线文档
####访问基础地址：http://task.51pyb.com/v1/
#####测试的时候前缀：http://test.51pyb.com/v1/
####访问方式 GET/POST
##请求必传递参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| dtype| 从什么设备发出的请求 0:未指定  1: web  2:android  3:ios  4:QQ 5:微信 6:新浪  7:阿里  | 否| 无 |整型|
| ui_id| 用户ID | 否| 无 |字符串|
| ui_nd| 用户唯一标识符 | 否| 无 |字符串|
| token| 登陆后的令牌 | 否| 无 |字符串|
| sign| MD5参数签名串 | 否| 无 |字符串|
##请求接口返回结构
    {
        "data": "正确后的数据",
        "errorcode": "当errorno=0的时候 区分错误类别 例如：0: 用户不存在 1:用户余额不足 ",
        "errormsg": "错误信息",
        "errorno": "错误代码 0：正确  1：有错误"
    }


[1.用户管理接口文档](doc_new/user.html)
[2.笑话理接口文档](doc_new/Joke.html)
[3.消息管理接口文档](doc_new/Message.html)
[4.渠道管理接口文档](doc_new/Channel.html)

