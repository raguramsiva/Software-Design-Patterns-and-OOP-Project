# Progress Report

# Brief Summary of Specification

(Shortened, summarized version of the specification is below)

An inventory management system for a wholesale business similar to Costco. There are two types of users, administrators and customers who have login credentials (username and password) that can access an inventory system. The inventory system has an inventory that contains all of the store products where each product has a name, price, and stock quantity.  Customers are able to add products to a personal shopping cart if they are available and in stock. Administrators are able to add new products to the inventory, modify prices of products, and change product stock quantities. Store memberships are available which provide store discounts to customers. 

# Brief Summary of CRC cards

The program contains **4 Entity Classes**, **2 Use Case classes**, **2 Controller classes** and **3 other Interface Adapters**. 

**Entity Classes**: `User`, `Administrator`, `Customer`, `Product`

**Use Case Classes**: `InventorySystem`, `Membership`

**Controller Classes**: `TransactionSystem`, `WholesaleMain`

**Other Interface Adapters**: `PromptIterator` (Gateway Class), `InputOutput`, `SystemInputOutput`

**Note:** Clearly controllers are part of interface adapters, but they are listed separately above for emphasis since Phase0 requires at least one controller.

**Note**:  For the presentation, have the CRC card pdf open.  

# Brief Summary of Scenario Walkthrough

**Scenario**:     A customer enters their username, password, a product name, and a desired quantity of that product. The program will add the specified quantity of the product to the customer's shopping cart if the product is available and in stock. The program will provide a transaction summary. 

**Note**:  Use the project files while presenting the walkthrough scenario to highlight bits of code. 

# Brief Summary of Skeleton Program

The Skeleton Program has all 11 classes/interfaces contained in the CRC cards. The `TransactionSystem` has code sufficient for the walkthrough scenario involving a customer making a purchase of a product in the store inventory. A `customer_prompts.txt` file contains all the prompts necessary for the walkthrough scenario.

**Note**:  During the presentation, open the project files in IntelliJ and run the main method to demonstrate the walkthrough scenario. 


# What has worked well in the design so far

The `PromptIterator`is able to read from arbitrary text files. Hence, we can always quickly add new text files for administrators, memberships, etc. that can be easily read through. This will allow us to easily extend our program for Phase 1 and Phase 2. We are in a good position to add more command prompt text files for administrators and customers with memberships. And we can easily refactor the `TransactionSystem` class accordingly. So our program is in a solid position to be easily extended in accordance with Clean Architecture. 


# What everyone has done and plans on doing

As a group, everyone contributed to the Specification and CRC cards during group meetings. In these meetings, we designed the
basic entity and use case classes. 

**Raguram Sivabalan:**
Created the `TransactionSystem` class and other basic classes. Plans on creating a command prompt text file for administrator and write corresponding code in the `initialize` method in `TransactionSystem`.

**Yong Tong Zhu:**
Created the  `Membership` class and `MembershipTest`.  Plans on creating command prompt text files for customers with memberships and write corresponding code in the `initialize` method in `TransactionSystem`.

**Yipu Lu:**
Designed the initial entity and use case classes. Plans on adding a database to obtain a large number of products for the store inventory. 

**Yiyang Du:**
Designed the initial entity and use case classes. Plans on refactoring the `TransactionSystem` class using helper methods and other classes. 

**Shijia Ye:**
Designed the initial entity and use case classes. Plans on adding code to add product categories to the store inventory (i.e. produce, frozen goods, etc.)




