/*
  This implementation demonstrates how to 
  efficiently determine the number of ways
  to climb a staircase. It is assumed that
  1 or 2 steps can be climbed at any given 
  moment.  

  Let n be the number of steps.

  Time complexity: O(log2(n))
  Space complexity: O(1)
*/

function climbStairs(n) {
  const sqrtOf5 = Math.sqrt(5);
  // Solution is the closed-form expression of nth Fibonacci number
  const result =
    (1 / sqrtOf5) *
    (Math.pow((1 + sqrtOf5) / 2, n + 1) - Math.pow((1 - sqrtOf5) / 2, n + 1));
  return result;
}

// 1 + 1 + 1 or 1 + 2 or 2 + 1 steps
console.log(climbStairs(3)); // 3
