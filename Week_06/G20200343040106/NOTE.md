# DP学习笔记



适用：求解最优问题，例如最大值，最小值。可以显著的降低时间复杂度，提高代码执行效率。



个人觉得，DP最难的地方在于：

* 抽象问题为状态
* 找状态转换方程

## 0-1背包

对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？



0-1背包可以用回溯来做，就是**穷举**所有可能的解。这是指数复杂度的，用动态规划可以很巧妙的降低它。



如何用动态规划做？

构建一个二维数组 **bool state [ n ] [ w ]**。

1. 抽象出状态。**state(i,cw)**表示我们我们去决策第i个物品是否装入，此时背包里已经有了cw的物体的状态。
2. 状态转移方程：**state(i,j) = state(i-1,j)&&state(i-1,j-weight[i])**;

## 升级版0-1背包

改造一下刚才那个问题。我们引进**物品价值**。



对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？

给定：**weight[n]表示n个物体的重量，value[n]表示n个物体对应的价值，w表示背包的容量**



相比于上一个，我们现在需要3个变量来表示一个状态：**i,cw,cv。**

1. **i 表示当前决策的物品号**
2. **cw表示当前背包容量**
3. **cv表示当前背包里的东西值多少钱。**

构建一个二维数组 **int state [ n ] [ w ]**。

状态转移方程： **state(i,j) = max(state(i-1,j),state(i-1,j-weight[i])+value[i])**;



## 通过0-1背包对DP的理解

我们把问题分为多个阶段，每个阶段对应一个决策。**我们归纳每个阶段可到达的状态集合，或者说，每个状态可由哪几个状态抵达**。这便是动态规划。**空间换时间**。因为我们需要记录已经计算过的状态。







## 个人拙见

大部分动态规划问题，都可以用回溯来做，只不过回溯算法效率不接受。

**贪心，分治，回溯，DP**这些算法，大多是后验性的，就是说，我们往往先用这个方法解决，再去探究这个算法的正确性。所以强调多刷题。





# 理论

有没有想过什么问题可以用动态规划做？如何思考动态规划的解决过程？贪心，回溯，动态规划之间又什么区别和联系？



动态规划可解决的问题：满足**多阶段最优解模型+最优子结构+无后效性+重叠子问题**。



## 多阶段最优解模型

而解决问题的过程，需要经历多个决策阶段。每个决策阶段都对应着一组状态。然后我们寻找一组决策序列，经过这组决策序列，能够产生最终期望求解的最优值。

## 最优子结构

指的是问题的最优解包含子问题的最优解，换句话说，**我们可以通过子问题的最优解，推导出问题的最优解。**

对应到代码上就是：**后面的状态可以通过前面的状态推导出来**。

## 无后效性

某个状态一旦确定，不受后面决策的影响。

## 重复子问题

这个比较好理解，回溯的递归树中多次重复计算相同的状态。



# 解题思路

## 一，记忆化搜索

一个前提是：能用动态规划解决，一般呢能用回溯搜索，暴力枚举解决。

拿到题目后，先用简单的回溯算法做，然后根据递归树**定义状态**，每个状态对应一个节点。我们可以很容易的从递归树中看出来是否存在重复子问题。



**找到重复子问题**后，最直观的就是将暴力的回溯改造成**记忆化搜索**。效率上来说其实已经和自底向上的动态规划没什么区别了！！

## 一，状态转移表法

这种方法适用状态是二维的。

* 画一个状态表。一般是一维或二维的，然后分阶段填表。

* 翻译成代码

个人觉得这种有点类似**人肉找规律**。

## 二，状态转移方程法

状态转移方程是解决DP问题的关键，如果我们能正确写出它，那么问题基本上就解决一大半了，因为翻译成代码很简答。**问题就出在很多DP问题状态本身就不好定义，转移方程当然也就不好写**。



它有点类似**递归**的思想，我们需要分析最优子结构，根据最优子结构，写出**递归公式**，也就是所谓的**状态转移方程**。

有了状态转移方程，代码就很好写了。



# 回溯，DP，贪心？



## 回溯

万金油，基本上动规，贪心的问题，都能用回溯暴力的解决。

## DP

它比回溯高效，但是并不是所有问题都能用它解决。需要满足三个特征：

* 最优子结构
* 重叠子问题
* 无后效性

## Greedy

实际上它是DP的一种特殊情况，它更加高效，同时，**它对问题的要求更高，---> 贪心选择性**。



贪心选择性指的是，**通过局部最优解， 产生全局最优解。**







