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

		========

		abstract ==> Incomplete
		Can't instantiate abstract classes

		================

		packages ==> logically group related classses [ entity, service , dao, utility]

		com.cisco.prj/module.classtype

		packages are folder
			"com" folder contains "cisco" folder contains "prj" --


		Tv[] tvs = ...

		Mobile[] mobiles = ...


		for(Tv t : tvs) {
				///
		}

		for(Mobile m : mobiles) {
				// ..
		}


		Microwave[] mws = ,,,,

		for(Microwave mw : mws) {
				///
		}

		===========

		TypeChecking:

		Product p = new Mobile();

		p instanceof Mobile ==> true

		p instanceOf Product ===> true

		p instanceof Object ===> true

		p instanceof Tv ==> false;


		=======
			Product p = new Mobile();
			p.getClass() == Mobile.class ===> true
			p.getClass() == Product.class ===> false
			p.getClass() == Object.class ===> false



		int x = 10;

		Object o = x;

		String s = new String();

		Object o = s;

	===========================================================================

		Realization Relationship
		========================
			A Component / Object will realize the behaviour specified by other in order to communicate.

			this is done using interfaces

		In Java:

			interface MobileDao {	
				void addMobile(Mobile m);
				Mobile getMobile(int id);
			}

		Why Program to interface:
			1) DESIGN
			2) IMPLMENTATION
			3) TESTING
			4) INTEGRATION
			5) LOOSE Coupling

			DESIGN: [ take the requirement and design interface]


			Class loader loads a class if the class is used any where in application

			Abc.java ==> Abc.class
			if Abc is not used in any part of application classloader wont load this class

			Not used like:
				Abc obj;
				or new Abc();


			If i Know class name in advance
				new className();

		=====================

		Functional Interface:

		Term given in Java 8 to specifiy that an interface has only one method
		to implement

		@FunctionalInterface
		interface Flyable {
			void fly();
		}


		not a functional interface:
		interface MobileDao {	
				void addMobile(Mobile m);
				Mobile getMobile(int id);
		}


		===============


		interface Flyable {
			void fly();
		}

		class Bird implements Flyable {
				// state
				// behaviour

				public void fly() {

				}
		}

		class AeroPlane implements Flyable {
				// state
				// behaviour
				public void fly() {

				}
		}

		Flyable f = new Flyable(); // ERROR
		Flyable f = new Bird(); // valid
		Flyable f = new AeroPlane() ; // valid

		=============
		Anonymous class: 
		Flyable f = new Flyable() {
			public void fly() {
					jump from 10th floor!!!
			}
		};

		class Dummy1 implements Flyable {
				public void fly() {
					jump from 10th floor!!!
			}
		}

		class Dummy2 implements Flyable {
				public void fly() {
					jump from 12th floor!!!
			}
		}

==================================================================

	Annotation
		==> Metadata ==> data about data
	From Java programmers perspective metdata is provided using XML or annotation

	SAX / DOM parsers are required to process XML data

	Annotation : Java Compiler itself can compile annoation


	Annotation:
		1) Who uses it?
			a) COMPILER
			b) CLASSLOADER
			c) RuNTiME
		2) Where can i place the annoation?
			a) TYPE [ class, interface, annotation , Enum]
			b) FIELD
			c) Constructor
			d) method

			override annotation:

			@Target(ElementType.METHOD)
			@Retention(RetentionPolicy.SOURCE)
			public @interface Override {
			}


				@Override
				public boolean isExpensive() {
					// write logic
					return false;
				}

			class Base {
					void doTask() {

					}
			}

			class Derived extends Base {
					@Override
					public void dotask() { // override

					}

					@Override
					public void taskDone() {

					}
			}

			Base b = new Derived();
			b.doTask();

Annotation:
		1) Who uses it?
			a) COMPILER
			b) CLASSLOADER
			c) RuNTiME
		2) Where can i place the annoation?
			a) TYPE [ class, interface, annotation , Enum]
			b) FIELD
			c) Constructor
			d) method


			@Target(ElementType.TYPE)
			@Retention(RetentionPolicy.CLASS)
			public @interface Mobile {
				String name(); // not a field, not a method; it's a property
			}

			@Mobile(name="Samsung")
			public class PubG extends Game {

			}


			Annotations can't have state and behaviour; it has only properties

			==========



			@Target(ElementType.METHOD)
			@Retention(RetentionPolicy.RUNTIME)
			public @interface RequestMapping {
				String value(); // not a field, not a method; it's a property
			}


			public class ProductController {

				@RequestMapping(value="http://localhost:8080/products")
				void doTask() {

				}
			}

			== within JRE
			if any requests come with "http://localhost:8080/products"
			======================================

			
