学习笔记

26:

most votes方法和自己差不多
发现自己忽略了对于初始条件的判断，加上之后，感觉就更加完整了

189:

很快想到了暴力解决和copy数组再重新放置的方法，也很快完成了代码


然后想到了可以依次计算最终位置来移动，顺利完成，也通过了第一个测试用例，
但是第二个测试用例怎么都过不了，很烦很烦，在纸上算了很久最终才完成，花费了挺多的时间。


然后看题解，发现题解也用了这种方法，但是思路更加清晰，并没有局限于只写一个for搞定，而是在
外层的for里继续用while，但是步进是按照总的次数来的，所以时间复杂度也还是O（n），实现上比我的方法
要逻辑清晰很多。


题解还有另外一种解法，通过翻转数组来完成，不能说巧妙，交换数据的次数也更多，但是胜在易于理解，
易于实现，代码简洁，还不错。以后遇到题目可以多从数组的翻转上想想解题思路。同时要把翻转数组的代码牢牢记住。


