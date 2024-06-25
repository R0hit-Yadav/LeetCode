/*Given a function fn, an array of arguments args, and an interval time t, return a cancel function cancelFn.
After a delay of cancelTimeMs, the returned cancel function cancelFn will be invoked.
setTimeout(cancelFn, cancelTimeMs)
The function fn should be called with args immediately and then called again every t milliseconds until cancelFn is called at cancelTimeMs ms.
Example 1:

Input: fn = (x) => x * 2, args = [4], t = 35
Output: 
[
   {"time": 0, "returned": 8},
   {"time": 35, "returned": 8},
   {"time": 70, "returned": 8},
   {"time": 105, "returned": 8},
   {"time": 140, "returned": 8},
   {"time": 175, "returned": 8}
]*/
var cancellable = function(fn, args, t) 
{
    fn(...args)
    const intervalId = setInterval(()=>
        {
        fn(...args)
    },t)
    const cancelFn = () => clearInterval(intervalId);
    return cancelFn;
    
};
