package testdata;

public enum LoginTestData
{
  TEST_USER("testcodexercise@gmail.com", "Testing123!");

  private String userName;

  private String userPassword;

  LoginTestData(String userName, String userPassword)
  {
    this.userName = userName;
    this.userPassword = userPassword;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getUserPassword()
  {
    return this.userPassword;
  }

}
