
package appmain;
import java.util.Scanner;

import dao.LoginDetailsDao;
import dao.BookDetailsServiceImpl;
import dao.LoginDetailsDaoImpl;
import model.UserDetails;
import dao.BookDetailsService;
import model.Book;
import repository.BookDetailsDAO;


public class UserInterface {



public static void main(String[] args) {
// TODO Auto-generated method stub 

                         System.out.println("****Welcome Online Library Management*****");


                          System.out.println("1: Sign up");
                          System.out.println("2: Sign In");
                          System.out.println("3: Exit");
                          char ch;
                          System.out.println("*********************");
                          
                          LoginDetailsDao LoginDao=new LoginDetailsDaoImpl();
                          BookDetailsDAO bookDao=new BookDetailsDAO();
                          BookDetailsService bookService=new BookDetailsServiceImpl();
                          String username,firstname,lastname,password, mobileno,role;
                          String bookName,author,price;
                          int BookID;
                              do {
                          System.out.println("What you do wish to check from the above list");


                         Scanner sn = new Scanner(System.in);
                         int option=sn.nextInt();

                         switch(option)
                           {

                           case 1:System.out.println("enter the details to signup");

                             System.out.println("Enter username");
                             username=sn.next();

                              System.out.println("Enter firstname");
                              firstname=sn.next();

                             System.out.println("Enter lastname");
                             lastname=sn.next();

                             System.out.println("Enter password");
                             password=sn.next();

                            System.out.println("Enter mobileno");
                           mobileno=sn.next();
                           
                           System.out.println("Enter your role");
                           role=sn.next();
                           
                           UserDetails user=new UserDetails();
                          user.setUsername(username);
                          user.setFirstName(firstname);
                          user.setLastName(lastname);
                          user.setPassword(password);
                          user.setMobileno(mobileno);
                          user.setRole(role);
  LoginDao.signUp(user);
/*create table userdetails(
firstname varchar(20) not null,
lastname varchar(20),
username varchar(20) primary key,
password varchar(20) not null,
mobileno varchar(10) not null,
role varchar(20) not null
)
*/
      
                    
                                 System.out.println("********Successfully signUp**********");
                                  break;
                                  case 2:
                                  System.out.println("enter the username and password to login");
                                  String usern=sn.next();
                                  String pass=sn.next();
                                  UserDetails details=new UserDetails();
                                  details.setUsername(usern);
                                  details.setPassword(pass);
                                  String res=LoginDao.signIn(details);
                                  if ((("Login failed").equals(res)))
                  					System.out.println("login failed");
                  				else {
                  					System.out.println("login successful");
                  				
                  					
									if ("customer".equals(res)) {
                  						System.out.println("***********Welcome CUSTOMER " + usern + "****************");
                  						System.out.println("1:List of Books");
                  						System.out.println("2:Purchase");
                  						System.out.println("*************************************************************");
                  						int Customeropt=sn.nextInt();
                  						switch (Customeropt){
                  						case 1:
                  							System.out.println("List of Books");
                  							LoginDao.getBooks();
                  							break;
                  						case 2:
                  							System.out.println("Purchase");
                  							System.out.println("Enter your bookID");
                  							BookID = sn.nextInt();
                  														
                  							System.out.println(bookDao.PurchaseBook(BookID));
                  							break;
                  						}
                  					} else if ("admin".equals(res)) {
                						System.out.println("***********Welcome ADMIN " + usern + "****************");

                						System.out.println("1: Get books");
                						System.out.println("2: Insert book");
                						System.out.println("3: Update book");
                						System.out.println("4: Delete book");
                						System.out.println("5: Exit");
                						System.out.println("*************************************************************");
      /*create table book(
       BookID  varchar(20) not null primary key,
       BookName varchar(50) not null,
       Author varchar(50) not null,
       Price Varchar(30)not null
           );*/
        						
                						

                						int Adminopt = sn.nextInt();
                						
										switch (Adminopt) {
                						case 1:
                							System.out.println("List of Books");
                							LoginDao.getBooks();
                							break;

                						case 2:
                							System.out.println("enter the Bookdetails to Insert");

                							System.out.println("Enter your bookID");
                							BookID = sn.nextInt();
                							System.out.println("Enter your bookName");
                							bookName = sn.next();
                							System.out.println("Enter your author");
                							author = sn.next();
                							System.out.println("Enter your price");
                							price = sn.next();

                							Book book = new Book();
                							book.setBookID(BookID);
                							book.setBookName(bookName);
                							book.setAuthor(author);
                							book.setPrice(price);

                							System.out.println(bookDao.insertBook(book));
                							break;

                						case 3:
                							System.out.println("enter the Bookdetails to Update");

                							System.out.println("Enter your bookID");
                							BookID = sn.nextInt();
                							System.out.println("Enter your bookName");
                							bookName = sn.next();
                							System.out.println("Enter your author");
                							author = sn.next();
                							System.out.println("Enter your price");
                							price = sn.next();

                							Book book1 = new Book();
                							book1.setBookID(BookID);
                							book1.setBookName(bookName);
                							book1.setAuthor(author);
                							book1.setPrice(price);

                							System.out.println(bookService.updateBook(book1));
                							break;

                						case 4:
                							System.out.println("enter the Bookdetails to Delete");

                							System.out.println("Enter your bookID");
                							BookID = sn.nextInt();

                							System.out.println(bookService.deleteBook(BookID));
                							break;
                						case 5:
                							System.exit(0);
                						default:
                							System.out.println("enter a valid option");
                						}
                					}
                				}
                				break;
                			case 3:
                				System.exit(0);
                			default:
                				System.out.println("enter a valid option");
                			}
                			System.out.println("Do you wish to check other options");
                			ch = sn.next().charAt(0);

                		} while (ch == 'y' || ch == 'Y');

                	}

                }

