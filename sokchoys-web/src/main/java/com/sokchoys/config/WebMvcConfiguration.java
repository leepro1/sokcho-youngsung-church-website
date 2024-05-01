package com.sokchoys.config;

import com.sokchoys.member.interceptor.ConfirmInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = { "com.sokchoys.**.dao" })
public class WebMvcConfiguration implements WebMvcConfigurer {

	private final List<String> patterns = Arrays.asList("/members/admin/*", "/admin");

	@Autowired
	private ConfirmInterceptor confirmInterceptor;

	private final String uploadFilePath;

	public WebMvcConfiguration(@Value("${file.path.upload-files}") String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/file/**").addResourceLocations("file:///" + uploadFilePath + "/")
				.setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
	}

}
