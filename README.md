# 🍔 The Jalisco Grill by Los Díaz
### Custom Food Shop – Capstone Project 2  
**Author:** Alexander Diaz  

Welcome to **The Jalisco Grill by Los Díaz**, a custom-built point-of-sale console application created for the Advanced Java OOP Capstone Project.

This application allows customers to build custom burgers, select toppings, order drinks, pick sides, review their order, and generate receipts — all through a clean, menu-based console interface.

---

## 📸 Application Screenshots  


### 🏠 Home Screen  

<img width="423" height="248" alt="1 HomeScreen" src="https://github.com/user-attachments/assets/32a225a9-cf65-4396-907d-1c78a0517bec" />


### 🛒 Order Menu  

<img width="426" height="346" alt="2 Menu Screen" src="https://github.com/user-attachments/assets/39205e36-3326-4432-b931-dc926c192f80" />


### 🍔 Burger Customization 

<img width="392" height="620" alt="3 BURGER CUSTOMIZATION" src="https://github.com/user-attachments/assets/2b4c3c1a-b25b-41b0-9d81-44a9356b795b" />


### 💳 Checkout  

<img width="398" height="544" alt="CHECKOUT SCREEN" src="https://github.com/user-attachments/assets/27482ba9-4b96-4609-8184-99c0a771c893" />



### 🧾 Receipt Example  

<img width="514" height="310" alt="5 Receipt" src="https://github.com/user-attachments/assets/1a126694-b66a-45fd-84ad-eda0718d32b8" />


---

## 🎨 UML Class Diagram  

<img width="771" height="1344" alt="TheJaliscoGrillByLosDiaz_ClassDiagram" src="https://github.com/user-attachments/assets/bc1aecd6-4b2f-4d5f-b116-59b1a76b6c8c" />


---

## 📦 Java Classes Overview

### 🏁 Main.java  
Runs the entire application and launches the main menu.

### 📋 Menu.java  
Displays all menus (burgers, drinks, sides, checkout) and handles user choices.

### 🛒 Order.java  
Stores all selected items, calculates totals, and builds the final order summary.

### 🍔 Burger.java  
Represents a customizable burger (type, size, toppings, special option) and calculates pricing.

### 🌶️ Topping.java  
Represents each topping and whether it is regular or premium.

### 🥤 Drink.java  
Stores drink type + size and calculates drink prices.

### 🍟 Side.java  
Represents side items such as fries, churros, or nachos with fixed pricing.

### 🧾 ReceiptWriter.java  
Generates and saves timestamped receipts in the `/receipts` folder.

---

## 📝 Project Description  
The **Jalisco Grill by Los Díaz** is a console-based point-of-sale system where customers can fully customize their food orders.

Customers can:
- ✔ Build custom burgers  
- ✔ Add regular & premium toppings  
- ✔ Choose side items  
- ✔ Select drink sizes & flavors  
- ✔ Review order summary  
- ✔ Automatically generate timestamped receipts  

The theme reflects Mexican heritage and Bay Area roots, adding a personalized cultural identity to the shop.

---

## 🛠 Features

### 🍔 Burgers  
**Types:** Beef, Chicken, Veggie  
**Sizes:** Small, Medium, Large  
**Special Option:** Double Patty  

**Toppings:**  
- **Regular:** jalapeños, serrano, onion, bell pepper, cactus, lettuce, tomato  
- **Premium:** bacon, cheese, avocado  

### 🥤 Drinks  
- Horchata  
- Sprite  
- Coke  
- Mexican Coke  
- Corona  
- Modelo  
(Sizes: Small, Medium, Large)

### 🍟 Sides  
- Churros + Fries  
- Nachos  
- Fries  

---

## 🧾 Receipt Format  
Receipts are automatically saved and displayed 

---

## 🔍 Interesting Code Example – Dynamic Burger Pricing

Below is a key method from my `Burger` class that calculates the final price of a custom burger.  
It adjusts pricing based on size, special options, and premium toppings:

```java
public double getPrice() {

    double basePrice = switch (size) {
        case "Small" -> 5.50;
        case "Medium" -> 7.00;
        case "Large" -> 8.50;
        default -> 7.00;
    };

    if (special) {
        // Double patty upcharge
        basePrice += switch (size) {
            case "Small" -> 1.00;
            case "Medium" -> 1.50;
            case "Large" -> 2.00;
            default -> 1.00;
        };
    }

    for (Topping t : toppings) {
        if (t.isPremium()) {
            basePrice += switch (size) {
                case "Small" -> 0.75;
                case "Medium" -> 1.50;
                case "Large" -> 2.25;
                default -> 1.00;
            };
        }
    }

    return basePrice;
}
