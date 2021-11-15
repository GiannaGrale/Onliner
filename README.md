# Onliner
## The Test Automation Framework is developed using the following technologies:
+	Java 8.
+	Maven.
+ TestNG as an assertion library.
## Code style:
### File names
The source file name consists of the case-sensitive top-level class name that resides in that file, plus the .java extension. There can be only one top-level class in a file.

### Encoding
Source files are stored in UTF-8 encoding.

### Line length
The length of the line in the code has a limit of 120 characters. Any line larger than the limit must be split into 2 lines, as described in the section Line breaks.
Exceptions:
Strings for which it is impossible to meet the limit (for example, a long URL);
Package name and imports.

### Package name
The package name is not delimited by a line break. The specified line length does not apply to the package name line.
### Line breaks
There is no exact formula or algorithm for breaking lines in every situation. The main goal is to make the code more understandable and clear, and not necessarily fit into the minimum number of lines. Thus, the author can put the code to another line, even if it was within the limit.

### Wrapped line indentation - 8 spaces
When breaking lines, each wrapped line after the very first one is indented to the left by 8 spaces from the starting line. In general, the indentation for 2 wrapped lines will be the same only if they start with syntactically parallel constructs.

### Empty spaces:
#### Vertical blank space
##### One blank line is used:
+	Between successive class members: fields, constructors, methods, nested classes, static initialization, initialization of class instances.
+	Exception: an empty line between 2 fields is optional (if there is no other code between them). Such blank lines can separate logical groupings of fields.
+	Between expressions to isolate logical subsections.
+	Optionally before the first member of the class or after the last one.
+	Multiple blank lines in a row are allowed, but not required.
#### Horizontal blank space
##### A single ASCII space occurs in the following places (in addition to requiring language syntax, literals, comments, and javadoc):
+	Separates any reserved word such as catch, for, or if from the opening parenthesis that follows on that line
+	Separates any reserved word, such as else or catch, from the closing curly brace that precedes this word on this line
+	Before any open curly brace ({) except: @SomeAnnotation ({a, b}) (no empty space)
##### On both sides of any binary or ternary operator. This also applies to similar symbols:
+	Ampersand in type intersection: <T extends Foo & Bar>
+	A pipe for a catch block that handles multiple exceptions: catch (FooException | BarException e)
+	Colon (:) in for ("foreach")
+	Arrow in lambda expression: (String str) -> str.length ()
##### But does not apply to:
+	Two colons (: :) for a method reference, in the form Object :: toString
+	For a separator point when calling a method, in a record like object.toString ()
+	After the closing parenthesis in a cast
+	On both sides of the double slash (//), which starts a comment at the end of the line.
+	Between type and variable in definition: List<String> list.
##### The rules apply to whitespace within a line, not indentation (discussed further).
  ## Enum Classes
After the definition of the Enum constant separated by comma a line break is needed. Enum classes obey the general rules for class styling.

## Defining Variables
Only one variable is defined per line.
Each definition (field or local variable) consists of only one variable: definitions of the form int a, b; are not used.

## Arrays
Square brackets are placed next to the type, not the variable itself: String [] args, but not String args [].

## Switch blocks
One or more groups of statements are located inside the brackets in a switch block. Each group contains one or more labels (for example FOO: or default :) followed by statements.

## Indentation
As with other blocks, content is accessible by +2 spaces. After the tag, there is a line break, and the indentation is increased by +2 spaces again. The next tag is on the previous level, as if the block was closed.
Dips in the following tags: not used.
Inside a switch block, a group of statements ends with a break, continue, return, or throwing an exception. Dips in the next tags are unacceptable - this greatly reduces readability, and it is difficult to visually distinguish and track the logic. Exceptions are made only for empty tags. Each switch must have a default tag, even if it does not contain any code.

## Annotations
Annotations are applied to a class, method or constructor and placed immediately after the documentation block on a separate line (one annotation per line). The left indent does not increase after annotation. There are no special rules for formatting annotations on parameters, local variables, types.

## Comments
Block comments have the same left indentation as the surrounding code. They can be written in the style / * ... * / or // ... For multi-line comments, subsequent lines can start with *, which is aligned with the asterisk on the previous line.
## Modifiers
Class and method modifiers are placed in the order recommended by the Java Language Specification:

public protected private abstract default static final transient volatile synchronized native strictfp
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
## Type variable names
### Each type variable is named in one of 2 ways:
+	One capital letter, optionally followed by a number (e.g. E, T, X, T2).
+	A name similar to the name of the class, followed by a T (for example: RequestT, FooBarT).
## Static class members: specified through the class name
When there is a need to refer to a static field or method of a class, it is defined with the name of the class, not with a reference to an object or expression that returns an object of the type of that class.
 ## TAF Features overview:
Each test method has next annotations:
+ @Test - a mandatory annotation for test run;
+ @BeforeMethod - define the code that should be runned before a method\test method.
+ @AfterMethod - define the code that should be runned after a method\test method.
	
## Test execution
	Right click on the test -> Run Test;

