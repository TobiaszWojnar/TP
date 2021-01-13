# Software systems engineering
## Object-oriented software systems engineering course at Wroclaw University of Science and Technology 2020/2021

### Lecture
[Wojciech Macyna, PhD](https://cs.pwr.edu.pl/macyna/)

Course curriculum:
* Use case analysis
* UML diagrams
* GRASP methodology
* Testing
* Design patterns
* Workflow methodology (Waterfall, RUP, Scrum)
* Hibernate framework
* Spring framework

### Supplemental instruction
[Anna Lauks-Dutka, PhD](https://cs.pwr.edu.pl/lauks/)

5 List of exercises.

* [List 1 - Use cases](Cw/original/List-1.pdf)
* [List 2 - UML](Cw/original/List-2.pdf)
* [List 3 - Design patterns](Cw/original/List-3.pdf)
* [List 4 - Design patterns](Cw/original/List-4.pdf)
* [List 5 - System analysis](Cw/original/List-5.pdf)

### Laboratory
[Wojciech Macyna, PhD](https://cs.pwr.edu.pl/macyna/)

Setup and detailed requirements for each list are in their folder. Below are brief notes on each exercise.

* ##### Lab 1
    * #### Requirements
        * Complete tutorial for `mvn`
        * Complete tutorial for `git`
        * Complete tutorial for `PMD` tool
        * Complete tutorial for `Checkstyle` tool
        * Complete tutorial for chosen `UML` tool
        * Create one application using tool above
    * #### What I Learned

* ##### [Lab 2 - Application issuing invoices with GRASP methodology](Lab/List-2)
    * #### Requirements
        * Application should enable issuing invoices with many items, each item has product, it's price and quantity.
        * Application should enable adding and showing invoices for specific clients.
        * No complicated GUI or saving data is required.
        * Use `Maven`, create unit tests, use `PMD` and `Checkstyle` plugins.
        * Create ULM class diagram.
        * Design system with GRASP rule. Propose usage of Mocking Objects.

    * #### What I Learned
        * better understanding usage of `Maven`.
        * Usage of UML plugins (`Skech It!` and `PlantUML`).
        * Working with IntelliJ generated tests.
        * Usage of `PMD` and `Checkstyle` plugins.
        * Splitting User Interface into Operations classes. 
        * Using Data Access Object Interface and how to implement it.
        * Dividing project with packages.
        * GRASP methodology.

* ##### [Lab 3 - Design patterns](https://code.google.com/archive/p/javatrainings/source/default/source?page=5)
    
    Based on [J. Pereiry's java training from Google Code Archive](https://code.google.com/archive/p/javatrainings/source/default/source?page=5)
    * ##### Exercises
        * Adapter pattern.
        * Builder pattern.
        * Singleton pattern.
        * Factory Method pattern.
        * Abstract Factory pattern.
        * Composite pattern.
        * State pattern.
        * Decorator pattern.
        * Facade pattern.

* ##### [Lab 4 -  Chinese checkers application](https://github.com/TobiaszWojnar/Chinese-checkers/tree/v1.1)
    * ##### Requirements
        * 
    * ##### What I Learned

* ##### [Lab 5 -  Chinese checkers in Spring and web app](https://github.com/TobiaszWojnar/Chinese-checkers)
    * ##### Requirements
        * Extend **Lab 4** with saving to database using Spring framework
        * Create web interface in JavaScript or JSP.
    * ##### What I Learned
