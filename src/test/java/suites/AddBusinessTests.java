package suites;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.BankAccount;
import model.Organisation;
import testdata.LoginTestData;

@DisplayName("Business Manager Test Suite")
public class AddBusinessTests extends BaseTest
{

  private static Stream<Arguments> OrganizationAndBankDetailsProvider()
  {
    return Stream.of(
        Arguments.of(Organisation.builder().businessName("Test Organisation 1").industry("IT Company").country("New Zealand").hasEmployees(true).registeredForGST(false).build(),
            BankAccount.builder().accountName("Test Account 1").accountType("Everyday (day-to-day)").accountNumber("4325676").bankBrand("ANZ (NZ)").build()),
        Arguments.of(Organisation.builder().businessName("Test Organisation 2").industry("Web & Software Development").country("New Zealand").hasEmployees(false).registeredForGST(true).build(),
            BankAccount.builder().accountName("Test Account 1").accountType("credit card").last4DigitsCC("4378").bankBrand("ANZ (NZ)").build()));
  }

  @ParameterizedTest
  @MethodSource("OrganizationAndBankDetailsProvider")
  public void bankAccountForANewOrganizationIsAddedSuccessfully(Organisation organisation, BankAccount bankDetails)
  {
    assertThat(loginFlow.doLogin(LoginTestData.TEST_USER)
        .selectOrganizationNavMenu()
        .selectAddNewOrganisationOption()
        .addNewOrganization(organisation)
        .navigateToBankAccountManagement()
        .addBankAccount(bankDetails)
        .goBackToDashboard()
        .bankAccountAddedDisplaysOnDashboard(bankDetails)).as("Verifying bank account has been added successfully").isTrue();
  }

  private static Stream<Arguments> bankDetailsProvider()
  {
    return Stream.of(
        Arguments.of(
            BankAccount.builder().accountType("Everyday (day-to-day)").accountNumber("").bankBrand("ANZ (NZ)").build(), false),
        Arguments.of(
            BankAccount.builder().accountType("Term Deposit").accountNumber("12345").bankBrand("ANZ (NZ)").build(), true),
        Arguments.of(
            BankAccount.builder().accountType("Credit Card").last4DigitsCC("123").bankBrand("ANZ (NZ)").build(), false),
        Arguments.of(
            BankAccount.builder().accountType("Loan").accountNumber("65357").bankBrand("ANZ (NZ)").build(), true),
        Arguments.of(
            BankAccount.builder().accountType("Credit Card").last4DigitsCC("test").bankBrand("ANZ (NZ)").build(), false));
  }

  @ParameterizedTest
  @MethodSource("bankDetailsProvider")
  public void addValidAndInvalidBankAccountsForAnExistentOrganization(BankAccount bankDetails, boolean positiveTest)
  {
    Random rand = new Random();
    bankDetails.setAccountName(String.format("Test Bank Account %s", rand.nextInt(2000)));

    assertThat(loginFlow.doLogin(LoginTestData.TEST_USER)
        .navigateToBankAccountManagement()
        .selectAddBankAccountButton()
        .completeBankDetails(bankDetails)
        .submitBankDetails()
        .bankAccountHasBeenAddedSuccessfully()).as("Verifying whether bank account has been added successfully or not").isEqualTo(positiveTest);
  }
}
