# cse237-project

We are creating an executable program that will return data about the stock market or a specific ticker. By prompting the user to input a ticker and some data they are interested in finding out, we will be able to return that data. With the vested interested in the stock interest amongst young people recently, we hope that this program will be able to print out data in a digestible format and be easy for new traders to understand.


**Iteration 3:**
**What user stories were completed this iteration?**
#
This iteration we were not able to accomplish quite as much as we wanted to due to the API our program was built around going offline with only a few days left to work. Despite needed to completely overhaul the API requests and subsequent JSON parsing, we were able to add a couple new features. Firstly, we added a "Company Info" option that displays data such as the Industry, Exchange, and IPO of the company (this capability is a result of our new API!). Another option added is a profit/loss calculator where you enter the number of shares you purchased and the price they were purchased at, then your profit or loss will be displayed based on the most recent prices. Lastly, the option to graph the yearly price fluctuations of a stock was added. You can get to this option by selecting "Yearly Price Information" (3) and selecting "Yes" when given the option to export the data as a graph. JUnit tests were also updated and expanded on in this iteration.

**Is there anything that you implemented but doesn't currently work?**
#
No! Everything is working properly. You may have the program output errors but this is due to our limit of 30 API calls/minute.

**What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)**
#
clone our repository and run the program with either "bash run.sh" or "./run.sh" (you may need to change file permissions with "chmod +rwx run.sh)

**Iteration 2: **
**What user stories were completed this iteration?**
For this iteration, we focused on fixing our code based on the feedback we recieved last iteration. First, we focused on splitting up our main function and put them in different files. This allowed us to add more tests that we did not have during the first iteration. A new UI was implemented, now after a ticker is entered there are options for: price, daily change, yearly change and the option to enter a new ticker instead of just the price option. We also added a "dev" branch and other offshoot branches because our code was all in the master during the first iteration.

**What user stories do you intend to complete next iteration?**
Since we focused on cleaning up our code this iteration, we still have many of the same goals that we had last time. Our code already returns the basic information about the different stocks, so we would like to allow the stock trader to get more in depth information about the stocks they input, like standard deviaiton or moving averages.

**Is there anything that you implemented but doesn't currently work?**
While creating our tests, we ran into some issues with our UI Test and our Parser Test that we are still working through. Also, the dev branch has the updated Unit tests but the script is currently only working for the master branch (you can still run through eclipse in the dev branch though). Other than that everything should work.

**What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)**
In the master branch, run "bash run.sh" and the program will compile and run everything for you.



Iteration 1: What user stories were completed this iteration? For a trader, this program allows them to input a stock signal and learn information about that stock. This information includes the latest price of the stock and the highest and lowest prices allowing them to know what trades to place based on their own judgement.

What user stories do you intend to complete next iteration? The user stories we intend to complete is to allow traders to gain more in depth information about stocks they are interested in, such as standard deviation or moving averages. This would allow the trader to gain more insight on the markets and better decide potential actions to take.

Is there anything that you implemented but doesn't currently work? Everything should currently work.

What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!) "java -cp "path to Jsonsimple.jar" api.java"
