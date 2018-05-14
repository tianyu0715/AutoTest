package org.item1.model;

import lombok.Data;

@Data
public class User {
	private int id;
	private String userName;
	private String age;
	private String sex;
	private String permission;
	private String idDelete;
	
	@Override
	public String toString() {
		return (
				"{id"+id+","+
				"id:"+id+","+
				"userName:"+userName+","+
				"age:"+age+","+
				"sex:"+sex+","+
				"permission:"+permission+","+
				"idDelete:"+idDelete+","+"}"
						);
	}
}
