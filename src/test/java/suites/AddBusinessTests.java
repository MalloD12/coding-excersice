package suites;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.BankAccount;
import model.Organisation;
import testdata.LoginTestData;

//As starting point I assumed default organization as well as user credentials has been already created.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Business Manager Test Suite")
public class AddBusinessTests extends BaseTest
{

  private static Stream<Arguments> OrganizationAndBankDetailsProvider()
  {
    return Stream.of(
        Arguments.of(Organisation.builder().businessName("Test Organisation 1").industry("IT Company").country("Argentina").hasEmployees(true).registeredForGST(true).build(),
            BankAccount.builder().accountName("Test Account 1").accountType("").accountNumber("").bankBrand("ANZ").build()));
  }

  @ParameterizedTest
  @MethodSource("OrganizationAndBankDetailsProvider")
  public void test1(Organisation organisation, BankAccount bankDetails)
      throws InterruptedException
  {
    System.out.println("Test N1 executed.");
    loginFlow.doLogin(LoginTestData.TEST_USER)
        .selectOrganizationNavMenu()
        .selectAddNewOrganisationOption()
        .addNewOrganization(organisation);
    Thread.sleep(5000);
  }
}
