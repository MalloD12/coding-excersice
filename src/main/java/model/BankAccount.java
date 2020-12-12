package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class BankAccount
{
  private String bankBrand;
  private String accountName;
  private String accountType;
  private String accountNumber;
}
