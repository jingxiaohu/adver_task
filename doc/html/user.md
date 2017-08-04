
- - -
目录

[TOC]



####1.0->发送验证码

###### 接口地址
[http://task.51pyb.com/v1/sendcode.php](http://task.51pyb.com/v1/sendcode.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 用户手机号码 或者 邮箱 | 否| 无 |字符串|
| vclass| 固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡 | 否| 无 |字符串|
| type| 类型（0:未指定 1:邮箱 2:手机） | 否| 无 |整型|
| sign| MD5数字签名(dtype+tel+vclass)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果

    {
        "data": {
            "verify_list": "a6a23bd50f6a1e70ba93e4f4a2194f8b",
            "resend_time": "120",
            "tel": "251878350@qq.com"
        },
        "errorcode": "",
        "errormsg": "发送成功!",
        "errorno": "0"
    }

####1.1->重发送验证码

###### 接口地址
[http://task.51pyb.com/v1/resendcode.php](http://task.51pyb.com/v1/resendcode.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 用户手机号码 或者 邮箱 | 否| 无 |字符串|
| vclass| 固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡 | 否| 无 |字符串|
| verify_list| md5(tel+code)| 否| 无 |字符串|
| type| 类型（0:未指定 1:邮箱 2:手机） | 否| 无 |整型|
| sign| MD5数字签名(dtype+tel+vclass+verify_list)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果

    {
        "data": {
            "verify_list": "a6a23bd50f6a1e70ba93e4f4a2194f8b",
            "resend_time": "120",
            "tel": "251878350@qq.com"
        },
        "errorcode": "",
        "errormsg": "发送成功!",
        "errorno": "0"
    }

####1.2->用户注册

###### 接口地址
[http://task.51pyb.com/v1/reg.php](http://task.51pyb.com/v1/reg.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 用户手机号码 或者 邮箱 | 否| 无 |字符串|
| verify_code| 用户验证码| 否| 无 |字符串|
| password| 用户密码 | 否| 无 |字符串|
| vclass| 固定参数：1：注册 2：重置密码 3:重置绑定电话号码  4：绑定银行卡 | 否| 无 |字符串|
| verify_list| md5(tel+code)| 否| 无 |字符串|
| reg_type| 注册类型（0:未指定 1:邮箱 2:手机） | 否| 无 |整型|
| sign| MD5数字签名(dtype+tel+vclass+verify_list+verify_code+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果

    {
        "data": {
            "ctime": 1500180577424,
            "is_vip": 0,
            "note": "",
            "ui_avtar": "",
            "ui_bind_tel": "251878350@qq.com",
            "ui_email": "251878350@qq.com",
            "ui_flag": 2,
            "ui_id": 1,
            "ui_lock": 0,
            "ui_name": "",
            "ui_nd": "2017071612493744156",
            "ui_nickname": "m3pdkDN6",
            "ui_password": "123456",
            "ui_reg_type": 1,
            "ui_release": 0,
            "ui_sex": 0,
            "ui_sign": 0,
            "ui_task": 0,
            "ui_tel": "251878350@qq.com",
            "ui_tj": 0,
            "ui_token": "78cd4ce76d37a0c0fc29ff4a6ba53ce2",
            "ui_vc": 0,
            "ui_wx": "",
            "ui_zfb": "",
            "utime": 1500180577422
        },
        "errorcode": "",
        "errormsg": "注册成功",
        "errorno": "0"
    }
######返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id|主键ID|long|
|ui_nd|用户nd|String|
|ui_token|用户登陆token|String|
|ui_tel|用户账号（手机号码）|String|
|ui_password|用户密码|String|
|ui_sex|用户性别0:未知1:男2:女|int|
|ui_avtar|用户头像|String|
|ui_bind_tel|用户绑定手机号码|String|
|ui_name|用户真实姓名|String|
|ui_zfb|用户支付宝账号|String|
|ui_wx|用户微信账号|String|
|ui_vc|用户虚拟币|int|
|ui_sign|累计签到天数|int|
|ui_tj|推荐有效好友数|int|
|ui_lock|是否锁定(0:有效用户1:非法用户)|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|note|备注|String|
|ui_release|已发任务数|int|
|ui_task|已做任务数|int|
|is_vip|是否是VIP|int|
|ui_nickname|用户昵称|String|
|ui_flag|注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里|int|
|ui_email|保密邮箱|String|
|ui_reg_type|注册类型（0:未指定1:邮箱2:手机）|int|

####1.3->用户登陆

###### 接口地址
[http://task.51pyb.com/v1/login.php](http://task.51pyb.com/v1/login.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| tel| 用户手机号码 或者 邮箱 | 否| 无 |字符串|
| password| 用户密码 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+tel+password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果

    {
        "data": {
            "ctime": 1500180577424,
            "is_vip": 0,
            "note": "",
            "ui_avtar": "",
            "ui_bind_tel": "251878350@qq.com",
            "ui_email": "251878350@qq.com",
            "ui_flag": 2,
            "ui_id": 1,
            "ui_lock": 0,
            "ui_name": "",
            "ui_nd": "2017071612493744156",
            "ui_nickname": "m3pdkDN6",
            "ui_password": "123456",
            "ui_reg_type": 1,
            "ui_release": 0,
            "ui_sex": 0,
            "ui_sign": 0,
            "ui_task": 0,
            "ui_tel": "251878350@qq.com",
            "ui_tj": 0,
            "ui_token": "78cd4ce76d37a0c0fc29ff4a6ba53ce2",
            "ui_vc": 0,
            "ui_wx": "",
            "ui_zfb": "",
            "utime": 1500180577422
        },
        "errorcode": "",
        "errormsg": "登陆成功",
        "errorno": "0"
    }
######返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id|主键ID|long|
|ui_nd|用户nd|String|
|ui_token|用户登陆token|String|
|ui_tel|用户账号（手机号码）|String|
|ui_password|用户密码|String|
|ui_sex|用户性别0:未知1:男2:女|int|
|ui_avtar|用户头像|String|
|ui_bind_tel|用户绑定手机号码|String|
|ui_name|用户真实姓名|String|
|ui_zfb|用户支付宝账号|String|
|ui_wx|用户微信账号|String|
|ui_vc|用户虚拟币|int|
|ui_sign|累计签到天数|int|
|ui_tj|推荐有效好友数|int|
|ui_lock|是否锁定(0:有效用户1:非法用户)|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|note|备注|String|
|ui_release|已发任务数|int|
|ui_task|已做任务数|int|
|is_vip|是否是VIP|int|
|ui_nickname|用户昵称|String|
|ui_flag|注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里|int|
|ui_email|保密邮箱|String|
|ui_reg_type|注册类型（0:未指定1:邮箱2:手机）|int|

####1.4->用户修改密码

###### 接口地址
[http://task.51pyb.com/v1/modify_password.php](http://task.51pyb.com/v1/modify_password.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| old_password| 用户手机号码 或者 邮箱 | 否| 无 |字符串|
| new_password| 用户密码 | 否| 无 |字符串|
| sign| MD5数字签名(dtype+ui_id+old_password+new_password)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果
    {
        "data": {
            "ctime": 1500180577000,
            "is_vip": 0,
            "note": "",
            "ui_avtar": "http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_26080.jpg",
            "ui_bind_tel": "251878350@qq.com",
            "ui_email": "251878350@qq.com",
            "ui_flag": 2,
            "ui_id": 1,
            "ui_lock": 0,
            "ui_name": "敬小虎",
            "ui_nd": "2017071612493744156",
            "ui_nickname": "小虎",
            "ui_password": "25d55ad283aa400af464c76d713c07ad",
            "ui_reg_type": 1,
            "ui_release": 0,
            "ui_sex": 1,
            "ui_sign": 0,
            "ui_task": 0,
            "ui_tel": "251878350@qq.com",
            "ui_tj": 0,
            "ui_token": "559a778edef011aeeaabc210de0e615e",
            "ui_vc": 0,
            "ui_wx": "",
            "ui_zfb": "",
            "utime": 1500302818956
        },
        "errorcode": "",
        "errormsg": "更改密码成功",
        "errorno": "0"
    }
######返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id|主键ID|long|
|ui_nd|用户nd|String|
|ui_token|用户登陆token|String|
|ui_tel|用户账号（手机号码）|String|
|ui_password|用户密码|String|
|ui_sex|用户性别0:未知1:男2:女|int|
|ui_avtar|用户头像|String|
|ui_bind_tel|用户绑定手机号码|String|
|ui_name|用户真实姓名|String|
|ui_zfb|用户支付宝账号|String|
|ui_wx|用户微信账号|String|
|ui_vc|用户虚拟币|int|
|ui_sign|累计签到天数|int|
|ui_tj|推荐有效好友数|int|
|ui_lock|是否锁定(0:有效用户1:非法用户)|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|note|备注|String|
|ui_release|已发任务数|int|
|ui_task|已做任务数|int|
|is_vip|是否是VIP|int|
|ui_nickname|用户昵称|String|
|ui_flag|注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里|int|
|ui_email|保密邮箱|String|
|ui_reg_type|注册类型（0:未指定1:邮箱2:手机）|int|

####1.5->用户修改基础属性

###### 接口地址
[http://task.51pyb.com/v1/change_userinfo.php](http://task.51pyb.com/v1/change_userinfo.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| nickname| 用户昵称| 是| 无 |字符串|
| name| 用户姓名| 是| 无 |字符串|
| sex| 用户性别 : male 男   women 女   no  未知|是| 无 |字符串|
| email| 用户邮箱|是| 无 |字符串|
| avatar| 用户头像|是| 无 |文件|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果
    {
        "data": {
            "ctime": 1500180577000,
            "is_vip": 0,
            "note": "",
            "ui_avtar": "http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_26080.jpg",
            "ui_bind_tel": "251878350@qq.com",
            "ui_email": "251878350@qq.com",
            "ui_flag": 2,
            "ui_id": 1,
            "ui_lock": 0,
            "ui_name": "敬小虎",
            "ui_nd": "2017071612493744156",
            "ui_nickname": "小虎",
            "ui_password": "e10adc3949ba59abbe56e057f20f883e",
            "ui_reg_type": 1,
            "ui_release": 0,
            "ui_sex": 1,
            "ui_sign": 0,
            "ui_task": 0,
            "ui_tel": "251878350@qq.com",
            "ui_tj": 0,
            "ui_token": "78cd4ce76d37a0c0fc29ff4a6ba53ce2",
            "ui_vc": 0,
            "ui_wx": "",
            "ui_zfb": "",
            "utime": 1500180577000
        },
        "errorcode": "",
        "errormsg": "更改用户基本信息成功",
        "errorno": "0"
    }
######返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id|主键ID|long|
|ui_nd|用户nd|String|
|ui_token|用户登陆token|String|
|ui_tel|用户账号（手机号码）|String|
|ui_password|用户密码|String|
|ui_sex|用户性别0:未知1:男2:女|int|
|ui_avtar|用户头像|String|
|ui_bind_tel|用户绑定手机号码|String|
|ui_name|用户真实姓名|String|
|ui_zfb|用户支付宝账号|String|
|ui_wx|用户微信账号|String|
|ui_vc|用户虚拟币|int|
|ui_sign|累计签到天数|int|
|ui_tj|推荐有效好友数|int|
|ui_lock|是否锁定(0:有效用户1:非法用户)|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|note|备注|String|
|ui_release|已发任务数|int|
|ui_task|已做任务数|int|
|is_vip|是否是VIP|int|
|ui_nickname|用户昵称|String|
|ui_flag|注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里|int|
|ui_email|保密邮箱|String|
|ui_reg_type|注册类型（0:未指定1:邮箱2:手机）|int|

####1.6->获取用户基本信息

###### 接口地址
[http://task.51pyb.com/v1/read_myinfo.php](http://task.51pyb.com/v1/read_myinfo.php)

###### 请求方法
POST

###### 请求参数
|参数名称|值描述|是否可空|限制长度|参数类型|
|--------|-----|----|--------|-------|
| sign| MD5数字签名(dtype+ui_id)按参数的首字母升序顺序进行组装| 否| 无 |字符串|

######返回结果
    {
        "data": {
            "ctime": 1500180577000,
            "is_vip": 0,
            "note": "",
            "ui_avtar": "http://app.qc-wbo.com/file/img/avatar/2017/head251878350@qq.com_26080.jpg",
            "ui_bind_tel": "251878350@qq.com",
            "ui_email": "251878350@qq.com",
            "ui_flag": 2,
            "ui_id": 1,
            "ui_lock": 0,
            "ui_name": "敬小虎",
            "ui_nd": "2017071612493744156",
            "ui_nickname": "小虎",
            "ui_password": "",
            "ui_reg_type": 1,
            "ui_release": 0,
            "ui_sex": 1,
            "ui_sign": 0,
            "ui_task": 0,
            "ui_tel": "251878350@qq.com",
            "ui_tj": 0,
            "ui_token": "559a778edef011aeeaabc210de0e615e",
            "ui_vc": 0,
            "ui_wx": "",
            "ui_zfb": "",
            "utime": 1500302819000
        },
        "errorcode": "",
        "errormsg": "读取我的信息成功",
        "errorno": "0"
    }

######返回字段说明
|名称|描述|类型|
|----|----|---|
|ui_id|主键ID|long|
|ui_nd|用户nd|String|
|ui_token|用户登陆token|String|
|ui_tel|用户账号（手机号码）|String|
|ui_password|用户密码|String|
|ui_sex|用户性别0:未知1:男2:女|int|
|ui_avtar|用户头像|String|
|ui_bind_tel|用户绑定手机号码|String|
|ui_name|用户真实姓名|String|
|ui_zfb|用户支付宝账号|String|
|ui_wx|用户微信账号|String|
|ui_vc|用户虚拟币|int|
|ui_sign|累计签到天数|int|
|ui_tj|推荐有效好友数|int|
|ui_lock|是否锁定(0:有效用户1:非法用户)|int|
|ctime|创建时间|java.util.Date|
|utime|更新时间|java.util.Date|
|note|备注|String|
|ui_release|已发任务数|int|
|ui_task|已做任务数|int|
|is_vip|是否是VIP|int|
|ui_nickname|用户昵称|String|
|ui_flag|注册来源0:未指定1:web2:android3:ios4:QQ5:微信6:新浪7:阿里|int|
|ui_email|保密邮箱|String|
|ui_reg_type|注册类型（0:未指定1:邮箱2:手机）|int|