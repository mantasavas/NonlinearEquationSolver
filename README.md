# Nonlinear Equation Solver
Let's say we have initial equation: x = tan(x)

First method we are going to solve this equation is called fixed point iteration method:
1) And our first funtion which we will check if it converges would be g(x) = tan(x)
2) The point there g(x) = tan(x) and y = x intersects: 

![capture](https://user-images.githubusercontent.com/14164123/30591336-33941ff0-9cf7-11e7-8e0b-cbe70af0eb76.PNG)

3) As we can see from the graph final point there function after many iterations g(x + 1) = g(x) should converge would be 0, and our initial guess should be close to it.
4) Let's say our initial guess is x0 = 0,4, it could be anything, but closer to real solution the better :) 
5) So iteration would be as follows:
5.1) 
  ![capture1](https://user-images.githubusercontent.com/14164123/30592401-728778e8-9cfb-11e7-97c9-380e69f25349.PNG)
  
  5.2) From graph we could clearly see, that this iteration should diverge, but let's write it down to make sure
  5.3) when  x0 = 1         then    g(0,4)      =     tan(0,4)        = 0.42279
       when  x1 = 0.42279   then    g(0.42279)  =     tan(0.42279)    = 0.44992
       when  x2 = 0.44992   then    g(0.44992)  =     tan(0.44992)    = 0.48295
       when  x2 = 0.48295   then    g(0.48295)  =     tan(0.48295)    = 0.52436
  5.4) If only go further away from initial guess x0 = 0, so it really diverges
6) Conclusion, we need to find (modify) current function g(x) = tan(x) into function which will converge finally
7) Our first try:
  7.1) x = tan(x)   
  7.2) x = arctan(x)
  7.3) x - n*pi = arctan(x - n*pi)
  7.4) x - n*pi = arctan(x)
  7.5) x = arctan(x) + n*pi
8) let's say n = 0, when we try again and check if function g(x) = arctan(x) converges
  8.1) Function g(x) graph
  ![capture4](https://user-images.githubusercontent.com/14164123/30593914-093edb00-9d01-11e7-9e8c-4b746bc9d917.PNG)
