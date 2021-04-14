![Boolean-Checker Build](https://github.com/Gatoke/boolean-checker/actions/workflows/gradle.yml/badge.svg)
[![codecov](https://codecov.io/gh/Gatoke/boolean-checker/branch/main/graph/badge.svg?token=GBGOX3RZJA)](https://codecov.io/gh/Gatoke/boolean-checker)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Are you tired of == != || && when comparing values?
- 

## Do you feel professionally burned out after a long day of writing code like this?

```java
boolean shouldHaveSomeRest = 
    selectedOption == FeelingEnum.TIRED
        || selectedOption == FeelingEnum.SLEEPY
        || selectedOption == FeelingEnum.RESIGNED;
```

#### It's time for change...

# REPRESENTING BOOLEAN-CHECKER:

```java
boolean shouldCodeMore = BooleanChecker.anyEqual(selectedOption,
        FeelingEnum.NOT_TIRED,
        FeelingEnum.NOT_SLEEPY,
        FeelingEnum.ABLE_TO_DO_MORE_JIRA_TASKS
);
```

---

## Interested? Here's more:

### 1. allTrue:

```java
boolean canPerformOperation = BooleanChecker.allTrue(
        userRepository.doesExist(userId),
        authorizationService.hasPrivileges(userId),
        operationType == SomeEnum.DEPOSIT
);
```

### 2. noneFalse (safe for null values!!):

```java
boolean canPerformOperation = BooleanChecker.noneFalse(
        userRepository.doesExist(userId),
        authorizationService.hasPrivileges(userId),
        null // it's totaly safe (no joke)!! treats "null" as not "false"
);
```

### 4. allFalse:

```java
boolean hasPermission = BooleanChecker.allFalse(
        authorizationService.isBanned(userId),
        paymentService.didExceedMonthlyLimit(userId)
);
```

### 5. noneTrue (also null safe):

```java
boolean hasPermission = BooleanChecker.noneTrue(
        authorizationService.isBanned(userId),
        paymentService.didExceedMonthlyLimit(userId),
        null
);
```

### 6. anyTrue (null safe):

```java
boolean hasAccess = BooleanChecker.anyTrue(
        authorizationService.isAdministrator(userId),
        authorizationService.isTester(userId)
);
```

### 7. anyFalse (null safe):

```java
boolean shouldBlockAccess = BooleanChecker.anyFalse(
        authorizationService.isTester(userId),
        authorizationService.hasPrivileges(userId)
);
```

### 8. allEqual:

```java
boolean haveWonEverywhere = BooleanChecker.allEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

### 9. allNotEqual:

```java
boolean didNotWinAnywhere = BooleanChecker.allNotEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

### 10. anyEqual (null safe!!):

```java
boolean haveWonSomewhere = BooleanChecker.anyEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

### 11. anyNotEqual (null safe!!):

```java
boolean haveFailedSomewhere = BooleanChecker.anyNotEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```
