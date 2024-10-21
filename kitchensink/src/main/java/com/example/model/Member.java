package com.example.model;

public class Member
{
	private Long id ;
	private String name ;
	private String email ;
	private String phoneNumber ;
	
	public Member(Long idP, String nameP, String emailP,  String phoneNumberP)
	{
		id = idP ;
		 name = nameP ;
		email = emailP ;
		phoneNumber = phoneNumberP ;
	}
	
	public String toString()
	{
	 return "Id:" + id + " Name:" + name + " Email:" + email + " Phone:" + phoneNumber ;  	
		
	
	}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
