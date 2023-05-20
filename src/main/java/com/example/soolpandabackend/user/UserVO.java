package com.example.soolpandabackend.user;

import lombok.Data;

@Data
public class UserVO {
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_code;
	private String user_tel;
	private String user_email;
	private boolean user_sns_push_yn;
	private boolean user_email_push_yn;
}
