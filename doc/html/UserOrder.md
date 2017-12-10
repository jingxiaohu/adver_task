[TOC]
### 订单管理模块
#### 1->获取用户订单列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|state|订单状态 0：待付款 1：待发货 2：待收货 3：已完成|是|无|整型|0|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_list](/goods/order_list)
###### 返回结果
```json
{
	"data":[
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1512904810000",
			"express_info":"",
			"express_time":"1512904810000",
			"freight_price":"1000",
			"g_id":"1",
			"g_logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
			"g_name":"橘子",
			"go_id":"4",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"money":"51",
			"name":"敬小虎",
			"note":"",
			"num":"2",
			"order_id":"2017121019201074573",
			"price":"4100",
			"ptime":"1512904810000",
			"recommend_id":"0",
			"state":"0",
			"stime":"1512904810000",
			"subtotal":"0",
			"telephone":"15882345446",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1512904353000",
			"express_info":"",
			"express_time":"1512904353000",
			"freight_price":"1000",
			"g_id":"1",
			"g_logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
			"g_name":"橘子",
			"go_id":"3",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"money":"51",
			"name":"敬小虎",
			"note":"",
			"num":"2",
			"order_id":"2017121019123350997",
			"price":"4100",
			"ptime":"1512904353000",
			"recommend_id":"0",
			"state":"0",
			"stime":"1512904353000",
			"subtotal":"0",
			"telephone":"15882345446",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1512904110000",
			"express_info":"",
			"express_time":"1512904110000",
			"freight_price":"1000",
			"g_id":"1",
			"g_logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
			"g_name":"橘子",
			"go_id":"2",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"money":"51",
			"name":"敬小虎",
			"note":"",
			"num":"2",
			"order_id":"2017121019083014318",
			"price":"4100",
			"ptime":"1512904110000",
			"recommend_id":"0",
			"state":"0",
			"stime":"1512904110000",
			"subtotal":"0",
			"telephone":"15882345446",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1512903975000",
			"express_info":"",
			"express_time":"1512903975000",
			"freight_price":"1000",
			"g_id":"1",
			"g_logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
			"g_name":"橘子",
			"go_id":"1",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"money":"51",
			"name":"敬小虎",
			"note":"",
			"num":"2",
			"order_id":"2017121019061509600",
			"price":"4100",
			"ptime":"1512903975000",
			"recommend_id":"0",
			"state":"0",
			"stime":"1512903975000",
			"subtotal":"0",
			"telephone":"15882345446",
			"ui_id":"1"
		}
	],
	"errorcode":"",
	"errormsg":"获取我的订单列表成功",
	"errorno":"0"
}

```
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|go_id|主键ID|long|
|order_id|订单号|String|
|g_id|商品表主键ID|long|
|ui_id|用户ID|long|
|price|商品单价|int|
|num|商品数量|int|
|express_info|快递信息（例如：已经签收收发室代收投递员：宋李鹏15608194018）|String|
|express_time|快递签收时间（2017-12-0116：49：35）|java.util.Date|
|address|收货地址（四川省成都市青羊区四川省成都市青羊区金丝街22号）|String|
|name|收货人姓名|String|
|telephone|收货人手机号码|String|
|subtotal|商品小计金额单位分|int|
|freight_price|运费单位分|int|
|money|实付金额（含运费）单位分|int|
|ctime|创建时间|java.util.Date|
|ptime|支付时间|java.util.Date|
|stime|发货时间|java.util.Date|
|is_after_sale|是否申请了售后0：没有1：有|int|
|is_pay|是否支付成功0：没有1：支付成功|int|
|state|订单状态0：待付款1：待发货2：待收货3：已完成|int|
|is_send|卖家是否发货0：没有1：已经发货|int|
|is_evaluate|是否待评价0：待评价1：已评价|int|
|note|备注|String|
|is_del|是否逻辑删除:0：不删除1：删除|int|
|recommend_id|我的推荐人用户ID|long|
|g_name|商品名称|String|
|g_logo_url|商品logo图片|String|


#### 2->用户取消订单
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|go_id|订单主键ID|否|无|长整型|1|
|order_id|订单编号|否|无|字符串|1|
| sign| MD5数字签名(ui_id+go_id+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_cancel](/goods/order_cancel)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"1",
	"errormsg":"订单不存在",
	"errorno":"1002"
}

```

#### 3->获取订单详情
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|go_id|订单主键ID|否|无|长整型|1|
|order_id|订单编号|否|无|字符串||
| sign| MD5数字签名(ui_id+go_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_info](/goods/order_info)
###### 返回结果
```json
{
	"data":	{
		"address":"四川省成都市龙泉驿区十陵灵龙路23号",
		"ctime":"1512903975000",
		"express_info":"",
		"express_time":"1512903975000",
		"freight_price":"1000",
		"g_id":"1",
		"g_logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
		"g_name":"橘子",
		"go_id":"1",
		"is_after_sale":"0",
		"is_del":"0",
		"is_evaluate":"0",
		"is_pay":"0",
		"is_send":"0",
		"money":"51",
		"name":"敬小虎",
		"note":"",
		"num":"2",
		"order_id":"2017121019061509600",
		"price":"4100",
		"ptime":"1512903975000",
		"recommend_id":"0",
		"state":"0",
		"stime":"1512903975000",
		"subtotal":"0",
		"telephone":"15882345446",
		"ui_id":"1"
	},
	"errorcode":"",
	"errormsg":"用户取消订单成功",
	"errorno":"0"
}

```
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|go_id|主键ID|long|
|order_id|订单号|String|
|g_id|商品表主键ID|long|
|ui_id|用户ID|long|
|price|商品单价|int|
|num|商品数量|int|
|express_info|快递信息（例如：已经签收收发室代收投递员：宋李鹏15608194018）|String|
|express_time|快递签收时间（2017-12-0116：49：35）|java.util.Date|
|address|收货地址（四川省成都市青羊区四川省成都市青羊区金丝街22号）|String|
|name|收货人姓名|String|
|telephone|收货人手机号码|String|
|subtotal|商品小计金额单位分|int|
|freight_price|运费单位分|int|
|money|实付金额（含运费）单位分|int|
|ctime|创建时间|java.util.Date|
|ptime|支付时间|java.util.Date|
|stime|发货时间|java.util.Date|
|is_after_sale|是否申请了售后0：没有1：有|int|
|is_pay|是否支付成功0：没有1：支付成功|int|
|state|订单状态0：待付款1：待发货2：待收货3：已完成|int|
|is_send|卖家是否发货0：没有1：已经发货|int|
|is_evaluate|是否待评价0：待评价1：已评价|int|
|note|备注|String|
|is_del|是否逻辑删除:0：不删除1：删除|int|
|recommend_id|我的推荐人用户ID|long|
|g_name|商品名称|String|
|g_logo_url|商品logo图片|String|


#### 4->用户商品下单
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|pay_price|充值金额或者商品价格总计 单位 分|否|无|整型|51|
|g_id|商品主键ID|否|无|长整型|1|
|address|收货地址|否|无|字符串|四川省成都市龙泉驿区十陵灵龙路23号|
|t|时间戳ms|否|无|长整型|1512909475849|
|openid|用户对于微信公众号APPID唯一ID|是|无|字符串|oA_cb0jLCM68XRZMlQ5Z_VHX5onI|
|num|商品购买数量|是|无|整型|2|
|name|收货人姓名|否|无|字符串|敬小虎|
|clothing|服装类商品尺码颜色JSON{"size":[ 120,130,140,150],"color":["黄色","红色","蓝色"]}|是|无|字符串|{"size":[ 120,130,140,150],"color":["黄色","红色","蓝色"]}|
|telephone|收货人电话号码|否|无|字符串|15882345446|
|type|用户token|是|无|整型|0|
|token|用户token|否|无|字符串|d7d87c21bedc6d236b1f77ca36c1a770|
| sign| MD5数字签名(dtype+ui_id+type+pay_price+t+token+g_id+num+telephone)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/weixin_charge_jsapi](/goods/weixin_charge_jsapi)
###### 返回结果
```json
{
	"data":	{
		"appid":"wxebee99b0aba36d8f",
		"mch_id":"1486469632",
		"nonce_str":"RE3FYq7OzY7rPvVw",
		"prepay_id":"wx2017121020375670d21f76940566124686",
		"result_code":"SUCCESS",
		"return_code":"SUCCESS",
		"return_msg":"OK",
		"sign":"589755DB84015C1BBA3E6A615FC77BB1",
		"trade_type":"JSAPI"
	},
	"errorcode":"",
	"errormsg":"微信充值成功",
	"errorno":"0"
}

```
