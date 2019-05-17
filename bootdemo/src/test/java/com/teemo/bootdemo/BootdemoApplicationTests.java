package com.teemo.bootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BootdemoApplicationTests {
	//记得配置log4j.properties ,的命令行输出水平是debug
	/*private static final Logger log = LoggerFactory.getLogger(BootdemoApplicationTests.class);

	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@Before()  //这个方法在每个方法执行之前都会执行一遍
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
	}*/

	/**
	 * @Description: controller 测试
	 * @Param:  
	 * @return:  
	 * @Author: Teemo
	 * @Date: 2019/5/16 
	 */
	/*@Test
	public void controllerTest1() throws Exception {
		log.debug(">>> controllerTest Start");

		///////////////////////////get///////////////////////////////////
		String responseString = null;

		responseString = mockMvc.perform(
				get("/categories/getAllCategory")   //请求的url,请求的方法是get
				.contentType(MediaType.APPLICATION_FORM_URLENCODED) //数据的格式
				.param("pcode","root") //添加参数
        ).andExpect(status().isOk())    //返回的状态是200
				.andDo(print())         //打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
		System.out.println("--------返回的json = " + responseString);


		///////////////////////////post///////////////////////////////////
		ObjectMapper mapper = new ObjectMapper();
//		Passportinfo info = new Passportinfo();		//entity
		String info = "";

		// 写为字符串
		String requestJson = mapper.writeValueAsString(info);


		responseString = mockMvc.perform(MockMvcRequestBuilders.post("/personnel/addPassport")
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andReturn().getResponse().getContentAsString();


		//////////////////////////file upload////////////////////////////////////
		File file = new File("D:\\springbootTest\\docName.xls");
		try {
			String result = mockMvc.perform(
					MockMvcRequestBuilders.fileUpload("/personnel/importRecordPersonnel")
							.file( new MockMultipartFile("file","备案人员导入.xls",MediaType.MULTIPART_FORM_DATA_VALUE,new FileInputStream(file))))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn().getResponse().getContentAsString();


			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}


		log.debug(">>> controllerTest End");
	}


	*//**
	 * @Description: controller 测试
	 * @Param:
	 * @return:
	 * @Author: Teemo
	 * @Date: 2019/5/16
	 *//*
	@Test
	public void controllerTest2() throws Exception {
		log.debug(">>> controllerTest Start");

		RequestBuilder request = null;
		///////////////////////////get///////////////////////////////////
		request = get("/busimonitor/updateApplicantInfo")
				.param("tempId", "45")
				.param("keeppassportStartdate", "2019-05-11")
				.param("keeppassportEnddate", "2019-05-28")
				.param("procInstId", "3930");

		mockMvc.perform(request)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());



		///////////////////////////post///////////////////////////////////


		///////////////////////////put///////////////////////////////////
		request = put("/busimonitor/updateApplicantInfo")
				.param("tempId", "45")
				.param("keeppassportStartdate", "2019-05-11")
				.param("keeppassportEnddate", "2019-05-28")
				.param("procInstId", "3930");

		mockMvc.perform(request)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());

		///////////////////////////delete///////////////////////////////////





		//////////////////////////file upload////////////////////////////////////






		log.debug(">>> controllerTest End");
	}*/

}
