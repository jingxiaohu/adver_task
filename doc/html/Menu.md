[[_TOC_]]
### 菜单管理模块
#### 1->读取一级菜单列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/v1/menu_list](/v1/menu_list)
###### 返回结果
```json
{
	"data":[
		{
			"name":"最新资讯",
			"slug":"http://www.528ads.com/archives/category/news",
			"term_group":"0",
			"term_id":"1"
		},
		{
			"name":"股市笑话",
			"slug":"http://www.528ads.com/archives/category/gsxh",
			"term_group":"0",
			"term_id":"3"
		},
		{
			"name":"本周热点",
			"slug":"http://www.528ads.com/archives/category/bzrd",
			"term_group":"0",
			"term_id":"4"
		},
		{
			"name":"个股雷达",
			"slug":"http://www.528ads.com/archives/category/ggld",
			"term_group":"0",
			"term_id":"5"
		},
		{
			"name":"赏善罚恶",
			"slug":"http://www.528ads.com/archives/category/ssfe",
			"term_group":"0",
			"term_id":"7"
		},
		{
			"name":"解套心灵咨询",
			"slug":"http://www.528ads.com/archives/category/jtxlzx",
			"term_group":"0",
			"term_id":"8"
		},
		{
			"name":"技术学习",
			"slug":"http://www.528ads.com/archives/category/study",
			"term_group":"0",
			"term_id":"10"
		}
	],
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```

#### 2->读取一级菜单列表
|参数名称|值描述|是否可空|限制长度|参数类型|举例|
|--------|-----|----|--------|-------|-----|
|term_id|菜单主键ID|否|无|长整型|4|
|slug|菜单英文名称|否|无|字符串|bzrd|
| sign| MD5数字签名(dtype+ui_id+term_id+slug)按参数的首字母升序顺序进行组装| 否| 无 |字符串|---|
#### 请求路径
[/v1/menu_list2](/v1/menu_list2)
###### 返回结果
```json
{
	"data":[
		{
			"name":"行业研究",
			"slug":"bzrd/hyyj",
			"term_group":"0",
			"term_id":"90"
		},
		{
			"name":"数据资金",
			"slug":"bzrd/sjzj",
			"term_group":"0",
			"term_id":"91"
		},
		{
			"name":"证券要闻",
			"slug":"bzrd/zqyw",
			"term_group":"0",
			"term_id":"92"
		},
		{
			"name":"国内经济",
			"slug":"bzrd/cgnjj",
			"term_group":"0",
			"term_id":"93"
		}
	],
	"errorcode":"",
	"errormsg":"获取成功",
	"errorno":"0"
}

```
