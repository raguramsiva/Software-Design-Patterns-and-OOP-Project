# Walkthrough


**Walkthrough Scenario:**  A customer enters their username, password, a product name, and a desired quantity of that product. The program will add the specified quantity of the product to the customer's shopping cart if the product is available and in stock. The program will provide a transaction summary. 

For example, the customer can enter the following inputs when prompted.
    
    "customer"

    "Bob24"

    "password123"

    "apple"

    "500"

**Further Details of Walkthrough Scenario involving Classes and Methods** 

First, the main method in the `WholesaleMain` class is executed. The main method creates an instance of `Transactions.TransactionSystem` and an instance of `UI.SystemInputOutput`. It then executes the `initialize` method within `Transactions.TransactionSystem` using the instance of `UI.SystemInputOutput` as parameter. The `initialize` method will then output a string prompting the user to input either ‘customer’ or ‘administrator’. After the user enters ‘customer’, a `Prompts.PromptIterator` instance is created with the `customer_prompts.txt` file used as a parameter. The file `customer_prompts.txt` contains a list of prompts that will be outputted to the user.  Next, an instance of `Uses.InventorySystem` is created with some default products (apple, banana, orange) added to the inventory using the `setInventory` and `createProduct` methods in `Uses.InventorySystem`.

The user is then prompted to input a username and password.  The `createCustomer` method from  `Uses.InventorySystem` is called with the username and password inputs taken as parameters.  For instance, the user inputs could be "Bob24" and "password123". The user is then asked to input a product name and the desired quantity of the product. For instance, the user inputs could be "apple" and "500" since "apple" is one of the default products in the inventory.  Finally, the`addToCart` and `cartTotal` methods in `Uses.InventorySystem` are called which take the customer, product name, and desired quantity as parameters. The customer's cart will contain the desired quantity of the product if it is available and in stock. Finally, a summary of the transaction is outputted to the user.
