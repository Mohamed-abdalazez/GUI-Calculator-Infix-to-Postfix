package com.company

import scala.collection.mutable.Stack
import scala.util.control.Breaks

// Main object
object get {

  trait getAssistantFunction {
    // Assistant Function
    def precedence(c: Char): Int
    def operation(a: Int, b: Int, c: String): Int
    def isOperator(c: String): Boolean
  }
  trait getMainFunction {
    // Main Functions
    def convertFromInfixToPostfix(s: String): String
    def evaluatingAPostfixExpression(s: String): Int
  }

  class assistantFunctions extends getAssistantFunction {
    /*
     * implementation of assistant Functions
     * def precedence(c:Char):Int
     * def operation(a:Int, b:Int, c:String):Int
     * def isOperator(c:String):Boolean
     */
    def precedence(c: Char): Int = {
      if (c == '(') return 0
      if (c == '+' || c == '-') return 1
      if (c == '*' || c == '/' || c == '%') return 2
      return -1
    }

    def operation(b: Int, a: Int, c: String): Int = {
      if (c == "+") return b + a
      else if (c == "-") return b - a
      else if (c == "*") return b * a
      else if (c == "/") {
        if (a != 0)
          return b / a
        else
          return  -1
      }
      else if (c == "%") return b % a
      else return -1
    }
    def isOperator(c: String): Boolean = {
      return if ((c == "+") || (c == "-") || (c == "*") || (c == "/") || (c == "%")) true else false
    }
  }

  class mainFunctions extends getMainFunction {
    /*
     * implementation of main Functions
     * def convertFromInfixToPostfix(s:String):String
     * def evaluatingAPostfixExpression(s: String):Int
     */

    var obj = new assistantFunctions;

    def convertFromInfixToPostfix(s: String): String = {
      var number = ""
      var Operator:Char = '$';
      var Postfix = ""
      var re = false
      val again = new Breaks;
      val done = new Breaks;
      var op = Stack[Char]()
      for (i <- 0 to s.length - 1)
      {
        again.breakable {
          if (s(i).isDigit) {
            number += s(i)
          } else {
            if (number != "")
            {
              Postfix += number
              Postfix += " "
              number = ""
            }
            if (s(i) != ' ') {
              Operator = s(i)
              if (Operator == ')')
              {
                while (op.top != '(')
                {
                  var symbol = ""
                  symbol += op.top
                  Postfix += symbol
                  Postfix += " "
                  op.pop()
                }
                op.pop()
                again.break;
              }
              if (op.isEmpty || Operator == '(' || obj.precedence(Operator) > obj.precedence(op.top)) {
                op.push(Operator)
              } else {
                if (obj.precedence(Operator) <= obj.precedence(op.top)) {
                  done.breakable {
                    while (obj.precedence(Operator) <= obj.precedence(op.top)) {
                      var symbol = ""
                      symbol += op.top
                      Postfix += symbol
                      Postfix += " "
                      op.pop()
                      if (op.isEmpty)
                        done.break;
                    }
                  }
                  op.push(Operator)
                }
              }
            }
          }
        }
      }
      if (number != "") {
        Postfix += number
        Postfix += " "
        number = ""
      }
      if (!op.isEmpty) {
        while (!op.isEmpty) {
          var symbol = ""
          symbol += op.top
          Postfix += symbol
          Postfix += " "
          op.pop()
        }
      }
      return Postfix
    }

    def evaluatingAPostfixExpression(s: String): Int = {
      var ans = 0
      var operand = Stack[Int]()
      var obj = new assistantFunctions
      val sarray = s.split(" ") // for that number that jave more than one digit
      val byeBye = new Breaks;
      byeBye.breakable {
        for (i <- 0 to sarray.length - 1) {
          if (!obj.isOperator(sarray(i)) && sarray(i) != ' ') {
            var num: Int = -1
            num = sarray(i).toInt
            if (num != -1)
              operand.push(num)
          }
          if (obj.isOperator(sarray(i))) {
            var a: Int = 0
            var b: Int = 0
            var sum: Int = 0
            a = operand.top
            operand.pop()
            b = operand.top
            operand.pop()
            if (a == 0 && sarray(i) == "/") {
              ans = -1
              byeBye.break()
            }
            sum = obj.operation(b, a, sarray(i))
            operand.push(sum)
            if (!operand.isEmpty) {
              ans = operand.top
            }
          }
        }
      }
      return ans
    }
  }
  // java Code will call this function

  def Solve(a: String): String = {
    var ans = ""
    var value = 0
    var obj = new mainFunctions()
    ans = obj.convertFromInfixToPostfix(a)
    value = obj.evaluatingAPostfixExpression(ans)
    if (value == -1)
      return "Math ERROR"
    else
    return "The Postfix is := " + ans + ", value is := " + value.toString
  }

  def main(args: Array[String]): Unit = {
  }
}
