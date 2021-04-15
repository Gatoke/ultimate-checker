![logo](docs/ultimate-checker-logo.png)

![Ultimate-Checker Build](https://github.com/Gatoke/ultimate-checker/actions/workflows/gradle.yml/badge.svg)
[![codecov](https://codecov.io/gh/Gatoke/ultimate-checker/branch/main/graph/badge.svg?token=GBGOX3RZJA)](https://codecov.io/gh/Gatoke/ultimate-checker)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

### Are you tired of == != || && when comparing values?

![tired cat](docs/tired_cat.jpg)

### Do you feel professionally burned out after a long day of writing code like this?

```java
boolean shouldHaveSomeRest = 
    selectedOption == FeelingEnum.TIRED
        || selectedOption == FeelingEnum.SLEEPY
        || selectedOption == FeelingEnum.RESIGNED;
```

![angry cat](docs/angry_cat.jpg)

#### It's time for change...

# REPRESENTING ULTIMATE CHECKER:

```java
boolean shouldCodeMore = Check.anyEqual(selectedOption,
        FeelingEnum.NOT_TIRED,
        FeelingEnum.NOT_SLEEPY,
        FeelingEnum.ABLE_TO_DO_MORE_JIRA_TASKS
);
```

![relaxed cat](docs/relaxed_cat.jpg)

---

### Interested? Here's more:

![interested cats](docs/interested_cats.jpg)

- #### 1. allTrue:

```java
boolean canPerformOperation = Check.allTrue(
        userRepository.doesExist(userId),
        authorizationService.hasPrivileges(userId),
        operationType == SomeEnum.DEPOSIT
);
```

- #### 2. noneFalse (safe for null values!!):

```java
boolean canPerformOperation = Check.noneFalse(
        userRepository.doesExist(userId),
        authorizationService.hasPrivileges(userId),
        null // it's totaly safe (no joke)!! treats "null" as not "false"
);
```

- #### 4. allFalse:

```java
boolean hasPermission = Check.allFalse(
        authorizationService.isBanned(userId),
        paymentService.didExceedMonthlyLimit(userId)
);
```

- #### 5. noneTrue (also null safe):

```java
boolean hasPermission = Check.noneTrue(
        authorizationService.isBanned(userId),
        paymentService.didExceedMonthlyLimit(userId),
        null
);
```

- #### 6. anyTrue (null safe):

```java
boolean hasAccess = Check.anyTrue(
        authorizationService.isAdministrator(userId),
        authorizationService.isTester(userId)
);
```

- #### 7. anyFalse (null safe):

```java
boolean shouldBlockAccess = Check.anyFalse(
        authorizationService.isTester(userId),
        authorizationService.hasPrivileges(userId)
);
```

- #### 8. allEqual:

```java
boolean haveWonEverywhere = Check.allEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

- #### 9. allNotEqual:

```java
boolean didNotWinAnywhere = Check.allNotEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

- #### 10. anyEqual (null safe!!):

```java
boolean haveWonSomewhere = Check.anyEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

- #### 11. anyNotEqual (null safe!!):

```java
boolean haveFailedSomewhere = Check.anyNotEqual(username,
        electionsService.getWinnerFrom("Śródmieście"),
        electionsService.getWinnerFrom("Żoliborz")
);
```

---

### Compatibility:
The project is tested with Java 8 but there's no usage of Java 8's specific API, so it should be compatible with Java 7 also.
