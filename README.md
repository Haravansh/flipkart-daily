**Overview**

.  Flipkart Daily is a Spring Boot-based backend service for managing an inventory of grocery and daily essential products. The application allows users to add items to inventory, search using filters, and sort results efficiently.

**Tech Stack:**

Java 17

Spring Boot 3+

**Features**

Add Items & Inventory: Users can add products and their inventory details.

Search Functionality: Users can filter products by category, brand, price range, and sorting.

Inventory Management: Displays current inventory with structured output.

Unit Testing: JUnit test cases implemented for key functionalities.

**Known Issues & Workarounds**

Lombok Annotations Issue: Due to an unexpected error, some Lombok annotations (e.g., @Getter, @Setter) are not working correctly. To resolve this, getter and setter methods have been manually added in some classes.
