![](http://game.reyun.com/img/contlogo.png)热云 Java sdk
=======================================================

# 游戏运营支撑平台
[http://game.reyun.com](http://game.reyun.com) 

# SDK接口方法和参数说明及注意事项(必读) 

> * 申请appid，打开[http://game.reyun.com](http://game.reyun.com)，使用您的热云账号登陆后在**【我的游戏】**管理后台，点击**【添加游戏】**，在弹出的面板中创建新游戏，完成后您将获得一个32位的16进制APPID，用来唯一标识您刚刚创建的游戏。  
`注：为了保证您的数据安全，请勿泄露您的APP ID给其他人。`

> * deviceid是很重要的参数，是用来记录用户设备的身份信息（ios获取的是openudid或idfa，android获取IMEI或者mac地址，但要保证一致），如果有个别用户出现获取不到deviceid的情况，deviceid要传unknown。

> * 文档中的**是否必填**项是决定数据是否报送成功的选项，必填参数没有填写会导致数据报送不出来，不是不是必填参数就不是重要参数，（如果必填参数获取不到，请用unknown代替）例如以下参数：

>> * channelid是区分渠道的重要参数，是记录用户来源的信息

>> * serverid是多服游戏的重要参数，通过serverid来统计每个游戏的服各指标数据，同一个服的各项参数要有相同的serverid，除install和startup参数以外，其他参数都要有serverid。

>> * level也是必填参数，除install,stastup,register不用填充写level

> * 在玩家首次进入某个服务器调用，报送register接口数据（也就是说每次进入新服都需要发送register接口，并且同时发送loggedin接口）, 要确保参数who不能为空（有平台的记录平台ID，没有平台的只要用户ID唯一就可以了，也就是用户进所有服务器只有一个ID） 。用户每进入一个新服发送且仅发送一次register。

# sdk打包
mvn clean compile assembly:single  
`源码编译打包需要maven 3.0+支持`

# sdk使用
```
// 获得reyunapi实例
ReyunAPI api = ReyunAPI.getInstance("1edf4b9540a5e83c0febf1f4ac407224");

// 生成install model
Install install = api.createInstall();

// 设置install参数
install.setDeviceid("xxxxxxxxxx");
install.setChannelid("appstore");

// 报送install数据并获得返回结果
Result result = api.post(install);

// 输出返回结果
System.out.println("status: " + result.getStatus());
System.out.println("httpcode: " + result.getHttpcode());
System.out.println("requesturl: " + result.getRequestUrl());
System.out.println("requestjson: " + result.getRequest());
System.out.println("responsejson: " + result.getResponse());
```