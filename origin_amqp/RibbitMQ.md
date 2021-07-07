# RabbitMQ 实战教程

## 1.MQ引言

### 1.1 什么是MQ

`MQ`(Message Quene) :  翻译为 `消息队列`,通过典型的 `生产者`和`消费者`模型,生产者不断向消息队列中生产消息，消费者不断的从队列中获取消息。因为消息的生产和消费都是异步的，而且只关心消息的发送和接收，没有业务逻辑的侵入,轻松的实现系统间解耦。别名为 `消息中间件`	通过利用高效可靠的消息传递机制进行平台无关的数据交流，并基于数据通信来进行分布式系统的集成。

### 1.2 MQ有哪些

当今市面上有很多主流的消息中间件，如老牌的`ActiveMQ`、`RabbitMQ`，炙手可热的`Kafka`，阿里巴巴自主开发`RocketMQ`等。

### 1.3 不同MQ特点

```markdown
# 1.ActiveMQ
		ActiveMQ 是Apache出品，最流行的，能力强劲的开源消息总线。它是一个完全支持JMS规范的的消息中间件。丰富的API,多种集群架构模式让ActiveMQ在业界成为老牌的消息中间件,在中小型企业颇受欢迎!

# 2.Kafka
		Kafka是LinkedIn开源的分布式发布-订阅消息系统，目前归属于Apache顶级项目。Kafka主要特点是基于Pull的模式来处理消息消费，
		追求高吞吐量，一开始的目的就是用于日志收集和传输。0.8版本开始支持复制，不支持事务，对消息的重复、丢失、错误没有严格要求，
		适合产生大量数据的互联网服务的数据收集业务。

# 3.RocketMQ
		RocketMQ是阿里开源的消息中间件，它是纯Java开发，具有高吞吐量、高可用性、适合大规模分布式系统应用的特点。RocketMQ思路起
		源于Kafka，但并不是Kafka的一个Copy，它对消息的可靠传输及事务性做了优化，目前在阿里集团被广泛应用于交易、充值、流计算、消
		息推送、日志流式处理、binglog分发等场景。

# 4.RabbitMQ
		RabbitMQ是使用Erlang语言开发的开源消息队列系统，基于AMQP协议来实现。AMQP的主要特征是面向消息、队列、路由（包括点对点和
		发布/订阅）、可靠性、安全。AMQP协议更多用在企业系统内对数据一致性、稳定性和可靠性要求很高的场景，对性能和吞吐量的要求还在
		其次。
		
```

> RabbitMQ比Kafka可靠，Kafka更适合IO高吞吐的处理，一般应用在大数据日志处理或对实时性（少量延迟），可靠性（少量丢数据）要求稍低的场景使用，比如ELK日志收集。

---

## 2.RabbitMQ 的引言

### 2.1 RabbitMQ 

> 基于`AMQP`协议，erlang语言开发，是部署最广泛的开源消息中间件,是最受欢迎的开源消息中间件之一。

![image-20190925215603036](RibbitMQ 实战教程.assets/image-20190925215603036-9419777.png)

`官网`: https://www.rabbitmq.com/

`官方教程`: https://www.rabbitmq.com/#getstarted

```markdown
 # AMQP 协议
 		AMQP（advanced message queuing protocol）`在2003年时被提出，最早用于解决金融领不同平台之间的消息传递交互问题。顾名思义，AMQP是一种协议，更准确的说是一种binary wire-level protocol（链接协议）。这是其和JMS的本质差别，AMQP不从API层进行限定，而是直接定义网络交换的数据格式。这使得实现了AMQP的provider天然性就是跨平台的。以下是AMQP协议模型:
```

![image-20200311182438041](RibbitMQ 实战教程.assets/image-20200311182438041.png)

### 2.2 RabbitMQ 的安装

#### 2.2.1 下载

`官网下载地址`: https://www.rabbitmq.com/download.html![image-20190925220115235](RibbitMQ 实战教程.assets/image-20190925220115235.png)

> `最新版本`: 3.7.18

#### 2.2.2 下载的安装包![image-20190925220343521](RibbitMQ 实战教程.assets/image-20190925220343521.png)

> `注意`:这里的安装包是centos7安装的包

#### 2.2.3 安装步骤

```markdown
# 1.将rabbitmq安装包上传到linux系统中
	erlang-22.0.7-1.el7.x86_64.rpm
	rabbitmq-server-3.7.18-1.el7.noarch.rpm

# 2.安装Erlang依赖包
	rpm -ivh erlang-22.0.7-1.el7.x86_64.rpm

# 3.安装RabbitMQ安装包(需要联网)
	yum install -y rabbitmq-server-3.7.18-1.el7.noarch.rpm
		注意:默认安装完成后配置文件模板在:/usr/share/doc/rabbitmq-server-3.7.18/rabbitmq.config.example目录中,需要	
				将配置文件复制到/etc/rabbitmq/目录中,并修改名称为rabbitmq.config
# 4.复制配置文件
	cp /usr/share/doc/rabbitmq-server-3.7.18/rabbitmq.config.example /etc/rabbitmq/rabbitmq.config

# 5.查看配置文件位置
	ls /etc/rabbitmq/rabbitmq.config

# 6.修改配置文件(参见下图:)
	vim /etc/rabbitmq/rabbitmq.config 
```

![image-20190925222230260](RibbitMQ 实战教程.assets/image-20190925222230260-3836271.png)

将上图中配置文件中红色部分去掉`%%`,以及最后的`,`逗号 修改为下图:

![image-20190925222329200](RibbitMQ 实战教程.assets/image-20190925222329200-3836312.png)

```markdown
# 7.执行如下命令,启动rabbitmq中的插件管理
	rabbitmq-plugins enable rabbitmq_management
	
	出现如下说明:
		Enabling plugins on node rabbit@localhost:
    rabbitmq_management
    The following plugins have been configured:
      rabbitmq_management
      rabbitmq_management_agent
      rabbitmq_web_dispatch
    Applying plugin configuration to rabbit@localhost...
    The following plugins have been enabled:
      rabbitmq_management
      rabbitmq_management_agent
      rabbitmq_web_dispatch

    set 3 plugins.
    Offline change; changes will take effect at broker restart.

# 8.启动RabbitMQ的服务
	systemctl start rabbitmq-server
	systemctl restart rabbitmq-server
	systemctl stop rabbitmq-server
	

# 9.查看服务状态(见下图:)
	systemctl status rabbitmq-server
  ● rabbitmq-server.service - RabbitMQ broker
     Loaded: loaded (/usr/lib/systemd/system/rabbitmq-server.service; disabled; vendor preset: disabled)
     Active: active (running) since 三 2019-09-25 22:26:35 CST; 7s ago
   Main PID: 2904 (beam.smp)
     Status: "Initialized"
     CGroup: /system.slice/rabbitmq-server.service
             ├─2904 /usr/lib64/erlang/erts-10.4.4/bin/beam.smp -W w -A 64 -MBas ageffcbf -MHas ageffcbf -
             MBlmbcs...
             ├─3220 erl_child_setup 32768
             ├─3243 inet_gethost 4
             └─3244 inet_gethost 4
      .........
```

![image-20190925222743776](RibbitMQ 实战教程.assets/image-20190925222743776-3836511.png)

```markdown
# 10.关闭防火墙服务
	systemctl disable firewalld
    Removed symlink /etc/systemd/system/multi-user.target.wants/firewalld.service.
    Removed symlink /etc/systemd/system/dbus-org.fedoraproject.FirewallD1.service.
	systemctl stop firewalld   

# 11.访问web管理界面
	http://10.15.0.8:15672/
```

 ![image-20190926194738708](RibbitMQ 实战教程.assets/image-20190926194738708-3836601.png)

```markdown
# 12.登录管理界面
	username:  guest
	password:  guest
```

![image-20190926194954822](RibbitMQ 实战教程.assets/image-20190926194954822-3836665.png)

----

## 3. RabiitMQ 配置

### 3.1RabbitMQ 管理命令行

```markdown
# 1.服务启动相关
	systemctl start|restart|stop|status rabbitmq-server

# 2.管理命令行  用来在不使用web管理界面情况下命令操作RabbitMQ
	rabbitmqctl  help  可以查看更多命令

# 3.插件管理命令行
	rabbitmq-plugins enable|list|disable 
```

### 3.2 web管理界面介绍

#### 3.2.1 overview概览

![image-20191126162026720](RibbitMQ 实战教程.assets/image-20191126162026720.png)

- `connections：无论生产者还是消费者，都需要与RabbitMQ建立连接后才可以完成消息的生产和消费，在这里可以查看连接情况`

- `channels：通道，建立连接后，会形成通道，消息的投递获取依赖通道。`

- `Exchanges：交换机，用来实现消息的路由`

- `Queues：队列，即消息队列，消息存放在队列中，等待消费，消费后被移除队列。`

  

#### 3.2.2 Admin用户和虚拟主机管理

##### 1. 添加用户

![image-20191126162617280](RibbitMQ 实战教程.assets/image-20191126162617280.png)

上面的Tags选项，其实是指定用户的角色，可选的有以下几个：

- `超级管理员(administrator)`

  可登陆管理控制台，可查看所有的信息，并且可以对用户，策略(policy)进行操作。

- `监控者(monitoring)`

  可登陆管理控制台，同时可以查看rabbitmq节点的相关信息(进程数，内存使用情况，磁盘使用情况等)

- `策略制定者(policymaker)`

  可登陆管理控制台, 同时可以对policy进行管理。但无法查看节点的相关信息(上图红框标识的部分)。

- `普通管理者(management)`

  仅可登陆管理控制台，无法看到节点信息，也无法对策略进行管理。

- `其他`

  无法登陆管理控制台，通常就是普通的生产者和消费者。

##### 2. 创建虚拟主机

```markdown
# 虚拟主机
	为了让各个用户可以互不干扰的工作，RabbitMQ添加了虚拟主机（Virtual Hosts）的概念。其实就是一个独立的访问路径，不同用户使用不同路径，各自有自己的队列、交换机，互相不会影响。
```

 ![image-20191126163023153](RibbitMQ 实战教程.assets/image-20191126163023153.png)

##### 3. 绑定虚拟主机和用户

创建好虚拟主机，我们还要给用户添加访问权限：

点击添加好的虚拟主机：

 ![image-20191126163506795](RibbitMQ 实战教程.assets/image-20191126163506795.png)

进入虚拟机设置界面:

![image-20191126163631889](RibbitMQ 实战教程.assets/image-20191126163631889.png)

-----

## 4.RabbitMQ 的第一个程序

### 4.0 AMQP协议的回顾

![image-20200312140114784](RibbitMQ 实战教程.assets/image-20200312140114784.png)

### 4.1 RabbitMQ支持的消息模型

![image-20191126165434784](RibbitMQ 实战教程.assets/image-20191126165434784.png)

![image-20191126165459282](RibbitMQ 实战教程.assets/image-20191126165459282.png)



### 4.2 引入依赖

```xml
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>5.7.2</version>
</dependency>
```



## 6. MQ的应用场景

### 6.1 异步处理

`场景说明：用户注册后，需要发注册邮件和注册短信,传统的做法有两种 1.串行的方式 2.并行的方式`

- `串行方式:` 将注册信息写入数据库后,发送注册邮件,再发送注册短信,以上三个任务全部完成后才返回给客户端。 这有一个问题是,邮件,短信并不是必须的,它只是一个通知,而这种做法让客户端等待没有必要等待的东西. 

 ![这里写图片描述](RibbitMQ 实战教程.assets/SouthEast-4860248.png)

- `并行方式: `将注册信息写入数据库后,发送邮件的同时,发送短信,以上三个任务完成后,返回给客户端,并行的方式能提高处理的时间。 

 ![这里写图片描述](RibbitMQ 实战教程.assets/SouthEast-20191127211112660.png)

- `消息队列:`假设三个业务节点分别使用50ms,串行方式使用时间150ms,并行使用时间100ms。虽然并行已经提高的处理时间,但是,前面说过,邮件和短信对我正常的使用网站没有任何影响，客户端没有必要等着其发送完成才显示注册成功,应该是写入数据库后就返回.  `消息队列`: 引入消息队列后，把发送邮件,短信不是必须的业务逻辑异步处理 

  ![img](RibbitMQ 实战教程.assets/592892-20190520220249900-1679743651.jpg)

由此可以看出,引入消息队列后，用户的响应时间就等于写入数据库的时间+写入消息队列的时间(可以忽略不计),引入消息队列后处理后,响应时间是串行的3倍,是并行的2倍。



### 6.2 应用解耦

`场景：双11是购物狂节,用户下单后,订单系统需要通知库存系统,传统的做法就是订单系统调用库存系统的接口. `

 ![这里写图片描述](RibbitMQ 实战教程.assets/SouthEast-20191127211247287.png)

这种做法有一个缺点:

当库存系统出现故障时,订单就会失败。 订单系统和库存系统高耦合.  引入消息队列 

 ![这里写图片描述](RibbitMQ 实战教程.assets/SouthEast-20191127211304085.png)

- `订单系统:`用户下单后,订单系统完成持久化处理,将消息写入消息队列,返回用户订单下单成功。

- `库存系统:`订阅下单的消息,获取下单消息,进行库操作。  就算库存系统出现故障,消息队列也能保证消息的可靠投递,不会导致消息丢失.

  

### 6.3 流量削峰

 `场景:` 秒杀活动，一般会因为流量过大，导致应用挂掉,为了解决这个问题，一般在应用前端加入消息队列。  

  `作用:` 

​			1.可以控制活动人数，超过此一定阀值的订单直接丢弃(我为什么秒杀一次都没有成功过呢^^) 

​			2.可以缓解短时间的高流量压垮应用(应用程序按自己的最大处理能力获取订单) 

 ![这里写图片描述](RibbitMQ 实战教程.assets/SouthEast-20191127211341601.png)

1.用户的请求,服务器收到之后,首先写入消息队列,加入消息队列长度超过最大值,则直接抛弃用户请求或跳转到错误页面.  

2.秒杀业务根据消息队列中的请求信息，再做后续处理.

-----

## 7. RabbitMQ的集群

### 7.1 集群架构

#### 7.1.1 普通集群(副本集群)

> All data/state required for the operation of a RabbitMQ broker is replicated across all nodes. An exception to this are message queues, which by default reside on one node, though they are visible and reachable from all nodes. To replicate queues across nodes in a cluster   --摘自官网

`默认情况下:RabbitMQ代理操作所需的所有数据/状态都将跨所有节点复制。这方面的一个例外是消息队列，默认情况下，消息队列位于一个节点上，尽管它们可以从所有节点看到和访问`

1. ##### 架构图

![image-20200320094147471](RibbitMQ 实战教程.assets/image-20200320094147471.png)

​	核心解决问题:  `当集群中某一时刻master节点宕机,可以对Quene中信息,进行备份`

2. ##### 集群搭建

   ```markdown
   # 0.集群规划
   	node1: 10.15.0.3  mq1  master 主节点
   	node2: 10.15.0.4  mq2  repl1  副本节点
   	node3: 10.15.0.5  mq3  repl2  副本节点
   
   # 1.克隆三台机器主机名和ip映射
   	vim /etc/hosts加入:
   		 10.15.0.3 mq1
       	10.15.0.4 mq2
       	10.15.0.5 mq3
   	node1: vim /etc/hostname 加入:  mq1
   	node2: vim /etc/hostname 加入:  mq2
   	node3: vim /etc/hostname 加入:  mq3
   
   # 2.三个机器安装rabbitmq,并同步cookie文件,在node1上执行:
   	scp /var/lib/rabbitmq/.erlang.cookie root@mq2:/var/lib/rabbitmq/
   	scp /var/lib/rabbitmq/.erlang.cookie root@mq3:/var/lib/rabbitmq/
   
   # 3.查看cookie是否一致:
   	node1: cat /var/lib/rabbitmq/.erlang.cookie 
   	node2: cat /var/lib/rabbitmq/.erlang.cookie 
   	node3: cat /var/lib/rabbitmq/.erlang.cookie 
   
   # 4.后台启动rabbitmq所有节点执行如下命令,启动成功访问管理界面:
   	rabbitmq-server -detached 
   
   # 5.在node2和node3执行加入集群命令:
   	1.关闭       rabbitmqctl stop_app
   	2.加入集群    rabbitmqctl join_cluster rabbit@mq1
   	3.启动服务    rabbitmqctl start_app
   
   # 6.查看集群状态,任意节点执行:
   	rabbitmqctl cluster_status
   
   # 7.如果出现如下显示,集群搭建成功:
   	Cluster status of node rabbit@mq3 ...
   	[{nodes,[{disc,[rabbit@mq1,rabbit@mq2,rabbit@mq3]}]},
   	{running_nodes,[rabbit@mq1,rabbit@mq2,rabbit@mq3]},
   	{cluster_name,<<"rabbit@mq1">>},
   	{partitions,[]},
   	{alarms,[{rabbit@mq1,[]},{rabbit@mq2,[]},{rabbit@mq3,[]}]}]
   
   # 8.登录管理界面,展示如下状态:
   ```

   ![image-20200320095613586](RibbitMQ 实战教程.assets/image-20200320095613586.png)

   ```markdown
   # 9.测试集群在node1上,创建队列
   ```

   ![image-20200320095743935](RibbitMQ 实战教程.assets/image-20200320095743935.png)

   ```markdown
   # 10.查看node2和node3节点:
   ```

   ![image-20200320095827688](RibbitMQ 实战教程.assets/image-20200320095827688.png)

   ![image-20200320095843370](RibbitMQ 实战教程.assets/image-20200320095843370.png)

   ```markdown
   # 11.关闭node1节点,执行如下命令,查看node2和node3:
   	rabbitmqctl stop_app
   ```

   ![image-20200320100000347](RibbitMQ 实战教程.assets/image-20200320100000347.png)

   ![image-20200320100010968](RibbitMQ 实战教程.assets/image-20200320100010968.png)

   ---

#### 7.1.2 镜像集群

> This guide covers mirroring (queue contents replication) of classic queues  --摘自官网
>
> By default, contents of a queue within a RabbitMQ cluster are located on a single node (the node on which the queue was declared). This is in contrast to exchanges and bindings, which can always be considered to be on all nodes. Queues can optionally be made *mirrored* across multiple nodes. --摘自官网

`镜像队列机制就是将队列在三个节点之间设置主从关系，消息会在三个节点之间进行自动同步，且如果其中一个节点不可用，并不会导致消息丢失或服务不可用的情况，提升MQ集群的整体高可用性。`



1. ##### 集群架构图

   ![image-20200320113423235](RibbitMQ 实战教程.assets/image-20200320113423235.png)

   

2. ##### 配置集群架构

   ```markdown
   # 0.策略说明
   	rabbitmqctl set_policy [-p <vhost>] [--priority <priority>] [--apply-to <apply-to>] <name> <pattern>  <definition>
   	-p Vhost： 可选参数，针对指定vhost下的queue进行设置
   	Name:     policy的名称
   	Pattern: queue的匹配模式(正则表达式)
   	Definition：镜像定义，包括三个部分ha-mode, ha-params, ha-sync-mode
              		ha-mode:指明镜像队列的模式，有效值为 all/exactly/nodes
                           all：表示在集群中所有的节点上进行镜像
                           exactly：表示在指定个数的节点上进行镜像，节点的个数由ha-params指定
                           nodes：表示在指定的节点上进行镜像，节点名称通过ha-params指定
               	 ha-params：ha-mode模式需要用到的参数
                   ha-sync-mode：进行队列中消息的同步方式，有效值为automatic和manual
                   priority：可选参数，policy的优先级
                   
                    
   # 1.查看当前策略
   	rabbitmqctl list_policies
   
   # 2.添加策略
   	rabbitmqctl set_policy ha-all '^hello' '{"ha-mode":"all","ha-sync-mode":"automatic"}' 
   	说明:策略正则表达式为 “^” 表示所有匹配所有队列名称  ^hello:匹配hello开头队列
   
   # 3.删除策略
   	rabbitmqctl clear_policy ha-all
   
   # 4.测试集群
   ```

   ----

   