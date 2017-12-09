[TOC]
### 商品管理模块
#### 1->获取商品分类列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(dtype)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/goods_class_list](/goods/goods_class_list)
###### 返回结果
```json
{
	"data":[
		{
			"ctime":"1512801048000",
			"gt_code":"farm",
			"gt_id":"4",
			"gt_name":"农副产品",
			"note":""
		},
		{
			"ctime":"1512800977000",
			"gt_code":"baihuo",
			"gt_id":"3",
			"gt_name":"拼一把百货",
			"note":""
		},
		{
			"ctime":"1512800927000",
			"gt_code":"cloth",
			"gt_id":"2",
			"gt_name":"拼一把服装",
			"note":""
		},
		{
			"ctime":"1512800884000",
			"gt_code":"book",
			"gt_id":"1",
			"gt_name":" 拼一把图书",
			"note":""
		}
	],
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```

#### 2->通过分类获取商品列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|gt_id|商品类型ID|否|无|长整型|1|
| sign| MD5数字签名(gt_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/search_goods_class](/goods/search_goods_class)
###### 返回结果
```json
{
	"data":[
		{
			"banner_urls":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512801579&di=f8ca93f83ff4468e60cac8463968df89&src=http://pic33.photophoto.cn/20141109/0035035590790294_b.jpg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512801579&di=f8ca93f83ff4468e60cac8463968df89&src=http://pic33.photophoto.cn/20141109/0035035590790294_b.jpg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512801579&di=f8ca93f83ff4468e60cac8463968df89&src=http://pic33.photophoto.cn/20141109/0035035590790294_b.jpg",
			"clothing":"",
			"cp_num":"1",
			"create_admin_id":"0",
			"ctime":"1512801234000",
			"dimension":"箱",
			"evaluate_num":"90",
			"express":"‘’",
			"express_price":"1000",
			"g_id":"1",
			"gt_id":"1",
			"hp_num":"2",
			"hp_percent":"",
			"intro":"优质赣南橙子，肉质鲜美，口味十足，是居家必备之物",
			"is_bestseller":"0",
			"is_del":"0",
			"is_new":"0",
			"is_postage":"0",
			"is_promotion":"0",
			"is_putaway":"0",
			"is_recommend":"0",
			"is_sellout":"0",
			"is_show":"0",
			"is_timelimit":"0",
			"logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
			"market_num":"5",
			"modify_admin_id":"0",
			"name":"橘子",
			"note":"‘’",
			"order_num":"0",
			"order_pay_num":"0",
			"price_new":"4100",
			"price_old":"6300",
			"src_intro":"优质赣南橙子，肉质鲜美，口味十足，是居家必备之物",
			"st_num":"2",
			"stock_num":"1000",
			"utime":"1512801237000",
			"zp_num":"3"
		}
	],
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```

#### 3->通过类型获取商品列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|type|查询方式 0：促销商品类型 1：热卖商品类型  2：限时抢购商品类型 3：推荐商品类型 4:卖家包邮商品类型 5:新品上市商品类型|否|无|整型|1|
| sign| MD5数字签名(dtype)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/goods_list](/goods/goods_list)
###### 返回结果
```json
{
	"data":[
	],
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```

#### 4->获取商品信息
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|g_id|商品ID|否|无|长整型|1|
| sign| MD5数字签名(g_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/goods_info](/goods/goods_info)
###### 返回结果
```json
{
	"data":	{
		{
			"banner_urls":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512801579&di=f8ca93f83ff4468e60cac8463968df89&src=http://pic33.photophoto.cn/20141109/0035035590790294_b.jpg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512801579&di=f8ca93f83ff4468e60cac8463968df89&src=http://pic33.photophoto.cn/20141109/0035035590790294_b.jpg,https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512801579&di=f8ca93f83ff4468e60cac8463968df89&src=http://pic33.photophoto.cn/20141109/0035035590790294_b.jpg",
			"clothing":"",
			"cp_num":"1",
			"create_admin_id":"0",
			"ctime":"1512801234000",
			"dimension":"箱",
			"evaluate_num":"90",
			"express":"‘’",
			"express_price":"1000",
			"g_id":"1",
			"gt_id":"1",
			"hp_num":"2",
			"hp_percent":"",
			"intro":"优质赣南橙子，肉质鲜美，口味十足，是居家必备之物",
			"is_bestseller":"0",
			"is_del":"0",
			"is_new":"0",
			"is_postage":"0",
			"is_promotion":"0",
			"is_putaway":"0",
			"is_recommend":"0",
			"is_sellout":"0",
			"is_show":"0",
			"is_timelimit":"0",
			"logo_url":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=15128",
			"market_num":"5",
			"modify_admin_id":"0",
			"name":"橘子",
			"note":"‘’",
			"order_num":"0",
			"order_pay_num":"0",
			"price_new":"4100",
			"price_old":"6300",
			"src_intro":"优质赣南橙子，肉质鲜美，口味十足，是居家必备之物",
			"st_num":"2",
			"stock_num":"1000",
			"utime":"1512801237000",
			"zp_num":"3"
		},
		{
			"ctime":"1512801785000",
			"g_id":"1",
			"gd_id":"1",
			"goods_desc":"详情描述",
			"img_urls":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512811665111&di=977824d6a145999d051b8ee3ba0b57de&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F120820%2F219134-120R009493177.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512811665110&di=5858f72eb16af219f1875595aaa343ca&imgtype=0&src=http%3A%2F%2Fpic36.photophoto.cn%2F20150728%2F0035035565400548_b.jpg,https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512811665110&di=fb84bb1191113ef480e2064179dd2474&imgtype=0&src=http%3A%2F%2Fimg1.sc115.com%2Fuploads%2Fsc%2Fjpg%2FHD%2F33%2F3706.jpg",
			"is_del":"0",
			"note":"",
			"utime":"1512801787000"
		}
	},
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```
