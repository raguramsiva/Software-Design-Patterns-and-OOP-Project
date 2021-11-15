## Phase 1 Progress Report

**Open Questions:**

1. We are currently using gradle to build our project. In Phase 2, we are hoping to develop a GUI and web application. Should we consider alternatives to gradle?

2. We are currently using JSON files and a JSON reader/writer as our database. All our business rules are in our use case classes. What additional functionality would we gain by using SQLite as opposed to sticking with JSON files? 

**What has worked well with our design:**

1. Our `PromptIterator` class which implements the Iterator Design Pattern allow us to easily extend our program by adding new prompts through `.txt` files without having to do any hard coding.  We can even use this `PromptIterator` to give users instructions in a GUI. 

2.  Our use of JSON files allow us to easily create new product categories for our inventory. And our `DatabaseInput` class iterates through every `.json` file within the `database/data` directory. Hence, we can always create a new product category by creating  a `.json` file and simply drop it in the `database/data` directory without having to add any additional java code. 


**What each group member has been working on and plans to work on next**

**Raguram Sivabalan:** Inverted the dependency between our UI class and main controller so that the UI class `SystemInputOutput` is now dependant on the controller class `TransactionSystem`.  Modified the database class so that data is read from `.json` files as opposed to `.txt` files. Implemented the Facade design pattern for our `TransactionSystem` class which now delegates responsibilities to the following classes: `InventorySystem`, `UserManager`, and `DatabaseInput`. 

Plans to work on GUI with dropdown menus and buttons. Also plans on creating an account or password manager for users of our program that will persist across program runs. 

**Yong Tong Zhu:** Created the `DatabaseInput` class as well as categories for our products; i.e. (Fruits and Vegetables, Household products, etc.). Initially, these files were stored in `.txt` files but are now stored in `.json` files after TA advice. 

Plans to implement the Template Method Design Patterns to allow for various store memberships (gold membership, silver membership, etc.) which provide customers with discounts and other perks. 

**Yiyang Du:**  Added additional product categories as `.json` files for our `DatabaseInput` class. 

Plans on further developing our database class and data files to allow for more product categories. 

**Shijia Ye:**  Plans on further developing our database class and data files to allow for more product categories. 
