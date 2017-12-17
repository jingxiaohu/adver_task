[TOC]
### 收货地址管理模块
#### 1->新增地址
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|ua_id|主键ID|是|无|长整型||
|area|所在地区（四川省 成都市  龙泉驿区）|否|无|字符串|四川省成都市龙泉驿区|
|address|详细地址|否|无|字符串|十陵灵龙路218号|
|name|用户名字|否|无|字符串|敬小虎|
|telephone|电话号码|否|无|字符串|15882345446|
|is_defaut|是否设置为默认地址 0：不是  1:是|是|无|整型|1|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/add_address](/goods/add_address)
###### 返回结果
```json
{
	"data":	{
		"address":"十陵灵龙路218号",
		"area":"四川省成都市龙泉驿区",
		"ctime":"1513494912996",
		"is_defaut":"1",
		"name":"敬小虎",
		"note":"",
		"telephone":"15882345446",
		"ua_id":"1",
		"ui_id":"1"
	},
	"errorcode":"",
	"errormsg":"新增地址成功",
	"errorno":"0"
}

```
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ua_id|主键ID|long|
|ui_id|用户ID|long|
|name|收件人|String|
|telephone|联系电话|String|
|area|所在地区（四川省成都市龙泉驿区）|String|
|address|详细地址|String|
|ctime|创建时间|java.util.Date|
|note|备注|String|
|is_defaut|是否设置为默认地址0：不是1:是|int|



#### 2->修改地址
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|ua_id|主键ID|是|无|长整型|1|
|area|所在地区（四川省 成都市  龙泉驿区）|否|无|字符串|四川省成都市龙泉驿区|
|address|详细地址|否|无|字符串|十陵灵龙路218号|
|name|用户名字|否|无|字符串|敬小虎|
|telephone|电话号码|否|无|字符串|15882345446|
|is_defaut|是否设置为默认地址 0：不是  1:是|是|无|整型|1|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/up_address](/goods/up_address)
###### 返回结果
```json
{
	"data":	{
		"address":"十陵灵龙路218号",
		"area":"四川省成都市龙泉驿区",
		"ctime":"1513494912000",
		"is_defaut":"1",
		"name":"敬小虎",
		"note":"",
		"telephone":"15882345446",
		"ua_id":"1",
		"ui_id":"1"
	},
	"errorcode":"",
	"errormsg":"修改地址成功",
	"errorno":"0"
}

```
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|ua_id|主键ID|long|
|ui_id|用户ID|long|
|name|收件人|String|
|telephone|联系电话|String|
|area|所在地区（四川省成都市龙泉驿区）|String|
|address|详细地址|String|
|ctime|创建时间|java.util.Date|
|note|备注|String|
|is_defaut|是否设置为默认地址0：不是1:是|int|


#### 3->设置为默认地址
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|ua_id|主键ID|是|无|长整型|1|
|is_defaut|是否设置为默认地址 0：不是  1:是|是|无|整型|1|
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/isdefault_address](/goods/isdefault_address)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"",
	"errormsg":"设置为默认地址成功",
	"errorno":"0"
}

```

#### 4->删除地址
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|ua_id|主键ID|是|无|长整型|1|
|is_defaut|是否设置为默认地址 0：不是  1:是|是|无|整型||
| sign| MD5数字签名(ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/del_address](/goods/del_address)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"",
	"errormsg":"删除地址成功",
	"errorno":"0"
}

```
