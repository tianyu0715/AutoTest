package org.item1.model;

import lombok.Data;

@Data
public class AddUserCase {
	private String userName;
	private String password;
	private String sex;
	private String permission;
	private String isDelete;
	private String expected;
}
