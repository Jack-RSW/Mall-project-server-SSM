# SSM商城项目服务端开发

该项目需要有Linux、Mysql、Git、Maven、Java、Spring、SpringMVC、Mybatis等基本概念

**如果觉得不错就点击右上角star鼓励一下作者吧！**

# 关于项目

## 测试环境

```
后端：spring+mybatis+springmvc 
测试环境：IDEA + tomcat8 + mysql5.1.6 + jdk8 + maven
```

## 技术栈

- 项目环境采用`IDEA` + `MAVEN` + `Tomcat` + `MySQL`，数据库连接池采用`dbcp`
- 后台采用SSM，并使用`MP(Mybatis-plus)`
- 图片服务：`vsftpd`
- Token缓存服务：`Guava`
- 响应数据：`json`

## 项目功能

- 用户模块

- 分类模块
- 商品模块
- 购物车模块
- 订单模块
- 订单模块
- 支付模块

## 项目测试文档

见代码文件夹：Documentation of the test interface

## 项目运行步骤

1. 运行项目前需导入mmall.sql，且需保证在已经安装jdk，maven，tomcat，mysql等的环境并配置好。

2. 另外mybatis-generator需要的mysql包已经放在了tools包下，可以copy出来，放到某个位置，并修改 db.driverLocation的路径到你放的路径。
3. 打开datasource.properties请修改db.url、db.username、db.password为自己的mysql数据库连接需要的url、username、password
4. 打开mmall.properties，修改成自己的ftp服务器地址，账号和密码，支付宝回调的地址可以通过NATAPP外网穿透进行配置。如果用nginx配置的话，请修改本机host支持域名。然后修改ftp文件服务器的访问前缀。MD5的salt值非常不建议修改。建议新建账户进行测试
5. 然后部署tomcat运行就可以了。

## 项目结构

```
│  README.md
│  pom.xml
│  
│          
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      ├─alipay
│  │  │      │  └─demo
│  │  │      │      └─trade
│  │  │      │              DemoHbRunner.java --Alipay demo
│  │  │      │              Main.java --Alipay demo
│  │  │      │              
│  │  │      └─jack
│  │  │          └─mymall
│  │  │              ├─common --通用类
│  │  │              │      Const.java --常量
│  │  │              │      ResponseCode.java --响应代码
│  │  │              │      ServerResponse.java --高可复用相应对象
│  │  │              │      TokenCache.java --guava缓存
│  │  │              │      
│  │  │              ├─controller
│  │  │              │  ├─backend  --后台控制器
│  │  │              │  │      CategoryManageController.java
│  │  │              │  │      OrderManageController.java
│  │  │              │  │      ProductManageController.java
│  │  │              │  │      UserManageController.java
│  │  │              │  │      
│  │  │              │  └─portal --前台控制器
│  │  │              │          CartController.java
│  │  │              │          OrderController.java
│  │  │              │          ProductController.java
│  │  │              │          ShippingController.java
│  │  │              │          UserController.java
│  │  │              │          
│  │  │              ├─dao --dao层
│  │  │              │      CartMapper.java
│  │  │              │      CategoryMapper.java
│  │  │              │      OrderItemMapper.java
│  │  │              │      OrderMapper.java
│  │  │              │      PayInfoMapper.java
│  │  │              │      ProductMapper.java
│  │  │              │      ShippingMapper.java
│  │  │              │      UserMapper.java
│  │  │              │      
│  │  │              ├─pojo --pojo层
│  │  │              │      Cart.java
│  │  │              │      Category.java
│  │  │              │      Order.java
│  │  │              │      OrderItem.java
│  │  │              │      PayInfo.java
│  │  │              │      Product.java
│  │  │              │      Shipping.java
│  │  │              │      User.java
│  │  │              │      
│  │  │              ├─service --业务层
│  │  │              │  │  ICartService.java
│  │  │              │  │  ICategoryService.java
│  │  │              │  │  IFileService.java
│  │  │              │  │  IOrderService.java
│  │  │              │  │  IProductService.java
│  │  │              │  │  IShippingService.java
│  │  │              │  │  IUserService.java
│  │  │              │  │  
│  │  │              │  └─impl --业务实现层
│  │  │              │          CartServiceImpl.java
│  │  │              │          CategoryServiceImpl.java
│  │  │              │          FileServiceImpl.java
│  │  │              │          OrderServiceImpl.java
│  │  │              │          ProductServiceImpl.java
│  │  │              │          ShippingServiceImpl.java
│  │  │              │          UserServiceImpl.java
│  │  │              │          
│  │  │              ├─util --工具类
│  │  │              │      BigDecimalUtil.java
│  │  │              │      DateTimeUtil.java
│  │  │              │      FTPUtil.java
│  │  │              │      MD5Util.java
│  │  │              │      PropertiesUtil.java
│  │  │              │      
│  │  │              └─vo	--视图对象、值对象
│  │  │                      CartProductVo.java
│  │  │                      CartVo.java
│  │  │                      OrderItemVo.java
│  │  │                      OrderProductVo.java
│  │  │                      OrderVo.java
│  │  │                      ProductDetailVo.java
│  │  │                      ProductListVo.java
│  │  │                      ShippingVo.java
│  │  │                      
│  │  ├─resources --maven项目存放配置文件的根目
│  │  │  │  applicationContext-datasource.xml
│  │  │  │  applicationContext.xml
│  │  │  │  datasource.properties
│  │  │  │  generatorConfig.xml
│  │  │  │  logback.xml 
│  │  │  │  mmall.properties
│  │  │  │  zfbinfo.properties
│  │  │  │  
│  │  │  └─mappers --mybatis映射配置
│  │  │          CartMapper.xml
│  │  │          CategoryMapper.xml
│  │  │          OrderItemMapper.xml
│  │  │          OrderMapper.xml
│  │  │          PayInfoMapper.xml
│  │  │          ProductMapper.xml
│  │  │          ShippingMapper.xml
│  │  │          UserMapper.xml
│  │  │          
│  │  ├─tools --mybatis-generator所需的包
│  │  │      mysql-connector-java-5.1.6-bin.jar
│  │  │      
│  │  └─webapp --项目的根目录
│  │      │  index.jsp
│  │      │  
│  │      ├─lib --Alipay 支付依赖包
│  │      │      alipay-sdk-java-3.3.0-source.jar
│  │      │      alipay-sdk-java-3.3.0.jar
│  │      │      alipay-trade-sdk-20161215-source.jar
│  │      │      alipay-trade-sdk-20161215.jar
│  │      │      
│  │      └─WEB-INF
│  │              dispatcher-servlet.xml
│  │              web.xml
│  │              
│  └─test --测试目录
│      └─java
```



## 整合思路

各模块独立开发，整合通过基本的三层架构实现



# 需求实现

1. ### 用户模块

横向越权、纵向越权、 MD5明文加密、guava缓存、高复用服务响应对象的设计思想和封装

**登陆（后台）**

1.控制层流程：从业务层获取响应对象response，然后从response中获取user，判断该用户是否为管理员，然后session设置属性user

（入参: String username, String password, HttpSession session）

（出参：ServerResponse<user>）

```
public ServerResponse<User> login(String username, String password, HttpSession session){
    ServerResponse<User> response = iUserService.login(username,password);
    if(response.isSuccess()){
        User user = response.getData();
        if(user.getRole() == Const.Role.ROLE_ADMIN){
            //说明登录的是管理员
            session.setAttribute(Const.CURRENT_USER,user);
            return response;
        }else{
            return ServerResponse.createByErrorMessage("不是管理员,无法登录");
        }
    }
    return response;
}
```

2.业务层流程如下

（入参：String username, String password）

（出参：ServerResponse<user>）

​	1.通过userMapper检查传入的username，判断用户名是否存在

​	2.MD5加密传入的密码，获取user通过userMapper，判断user是否为null，然后设置用户的密码为空，返回user对象

```
public ServerResponse<User> login(String username, String password) {
    int resultCount = userMapper.checkUsername(username);
    if(resultCount == 0 ){
        return ServerResponse.createByErrorMessage("用户名不存在");
    }

    String md5Password = MD5Util.MD5EncodeUtf8(password);
    User user  = userMapper.selectLogin(username,md5Password);
    if(user == null){
        return ServerResponse.createByErrorMessage("密码错误");
    }

    user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
    return ServerResponse.createBySuccess("登录成功",user);
}
```



**用户登录（前台）**

1.控制层流程：从业务层获取响应对象response，然后从response中获取user，判断该用户是否为管理员，然后session设置属性user

（入参: String username, String password, HttpSession session）

（出参：ServerResponse<User>）

2.业务层流程如下

（入参：String username, String password）

（出参：ServerResponse<user>）

​	1.通过userMapper检查传入的username，判断用户名是否存在

​	2.MD5加密传入的密码，获取user通过userMapper，判断user是否为null，然后设置用户的密码为空，返回user对象

```
@Override
public ServerResponse<User> login(String username, String password) {
    int resultCount = userMapper.checkUsername(username);
    if(resultCount == 0 ){
        return ServerResponse.createByErrorMessage("用户名不存在");
    }

    String md5Password = MD5Util.MD5EncodeUtf8(password);
    User user  = userMapper.selectLogin(username,md5Password);
    if(user == null){
        return ServerResponse.createByErrorMessage("密码错误");
    }

    user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
    return ServerResponse.createBySuccess("登录成功",user);
}
```

**用户登出（前台）**

1.控制层流程：从session中移除用户属性

（入参: HttpSession session）

（出参：ServerResponse<String>）

```
@RequestMapping(value = "logout.do",method = RequestMethod.POST)
@ResponseBody
public ServerResponse<String> logout(HttpSession session){
    session.removeAttribute(Const.CURRENT_USER);
    return ServerResponse.createBySuccess();
}
```

2.业务层流程如下

无



**用户注册（前台）**

1.控制层流程：直接进入业务层

（入参: User user）

（出参：ServerResponse<String>）

2.业务层流程如下

（入参：User user）

（出参：ServerResponse<String>）

​	1.效验用户名和邮箱（因为这两个字段不能重复，且需返回给前台）

​	2.设置用户的角色为顾客

​	3.MD5加密用户的设置的密码

​	4.插入user通过userMapper，通过返回值rowCount判断插入是否成功

```
public ServerResponse<String> register(User user){
    ServerResponse validResponse = this.checkValid(user.getUsername(),Const.USERNAME);
    if(!validResponse.isSuccess()){
        return validResponse;
    }
    validResponse = this.checkValid(user.getEmail(),Const.EMAIL);
    if(!validResponse.isSuccess()){
        return validResponse;
    }
    user.setRole(Const.Role.ROLE_CUSTOMER);
    //MD5加密
    user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
    int resultCount = userMapper.insert(user);
    if(resultCount == 0){
        return ServerResponse.createByErrorMessage("注册失败");
    }
    return ServerResponse.createBySuccessMessage("注册成功");
}

public ServerResponse<String> checkValid(String str,String type){
    if(org.apache.commons.lang3.StringUtils.isNotBlank(type)){
        //开始校验
        if(Const.USERNAME.equals(type)){
            int resultCount = userMapper.checkUsername(str);
            if(resultCount > 0 ){
                return ServerResponse.createByErrorMessage("用户名已存在");
            }
        }
        if(Const.EMAIL.equals(type)){
            int resultCount = userMapper.checkEmail(str);
            if(resultCount > 0 ){
                return ServerResponse.createByErrorMessage("email已存在");
            }
        }
    }else{
        return ServerResponse.createByErrorMessage("参数错误");
    }
    return ServerResponse.createBySuccessMessage("校验成功");
}
```



**用户效验（前台）**

1.控制层流程：直接进入业务层，返回业务层信息

（入参: String str,String type）

（出参：ServerResponse<String>）

2.业务层流程如下

（入参：User user）

（出参：ServerResponse<String>）

​	1.效验用户名和邮箱（因为这两个字段不能重复，且需返回给前台）

```
public ServerResponse<String> checkValid(String str,String type){
    if(org.apache.commons.lang3.StringUtils.isNotBlank(type)){
        //开始校验
        if(Const.USERNAME.equals(type)){
            int resultCount = userMapper.checkUsername(str);
            if(resultCount > 0 ){
                return ServerResponse.createByErrorMessage("用户名已存在");
            }
        }
        if(Const.EMAIL.equals(type)){
            int resultCount = userMapper.checkEmail(str);
            if(resultCount > 0 ){
                return ServerResponse.createByErrorMessage("email已存在");
            }
        }
    }else{
        return ServerResponse.createByErrorMessage("参数错误");
    }
    return ServerResponse.createBySuccessMessage("校验成功");
}
```



**获取用户信息（前台）**

1.控制层流程：从session中获取用户，然后判断user是否为null

（入参: HttpSession session）

（出参：ServerResponse<User>）

```
@RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
@ResponseBody
public ServerResponse<User> getUserInfo(HttpSession session){
    User user = (User) session.getAttribute(Const.CURRENT_USER);
    if(user != null){
        return ServerResponse.createBySuccess(user);
    }
    return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
}
```

2.业务层流程如下

无



**忘记获取问题（前台）**

1.控制层流程：直接进入业务层，返回业务层信息

（入参: String username）

（出参：ServerResponse<String>）

2.业务层流程如下

（入参：String username）

（出参：ServerResponse）

​	1.效验用户名和邮箱（因为这两个字段不能重复，且需返回给前台）

​	2.获取问题通过userMapper，判断问题不为空，返回问题

```
public ServerResponse selectQuestion(String username){

    ServerResponse validResponse = this.checkValid(username,Const.USERNAME);
    if(validResponse.isSuccess()){
        //用户不存在
        return ServerResponse.createByErrorMessage("用户不存在");
    }
    String question = userMapper.selectQuestionByUsername(username);
    if(org.apache.commons.lang3.StringUtils.isNotBlank(question)){
        return ServerResponse.createBySuccess(question);
    }
    return ServerResponse.createByErrorMessage("找回密码的问题是空的");
}
```



**忘记效验答案（前台）**

1.控制层流程：直接进入业务层，返回业务层信息

（入参: String username,String question,String answer）

（出参：ServerResponse<String>）

2.业务层流程如下

（入参：String username）

（出参：ServerResponse）

​	1.通过userMapper效验答案，入参为username,question,answer

​	2.判断效验是否正确，获取token，然后在Token缓存中设置该token，返回

```
public ServerResponse<String> checkAnswer(String username,String question,String answer){
    int resultCount = userMapper.checkAnswer(username,question,answer);
    if(resultCount>0){
        //说明问题及问题答案是这个用户的,并且是正确的
        String forgetToken = UUID.randomUUID().toString();
        TokenCache.setKey(TokenCache.TOKEN_PREFIX+username,forgetToken);
        return ServerResponse.createBySuccess(forgetToken);
    }
    return ServerResponse.createByErrorMessage("问题的答案错误");
}
```



忘记重置密码（前台）**

1.控制层流程：直接进入业务层，返回业务层信息

（入参: String username,String passwordNew,String forgetToken）

（出参：ServerResponse<String>）

2.业务层流程如下

（入参：String username,String passwordNew,String forgetToken）

（出参：ServerResponse<String>）

​	1.判断入参forgetToken不为null

​	2.效验用户名和邮箱

​	3.从Token缓存中获取token，并判断是否过期

​	4.比较入参forgetToken和缓存中的token

​	5.MD5加密入参passwordNew，然后通过userMapper更新，之后通过返回值判断更新是否成功

```
public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken){
    if(org.apache.commons.lang3.StringUtils.isBlank(forgetToken)){
        return ServerResponse.createByErrorMessage("参数错误,token需要传递");
    }
    ServerResponse validResponse = this.checkValid(username,Const.USERNAME);
    if(validResponse.isSuccess()){
        //用户不存在
        return ServerResponse.createByErrorMessage("用户不存在");
    }
    String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX+username);
    if(org.apache.commons.lang3.StringUtils.isBlank(token)){
        return ServerResponse.createByErrorMessage("token无效或者过期");
    }

    if(org.apache.commons.lang3.StringUtils.equals(forgetToken,token)){
        String md5Password  = MD5Util.MD5EncodeUtf8(passwordNew);
        int rowCount = userMapper.updatePasswordByUsername(username,md5Password);

        if(rowCount > 0){
            return ServerResponse.createBySuccessMessage("修改密码成功");
        }
    }else{
        return ServerResponse.createByErrorMessage("token错误,请重新获取重置密码的token");
    }
    return ServerResponse.createByErrorMessage("修改密码失败");
}
```



**重置密码（前台）**

1.控制层流程：从session中获取user，然后判断用户是否为null，之后进入业务层

（入参: HttpSession session,String passwordOld,String passwordNew）

（出参：ServerResponse<String>）

2.业务层流程如下

（入参：String passwordOld,String passwordNew,User user）

（出参：ServerResponse<String>）

​	1.效验密码是否正确通过userMapper

​	2.MD5加密新密码

​	3.更新加密的新密码通过userMapper，根据返回值判断密码是否更新成功

```
public ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user){
    //防止横向越权,要校验一下这个用户的旧密码,一定要指定是这个用户.因为我们会查询一个count(1),如果不指定id,那么结果就是true啦count>0;
    int resultCount = userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld),user.getId());
    if(resultCount == 0){
        return ServerResponse.createByErrorMessage("旧密码错误");
    }

    user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
    int updateCount = userMapper.updateByPrimaryKeySelective(user);
    if(updateCount > 0){
        return ServerResponse.createBySuccessMessage("密码更新成功");
    }
    return ServerResponse.createByErrorMessage("密码更新失败");
}
```



**更新用户信息（前台）**

1.控制层流程：从session中获取user，然后判断用户不为null，user设置setId，setUsername，之后进入业务层。根据返回的response，得到data，重新设置用户名setUsername，然后session设置用户

（入参: HttpSession session,User user）

（出参：ServerResponse<User>）

```
@RequestMapping(value = "update_information.do",method = RequestMethod.POST)
@ResponseBody
public ServerResponse<User> update_information(HttpSession session,User user){
    User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
    if(currentUser == null){
        return ServerResponse.createByErrorMessage("用户未登录");
    }
    user.setId(currentUser.getId());
    user.setUsername(currentUser.getUsername());
    ServerResponse<User> response = iUserService.updateInformation(user);
    if(response.isSuccess()){
        response.getData().setUsername(currentUser.getUsername());
        session.setAttribute(Const.CURRENT_USER,response.getData());
    }
    return response;
}
```

2.业务层流程如下

（入参：User user）

（出参：ServerResponse<User>）

​	1.效验密码是否正确通过userMapper，用户名在控制层已经设置，不需效验

​	2.新建用户updateUser，重新设置setId，setEmail，setPhone，setQuestion，setAnswer

​	3.通过userMapper更新updateUser，根据返回值判断更新是否成功

```
public ServerResponse<User> updateInformation(User user){
    //username是不能被更新的
    //email也要进行一个校验,校验新的email是不是已经存在,并且存在的email如果相同的话,不能是我们当前的这个用户的.
    int resultCount = userMapper.checkEmailByUserId(user.getEmail(),user.getId());
    if(resultCount > 0){
        return ServerResponse.createByErrorMessage("email已存在,请更换email再尝试更新");
    }
    User updateUser = new User();
    updateUser.setId(user.getId());
    updateUser.setEmail(user.getEmail());
    updateUser.setPhone(user.getPhone());
    updateUser.setQuestion(user.getQuestion());
    updateUser.setAnswer(user.getAnswer());

    int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
    if(updateCount > 0){
        return ServerResponse.createBySuccess("更新个人信息成功",updateUser);
    }
    return ServerResponse.createByErrorMessage("更新个人信息失败");
}
```

**获取用户信息（前台）**

1.控制层流程：从session中获取user，然后判断用户是否为null，之后进入业务层

（入参: HttpSession session）

（出参：ServerResponse<User>）

2.业务层流程如下

（入参：Integer userId）

（出参：ServerResponse<User>）

​	1.获取user通过userMapper，判断user不为null

​	2.user设置密码为空，返回user

```
public ServerResponse<User> getInformation(Integer userId){
    User user = userMapper.selectByPrimaryKey(userId);
    if(user == null){
        return ServerResponse.createByErrorMessage("找不到当前用户");
    }
    user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
    return ServerResponse.createBySuccess(user);

}
```



2. ### 分类模块

递归算法 复杂对象排重 无限层级树结构设计，具体流程见代码

3. ### 商品模块

POJO、BO、VO抽象模型 高效分页及动态排序 FTP服务对接、富文本上传，具体流程见代码

4. ### 购物车模块

商品总价计算复用封装 高复用的逻辑方法封装思想 解决商业运算丢失精度的坑，具体流程见代码

5. ### 订单模块

安全漏洞解决方案 订单号生成规则 强大的常量、枚举设计，具体流程见代码

6. ### 收货地址

同步获取自增主键 数据绑定的对象绑定 越权问题升级巩固，具体流程见代码

7. ### 支付模块

支付宝SDK源码解析 支付宝支付流程与集成 二维码生成，扫码支付，具体流程见代码

