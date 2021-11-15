
# Phase 1 Design Document

## Updated Specification
  
**Wholesale Inventory Management System**  
  
An inventory management system for a wholesale business similar to Costco. The inventory system can be accessed by two types of users (administrators and customers) using login credentials (username and password). The inventory system has an inventory that contains all of the store products. There is a name, price, and stock quantity associated with each product in the inventory.  
  
Each customer is able to add products to a personal shopping cart. Customers can add a desired quantity of a particular product if that product is available and if there is a sufficient quantity of that product in stock. Administrators are able to add new products to the inventory, modify prices of products, and modify product stock quantities.  **Store products are organized by categories (i.e. fruits and vegetables, household products, etc. )**

Store memberships are available which can provide store discounts to customers. Memberships will have an associated membership number, membership expiration date, mobile number, payment method, and shipping address.

**Note:** Changes to the specification from Phase 0 is in bold above. 


## Additional Functionality added since Phase 0

We added a database class that can read and write data from JSON files which contain products that will be injected into our inventory. Products are organized by product categories (i.e. fruits and vegetables, household products, etc.).

Our program now has **data persistence**. Whenever an administrator adds a product to the inventory, the product is also added to the database. Similarly, whenever an administrator modifies the price or stock quantity of an existing product in the inventory, the database is updated accordingly. When a customer successfully adds a product of a specified quantity to their shopping cart, the stock quantity of that product within the database is updated accordingly. 

Note: Initially the data files were `.txt` files, but we later switched to `.json` files after TA advice. 


## UML Class Diagram

A UML class diagram is provided within the `phase1` folder in `UML_diagram.pdf` and `UML_diagram.uml` formats. 

## Major Design Decisions

1. We decided to use text files and a text reader/writer as a database to store the products of our inventory. After TA advice, we switched to JSON. We made this decision so that we can quickly attain data persistence for Phase 1.  Any changes in our inventory (i.e. price or stock quantity of a product) is reflected in our database class, and the underlying JSON files. These changes persist across runs of our program. 

2. We decided to change our `TransactionSystem` class by using the Facade Design Pattern. In Phase 0, the `TransactionSystem`  had too many responsibilities.  We now delegate responsibilities to the classes `UserManager`, `DatabaseInput`, `InventorySystem` in accordance with the Facade Design Pattern.  

3. We decided not to rely too much on a command line interface moving forward since we would like to have a GUI with buttons, dropdown menus, etc within a web application. It isn't practical for a user to be expected to always correctly type in commands. It is also impractical to deal with exceptions from a command line interface when users provide incorrect inputs. Hence, we kept the command line interface somewhat minimal in Phase 1. However, we will still use the PromptIterator to give users instructors for our program in a GUI in Phase 2. 

## How our Project adheres to Clean Architecture

In Phase 0, our program had a major violation of Clean Architecture. Our main controller class `TransactionSystem` was dependant on our UI class `SystemInputOutput`. We inverted this dependency so that `SystemInputOutput` is now dependant on `TransactionSystem`. 

Our dependencies now all point inwards. i.e. Classes in the outer layer all depend on classes within the same layer, or depend on classes in the next inner layer. Our classes are now well encapsulated. 

Moving forward, we can easily replace our command line UI with a GUI without having to change the underlying business rules of our use case classes. If we choose to use SQLite to replace our current database, we do not have to change our InventorySystem class which contains all of the business rules of our products. 


## How our Project adheres to SOLID principles

**Single Reponsibility Principle**:  Our classes are each responsible for a single function of our program.  In Phase0, our `TransactionSystem` violated the Single Responsibility Principle and had many responsibilities (creating users, inventory management, etc.). But now responsibilities are separated and delegated to the classes `UserManager`, `DatabaseInput`, `InventorySystem`.  Now, `TransactionSystem` serves as a facade, in accordance with the Facade Design Pattern. 

**Dependency Inversion Principle**: In Phase 0, our main controller class `TransactionSystem` was dependant on our UI class `SystemInputOutput`. We inverted this dependency so that `SystemInputOutput` is now dependant on `TransactionSystem`. 

**Open/Closed Principle**: Our classes are well encapsulated and hence, are open to extension, but closed to modification. We can easily extend our program by adding a graphical user interface (GUI) with buttons and drop-down menus without having to change code within our controller and use case classes. 


## Design Patterns Used so Far

**Iterator Design Pattern:** We used the Iterator Design Pattern for our `PromptIterator` class. It contains `hasNext()` and `next()` methods which allows us to iterate through command prompts which will later be provided to the user of our program. 

**Facade Pattern:** We used the Facade Design Pattern for our TransactionSystem class. In phase 0, the TransactionSystem class was initially responsible for multiple actors and had multiple responsibilities (creating users, inventory management, etc.). Now, with the Facade Design Pattern, we now consider `TransactionSystem` class as a Facade class, and delegate responsibilities to the following classes: `InventorySystem`, `UserManager`, and `DatabaseInput`.  The `InventorySystem` class creates an inventory, `DatabaseInput` injects products into this inventory, and `UserManager` creates and manages users. 


## Packaging Strategy

We packaged our classes according to layers of Clean Architecture. Our UI, database, Controller, Gateway, Use Case and Entity classes are all in separate layers. 

We did this to simplify the number of import statements that we required. Within any class, import statements are only made to other classes within the same layer, or the first inner layer. For instance, our database class `DatabaseInput` has one import statement, namely  `import uses.InventorySystem` which imports the use case class `InventorySystem` from the `uses` package. 

We also chose this packaging strategy to allow us to easily catch any obvious violations of Clean Architecture. 


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
