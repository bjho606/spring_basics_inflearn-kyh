package com.myspring.jb;

import com.myspring.jb.member.MemberRepository;
import com.myspring.jb.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "com.myspring.jb.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)     // AppConfig,TestConfig 등의 @Configuration이 붙은 설정 정보를 제외하기 위해서
)
public class AutoAppConfig {
//    // 수동 빈 등록
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
