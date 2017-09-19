# Nonlinear Equation Solver
Let's say we have initial equation: x = tan(x)

First method we are going to solve this equation is called fixed point iteration method:
1) And our first funtion which we will check if it converges would be g(x) = tan(x)
2) The point there g(x) = tan(x) and y = x intersects: 

![capture](https://user-images.githubusercontent.com/14164123/30591336-33941ff0-9cf7-11e7-8e0b-cbe70af0eb76.PNG)

3) As we can see from the graph final point there function after many iterations g(x + 1) = g(x) should converge would be 0, and our initial guess should be close to it.
4) Let's say our initial guess is x0 = 1
5) So iteration would be as follows:
  5.1) ![capture1](https://user-images.githubusercontent.com/14164123/30592401-728778e8-9cfb-11e7-97c9-380e69f25349.PNG)

