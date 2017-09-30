package jp.co.aimsoft.attendance.sample.common.aop;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

	static final Logger logger = LoggerFactory.getLogger(SampleAspect.class);

	@Around("within(jp.co.aimsoft.attendance.sample.mybatisTest.service.impl.*)")
	public void around(ProceedingJoinPoint pjp) throws Throwable {

		List<Object> args = Arrays.asList(pjp.getArgs());
		args.forEach(arg -> arg.toString());

		logger.info("method start :" + pjp.getSignature().getDeclaringType().getSimpleName() + "#"
				+ pjp.getSignature().getName() + " | params : " + StringUtils.join(args, ", "));

		pjp.proceed();
	}
}
