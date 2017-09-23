# Nonlinear Equation Solver
Let's say we have initial equation: x = tan(x)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

First method we are going to solve this equation is called fixed point iteration method:

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

1) Our first funtion which we will check if it converges would be g(x) = tan(x)
2) The point there g(x) = tan(x) and y = x intersects, must be our precise solution: 

![capture](https://user-images.githubusercontent.com/14164123/30591336-33941ff0-9cf7-11e7-8e0b-cbe70af0eb76.PNG)

As we can see from the graph final point there function after many iterations g(x + 1) = g(x) should converge to 0, and our initial guess should be close to it. Let's say our initial guess is x0 = 0.4, it could be anything, but the closer to real solution the better :) So iteration would be as follows:
Function g(x) graph

![capture1](https://user-images.githubusercontent.com/14164123/30592401-728778e8-9cfb-11e7-97c9-380e69f25349.PNG)
  
From graph we could clearly see, that this iteration should diverge, but let's write it down to make sure
1) when  x0 = 0.4         then    g(0,4)      =     tan(0,4)      = 0.42279
2) when  x1 = 0.42279   then    g(0.42279)  =     tan(0.42279)    = 0.44992
3) when  x2 = 0.44992   then    g(0.44992)  =     tan(0.44992)    = 0.48295
4) when  x2 = 0.48295   then    g(0.48295)  =     tan(0.48295)    = 0.52436

It only goes further and further away from initial guess x0 = 0.4, so it really diverges. And if we find a derivative of function tan(x), it will be grater when > 1, so this as well is an indication that function diverges. Conclusion, we need to find (modify) current function g(x) = tan(x) into function which will converge finally.
Our first try:
1) x = tan(x)   
2) x = arctan(x)
3) x - n*pi = arctan(x - n*pi)
4) x - n*pi = arctan(x)
5) x = arctan(x) + n*pi

This functions 5) derivative is lower when < 1, so this is an indication, that we have chosen ther right equation, and it's a way to go. Let's say n = 0, when we try again and check if function g(x) = arctan(x) converges. Function g(x) graph when initial guess x0 = 1.4, it could be any point, keep in mind that

![capture4](https://user-images.githubusercontent.com/14164123/30593914-093edb00-9d01-11e7-9e8c-4b746bc9d917.PNG)

From graph we could clearly see, that this iteration should converge, but let's write it down to make sure
1) when  x0 = 1.4       then    g(1,4)      =     arctan(1,4)       = 0.9505
2) when  x1 = 0.9505    then    g(0.9505)   =     arctan(0.9505)    = 0.76
3) when  x2 = 0.76      then    g(0.76)     =     arctan(0.76)      = 0.6499
4) when  x2 = 0.6499    then    g(0.6499)   =     arctan(0.6499)    = 0.5763

We stop after it meets condition: |g(xn) - xn| <= ((1-q)/q)*e, where e is precision, q is derivative in defined interval [a, b]. It clearly slowly converges, and after many iterations we should get to our precise solution. But we should be conscious about precision, because then it slowly converges it is indicator that with the high precision given, we could still be far away from our solution.

Let's say n=1, when we could clearly see, this this iteration even nicer converges to our precise solution, in graph you can see functions: f(x) = tan(x), f(x) = arctan(x) + pi, f(x) = x

![capture1](https://user-images.githubusercontent.com/14164123/30774158-b2434d16-a086-11e7-8c14-35161ec4c20d.PNG)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Our sencod method which we are goind to use to solve equation x = tan(x) is call secant method

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

This method is more efficiant when previous method, the convergion to sulution happens much more faster. First step, we need to rewrite function:
1) x = tan(x)
2) f(x) = tan(x) - x

After that we pick two arbitrary points. Lets say this is: x0 = 2 and x1 = 4, and for example we wanna get solution 4.493 When we draw some graphs to get a visual idea there is this going for

![capture](https://user-images.githubusercontent.com/14164123/30774379-41cf259c-a08a-11e7-91f9-d2d20d52342a.PNG)

We won't get that solution, so we need to change two initial point, maybe when we will get some success. Lets take x0 = 4.4 and x1 = 4.6

![capture](https://user-images.githubusercontent.com/14164123/30774451-5a693aa6-a08b-11e7-8fb7-1e2fec14d23d.PNG)

There wasn't any space left, but with little imagination we can later on it should get more and more closer to our so desired solution 4.493 :) 



