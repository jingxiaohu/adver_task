[TOC]
### 用户管理模块
#### 1->取用户基本信息
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/user_info](/goods/user_info)
###### 返回结果
```json
{
	"data":	{
		"area":"四川:成都",
		"attention_state":"0",
		"avatar":"http://wx.qlogo.cn/mmopen/lAc4GXjRfWluedaaDbHD5AbUgEFbNGlvR3xfKRsLcVoPsMp4U9d0XKlshbPFW86L1jN2QmjLJjEXVncGCUaw8A7hEayctA9n/0",
		"ctime":"1512803357000",
		"g_logo_url":"",
		"is_forbidden":"0",
		"is_partner":"0",
		"level":"0",
		"name":"",
		"nickname":"tom",
		"note":"",
		"recommend_code":"065387",
		"recommend_id":"0",
		"recommend_nickname":"",
		"recommend_num":"0",
		"score":"0",
		"sex":"1",
		"telephone":"",
		"ticket":"",
		"token":"d7d87c21bedc6d236b1f77ca36c1a770",
		"ui_id":"1",
		"user_weixin":"",
		"utime":"1512373749000",
		"vc":"0",
		"weixin_id":"oA_cb0jLCM68XRZMlQ5Z_VHX5onI",
		"weixin_no":"20171204154909-18205228126080618"
	},
	"errorcode":"",
	"errormsg":"获取用户信息成功",
	"errorno":"0"
}

```

#### 2->申请成为推荐合作人
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/apply_user](/goods/apply_user)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"1",
	"errormsg":"已经是合作人了",
	"errorno":"1002"
}

```

#### 3->获取推荐合作人
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/read_cooperator](/goods/read_cooperator)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"",
	"errormsg":"获取合伙人的收益汇总成功",
	"errorno":"0"
}

```
