[TOC]
### 订单管理模块
#### 1->用户商品下单
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|address|收货地址|否|无|字符串|四川省成都市龙泉驿区十陵灵龙路23号|
|goods_list|商品列表JSONARRAY数组字符串[{"clothing":"{\"size\":[ 120,130,140,150],\"color\":[\"黄色\",\"红色\",\"蓝色\"]}","g_id":1,"num":2,"pay_price":51}]|是|无|字符串|[{"clothing":"{\"size\":[ 120,130,140,150],\"color\":[\"黄色\",\"红色\",\"蓝色\"]}","g_id":1,"num":2,"pay_price":51}]|
|t|时间戳ms|否|无|长整型|1513266349545|
|openid|用户对于微信公众号APPID唯一ID|是|无|字符串|oA_cb0jLCM68XRZMlQ5Z_VHX5onI|
|name|收货人姓名|否|无|字符串|敬小虎|
|telephone|收货人电话号码|否|无|字符串|15882345446|
|type|是支付 还是 充值  0:订单支付 1：充值|是|无|整型|0|
|token|用户token|否|无|字符串|d7d87c21bedc6d236b1f77ca36c1a770|
| sign| MD5数字签名(dtype+ui_id+type+t+token+telephone)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/weixin_charge_jsapi](/goods/weixin_charge_jsapi)
###### 返回结果
```json
{
	"data":	{
		"appid":"wxebee99b0aba36d8f",
		"mch_id":"1486469632",
		"nonce_str":"48IAhXrrvFFAA2WZ",
		"prepay_id":"wx20171214234551c05239662d0576944130",
		"result_code":"SUCCESS",
		"return_code":"SUCCESS",
		"return_msg":"OK",
		"sign":"E84E34C45D54B39A4155FF509FEA3380",
		"trade_type":"JSAPI"
	},
	"errorcode":"",
	"errormsg":"微信充值成功",
	"errorno":"0"
}

```

#### 2->获取用户订单列表
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
			"ctime":"1513265580000",
			"express_info":"",
			"express_time":"1513265580000",
			"freight_price":"500",
			"go_id":"7",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423330000367",
			"ptime":"1513265580000",
			"recommend_id":"0",
			"shipper_code":"",
			"shipper_name":"",
			"state":"0",
			"stime":"1513265580000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"1",
            "wx_pay_json":"{"nonce_str":"YAXGAgmrA5rc0qYn","appid":"wxebee99b0aba36d8f","sign":"08F20A062EA102393B96644C39AD8FE4","trade_type":"JSAPI","return_msg":"OK","result_code":"SUCCESS","mch_id":"1486469632","return_code":"SUCCESS","prepay_id":"wx20171230200231c13b0dab2a0603470458"}"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513265303000",
			"express_info":"",
			"express_time":"1513265303000",
			"freight_price":"500",
			"go_id":"6",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423282392998",
			"ptime":"1513265303000",
			"recommend_id":"0",
			"shipper_code":"",
			"shipper_name":"",
			"state":"0",
			"stime":"1513265303000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513265215000",
			"express_info":"",
			"express_time":"1513265215000",
			"freight_price":"500",
			"go_id":"5",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423265527173",
			"ptime":"1513265215000",
			"recommend_id":"0",
			"shipper_code":"",
			"shipper_name":"",
			"state":"0",
			"stime":"1513265215000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513264891000",
			"express_info":"",
			"express_time":"1513264891000",
			"freight_price":"500",
			"go_id":"4",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423213190135",
			"ptime":"1513264891000",
			"recommend_id":"0",
			"shipper_code":"",
			"shipper_name":"",
			"state":"0",
			"stime":"1513264891000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513264656000",
			"express_info":"",
			"express_time":"1513264656000",
			"freight_price":"500",
			"go_id":"3",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423173699860",
			"ptime":"1513264656000",
			"recommend_id":"0",
			"shipper_code":"",
			"shipper_name":"",
			"state":"0",
			"stime":"1513264656000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513264398000",
			"express_info":"",
			"express_time":"1513264398000",
			"freight_price":"500",
			"go_id":"2",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423131874066",
			"ptime":"1513264398000",
			"recommend_id":"0",
			"shipper_code":"",
			"shipper_name":"",
			"state":"0",
			"stime":"1513264398000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"1"
		},
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513264333000",
			"express_info":"",
			"express_time":"1513264333000",
			"freight_price":"500",
			"go_id":"1",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"0",
			"logistic_code":"9891649961956",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423121300935",
			"ptime":"1513264333000",
			"recommend_id":"0",
			"shipper_code":"YZPY",
			"shipper_name":"邮政快递",
			"state":"0",
			"stime":"1513264333000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
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
|ui_id|用户ID|long|
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
|transaction_id|第三方交易单号|String|
|logistic_code|快递单号|String|
|shipper_name|快递公司名称|String|
|shipper_code|快鸟-快递公司编码|String|







#### 3->用户取消订单
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|go_id|订单主键ID|否|无|长整型|1|
|order_id|订单编号|否|无|字符串|2017121423121300935|
| sign| MD5数字签名(ui_id+go_id+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_cancel](/goods/order_cancel)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"",
	"errormsg":"用户取消订单成功",
	"errorno":"0"
}

```

#### 4->获取订单详情
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
		"ctime":"1513264333000",
		"express_info":"",
		"express_time":"1513264333000",
		"freight_price":"500",
		"go_id":"1",
		"is_after_sale":"0",
		"is_del":"1",
		"is_evaluate":"0",
		"is_pay":"0",
		"is_send":"0",
		"logistic_code":"9891649961956",
		"money":"20000",
		"name":"敬小虎",
		"note":"",
		"order_id":"2017121423121300935",
		"ptime":"1513264333000",
		"recommend_id":"0",
		"shipper_code":"YZPY",
		"shipper_name":"邮政快递",
		"state":"0",
		"stime":"1513264333000",
		"subtotal":"0",
		"telephone":"15882345446",
		"transaction_id":"",
		"ui_id":"1"
	},
	"errorcode":"",
	"errormsg":"用户获取订单详情成功",
	"errorno":"0"
}

```
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|go_id|主键ID|long|
|order_id|订单号|String|
|ui_id|用户ID|long|
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
|transaction_id|第三方交易单号|String|
|logistic_code|快递单号|String|
|shipper_name|快递公司名称|String|
|shipper_code|快鸟-快递公司编码|String|



#### 5->获取用户订单对应商品列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|go_id|订单主键ID|否|无|长整型|1|
|order_id|订单编号|否|无|字符串||
| sign| MD5数字签名(ui_id+go_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_info_goods](/goods/order_info_goods)
###### 返回结果
```json
{
    "data": {
        "order_goods": [
            {
                "clothing": "{\"size\":[ 120,130,140,150],\"color\":[\"黄色\",\"红色\",\"蓝色\"]}",
                "ctime": 1513264333000,
                "freight_price": 0,
                "g_id": 1,
                "g_logo_url": "",
                "g_name": "衣服",
                "gt_id": 2,
                "is_del": 0,
                "money": 20000,
                "note": "",
                "num": 2,
                "og_id": 1,
                "order_id": "2017121423121300935",
                "price": 10000,
                "subtotal": 20000,
                "ui_id": 1
            }
        ],
        "order_info": {
            "address": "四川省成都市龙泉驿区十陵灵龙路23号",
            "ctime": 1513264333000,
            "express_info": "",
            "express_time": 1513264333000,
            "freight_price": 500,
            "go_id": 1,
            "is_after_sale": 0,
            "is_del": 1,
            "is_evaluate": 0,
            "is_pay": 0,
            "is_send": 0,
            "logistic_code": "9891649961956",
            "money": 20000,
            "name": "敬小虎",
            "note": "",
            "order_id": "2017121423121300935",
            "ptime": 1513264333000,
            "recommend_id": 0,
            "shipper_code": "YZPY",
            "shipper_name": "邮政快递",
            "state": 3,
            "stime": 1513264333000,
            "subtotal": 0,
            "telephone": "15882345446",
            "transaction_id": "",
            "ui_id": 1
        }
    },
    "errorcode": "",
    "errormsg": "获取用户订单对应商品列表成功",
    "errorno": "0"
}

```
#########返回字段order_info说明
|名称|描述|类型|
|----|----|---|
|go_id|主键ID|long|
|order_id|订单号|String|
|ui_id|用户ID|long|
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
|transaction_id|第三方交易单号|String|
|logistic_code|快递单号|String|
|shipper_name|快递公司名称|String|
|shipper_code|快鸟-快递公司编码|String|

#########返回字段order_goods说明
|名称|描述|类型|
|----|----|---|
|og_id|主键ID|long|
|ui_id|用户ID|long|
|order_id|订单号|String|
|g_id|商品表主键ID|long|
|price|商品单价|int|
|num|商品数量|int|
|subtotal|商品小计金额单位分|int|
|freight_price|运费单位分|int|
|money|实付金额（含运费）单位分|int|
|g_name|商品名称|String|
|g_logo_url|商品logo图片|String|
|clothing|服装类商品尺码颜色JSON{"size":[120,130,140,150],"color":["黄色","红色","蓝色"]}|String|
|gt_id|商品类型ID|long|
|is_del|是否逻辑删除:0：不删除1：删除|int|
|ctime|创建时间|java.util.Date|
|note|备注|String|




#### 6->获取订单快递信息列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|order_id|订单编号|否|无|字符串|2017121423121300935|
| sign| MD5数字签名(dtype+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/kdwl](/goods/kdwl)
###### 返回结果
```json
{
	"data":"{  'LogisticCode' : '9891649961956',  'ShipperCode' : 'YZPY',  'Traces' : [ {    'AcceptStation' : '【<a>江西省赣县邮政营销中心</a>】已收寄',    'AcceptTime' : '2017-11-28 18:48:24'  }, {    'AcceptStation' : '离开【赣县邮政营销中心】，下一站【赣县】',    'AcceptTime' : '2017-11-28 18:54:00'  }, {    'AcceptStation' : '到达【<a>赣州中心</a>】',    'AcceptTime' : '2017-11-28 19:51:44'  }, {    'AcceptStation' : '离开【赣州中心】，下一站【南昌中心】',    'AcceptTime' : '2017-11-28 22:10:58'  }, {    'AcceptStation' : '到达【<a>南昌中心</a>】',    'AcceptTime' : '2017-11-29 05:25:36'  }, {    'AcceptStation' : '离开【南昌中心】，下一站【成都中心】',    'AcceptTime' : '2017-11-29 21:08:02'  }, {    'AcceptStation' : '到达【<a>成都中心</a>】',    'AcceptTime' : '2017-12-01 01:20:19'  }, {    'AcceptStation' : '离开【成都中心】，下一站【龙泉驿】',    'AcceptTime' : '2017-12-01 05:36:20'  }, {    'AcceptStation' : '到达【<a>龙泉驿</a>】',    'AcceptTime' : '2017-12-01 07:31:42'  }, {    'AcceptStation' : '离开【龙泉驿】，下一站【龙泉十陵】',    'AcceptTime' : '2017-12-01 11:19:25'  }, {    'AcceptStation' : '【<a>龙泉驿区十陵投递</a>】接收',    'AcceptTime' : '2017-12-01 13:15:45'  }, {    'AcceptStation' : '【<a>龙泉驿区十陵投递</a>】正在投递,投递员：王槐志 18728538852',    'AcceptTime' : '2017-12-01 13:59:11'  }, {    'AcceptStation' : '已签收,万科金色城菜鸟驿站 代收,投递员：王槐志 18728538852 ',    'AcceptTime' : '2017-12-01 14:43:41'  } ],  'State' : '3',  'EBusinessID' : '1315771',  'Success' : true}",
	"errorcode":"",
	"errormsg":"用户获取订单快递物流情况成功",
	"errorno":"0"
}

```

#### 7->用户确认收货
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|go_id|订单主键ID|否|无|长整型|1|
|order_id|订单编号|否|无|字符串|2017121423121300935|
| sign| MD5数字签名(ui_id+go_id+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_sure](/goods/order_sure)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"",
	"errormsg":"用户确认收货成功",
	"errorno":"0"
}

```

#### 8->获取用户推广明细订单列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|state|订单状态 0：待付款 1：待发货 2：待收货 3：已完成|是|无|整型|0|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/recommend_order_list](/goods/recommend_order_list)
###### 返回结果
```json
{
	"data":[
		{
			"address":"四川省成都市龙泉驿区十陵灵龙路23号",
			"ctime":"1513266349000",
			"express_info":"",
			"express_time":"1513266349000",
			"freight_price":"500",
			"go_id":"10",
			"is_after_sale":"0",
			"is_del":"0",
			"is_evaluate":"0",
			"is_pay":"0",
			"is_send":"1",
			"logistic_code":"6903244675338",
			"money":"20000",
			"name":"敬小虎",
			"note":"",
			"order_id":"2017121423454961853",
			"ptime":"1513847475000",
			"recommend_id":"1",
			"shipper_code":"HHKD",
			"shipper_name":"华航快递",
			"state":"0",
			"stime":"1513266349000",
			"subtotal":"0",
			"telephone":"15882345446",
			"transaction_id":"",
			"ui_id":"2"
		}
	],
	"errorcode":"",
	"errormsg":"获取用户推广明细订单列表成功",
	"errorno":"0"
}

```
#########返回字段说明
|名称|描述|类型|
|----|----|---|
|go_id|主键ID|long|
|order_id|订单号|String|
|ui_id|用户ID|long|
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
|transaction_id|第三方交易单号|String|
|logistic_code|快递单号|String|
|shipper_name|快递公司名称|String|
|shipper_code|快鸟-快递公司编码|String|


#### 9->用户退货或者退款
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|sales_return_intro|退款说明（选填）|是|无|字符串||
|sales_return|退货原因：0：未指定1：不想要了2：卖家缺货3：拍错了/订单信息错误4:其它|否|无|整型|1|
|refund_info|退款系统文字提示|是|无|字符串||
|refund_money|退款金额单位分|是|无|整型||
|allow_refund_money|允许退款最大金额单位分|是|无|整型||
|type|处理方式0：未指定1：退货退款2：换货3：退款（仅退款不退货）|否|无|整型|1|
|order_id|订单编号|否|无|字符串|2017121423121300935|
|notice|提示信息（例如：你可以退款的最大金额为41.90）|是|无|字符串||
|multipartfiles|图片文件数组（例如：MultipartFile[] multipartfiles）|是|无|file||
| sign| MD5数字签名(ui_id+order_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/order_refund](/goods/order_refund)
###### 返回结果
```json
{
	"data":"",
	"errorcode":"",
	"errormsg":"用户退货或者退款成功",
	"errorno":"0"
}

```