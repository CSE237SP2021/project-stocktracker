# cse237-project

We are creating an executable program that will return data about the stock market or a specific ticker. By prompting the user to input a ticker and some data they are interested in finding out, we will be able to return that data. With the vested interested in the stock interest amongst young people recently, we hope that this program will be able to print out data in a digestible format and be easy for new traders to understand.

Iteration 2:
What user stories were completed this iteration?
For this iteration, we focused on fixing our code based on the feedback we recieved last iteration. First, we focused on splitting up our main function and put them in different files. This allowed us to add more tests that we did not have during the first iteration. We also added a "dev" branch and other offshoot branches because our code was all in the master during the first iteration. 

What user stories do you intend to complete next iteration?
Since we focused on cleaning up our code this iteration, we still have many of the same goals that we had last time. Our code already returns the basic information about the different stocks, so we would like to allow the stock trader to get more in depth information about the stocks they input, like standard deviaiton or moving averages. 

Is there anything that you implemented but doesn't currently work?
Everything should work. 

What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
Run "bash run.sh" and the program will compile everything for you.

Iteration 1:
What user stories were completed this iteration?
For a trader, this program allows them to input a stock signal and learn information about that stock. This information includes the latest price of the stock and the highest and lowest prices allowing them to know what trades to place based on their own judgement. 

What user stories do you intend to complete next iteration?
The user stories we intend to complete is to allow traders to gain more in depth information about stocks they are interested in, such as standard deviation or moving averages. This would allow the trader to gain more insight on the markets and better decide potential actions to take. 

Is there anything that you implemented but doesn't currently work?
Everything should currently work. 

What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
"java -cp "path to Jsonsimple.jar" api.java"
