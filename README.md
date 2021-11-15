# Onliner
## The Test Automation Framework is developed using the following technologies:
+	Java 8.
+	Maven.
+ TestNG as an assertion library.
## Code style:
## Package names
Package names are written in lower case, words are simply concatenated sequentially with each other (no underscores).

## Class names
Class names are written in UpperCamelCase.
Class names are usually nouns or noun phrases. For example, Character or ImmutableList. Interfaces can also be called nouns or phrases with nouns (for example, List), but sometimes they can be adjectives or phrases with adjectives (for example, Readable).
There are no special rules for naming annotations.
+ Test classes start with the name of the class they are testing and end with Test. For example, HashTest or HashIntegrationTest.
+ Page classes start with name of the class and end with Page. For example, LoginPage.
+ Step classes start with the name of class and end with Step. For example, SuccessfulRegistrationStep.

## Method names
Method names are written in lowerCamelCase.
Method names are usually verbs or verb phrases. For example, sendMessage or stop.

## Constant names
Constant names use CONSTANT_CASE: all letters are uppercase, words are separated by underscores. Constant names are usually nouns or phrases with nouns.

## Non-constant field names
Non-constants (static or not) are written in lowerCamelCase. These names are usually nouns or phrases with nouns. For example, computedValues or index.

## Parameter names
Parameter names are written in lowerCamelCase. Single-character parameter names in public methods should be avoided.
#### Local variable names
Local variable names are written in lowerCamelCase. Even when they are final and immutable.
 ## TAF Features overview:
The following annotations are used:
+ @Test - a mandatory annotation for test run;
+ @BeforeMethod - define the code that should be runned before a method\test method.
+ @AfterMethod - define the code that should be runned after a method\test method.
	
## Test execution
	Right click on the test -> Run Test;

