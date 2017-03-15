# Sign_System
江科大计算机协会签到系统

* 开发环境：myeclipse+mysql
* 使用技术：java swing+jdbc+线程
* 使用场景：协会培训签到统计

---
> 文件说明	 

* jsd1507.sql用来还原该项目数据库
* 123.xlsx是装有协会成员成员信息的文件，其中字段与数据库字段保持一致，可用navicat for mysql批量导入数据库

> 使用说明  

1. 还原数据库
2. 导入协会成员数据
3. 修改/Sign_System/src/just/ca/util/ConnectionUtil.java中的数据库连接信息
4. 项目入口为/Sign_System/src/just/ca/UI/Main.java 

* 会长手机号和超级密码均为123456789，耦合在了代码里
* 账号为整型，name字段即登陆昵称
* 无注册功能，数据库中有事先准备好的账号：123456，密码：123456，昵称：测试

>关于

* 制作于2015-9，初学java时
* 代码分层模糊，耦合度高
* 基本无注释，查看痛苦
