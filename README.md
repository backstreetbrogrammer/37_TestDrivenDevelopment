# Test Driven Development (TDD)

> This is a tutorials course covering Test-Driven-Development (TDD) in Java.

Tools used:

- JDK 11
- Maven
- JUnit 5, Mockito
- IntelliJ IDE

## Table of contents

1. [Introduction to Test-Driven-Development (TDD)](https://github.com/backstreetbrogrammer/37_TestDrivenDevelopment#chapter-01-introduction-to-test-driven-development-tdd)
    - [Testing Terminology](https://github.com/backstreetbrogrammer/37_TestDrivenDevelopment#testing-terminology)
    - [JUnit Test Example](https://github.com/backstreetbrogrammer/37_TestDrivenDevelopment#junit-test-example)
    - [Common Java Testing Frameworks](https://github.com/backstreetbrogrammer/37_TestDrivenDevelopment#common-java-testing-frameworks)
    - [Continuous Integration and Continuous Delivery (CI/CD)](https://github.com/backstreetbrogrammer/37_TestDrivenDevelopment#continuous-integration-and-continuous-delivery-cicd)
2. [JUnit in details](https://github.com/backstreetbrogrammer/37_TestDrivenDevelopment#chapter-02-junit-in-details)
3. Mockito in details
4. Design Tic-Tac-Toe game using TDD

---

## Chapter 01. Introduction to Test-Driven-Development (TDD)

**Test-driven-development (TDD)** is a software development process relying on software requirements being converted to
test cases **before** software is fully developed, and tracking all software development by repeatedly testing the
software against all test cases.

This is as opposed to software being developed first and test cases created later.

Test-driven development cycle:

1. **Add a test**
   > The adding of a new feature begins by writing a test that passes if and only if the feature's specifications are
   > met. The developer can discover these specifications by asking about use cases and user stories.
   > A key benefit of test-driven development is that it makes the developer focus on requirements before writing code.
   > This is in contrast with the usual practice, where unit tests are only written after code.
2. **Run all tests. The new test should fail for expected reasons**
   > This shows that new code is actually needed for the desired feature.
   > It validates that the test harness is working correctly.
   > It rules out the possibility that the new test is flawed and will always pass.
3. **Write the simplest code that passes the new test**
   > Inelegant or hard code is acceptable, as long as it passes the test. The code will be honed anyway in **Step 5**.
   > No code should be added beyond the tested functionality.
4. **All tests should now pass**
   > If any fail, the new code must be revised until they pass. This ensures the new code meets the test
   > requirements and does not break existing features.
5. **Refactor as needed, using tests after each refactor to ensure that functionality is preserved**
   > Code is refactored for readability and maintainability. In particular, hard-coded test data should be removed.
   > Running the test suite after each refactor helps ensure that no existing functionality is broken.
    - Examples of refactoring:
        - moving code to where it most logically belongs
        - removing duplicate code
        - making **names** self-documenting
        - splitting methods into smaller pieces
        - re-arranging inheritance hierarchies

**Repeat**

The cycle above is repeated for each new piece of functionality.

Tests should be small and incremental, and commits made often.

That way, if new code fails some tests, the programmer can simply undo or revert rather than debug excessively.

### Testing Terminology

**Code Under Test**

This is the code (or application) we are testing.

**Test Fixture**

A test fixture is a fixed state of a set of objects used as a baseline for running tests. The purpose of a test fixture
is to ensure that there is a well known and fixed environment in which tests are run so that results are **repeatable**.

Includes: input data, mock objects, loading database with known data, etc.

**Unit Tests / Unit Testing**

- Code written to test code under test
- Designed to test specific sections of code
- Percentage of lines of code tested is **code-coverage**
- Ideal coverage is in the **70-80%** range
- Should be **unity** and execute very fast
- Should have no external dependencies, i.e. no database, no Spring context, etc.

**Integration Tests**

- Designed to test behaviors between objects and parts of the overall system
- Much larger scope
- Can include the Spring Context, database, and message brokers
- Will run much slower than unit tests

**Functional Tests**

- Typically, means we are testing the running application
- Application is live, likely deployed in a known environment
- Functional touch points are tested - (i.e. Using a web driver, calling web services, sending / receiving messages,
  etc.)

![TestPyramid](TestPyramid.PNG)

All three types of tests play important roles for software quality.

The majority of tests should be **Unit Tests**

- Small, fast, lightweight tests
- Very detailed and specific

**Integration Tests** should be next largest category.

**Functional Tests** are smallest and least detailed of the categories.

**TDD**

- Test Driven Development
- Write tests first, code to **fix** tests, refactor code to clean-up, improve etc.

**BDD**

- Behavior Driven Development
- Very similar to TDD
- Describes the expected behavior of software
- Often expressed as: **when / then** OR **given / when / then**

**Which is better to use?**

- Use both!!

**Mocks**

- A fake implementation of a class used for testing
- A test double for dependent objects - like a datasource
- Can provide expected responses
- Can verify expected interactions

**Spy**

- Like a mock, but real object is used
- Mocks completely replace expected object
- Spys are wrappers, but with real object inside

### JUnit Test Example

Suppose we create our class `Guidemy` which has got one method:

```java
public class Guidemy {

    public String getCourse() {
        return "";
    }

}
```

Now, before writing any implementation of the method, we first start with **JUnit test class**:

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuidemyTest {

    @Test
    void testGetCourseMethod() {
        final Guidemy guidemy = new Guidemy();
        assertEquals("Advanced Java", guidemy.getCourse());
    }
}
```

When we run this test case, it will fail as we expect the course name to be returned as `Advanced Java`.

Now we **fix** the code:

```java
public class Guidemy {

    public String getCourse() {
        return "Advanced Java";
    }

}
```

This will pass the test now, and we are good to write some more test cases **first** and implement the main source code
accordingly.

After the test is passed, we will keep on **refactoring** the code and rerun the tests whenever the code is changed.

As it's a maven project -> we have the defined project structure.

![ProjectStructure](ProjectStructure.PNG)

### Common Java Testing Frameworks

**JUnit**

- The most popular testing framework for Java
- **JUnit 5** was released in September 2017
- **JUnit 5** will be the primary focus in this course

**TestNG**

- Created by Cédric Beust in 2004 as an alternative to JUnit
- Cédric wished to address deficiencies in **JUnit**
- Functionality of **TestNG** and **JUnit** have evolved to be very close
- It is still popular, but much smaller base

**Spock**

- Testing Framework in **Groovy** for testing Java
- Does require knowledge of Groovy
- Follows BDD approach
- Includes own Mocking framework
- Very popular where Groovy is used

**Cucumber**

- BDD Testing Framework
- Available for Java, Javascript, and Ruby
- Very popular in Ruby community
- Gaining popularity in Java community
- Uses Gherkin syntax
- Natural English like syntax
- Describe the what, not the how

**Mockito**

- Mocking framework for testing
- Only does mocks
- Need to use with testing framework such as JUnit or TestNG
- Top 10 Java Library
- Very popular for testing Spring applications
- Will be covered in this course

**Spring MVC Test**

- Testing module found in the Spring Framework
- Very versatile for testing Spring MVC Controllers
- Provides mock Servlet environment
- Used in conjunction with a testing framework such as JUnit, TestNG, or Spock

**REST Assured**

- Java framework for testing RESTful web services
- Provides very powerful DSL for testing Restful interfaces
- Can be used with Spring Mock MVC
- Tests follow a BDD Syntax

**Selenium**

- Web Browser Automation
- Allows us to write functional tests against web applications
- Only Web Browser Automation
- Need to use a Testing Framework such as JUnit, TestNG, or Spock

**GEB**

- Groovy Browser Automation
- Uses Selenium under the covers
- Has JQuery-ish page element selectors
- Needs to be used with a Test Framework
- Very popular to use with Spock

**Test Containers**

- Allows us to launch Docker containers from JUnit Tests
- Allows us to start databases, message brokers, etc. for integration and functional tests
- Can be combined with Selenium for testing web applications

### Continuous Integration and Continuous Delivery (CI/CD)

**Continuous Integration (CI)** is a development practice that requires developers to integrate code into a shared
repository several times a day. Each check-in is then verified by an automated build, allowing teams to detect problems
early.

Continuous Integration does not get rid of bugs, but it does make them dramatically easier to find and remove.

**CI Practices**

- Maintain a single source repository
- Automate build
- Make our build self-testing
- Every commit should build on integration machine
- Fix broken builds immediately
- Keep the build fast
- Test in a clone of the production environment
- Make it easy for anyone to get the latest executable version
- Everyone can see what is happening

**Common CI Build Servers**

**1. Self-Hosted**

Jenkins, Bamboo, TeamCity, Hudson

**Fun-Fact** - Jenkins forked from Hudson in 2010 due to a legal conflict with Oracle.

**2. Cloud-Based**

CircleCI, TravisCI, Codeship, GitLab CI, AWS CodeBuild, and many more.

**Continuous Deployment** will automatically deploy build artifacts after all CI tests have run.

**Continuous Deployment Practices**

- Should happen with every commit
- Completely automated
- May include a staging area from which additional automated tests are run
- Easily confused with **Continuous Delivery**
- Example: AWS CodePipeline

**Continuous Delivery (CD)** is the process to automatically deliver code changes directly to the Production
Environment.

**Continuous Delivery (CD) Practices**

- Involves a high degree of automation in Testing and Deployment
- Must have a *VERY* Mature Process
- Can be difficult in some industries due to Regulatory requirements
- This area is evolving
- Few Hard "Rules" - No Standard Way
- "Best Practices" are maturing, and still a lot of lively debate!

---

## Chapter 02. JUnit in details

