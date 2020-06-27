package com.kangpei.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kangpei.constant.Status;
import com.kangpei.exception.ApiException;
import com.kangpei.resp.ResultVo;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * description: ResponseControllerAdvice <br>
 * date: 2020/6/27 11:02 下午 <br>
 * author: kangpei <br>
 * version: 1.0 <br>
 */
@RestControllerAdvice(basePackages = {"com.kangpei"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    // 如果没有被ResultVo包含我们才会去处理，否则就不处理。
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return !returnType.getGenericParameterType().equals(ResultVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        // 如果没有被ResultVo 包的话，那我就需这个方法来处理。
        // 如果是字符串的话。需要单独处理。
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVo<>(data));
            } catch (JsonProcessingException e) {
                throw new ApiException(Status.UNKNOWN_ERROR, "处理字符串错误");
            }
        }
        return new ResultVo<>(data);
    }
}
