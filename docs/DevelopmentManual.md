---
layout: default
---

[Back](index).

# Development manual
*The development manual describes what is needed and how to get the project to build on a fresh machine, source control client and access to source control Build environment and other necessary dependencies for development.*

## Requirements
* Git
* Java 8+ (either openjdk or oraclejdk should work)
* Gradle

## Testing
To test the application run `gradle check`, all new code should be tested.

## Building the jar file
Building the jar file is as simple as running `gradle jar`. That will deposit a jar file inside `build/libs`
which you can run.

## Walkthrough
1. `git clone https://github.com/hopur0/TicTacToe`
1. `cd TicTacToe`
1. Create feature branch
1. Make changes
1. `gradle check`
1. If all checks pass, and you are happy with your code, you can create a pull request and request a review for it.
