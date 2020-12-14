package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Organisation
{
  private String businessName;
  private String industry;
  private String country;
  private boolean hasEmployees;
  private boolean registeredForGST;
}
