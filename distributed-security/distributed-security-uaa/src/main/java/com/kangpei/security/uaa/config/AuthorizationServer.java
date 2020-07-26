package com.kangpei.security.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * description: AuthorizationServer
 * 授权服务的配置。<br>
 * date: 2020/7/20 12:08 上午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAccessTokenConverter converter;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security){
        security
                .tokenKeyAccess("permitAll()")                    //oauth/token_key是公开
                .checkTokenAccess("permitAll()")                  //oauth/check_token公开
                .allowFormAuthenticationForClients();				//表单认证（申请令牌）

    }

    //将客户端信息存储到数据库
    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    // 配置客户端的相关信息, 客户端详情服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetailsService);

//             clients.inMemory()// 使用in‐memory存储
//                .withClient("c1") // client_id
//                .secret(new BCryptPasswordEncoder().encode("secret")) // 客户端密钥
//                .resourceIds("res1")    // 可以访问的资源列表
//                .authorizedGrantTypes("authorization_code",
//                        "password","client_credentials","implicit","refresh_token")// 该client允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
//                .scopes("all") // 允许的授权范围
//                .autoApprove(false) // false跳转到用户授权页面， true的话就不跳转
//                 // 加上验证回调地址
//                .redirectUris("http://www.baidu.com");


    }

    // 配置令牌管理服务。

    public AuthorizationServerTokenServices tokenServices() {

        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService);//客户端详情服务
        service.setSupportRefreshToken(true);//支持刷新令牌
        service.setTokenStore(tokenStore);//令牌存储策略
//        //令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(converter));
        service.setTokenEnhancer(tokenEnhancerChain);

        service.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时
        service.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天
        return service;
    }


//    @Bean
//    public AuthorizationCodeServices authorizationCodeServices() { //设置授权码模式的授权码如何 存取，暂时采用内存方式
//        return new InMemoryAuthorizationCodeServices();
//    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        return new JdbcAuthorizationCodeServices(dataSource);//设置授权码模式的授权码如何存取
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices())
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }
}
