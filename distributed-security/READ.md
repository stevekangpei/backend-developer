## Spring-Security OAuth授权

要实现Spring-Security OAuth 授权有两个地方。
一是授权服务。  distributed-security-uaa
二是资源服务。  distributed-security-order


授权服务需要配置三个东西：

1，配置客户端的详情信息。
    
    ClientDetailsServiceConfigurer:用来配置客户端详情服务(ClientDetailsService)，
    客户端详情信息在 这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
    
    实现方式有两种，一种是基于内存的，方便测试。一种是基于数据库的
    
    
    基于内存。
    
    ```
    java
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
             throws Exception {
    clients.withClientDetails(clientDetailsService); clients.inMemory()// 使用in‐memory存储
                .withClient("c1")// client_id
                .secret(new BCryptPasswordEncoder().encode("secret"))
                .resourceIds("res1")
                .authorizedGrantTypes("authorization_code",
    "password","client_credentials","implicit","refresh_token")// 该client允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
    .scopes("all")// 允许的授权范围 .autoApprove(false)
    //加上验证回调地址 .redirectUris("http://www.baidu.com");
    }
    ```
    
    
    