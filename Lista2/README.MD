# Faktura maker
### List 2 -  application issuing invoices with GRASP methodology.

### Programing Technologies Course
Object-oriented programming course in Java at Wroclaw University of Science and Technology
2020/2021

#### Setup
```
    mvn package
    java -cp target/Lista2-1.0-SNAPSHOT.jar InvoiceApplication
```

#### Requirements
* [x] Application should enable issuing invoices. 
Invoice has many items, each item has product, it's price and quantity. 
* [x] Application should enable adding and showing invoices for specific clients. 
No complicated GUI or saving data is required.
* [x] Create ULM class diagram.
* [x] Design system with GRASP rule.
* [x] Design system for easy usage of different database. 
Use Pure Fabrication rule. Propose usage of Mocking Objects.
* [x] Use `PMD` and `Checkstyle` plugins.
* [x] Create unit tests.
* [x] Use `Maven`.

#### What I Learned
* better understanding usage of `Maven`.
* Usage of UML plugins (`Skech It!` and `PlantUML`).
* Working with IntelliJ generated tests.
* Usage of `PMD` and `Checkstyle` plugins.
* Splitting User Interface into Operations classes. 
* Using Data Access Object Interface and how to implement it.
* Dividing project with packages.
* GRASP methodology.