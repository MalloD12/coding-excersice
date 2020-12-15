## XERO - Coding Exercise ##
Coding exercise implemented for user story: 
```"As a Xero User, In order to manage my business successfully,I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation."``` 

## Assumption/Starting Point
As starting point I assumed default organization as well as user credentials has been already created.

## Implementation/Design Decisions

- Created a BaseTest class to address WebDriver configuration in which I decided to quite driver as part of a @AfterEach method, this was to avoid having to implement 
Logout flow. 

### Project Download
If SSH public key is set do:
```
git clone git@github.com:MalloD12/coding-excersice.git
``` 
Else, if using any versioning tool (i.e. SourceTree) use below link from there when cloning:
```$xslt
https://github.com/MalloD12/coding-excersice.git
```

###Test Execution
- Tests scripts have been implemented as part of ```test``` module which are going to be executed when building the project.

For doing that we can simply execute below gradle command from project source directory:
```
gradlew clean build
```

or by running:

```$xslt
gradlew test
```

###Test results 
Can be found in `./coding-excersice/build/reports/tests/test/index.html`

###Lombok Library Utilization
To configure lombok library see: https://www.baeldung.com/lombok-ide