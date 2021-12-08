## Phase 2 Progress Report

**Open Questions:**

1. Our program improved since Phase 1 in regard to adhering to Clean Architecture and Solid Principles. We refactored our code quite a bit and created boundary interfaces. Are there any obvious violations of clean architecture remaining in our code?

2. We used 5 design patterns explicitly in our program. Are there any additional design patterns that our program could have used?

**What has worked well with our design:**

1. Our main method in WholesaleMain is nice and short with only 2 lines of code in the body. So the entrypoint of our program is very concise.

2. Our `PromptIterator` class which implements the Iterator Design Pattern allow us to easily extend our program by adding new prompts through `.txt` files without having to do any hard coding.  We even use this `PromptIterator` to give users instructions in our command line user interface.

3. Our use of JSON files allow us to easily create new product categories for our inventory. And our `DatabaseAccess` class iterates through every `.json` file within the `database/data` directory. Hence, we can always create a new product category by creating  a `.json` file and simply drop it in the `database/data` directory without having to add any additional java code.


## What each group member has been working on since Phase 1

**Raguram Sivabalan:** Added a few boundary interfaces between layers of our program. Implemented the Factory design pattern for the `TransactionSystem`. Implemented the Singleton design pattern for the `MenuUI`. Created the Main Menu for the command line user interface allowing users to view product categories and individual product information in a table. Added test classes and refactored code.

Pull Request/Github Link: https://github.com/CSC207-UofT/course-project-group-009/pull/30

This pull request was for creating the main menu of our program and allow users to view product categories in a table within the command line user interface.

**Yong Tong Zhu:** Implemented the Template Design pattern for the store memberships. Added command-line prompts for the store memberships for customers. Added product categories to the database. Added test classes.

Pull Request/Github Link: https://github.com/CSC207-UofT/course-project-group-009/pull/29

This pull request was for implementing the Template design pattern and for creating the command prompts for store memberships for customers in the command line user interface.

**Yiyang Du:**  Worked on the login system of our program which uses serialization. Added product categories to the database.


**Shijia Ye:**  Worked on the login system of our program which uses serialization.