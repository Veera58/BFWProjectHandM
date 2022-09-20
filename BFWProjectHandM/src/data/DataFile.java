package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("C:\\Testing\\VeeralTest.xlsx");

	public String Email = d.getCellData("LoginCredential", "UserName", 2);
	public String Password = d.getCellData("LoginCredential", "Password", 2);
	public String LoginError = d.getCellData("LoginCredential", "LoginError", 2);
	public String PasswordError = d.getCellData("LoginCredential", "Password Error", 3);
	public String EmailError = d.getCellData("LoginCredential", "Email Error", 4);
}
