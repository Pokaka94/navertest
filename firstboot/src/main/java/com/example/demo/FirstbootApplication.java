package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import upload.MyPathConfig;

@SpringBootApplication //@ComponentScan(basePackages = "com.example.demo")
@ComponentScan
@ComponentScan(basePackageClasses = MyPathConfig.class)
@ComponentScan(basePackages = "errors")
@ComponentScan(basePackages = "board.spring.mybatis")
//@Service@Repository @Component @Controller @Congifuration

@MapperScan(basePackages = "board.spring.mybatis")
//@Mapper
public class FirstbootApplication {

	// 1.스프링ㅜ부트 메인클래스 : 자동 서버 시작 - com.example.demo 패키지 스캔 자동 포함 
	// 2. jsp파일 경로/확장자 비포함 -서블릿 api, jstl api 비포함 - pom.xml  수동 추가 설정
	// 3. xml  최소화 / src/main/resources/application.properties 파일 설정 - 서버포트, jsp 확장자/경로 설정
	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
		System.out.println("서버 시작중");
	}

}

/*4. ajax - pom.xml 라이브러리 추가 x
 * jquery 라이브러리 추가 o
 * src/main/resources/static/js/jqueryxxx.js
 *                   /static/images/*.*
 *                   /static/css/*.css
 *     => http://localhost:8063/js/jquery...js
 *                   
 * 5-1.file upload - pom.xml 라이브러리 추가 x 
 *5-2.. servlet-context.xml 불필요
 * <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />	
 * 5-3. javax.servlet 패키지명 - jakarata.servlet import 
 * c:/kdt/upload/a.png 업로드했다면
 *  http://localhost:8063/upload/a.png 이미지 보여주고 싶다
 *  서버파일저장폴더 = url 매핑 ( 브라우저 출력)
 *  
 	<resources mapping="/upload/**" location="file:///c:/kdt/upload/" />
 	==>http://localhost:8063/first/upload/a.png 이미지 보여주고 싶다
 * */









