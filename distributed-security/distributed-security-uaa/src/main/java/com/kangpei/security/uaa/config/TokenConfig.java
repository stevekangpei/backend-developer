package com.kangpei.security.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * description: TokenConfig <br>
 * date: 2020/7/20 12:21 上午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@Configuration
public class TokenConfig {

    // 资源服务需要放置跟他一样的密钥。
    private String SINGING_KEY = "uaa123";

    @Bean
    public TokenStore tokenStore() {
        // jwt 令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SINGING_KEY); // 对称密钥，资源服务器使用该密钥来验证。
        return converter;

    }


//    @Bean
//    public TokenStore tokenStore() {
//        // 使用内存存储令牌。
//        return new InMemoryTokenStore();
//    }
}
