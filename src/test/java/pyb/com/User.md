[[_TOC_]]
### 用户管理模块
#### 1->用户发送验证码
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|verify_list|md5(tel+code)|是|无|class java.lang.String||
|vclass|固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡|是|无|class java.lang.String|1|
|tel|用户手机号码 或者 邮箱|否|无|class java.lang.String|307881141@qq.com|
|type|类型（0:未指定 1:邮箱 2:手机）|是|无|class java.lang.Integer|1|
| sign| MD5数字签名(dtype+tel+vclass)按参数的首字母升序顺序进行组装| 否| 无 |字符串|
#### 请求路径
[/v1/sendcode](/v1/sendcode)
###### 返回结果
```json
{
	result:[
		{
			carport_space:"15"
			carport_total:"120"
			carport_yet:"105"
			juli:"1480.0"
			lat:"28.88549"
			lng:"105.45148"
			park_state:"warning"
			pi_name:"洪洋农贸市场地下车库"
			pi_state:"1"
		},
		{
			carport_space:"3"
			carport_total:"3"
			carport_yet:"1"
			juli:"2959.0"
			lat:"28.89549"
			lng:"105.46148"
			park_state:"free"
			pi_name:"万年场停车场"
			pi_state:"1"
		}
	]
}

```
