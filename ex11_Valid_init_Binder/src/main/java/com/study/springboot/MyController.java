package com.study.springboot;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Valid_initBinder (3)";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(contentDto);
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
		if(result.hasErrors()) {
			System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null){
				System.out.println("1:"+result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") != null){
				System.out.println("2"+result.getFieldError("content").getCode());
			}
			page = "createPage";
		}
		return page;
	}
	
	@InitBinder // 아래 메소드를 프로젝트 시작할 때 먼저 실행
	protected void initBinder(WebDataBinder binder) { // WebDataBinder 타입 변수에 유효성 검증 클래스 등록
		binder.setValidator(new ContentValidator());
	}
}