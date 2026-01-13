package com.rc.publicrestrooms.http;

import lombok.Data;
import lombok.ToString;

/**
 * POST 요청에 대한 ResponsePaging 객체
 * 
 * @author jklee
 */
@Data
@ToString
public class ResponsePagingVO {

	private Header header;
	private Object body;

	public ResponsePagingVO(String responseCode){
		this.header = new Header(responseCode);
	}

	@Data
	public static class Header {
		private String responseCode;
		private String responseMsg;

		public Header(String responseCode){
			this.responseCode = responseCode;
		}
	}
	
}
