# GUI-Calculator-Infix-to-Postfix

Converting Infix to Postfix and Evaluating Postfix Expression. (Java &amp; Scala).


## Converting Infix to Postfix and Evaluating Postfix Expression.


**precedence**
1.  ( )
2.  *, /, %
3.  +, -

**Converting Infix to Postfix :** 

 **Examples**

- Infix : ((A * B) + (C / D))  -> Postfix : A B * C D / + 
- Infix : ((A * (B + C)) / D)  -> Postfix : A B C + * D /
- Infix : (A * (B + (C / D)))  -> Postfix : A B C D / + *
- Infix : A * B + C / D        -> Postfix : A B * C D /+ 
- Infix : A * (B + C) / D      -> Postfix : A B C + * D / 
- Infix : A * (B + C / D)      -> Postfix : A B C D / + *



**Sample input :** 
(7 - 8 / 2 / 2) * (( 7 - 2) * 3 - 6)

**output :** 
7 8 2 / 2 / - 7 2 - 3 * 6 - * 

Its value is : 45


**Run Program**

**Type an infix expression and press Enter**

(7 - 8 / 2 / 2) * (( 7 - 2) * 3 - 6 )

**The Postfix form is**

7 8 2 / 2 / - 7 2 - 3 * 6 - *  

**Its value is :** 45

# Sample Input and Output

- Input

1 - ![Input](https://i.postimg.cc/P5SSC9ZW/1.png)

2 - [![1st.png](https://i.postimg.cc/d3PwjJx7/1st.png)](https://postimg.cc/34BsKQ77)

- Output

![Input](https://i.postimg.cc/7ZtNH78X/2.png)
