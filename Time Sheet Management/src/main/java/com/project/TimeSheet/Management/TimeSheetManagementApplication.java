package com.project.TimeSheet.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages= {"com.controller,com.dao"})
@EntityScan(basePackages="com.model")
public class TimeSheetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeSheetManagementApplication.class, args);
	}

}
