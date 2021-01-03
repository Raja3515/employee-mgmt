package com.training.employeemgmt.utils;

import com.training.employeemgmt.dto.ApiResponse;

public class AppUtils {
	
	public static ApiResponse generateSuccessResponseObject(Object data) {
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setData(data);
		apiResponse.setStatusCode(200);
		return apiResponse;
	}
}
