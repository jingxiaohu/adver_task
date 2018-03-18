[TOC]
### 轮播图管理模块
#### 1->获取首页banner图片列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(dtype)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/goods/banner_list](/goods/banner_list)
###### 返回结果
```json
{
	"data":[
		{
			"bi_id":"1",
			"ctime":"1512912726000",
			"img_intro":"新鲜可口",
			"img_name":"农产品出炉",
			"img_url":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512922780792&di=a28c3b52b6f65505a23e37dc56db31cf&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F83025aafa40",
			"note":"",
            "jump_url":"https://timgsa.baidu.com/timg.jpg"
		}
	],
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```
