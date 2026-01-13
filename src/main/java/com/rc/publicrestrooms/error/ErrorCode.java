package com.rc.publicrestrooms.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

	//Http 상태 코드
	HTTP_HANDLE_ACCESS_DENIED(403, "H403", "Access is Denied"),
	HTTP_METHOD_NOT_ALLOWED(405, "H405", " Method Not Allowed"),
	HTTP_INTERNAL_SERVER_ERROR(500, "H500", "Server Error"),

	//Common
	COMMON_INVALID_INPUT_VALUE(400, "C001", " 잘못된 입력 값입니다."),
	COMMON_INVALID_TYPE_VALUE(400, "C002", " 잘못된 타입입니다."),
	COMMON_SAVE_FAIL(400, "C003", "저장에 실패 하였습니다."),
	COMMON_FILE_UPLOAD_FAIL(400, "C004", "File Upload Fail."),
	COMMON_JSON_PARSING_FAIL(400, "C005","JSON Parings Failed"),
	COMMON_REQUEST_CONNECTION(400, "C005","커넥션 실패"),

	//Member
	MEMBER_EMAIL_DUPLICATION(400, "M001", "사용중인 이메일입니다."),
	MEMBER_LOGIN_INPUT_INVALID(400, "M002", "로그인 입력이 잘못되었습니다."),
	MEMBER_LOGIN_EMPTY_MEMBER(400, "M003", "가입 되지 않은 아이디입니다."),
	MEMBER_LOGIN_APPROVAL_REQUIRED(400, "M004", "회원가입 승인 처리 중입니다."),
	MEMBER_LOGIN_PASSWARD_ERROR(400, "M005", "비밀번호가 정확하지 않습니다."),
	MEMBER_LOGIN_DELYN_ERROR(400, "M006", "유효하지 않은 사용자입니다."),
	MEMBER_LOGIN_BUSINESS_REGISTRATION(400, "M007", "사업자 등록증을 다시 등록해주세요."),
	MEMBER_LOGIN_CMS(400, "M008", "CMS 등록이 필요합니다."),
	MEMBER_LOGIN_STOP(400, "M009", "서비스 사용이 중지됐습니다.\n고객센터로 연락바랍니다. (1644-2591)"),
	MEMBER_LOGIN_APPROVAL_COMPLETE(400, "M010", "이미 승인된 사용자 입니다."),
	MEMBER_LOGIN_APPROVAL_NON_COMPLETE(400, "M011", "정비업체 아이디 승인 업체만 이용하실 수 있습니다."),
	MEMBER_LOGIN_ADD_TERMS(400, "M012", "약관 동의 등록 오류"),

	//견적관련
	ESTIMATE_INVALID_MANAGER(400, "M101", "담당자가 올바르지 않아 변경이 필요합니다."),

	//엑셀관련 (공통)
	ETC_EXCEL_ERROR(400, "M201", "업로드에 문제가 발생했습니다."),
	ETC_EXCEL_ALLOWED(400, "M202", "허용되지 않는 서식이 존재합니다."),
	EXCEL_READ_EMPTY_ERROR(400, "M203", "미입력 항목이 있습니다."),
	ETC_EXCEL_DUPLICATION_ERROR(400, "M204", "중복된 서식이 존재합니다."),
	ETC_EXCEL_DOWNLOAD_ERROR(400, "M205", "다운로드에 문제가 발생했습니다."),

	//엑셀일괄 등록 / 수정 (부품)
	EXCEL_ITEM_PARTS_ALLOWED_ERROR(400, "M301", "parts_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MANUFACTURER_ALLOWED_ERROR(400, "M302", "manufacturer_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_ALLOWED_ERROR(400, "M303", "model_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_ACCIDENT_ALLOWED_ERROR(400, "M304", "accident_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_ACCIDENT_TYPE_CD_ALLOWED_ERROR(400, "M305", "accident_type_cd 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_STATEMENT_ADD_TYPE_CD_ALLOWED_ERROR(400, "M306", "statement_add_type_cd 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_DIVISION_TYPE_CD_ALLOWED_ERROR(400, "M307", "model_division_type_cd 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_DEL_YN_ALLOWRED_ERROR(400, "M308", "del_yn 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_DIVISION_TYPE_CD_ALLOWED_ERROR(400, "M309", "group_division_type_cd 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_ALLOWED_ERROR(400, "M310", "group_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_IN_NUM_ALLOWED_ERROR(400, "M311", "item_group_in_num 항목에 공백이 있습니다."),
	EXCEL_ITEM_CD_ALLOWED_ERROR(400, "M312", "item_cd 항목에 공백이 있습니다."),
	EXCEL_ITEM_NM_ALLOWED_ERROR(400, "M313", "item_nm 항목에 공백이 있습니다."),
	EXCEL_ITEM_NM_KO_ALLOWED_ERROR(400, "M314", "item_nm_ko 항목에 공백이 있습니다."),
	EXCEL_ITEM_FILE_NM_NOT_EXIST_ERROR(400, "M315", "file_nm 항목에 해당하는 이미지가 존재하지 않습니다.\n이미지 확인해주세요!"),
	EXCEL_ITEM_FILE_NM_ALLOWED_ERROR(400, "M316", "file_nm 항목에 공백이거나 업로드 누락 파일이 있습니다."),
	EXCEL_ITEM_MEMO_ALLOWED_ERROR(400, "M317", "memo 항목에 공백이 있습니다."),
	EXCEL_ITEM_PARTS_PRICE_ALLOWED_ERROR(400, "M318", "price 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_MIN_USED_PRICE_ALLOWED_ERROR(400, "M319", "min_used_price 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_MAX_USED_PRICE_ALLOWED_ERROR(400, "M320", "max_used_price 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_USED_PRICE_DAY_ALLOWED_ERROR(400, "M321", "used_price_day 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_WORKINGTIME_ALLOWED_ERROR(400, "M322", "working_time 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_DISPLAYORDERNUM_ALLOWED_ERROR(400, "M323", "display_order_num 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_DISPLAYYN_ALLOWED_ERROR(400, "M324", "display_yn 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_NM_ALLOWED_ERROR(400, "M325", "group_nm 항목에 공백이 있습니다."),
	EXCEL_ITEM_MODEL_NM1_ALLOWED_ERROR(400, "M326", "model_nm1 항목에 공백이 있습니다."),
	EXCEL_ITEM_MODEL_NM2_ALLOWED_ERROR(400, "M327", "model_nm2 항목에 공백이 있습니다."),
	EXCEL_ITEM_YEAR_ALLOWED_ERROR(400, "M328", "year 항목에 공백이 있습니다."),

	//menu
	EXCEL_ITEM_PARTS_SEARCH_POSSIBLE_CCOUNT_OVER_ERRER(400, "M401", "조회 가능 횟수를 초과 하였습니다."),

	//server
	EXCEPTION_SERVER_SQL(400, "5901", "DB 사용 오류."),
	EXCEPTION_SERVER_FILE(400, "5902", "File 처리 오류."),
	EXCEPTION_SERVER_CONNECT(400, "5903", "서버 연결 오류."),

	EXCEPTION_PROC_TRANS_DATA(500, "5004", "Value Object 변환 오류.")
	;

	private final int status;
	private final String code;
	private final String message;

	ErrorCode(final int status, final String code, final String message){
		this.status = status;
		this.message = message;
		this.code = code;
	}

	public int getStatus(){
		return this.status;
	}

	public String getMessage(){
		return this.message;
	}

	public String getCode(){
		return code;
	}

}