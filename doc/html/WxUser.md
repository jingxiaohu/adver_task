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
#### 4->获取我推荐的人
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/read_my_tj](/goods/read_my_tj)
###### 返回结果
```json
{
	"data":[
		{
			"area":"四川:成都",
			"attention_state":"0",
			"avatar":"http://wx.qlogo.cn/mmopen/PiajxSqBRaELfh04A2Jtl6aiaWHiaxmD8wLUy8Jg4tc3uDGT92Qujnsa7JC5L9hiamicJZoPWA2G3WCCmlmtqfVyB1Q/0",
			"ctime":"1513253735000",
			"g_logo_url":"",
			"is_forbidden":"0",
			"is_partner":"0",
			"level":"0",
			"name":"",
			"nickname":"X.hell",
			"note":"",
			"recommend_code":"538931",
			"recommend_id":"1",
			"recommend_nickname":"tom",
			"recommend_num":"0",
			"score":"0",
			"sex":"1",
			"telephone":"",
			"ticket":"",
			"token":"78a486543244dcea93d41ad1f2efdd3b",
			"ui_id":"2",
			"user_weixin":"",
			"utime":"1512377252000",
			"vc":"0",
			"weixin_id":"oA_cb0kgkRifepbeNlzO3kf7tL1U",
			"weixin_no":"20171204164732-84982412199482767"
		}
	],
	"errorcode":"",
	"errormsg":"获取合伙人的收益汇总成功",
	"errorno":"0"
}

```
#### 5->获取用户个人信息-openid
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|openid|用户微信对应平台的openid|是|无|字符串|oA_cb0jLCM68XRZMlQ5Z_VHX5onI|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/user_info_openid](/goods/user_info_openid)
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
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id|用户主键ID|long|
|avatar|用户头像|String|
|nickname|用户昵称|String|
|weixin_no|用户微信对应公众号的唯一ID（openid）|String|
|weixin_id|用户微信ID|String|
|vc|余额单位分|int|
|score|积分|int|
|level|用户等级|int|
|recommend_num|用户推荐人数|int|
|is_partner|是否是合伙人0：不是1：是|int|
|ctime|创建时间|java.util.Date|
|utime|修改时间|java.util.Date|
|is_forbidden|是否禁用0：不1：禁用|int|
|telephone|用户提现绑定手机号码|String|
|name|用户提现真实姓名|String|
|note|备注|String|
|recommend_id|推荐我的人用户ID|long|
|recommend_nickname|推荐我的人用户昵称|String|
|recommend_code|我的推荐邀请码（六位数字）|String|
|token|用户登录刷新token|String|
|sex|用户性别0：未指定1：男2：女|int|
|area|用户地区（例如：广东省广州）|String|
|ticket|用户推荐微信内部tickt|String|
|attention_state|关注平台状态0：关注中1：未关注|int|
|user_weixin|用户微信号码|String|
|g_logo_url|商品logo图片|String|

