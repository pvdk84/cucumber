# cucumber

Example of a Cucumber test project.

I've included three different kinds of test.
- Unit-like test of a calculator.
- Screen test for Wikipedia, with Selenium.
- API test for Google Books, with Rest-Assured.

I've also made a RunTest class, which acts as a JUnit TestRunner.

I've also added tags: @UnitTest, @ScreenTest, @ApiTest.
These can be used to group tests, and run them together.
You can tag a whole feature, an individual test, or even example sections.
To run e.g. @ScreenTest and @UnitTest from command line, type:
mvn test -Dcucumber.options="--tags @UnitTest,@ScreenTest"

Useful sources:
- https://docs.cucumber.io; cucumber documentation
- https://www.seleniumhq.org/docs/; selenium documentation
- www.rest-assured.io/docs; rest-assured documentation
- www.any-api.com; overview of public APIs (e.g. YouTube, Google, etc.)
- http://appsdeveloperblog.com/rest-assured-evaluate-json-response-body/
- http://angiejones.tech/rest-assured-with-cucumber-using-bdd-for-web-services-automation/