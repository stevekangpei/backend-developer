> 如何使用Spring-boot来实现统一的异常处理，避免过多的try-catch逻辑。


## 1， 首先通过使用valid 框架，我们避免了大量的if-else判断。

   * 比如说如下的代码， 如果不使用框架的话，是这样一番景象

```java
public String addUser(User user) {
     if (user == null || user.getId() == null || user.getAccount() == null || user.getPassword() == null || user.getEmail() == null) {
         return "对象或者对象字段不能为空";
     }
     if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getEmail())) {
         return "不能输入空字符串";
     }
     if (user.getAccount().length() < 6 || user.getAccount().length() > 11) {
         return "账号长度必须是6-11个字符";
     }
     if (user.getPassword().length() < 6 || user.getPassword().length() > 16) {
         return "密码长度必须是6-16个字符";
     }
     if (!Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", user.getEmail())) {
         return "邮箱格式不正确";
     }
     // 参数校验完毕后这里就写上业务逻辑
     return "success";
```

    * 使用了框架之后，是这样的。


```java
    @NotNull(message = "用户id不可以为空")
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;```


  * 不过还需要我们在每个接口上传入BindingResult这个注解。

    现在我们可以使用Spring-boot的全局异常处理机制来实现这个功能。

    我们需要创建一个类，在这个类上面加上@ControllerAdvice 或者@RestControllerAdvice注解。


## 自定义异常

全局处理当然不会只能处理一种异常，用途也不仅仅是对一个参数校验方式进行优化。在实际开发中，如何对异常处理其实是一个很麻烦的事情。传统处理异常一般有以下烦恼：

是捕获异常(try…catch)还是抛出异常(throws)
是在controller层做处理还是在service层处理又或是在dao层做处理
处理异常的方式是啥也不做，还是返回特定数据，如果返回又返回什么数据
不是所有异常我们都能预先进行捕捉，如果发生了没有捕捉到的异常该怎么办？
以上这些问题都可以用全局异常处理来解决，全局异常处理也叫统一异常处理，全局和统一处理代表什么？代表规范！规范有了，很多问题就会迎刃而解！

全局异常处理的基本使用方式大家都已经知道了，我们接下来更进一步的规范项目中的异常处理方式：自定义异常。

在很多情况下，我们需要手动抛出异常，比如在业务层当有些条件并不符合业务逻辑，我这时候就可以手动抛出异常从而触发事务回滚。那手动抛出异常最简单的方式就是throw new RuntimeException("异常信息")了，不过使用自定义会更好一些：

自定义异常可以携带更多的信息，不像这样只能携带一个字符串。
项目开发中经常是很多人负责不同的模块，使用自定义异常可以统一了对外异常展示的方式。
自定义异常语义更加清晰明了，一看就知道是项目中手动抛出的异常。

    

数据统一响应

现在我们规范好了参数校验方式和异常处理方式，然而还没有规范响应数据！比如我要获取一个分页信息数据，
获取成功了呢自然就返回的数据列表，获取失败了后台就会响应异常信息，即一个字符串，
就是说前端开发者压根就不知道后端响应过来的数据会是啥样的！所以，统一响应数据是前后端规范中必须要做的！

自定义统一响应体

统一数据响应第一步肯定要做的就是我们自己自定义一个响应体类，无论后台是运行正常还是发生异常，响应给前端的数据格式是不变的！那么如何定义响应体呢？关于异常的设计：如何更优雅的设计异常








