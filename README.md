# StringCalculatorJava
  Input: a string of comma-separated numbers
  Output: an integer, sum of the numbers

# 1.Create a simple String calculator
  ![Testcase1](Screenshots/Testcase1.png)
  ![Testcase1_1](Screenshots/Testcase1_1.png)

# 2.Allow the add method to handle any amount of numbers.
  ![Testcase2](Screenshots/Testcase2.png)
  ![Testcase2_1](Screenshots/Testcase2_1.png)


# 3.Allow the add method to handle new lines between numbers (instead of commas). ("1\n2,3" should return 6)
  ![Testcase3](Screenshots/Testcase3.png)
  ![Testcase3_1](Screenshots/Testcase3_1.png)

# 4.Support different delimiters: To change the delimiter, the beginning of the string will contain a separate line that looks like this: "//[delimiter]\n[numbers…]". For example, "//;\n1;2" where the delimiter is ";" should return 3.
  ![Testcase4](Screenshots/Testcase4.png)
  ![Testcase4_1](Screenshots/Testcase4_1.png)

# 5.Calling add with a negative number will throw an exception: "negative numbers not allowed <negative_number>".If there are multiple negative numbers, show all of them in the exception message, separated by commas.
  ![Testcase5](Screenshots/Testcase5.png)
  ![Testcase5_1](Screenshots/Testcase5_1.png)

# 6.Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
  ![Testcase6](Screenshots/Testcase6.png)
  ![Testcase6_1](Screenshots/Testcase6_1.png)

# 7.Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
  ![Testcase7](Screenshots/Testcase7.png)
  ![Testcase7_1](Screenshots/Testcase7_1.png)

# 8.Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
  ![Testcase8](Screenshots/Testcase8.png)

# 9.make sure you can also handle multiple delimiters with length longer than one char
  ![Testcase9](Screenshots/Testcase9.png)






