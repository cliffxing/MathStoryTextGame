
import java.util.Scanner;
import java.util.Random;
public class XingCliffTextBasedGame
{
    private static Scanner scan = new Scanner (System.in);
    public static int generateRandomIntInRange(int min, int max) 
    {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

    public XingCliffTextBasedGame()
    {
        //variable declaration
        String name;
        int notprime=1,prime1=1,hostage=10,numhints=0;
        boolean win=true;
        int primeCorrect=0;
        int squadnum=generateRandomIntInRange(1, 999);
        
        //storyline
        System.out.println("Welcome to Prison Rescue! You are apart of squad  "+squadnum+" of the US SWAT Team and ");
        System.out.println("you are on a mission to rescue 10 innocent civilians that have been taken hostage");
        System.out.println(" by Mr. Evil Man! Quick! It's time to embark on your mission.");
        System.out.println("Before we begin, what is your name soldier?");
        name=scan.nextLine();
        System.out.println("Alright "+name+"! Let us begin our mission!");
        System.out.println("*All Messages not related to the story will be written in asterics*");
        System.out.println("*Please simply press enter to progress through the story*");
        System.out.println("You and your squad members finally reach Mr. Evil Man's headquarters after man days.");
        String story1=scan.nextLine();
        System.out.println("The headquarters is on a large snowy mountain in the middle of nowhere. A blizzard begins.");
        String story2=scan.nextLine();
        System.out.println("You and our team slowly approach the main entrance. 'Blow the door with the bomb!' your commander screams!");
        String story3=scan.nextLine();
        System.out.println("You and your teammates slowly take out the bomb, and attach it to the side of the metallic entrance. 'Planted!'");
        System.out.println("says your teammate Jacky Wang. The bomb requires a confirmation code to install a timer. Enter the number to execute the bomb!");
        System.out.println("*Please enter the answer to the following 3 questions. An error in any will instantly malfunction the bomb");
        System.out.println("and the mission will be failed. Please answer carefully.*");
        
        //multiplication questions
        int score=0;
        //loops 3 times (3 questions)
        for (int i=0;i<3;i++)
        {
            //generates the two numbers being multiplied
            int num1=generateRandomIntInRange(7,20);
            int num2=generateRandomIntInRange(7,20);
            int product1=num1*num2;

            System.out.println("What is "+num1+" x "+num2+"?");
            int answer1=scan.nextInt();
               //checks answer
            if (answer1==product1)
            {
                System.out.println("Excellent! *Your Score has increased by 100 points*");
                score=score+100;
            }   

        }
        //if the score is not equal to 300, end game 
        if (score<300)
        {
            System.out.println("Not all the answers were correct! The bomb explodes in your face and your entire");
            System.out.println("squadron dies. Better luck next time!");
            System.out.println("Score: "+score);
        }
        
        //game continues
        else
        {
            //storyline
            System.out.println("Excellent job! You have sucessfully planted the bomb! You hurry back for cover while the bomb explodes...");
            String story4=scan.nextLine();
            System.out.println("BOOM!");
            System.out.println("The door opens! You and your squad head into the base. You enter a room. The door suddenly closes behind.");
            String story6=scan.nextLine();
            System.out.println("A sign lies in the middle of the room. It Reads: 'Which Ones Prime? If you fail you DIEEEE!!!'");
            String story7=scan.nextLine();
            System.out.println("*You Will Be Given 2 Numbers. Enter which option is a prime number*");
            String story8=scan.nextLine();
            int y=0;
            //genrates non-prime number (loops until a non-prime is generated)
            while(y==0)
            {
                notprime=generateRandomIntInRange(1,100);
                Boolean ifPrime=primeCheck(notprime);
                if (ifPrime==false)
                {
                    y=1;
                }
            }
            
            //genrates prime number (loops until a prime is generated)
            int x=0;
            while (x==0)
            {
                prime1=generateRandomIntInRange(1,100);
                Boolean primeOrNot=primeCheck(prime1);
                if (primeOrNot==true)
                {
                    x=x+1;
                }

            }
            //randomizes which spot the prime will be in (in the question)
            int randomPlacement=generateRandomIntInRange(1,1);
            
            if (randomPlacement==1)
            {
                System.out.println(prime1+" or "+notprime);
                int primeans=scan.nextInt();
                //checks answer
                if (primeans==prime1)
                {
                    primeCorrect=1;
                }
                else
                {
                    primeCorrect=2;
                    
                }
            }
            
            else 
            {
                System.out.println(notprime+" or "+prime1);
                int primeans=scan.nextInt();
                //checks answer
                if (primeans==prime1)
                {
                    primeCorrect=1;
                    
                }
                else
                {
                    primeCorrect=2;
                }
            }

            
            
            //if wrong number is chosen
            if (primeCorrect==2)
            {
                //ends game
                System.out.println("Incorrect! The room collapses and you die! Game Over!");
                System.out.println("Score : "+score);
            }
            //game continues
            else if (primeCorrect==1)
            {
                //storyline
                System.out.println("Excellent! You are Correct! *Score increased by 100*");
                score=score+100;
                System.out.println("A secret door opens from within the walls! You and your team enter within.");
                String story9=scan.nextLine();
                System.out.println("You and our squad descend a dark staircase full of spiders.");
                String story10=scan.nextLine();
                System.out.println("You eventually reach a dungeon! The hostages have been found!");
                String story11=scan.nextLine();
                System.out.println("Dr. Evilman's voice is projected in the speakers!!!");
                System.out.println("'I have set a bomb on this entire hideout! The only way to free them ");
                System.out.println("is to open the lock on the cages using a 3 digit number!");
                String story12=scan.nextLine();
                System.out.println("*You will be given 6 guesses at the 3 digit number*");
                System.out.println("*After each attempt, a hint can be requested. However, ");
                System.out.println("after each hint is taken, a hostage is killed. Try to save as many hostages!");
                System.out.println("You will be rewarded 100 points for each hostage saved in the end. Good luck!");
                int password=generateRandomIntInRange(100,999); //generates the 3 digit number
                
                int whilecondition=0;
                int attempts=6;
                //loop that asks user for input and hints
                while(whilecondition==0)
                {
                    //asks for input
                    System.out.println("Please enter guess: ");
                    int guess=scan.nextInt();
                
                    //if number is chosen
                    if (guess==password)
                    {
                        //game is won! game ends
                        System.out.println("Wonderful! You free the prisoners and escape the hideout!!! Mission Success.");
                        int hostagescore=hostage*100;
                        int finalgamescore=hostagescore+score;
                        System.out.println("Final Score: "+finalgamescore);
                        System.out.println("Thank you for playing Prison Rescue!");
                        win=true;
                        break;
                        
                    }
                    
                    else
                    {
                        
                        attempts=attempts-1; //subtracts attempts user has left
                        System.out.println("You have "+attempts+" attempts left!");
                        
                        if (guess>password)
                        {
                            
                            System.out.println("The password was incorrect!!! Too High!!! "); //if too high
                            
                        }
                        else
                        {
                            
                            System.out.println("The password was incorrect!!! Too Low!!! "); //if too low
                        }
                        if (attempts==0)
                        {
                            break; //if no attempts, end loop
                        }
                        System.out.println("Would you like a hint? Enter '1' for yes or '2' for no"); //asks user for hint
                        int hintrequested=scan.nextInt();
                        
                        //following if statements will give hints depending on how many hints have been requested
                        if (hintrequested==1)
                        {
                            hostage=hostage-1;
                            numhints=numhints+1;
                            if (numhints==1)
                            {
                                System.out.println("One hostage has died");
                                
                                if (password%2==0)
                                {
                                    System.out.println("The password is an even number.");
                                }
                                else 
                                {
                                    System.out.println("The password is an odd number.");
                                }
                            }
                            
                            else if (numhints==2)
                            {
                                
                                int sumdigits=sumDigit(password);
                                System.out.println("The sum of the digits is "+sumdigits);
                            }
                            
                            else if (numhints==3)
                            {
                                Boolean passwordprime=primeCheck(password);
                                if (passwordprime=true)
                                {
                                    System.out.println("The number is not prime.");
                                    
                                    
                                }
                                else 
                                {
                                    System.out.println("The number is prime.");
                                }
                                
                            }
                            else if (numhints==4)
                            {
                                int factor=generateRandomIntInRange(2,20);
                                if (password%factor==0)
                                {
                                    System.out.println("The number is divisble by "+factor);
                                }
                                else
                                {
                                    System.out.println("The number is not divisible by "+factor);
                                }
                                
                            }
                            
                            else 
                            {
                                String stringpassword=Integer.toString(password);
                                System.out.println("The last digit of the number is "+stringpassword.charAt(2));
                            }
                            
                            if (attempts==0)
                            {
                                break;
                            }
                            
                            
                        }
                        
                        
                    }
                    
                }
                //user has lost. end game:
                System.out.println("You failed to detonate the bomb. The bomb explodes the entire hideout, and everybody dies. Game over!");
                System.out.println("Final Score: "+score);
                System.out.println("The 3 digit code was "+password);
                
            } 
        }   
        
    }
    //method that generates random num
    private static int digitGeneration()
    {
        int n = generateRandomIntInRange(0, 9);
        return n;

    }
    //method that checks if number is prime
    private static Boolean primeCheck(int n)
    {
        if (n==1)
        {
            return false;
        }
        for (int i=2;i<n-1;i++)
        {
            int modulus=n%i;
            
            if (modulus==0)
            {
                return false;
            }

        }
        return true;
    }
    //method that finds the sum of the digits of a number
    private static int sumDigit(int n)
    {
        int sum=0;
        while (n > 0) 
        {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
    
    }
    


    




