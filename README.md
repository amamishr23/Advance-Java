# Advance Java Training

Banuprakash C
Co-founder Lucida Technologies Pvt Ltd.,

Full Stack Architect

banu@lucidatechnologies.com

banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/

GitHub: https://github.com/BanuPrakash/CISCO_2020
==================================================

Softwares Required:
1) JDK 8: [Java SE 8u261]
	https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

2) Eclipse for Java Enterprise Developers
	https://www.eclipse.org/downloads/packages/release/2020-06/r/eclipse-ide-enterprise-java-developers

3) MySQL 5: [ Not MySQL 8: few issues with 8]
	Download document shared on GIT [https://github.com/BanuPrakash/CISCO_2020]

==================================================

	Day 1: Recap of OOP using Java
	Day 2: Java Collection Framework, Java 8 streams
	Day 3, Day 4 and Day 5: Web application, Spring, RESTful web services using Spring Boot and ORM [ Hibernate]

==========================================================

	SOLID Design Principles:

		S ==> Single Responsibility
		O ==> Open Close Principle
		L ==> Liskov Substitution Principle
		I ==> Interface Segreagation
		D ==> Dependecny Injection


	Single Responsibility: Every object has one responsibility

	we have seperate objects for interacting with persistence,
	business logic, UI
		In Enterprise application, we logically divide the classes/objects as:

			1) Entity classes / Domain classes / Model classes
				==> They contain state which is mapped to persistence
				==> constructor to create objects
				==> setters and getters [ accessors and mutation ]
				==> equals() for object identity [ unique]

				== vs equals()

				class Product { 					Product p1 = new Product(1,"iPhone 11");
					..								Product p2 = new Product(1,"iPhone 11");
				}


				(p1 == p2) ==> false [ compares references ]
				p1.equals(p2); // should evaluate to true ; but we need to override this method in Product.java

				class Object {
						public boolean equals(Object o) {
								return this == o;
						}
				}

			2) DAO classes : Data Access Object 
				These classes contain CRUD operations
					SQL [ INSERT, UPDATE, DELETE and SELECT]

			3) Service:
				generally they act as facade over DAO
				they combine many fine grained operations of DAO into coarse grained and makes them atomic


				class BankingService {
						public void transferFunds(Account acc1, Account to, double amt) {
								SELECT if amount is present in acc1 ==> FROM [ DAO]
								UPDATE acc1 account [DAO]
								UPDATE acc2 account [DAO]
								INSERT INTO transaction table [DAO]
								SEND SMS
						}
				}


				UI: ==> transferFunds("SA102", "SA456", 6000);


				==> Services are generally : one per actor [ CustomerService, ManagerService]
				one per module
					Uber [ PaymentService / DriverService / CustomerService/ TripService]

			4) Utility:	
					Helpers
						implement Date conversion, Currency Conversion
						implement sorting 
			5) Exception classes:
				They represent any abnormal condition that arises during program execution
			6) UI:
				User interface classes

	=====================

		O ==> Open Close Principle
			Any object / component should be closed for a change but open for extension

			once this sort function is written; it should be close for change
			open for extension [ as of today, it can sort existing entities [ Product, ORder, Customer]]

			If we come with new entity: Category ==> the same sort() fn should be able to
			sort Category
			public void sort(....) {

			}
===================================

		L ==> Liskov Substitution Principle

		==> Generalization and Specialization
		At any point in your application a "Specialized object" should be able to replace
		a "Generalized object" and get the work done of what "Generalized was doing".

===================

	I ==> Interface segregation
		expose functionalites required by different objects using  different interfaces


		Banking application: BankingService
		I my provide Customer interface [ transcation, my account details], 
		Manager interface[ add account, suspend account]

======================

	D ==> Dependency Injection
		Inversion Of Control

	Training in CISCO campus:
		10:30 Tea Break , 3:00 Tea break
		I go in search of Vending machine, before that I need to get cup

	with DI:
		Day 1: Course co-ordinator asks [ Time of break, my options [ Tea / Coffee]]

		Course Co-rodinator assigns [ Office boy]

		Exactly duriing my tea break ; i get Tea / Coffee

	========

	Account.java
	public class Account {
			private double balance;

			public void deposit(<<Account this,>> double amt) {
					this.balance += amt;
			}
	}

	AccountClient.java
	public class AccountClient {
			public static void main(String[] args) {
					Account rahulAcc = new Account();
					Account swethaAcc = new Account();
					rahulAcc.deposit(6000);
					swethaAcc.deposit(8000);
					System.out.println("Hello!!!")
			}
	}


	==> Compilation Stage [ Development Kit]

	Source Java ==> Java compiler ===> Bytecode [ .class]

	Kotiln ==> Kotlin Compiler ===> Bytecode [ .class]



	javac Account.java ===> Account.class
	javac AccountClient.java ===> AccountClient.class

	================

		Runtime ==> Java Runtime Environment
		Platform + APIs



	Always first argument to an instance method is "implicit this" ==> refers to the context

	context.behaviour();

		tv.on();
		light1.on();
		rahulAcc.deposit(56666);
	====================================================

	Java Tools:
		1) Checkstyle 
			to check naming convetions and line spaces, empty spaces, brackets

		2) PMD/ Softbugs / Findbugs
			check coding stds:
				1) No Dead code
				2) empty catch block
					try {
							// code
					} catch(Exception ex){}
				3) Copy Paste code
					DRY ==> Don't repeat Yourself

	Relationship between objects:
		1) Generalization and Specialization
		2) Realization
		3) Association
			

		

		


	