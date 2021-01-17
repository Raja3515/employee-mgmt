package com.training.employeemgmt.utils;

import java.util.Base64;

import com.training.employeemgmt.dto.ApiResponse;

public class AppUtils {
	
	public static ApiResponse generateSuccessResponseObject(Object data) {
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setData(data);
		apiResponse.setStatusCode(200);
		return apiResponse;
	}
	
	public static String decodeBase64(String encodedValue) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedValue);
		return new String(decodedBytes);
	}
}
