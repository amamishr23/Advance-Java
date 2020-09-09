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


			@Target(ElementType.TYPE)
			@Retention(RetentionPolicy.RUNTIME)
			public @interface Table {
				String name();  
			}

			@Target(ElementType.METHOD)
			@Retention(RetentionPolicy.RUNTIME)
			public @interface Column {
				String name();  
				String type();
			}

			@Table(name="emps")
			public class Employee {

				@Column(name="EMP_ID", type="NUMERIC(12)")
				getId() {

				}
				@Column(name="ENAME")
				getName() {

				}
			}

		===========

		String is immutable

		String s1 = new String("Hello");

		s1 += "World";

		s1 += "123";

		s1 += "Bye";

============================================================

	Day 2:
	------
		Recap: Generalization and Specialization; Realization

		keywords: extends; implements 

		Object is the root class of all classes in Java

		-----------------

		interface; anonymous class and lambda expression

		---------------

		Annotations; RetentionPolicy.RUNTIME

		--------------------------------------------

		Any Questions?

	-------------------------------

		Java Collection Framework:

			2 interfaces for comparing:
				a) Comparable
					Natural Comparison:
					String[] names = {"George", "Lee", "Angelina", "Brad" , "Clooney" };
					We expect the sorted order to be:
					Angelina, Brad , Clooney, George and Lee

					Why not:
					Lee, Brad, George, .... Angelina [ Isn't this sorted?]

					Logic is a part of class on wich comparision happens:
						Example: String and Product has the logic
							public int compareTo(Object obj);
				b) Comparator
					Custom implmentation of comparision;
					Example: String compare by length

					Logic is a part of client code

					Lee, Brad, George, .... Angelina [ Isn't this sorted?]

					interface Comparable {
						int compareTo(Object o);
					}

					interface Comparator {
							int compare(Object o1, Object o2)
					}

					======

					public class String implements Comparable {
							//
							public int compareTo(Object o) {
									context is "this" [ s1 ]
									argument is "o" [ s2 ]
							}
					}

					String s1 = new ...
					String s2 = new ....

					s1.compareTo(s2); // 


					compare(s1,s2); // in client code

		============

		Comparable should be generally used to compare on PK field of the class

		for any other field comparison we should use comparator in client
		private int id;
		Product:
		@Override
		public int compareTo(Product o) {
			return this.id - o.id;
		}

		Client: comparison based on name, price or category goes in client [ Comparator]
		private String name;
		private double price;
		private String category;


		===========

			Java Collection Frameworks provides "Arrays.java" which contains methods
			to find "max", "min"; to 
			"sort" and "binarySearch", .... on array type data

			This class uses Comparable / Comparator to perform the above mentioned operations

		interface Comparator {
			int compare(Object o1, Object o2);
		}

		public Employee implements Comparator {

				public int compare(Object o1, Object o2) {
						Employee e1 = (Employee) o1;
						Employee e2 = (Employee) o2;
						return e1.id - e2-id;
				}
		}


		interface Comparator<T> {
				int compare(T o1, T o2);
		}

		public Employee implements Comparator<Employee> {

				public int compare(Employee o1, Employee o2) {
					 	return o1.id - o2-id;
				}
		}


		================================================

		Array type of container limitation:
			a) Size is fixed
			b) adding / removing from arbitrary position is difficult
			c) Need contiguous memory


		Java Collection Framework provides "List" data container
		List:
			a) ordered collection
			b) size is not fixed
				capacity doubles if it reaches the limit

				List of size 8; when we add 9th element
				List capcaity increases to 16

			c) supports adding duplicate elements
			d) supports index based operations

			add(4, obj);
			get(3);
			remove(10);	


			interface Iterator<String> {
					boolean hasNext();
					String next();
					String remove();
			}


			Vector: depricated

				==> Type Safe collection
				==> All methods in VEctor are synchronized
					==> Slow

			ArrayList and LinkedList ==> allows concurrent access [ not synchronized]
			===============

			ArrayList list = new ArrayList(); // avoid this

			List list = new ArrayList();

			list = new LinkedList();


			Avoid non-generic collection // not type-safe
				List list = new ArrayList();
				list.add("A");
				list.add(new Mobile());
				list.add(new Date()); 
				if(list.get(i) instanceof String) {
					String s = (String) list.get(i);
				}

			===========

			List<String> list = new ArrayList<String>();

			List<String> list = new ArrayList<>(); // java 7+ 
			list.add("A");
			list.add(new Date());  // compilation error

			String s = list.get(i); 


			List<?> different from List<Object>

			? ==> unknown type
			? ==> allows accessors; won't allow mutation


			==========
			Product
				Mobile extends Product
				Tv extends Product

			List<? super Mobile> list

				? can be Mobile; Product or Object


			List<? extends Product> list
				can be Product; Mobile or Tv

			===

			PECS ==> Producer Extends Consumer Super
		==============================================================================

			Java 8 streams:

			OOP:
				methods ==> tightly coupled to state of object
				class Account {
					double balance;
					void deposit(double amt) {
							balance += amt
					}
				}

			Functional style of programming:
				functions ==> not tightly coupled to an object

				sort() ; filter()


				Functional style of programming uses High Order Functions [ HOF ]
					HOF;
						a) a function which accepts other function as argument
						b) function which returns a function
						==> treat functions as first class members [ similar to primitive / object]

			On java 8 stream

			Stream ==> A Channel along which a data flows [ from Network / Database / File / Collection]

			we can use the below HOF:
				a) filter()
					gets a subset of data [ input is n ; output is m records]
					accepts predicateFn

				b) map()
					to transform the data [ n ==> n]
					accepts transformFn

				3) forEach
					traverse accepts Consumer as a function

				4) reduce()
					accepts aggregateFn

					max(); min(); sum(); count(); etc.....	

				....

			map() and filter() are intermediary functions

			forEach(), collect() and reduce() are terminal functions



			products.stream()
			.filter(p -> p.getCategory().equals("mobile"))
			.forEach(consumer);



			boolean test(Product p) {
					return p.getCategory().equals("mobile");
			}

			=========

			I need to get sum of price of all products

			=====

			Task: get sum of all price of mobiles

			=====================================

			Map ==> storage in the form of key / value pair

			Dictionary / DNS server registry / Employee registry / OS software [ regedit]

			=============================

			HashCode:
				1) two similar objects should have same hashcode
				2) possiblity is 2 dissimilar objects can also have same hashcode


			Map<String, Double> map = new HashMap<>();

			map.put("Java", 1200.00);
			map.put("JS" , 899.00);
			map.put("Oracle" , 1200.00);

			{
				computer=[Product [id=645, name=Hp Laptop, price=135000.0, category=computer], Product [id=834, name=Logitech Mouse, price=600.0, category=computer], Product [id=88, name=HP Printer, price=19000.0, category=computer]], 

				tv=[Product [id=5, name=Sony Bravia, price=125000.0, category=tv]], 

				mobile=[Product [id=224, name=iPhone, price=98000.0, category=mobile], Product [id=912, name=One Plus, price=32000.0, category=mobile]]
			}

			forEach(p -> System.out.println(p));

			forEach(System.out::println) ; // method reference


		===================================



			Any Questions?

				stream ==> map(), filter(), reduce(), forEach(), collect(), skip(), limit()

			List data contaimer
			Map data container

		=============================================

		MySQL installed ?


		============================================================

		Web application with JDBC to connect to MySQL database 

		Approach:
			Maven based standalone application to connect to MySQL
			=> convert this to web based application



		JDBC ==> Java Database connectivity
			==> integration APIS to connect to database
			==> java provides interfaces
			==> implementation classes are provided by database vendors


		Steps:

			1) we need to load classes provided by database vendors

				Class.forName("database driver class");

				Class.forName("oracle.jdbc.OracleDriver");

				Class.forName("com.mysql.jdbc.Driver")


				==> these implmentation classes are provided in the form of
				libraries ==> JAR files


			2) Establish a database connection:
				Done using getConnection() factory method

				Connection is an interface

				Connection con = DriverManager.getConnection(URL, USER , PWD);

				based on URL getConnection() creates OracleConnection / MySQLConnection

				URL
				jdbc:oracle:thin:@156.123.44.12:1521:CISCO_DB

				jdbc:mysql://localhost:3306/CISCO_DB


			3) Send SQL==> following interfaces are provided by Java

				a) Statement
					if SQL is fixed
						"select * from products"
				b) PreparedStatement
						if SQL accepts IN parameters
						select * from users where username = ? and password = ?

					Avoid creating SQL using string concatination

					"SELECT * FROM accounts WHERE custID='" + request.getParameter("id") + "'";

					?id=' or '1'='1

					"SELECT * FROM accounts WHERE custID= or 1 = 1"
				
				c) CallableStatement
					to invoke stored procedure

					In database:

						create or replace procedure TRANSACTIONS(FROM , TO , AMT)	
								SQL1
								SQL2
								SQL3
						END


						from Java: call TRANSACTIONS({'SB102', 'SB134', 5000})

			4) ResultSet
				==> cursor to fetched records of database

			5) Release the resources in finally block

				try {
						// code
				} catch(SQLException ex) {
						// exception handling
				} finally {
					con.close();
				}
			========================================



		Maven: uses pom.xml ==> Project object model

			is a java build tool
			a) manages dependecies [ 3rd part libaries]
				also manages transitive dependency
					<dependency>
						<groupId>org.apache.abc</groupId>
						<artifactId>ModuleOne</artifactId>
						<version>1.2.0</version>
					</dependency>

					This inturn may depend on 
					other jar files [ or.apache.commons; collections; 5.6 version]


			b) Configure goals
				clean compile test sonar package deploy

				SONAR ==> checkstyle , findbugs

			c) Providing Stds for application folder structure
				Maven projects are portable across IDEs
				==> Which Java version version, etc


			groupID ==> project
				com.uber

			artificatID => drivermodule

			version 1.0.0

			groupID ==> project
				com.uber

			artificatID => customermodule
			version 1.0.0

			=========================

		

			Day 3
			=====

			Web application development
			---------------------------

			Recap:
				DaoException class ==> provide abstraction to client

				Backend we might use SQL / NoSQL / FileSystem to store data

				Each one of these throws different exception like IOException, SQLException, ...

				We catch them and use DaoException to re-throw

				client has to have only catch(DaoException ex) { }

			==========

			Product getId(int id) throws DaoException {
				select statement 
				try {
				if(rs.next()) {
					Product p = new Product(rs.getInt(id), ..)
				} else {
					throw new DaoException("Product with " + id + " doesn;t exit  !!!");
				}
				} catch(SQLException ex) {
					throw new DaoException("unable to get product" , ex);
				}
			}

			=============================================

			Building Traditional web application using Servlet technology:

			Servlet is a technology using which we write server side code using Java as programming
			language
				Servlet technology has the following components:
					a) Servlet
					b) JSP
					c) Filters
					d) Listeners

				These components execute with an container called as Web Container / Servlet Container / Servlet engine

			We have different containers like "Tomcat" , "Jetty" , "JRocket" , ...


			Servlets are multi-threaded

			@WebServlet("/register")
			public class RegisterServlet extends HttpServlet {

			}



			===========

			login.html
				<html>
					<body>
						<form method="post" action="login">
							2 text box to accept username and pwd
							button to submit
						</form>
					</body>
				</html>


			JavaScript:
				React / Angular / jQuery / Vanila JS

				a.js
					$.ajax("uRI", function(data) {
						//process the data ..
					});

				a.js will execute in Browser / Engine has no role in executing this



	HTTP Methods:
		Traditional web application development we use "GET" and "POST" http methods

		any request from "address bar" and "hyper link" is a "GET" request to server
		[ any data sent to server is visible in address bar ]

		limitation -- 255 characters

		"POST" request is generally from "FORM" data [ payload is sent ==> data in body]	
		submitted data is not visible in address bar
		No limitation

			@WebServlet("/register")
			public class RegisterServlet extends HttpServlet {
				// dependecy injection
				public void doGet(HttpServletRequest req, HttpServletResponse res) {

				}

				public void doPost(HttpServletRequest req, HttpServletResponse res) {

				}
			}

		=========================



		Prior to Servlet 2.5 version we used XML for metadata instead of Annotations

		public class RegisterServlet extends HttpServlet {
				// dependecy injection
				public void doGet(HttpServletRequest req, HttpServletResponse res) {

				}

				public void doPost(HttpServletRequest req, HttpServletResponse res) {

				}
			}


		web.xml ==> Deployment descriptor
			<servlet>
				<servlet-name>First</servlet-name>
				<serlvet-class>com.cisco.prj.web.RegisterServlet</serlvet-class>
			</servlet>

			<servlet-mapping>
				<servlet-name>First</servlet-name>
				<url-pattern>/register</url-pattern>
			</servlet-mapping>

		without web.xml: @WebServlet("/register")


		=======


		javac RegisterServlet.java

		jar /src/*.* -xvf example.war


		=======================



		webapp ==> folder contains "view" related files like [ HTML / CSS / JS / image and JSP pages]


		"src/main/java" ==> Servlets/ Filter/ Listener reside along with other java code


		MIME types:
			image/gif
			image/png

			text/plain
			text/css
			text/html



		Goals:
			jetty:run

			or 

			tomcat:run

			depending on maven plugins added


		Prefer Servlets as Controller ==> should have application logic [ Flow of application ]

		Use HTML as presentation [ for pure static content]

		Use JSP as presentation [ static + dynamic content ]

		Java Server Pages ==> JSP 


		*.do ==> FrontController

		addProduct.do

		deleteProduct.do

		login.do

		register.do

		logout.do


		ServerSide Redirection : can be used for multi stage processing of data
		request.getRequestDispatcher("list.jsp").forward(request, response);


		${p.id} ==> out.print(p.getId())

		${p.price} ==> out.print(p.getPrice())

		===============================


		Servlet / JSP
			==> execute based on URI request from client

		Listeners ==> run within a servlet engine similar to JSP and Servlet
					  They execute based on events and not for client request

		ServletContextListener gets executed when an application is deployed / undeployed

			contextIntialized()
			contextDestroyed()

			==> generally any initialization required for the web application can be done here:
				Example: our own custom Thread pool
					reading from properties file 
					configuration

		=======================================

		Http Protocol is a stateless protocol:
		Doesn't understand the conversational state of a client, treats every request as comming from new client

		Tracking converstational state of client is important for many application:
			a) Email
			b) Shopping
			c) online exam
			.....

		Session Tracking is the ability given to server side code to track conversational state of client
			a) Cookie
			b) URL Rewriting


			${user}

				JSTL searchs in "request", "session" , "context"


			<%
				String user = (String) session.getAttribute("user");

			%>


====================================================================================================================

	JSP ==> Dynamic + static content
	HTML ==> static content [ very rarely we use this]
	index.html ===> index.jsp [ so that i can display messages ]

	Servlet
		==> Should be used as controller [ locus for interaction between View and backend]

	Listeners
		==> ServletContextListener
			==> whenever application is deployed / undeployed they get excuted
		==> HttpSessionListener
			==> HttpSession created or calling invalidate() 
		==> HttpSessionAttributeListener
			if any data is added to session / remove data from session

	HttpSession ==> to keep track of conversational state of client

	========================================================================================


 	public void contextDestroyed(ServletContextEvent sce)  { 
 		close connections
    }

	 
    public void contextInitialized(ServletContextEvent sce)  { 
    		Pool of database connection [100]
    }
  ==========================================================================

  