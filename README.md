<h1 style="text-align: center">onefood-admin 后台管理系统</h1>

#### 项目简介
alamousse基于 Spring Boot 2.1.0 、 Jpa、 Spring Security、redis、Vue的前后端分离的后台管理系统， 权限控制的方式为RBAC，项目支持数据字典与数据权限管理，支持一键生成前后端代码，支持前端菜单动态路由

####  系统功能
- 用户管理：提供用户的相关配置，新增用户后，默认密码为123456
- 角色管理：对权限与菜单进行分配，可根据部门设置角色的数据权限
- 权限管理：权限细化到接口，可以理解成按钮权限
- 菜单管理：已实现菜单动态路由，后端可配置化，支持多级菜单
- 部门管理：可配置系统组织架构，树形表格展示
- 岗位管理：配置各个部门的职位
- 字典管理：应广大码友的要求加入字典管理，可维护常用一些固定的数据，如：状态，性别等
- 操作日志：记录用户操作的日志
- 异常日志：记录异常日志，方便开发人员定位错误
- 系统缓存：使用jedis将缓存操作可视化，并提供对redis的基本操作，可根据需求自行扩展
- SQL监控：采用druid 监控数据库访问性能，默认用户名admin，密码123456
- 定时任务：整合Quartz做定时任务，加入任务日志，任务运行情况一目了然
- 代码生成：高灵活度一键生成前后端代码，减少百分之80左右的工作任务
- 邮件工具：配合富文本，发送html格式的邮件
- 免费图床：使用sm.ms图床，用作公共图片上传使用
- 七牛云存储：可同步七牛云存储的数据到系统，无需登录七牛云直接操作云数据

#### 项目结构
项目采用分模块开发方式，将通用的配置放在公共模块，```system```模块为系统核心模块也是项目入口模块，```logging``` 模块为系统的日志模块，```tools``` 为第三方工具模块，包含了图床、邮件、七牛云、支付宝，```generator``` 为系统的代码生成模块
- alamousse-common 公共模块
    - exception 项目统一异常的处理
    - mapper mapstruct的通用mapper
    - redis redis缓存相关配置
    - swagger2 接口文档配置
    - utils 系统通用工具类
- alamousse-system 系统核心模块（系统启动入口）
	- config 配置跨域与静态资源，与数据权限
	- modules 系统相关模块(登录授权、定时任务等)
- alamousse-logging 系统日志模块
- alamousse-tools 系统第三方工具模块
- alamousse-generator 系统代码生成模块

#### 开发

Google: developonefood@gmail.com psw：xc8tmg2b
Facebook, 

#### 部署

```
cd /usr/local/tomcat
sh /usr/local/tomcat/bin/startup.sh
/usr/local/tomcat/bin/catalina.sh stop
```

#### 打包

```
cd  D:\reactnative_pro\food\restaurant_manager\admin\alamousse-master

mvn clean && mvn compile && mvn package
```

#### git分支

新建远程临时分支 

```
git checkout -b tmp 
```

把新建的本地分支push到远程服务器，远程分支与本地分支同名（当然可以随意起名） 合并分支 ：

```
 git push origin tmp:tmp     
 git merge    
 git push origin tmp:tmp     
 git merge  
```

 删除指定的远程分支,   删除指定的本地分支:

```
 git push origin --delete tmp  
 git branch -d  tmp
```

#### 上线

```
mvn compile
mvn clean package
scp  *jar   47.74.240.50/

restful jar run:
nohup /usr/bin/java -Xms256m -Xmx256m -Xmn72m -XX:PermSize=180m -XX:MaxPermSize=180m  -Xss1024k -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=73 -XX:+CMSParallelRemarkEnabled -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+PrintClassHistogram -XX:+PrintGCDetails -Xloggc:/root/java/logs/appgc.log  -Dsun.rmi.dgc.server.gcInterval=3600000 -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.server.exceptionTrace=true -jar /root/java/app-0.01.jar  > /root/java/logs/appcatalina.out 2>&1 &

stop:
kill -9 `ps -ef|grep app-0.01.jar|grep -v grep|awk '{print $2}'`

pc jar run:
nohup /usr/bin/java -Xms256m -Xmx256m -Xmn72m -XX:PermSize=180m -XX:MaxPermSize=180m  -Xss1024k -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=73 -XX:+CMSParallelRemarkEnabled -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+PrintClassHistogram -XX:+PrintGCDetails -Xloggc:/root/java/logs/pcgc.log  -Dsun.rmi.dgc.server.gcInterval=3600000 -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.server.exceptionTrace=true -jar /root/java/alamousse-system-0.01.jar  > /root/java/logs/pccatalina.out 2>&1 &

stop:
kill -9 `ps -ef|grep alamousse-system-0.01.jar|grep -v grep|awk '{print $2}'`

redis:
/usr/bin/redis-server /etc/redis/redis.conf
pkill  redis-server

参考:https://blog.csdn.net/goolejuck/article/details/47753041

```





