### PEARSON CORRELATION COEFFICIENT 

Pearson's correlation coefficient is a statistical measure that allows you to calculate the relationship 
between two variables, as long as they are quantitative and continuous variables. Pearson is the most 
commonly used correlation coefficient for calculating linear type relationships.

#### How to interpret Pearson's linear correlation coefficient?

The result of calculating the Pearson Correlation Index (we will call r) will always be in the range [-1, 1]. 
Indicating 1 a total positive correlation, and -1 a total negative correlation.

Therefore:

* If **r = |1|**, it will be a perfect correlation.
* If **r = 1**, we'll be talking about a perfect POSITIVE correlation.
* If **r = -1**, we'll be talking about a perfect NEGATIVE correlation.
* If **r = 0**, we will say that there is no correlation between the variables.
* If **r is negative** (that is, the value of r is between -1 and 0), we will be talking about a negative correlation between the variables. 

The closer to zero the value of r, the smaller the relationship between variables, or in other words, the closer it is to r of -1, the more related the variables will be.

* If r is positive (that is, the value is between 0 and 1), we will talk about the existence of a positive correlation between the variables. 

The closer to zero the value of r, the less relationship there will be between the two variables, the closer the value of r to 1, the more related the variables will be.

Example of positive linear correlation:

![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image1.png)

Example of negative linear correlation:

![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image2.png)

Example of nonlinear correlation:

![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image3.png)

#### Formula

The Pearson correlation coefficient is defined by the following expression: 


![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image4.png)


Pearson's correlation coefficient refers to the cross-product mean of standardized X and Y scores. This formula brings together some properties that make it preferable to others. To trade with standardized scores is a free index of measurement scale. On the other hand, its value fluctuates, as already indicated, in absolute terms, between 0 and 1. 
This formula is especially useful when X and Y means are known as well as their type deviations, which is relatively common. If under any circumstances we did not have the information of these statistics we could calculate rxy using the expression in direct scores:  

**Example. Let's have the following scores in variables X (intelligence) and Y (academic performance):**

![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image5.png)


**Calculate Pearson's correlation coefficient in direct scores:**
 
Before calculating Pearson's correlation coefficient, we need to check for a linear trend in the relationship. Although we will later offer analytical procedures to verify exactly the Linearity Hypothesis, for the time being, we will resort to graphical procedures, which in a first instance, may be sufficient: 


![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image6.png)


There is a certain linear trend in the relationship. We can therefore proceed to calculate Pearson's correlation coefficient. Let's set up the following table: 


![](https://github.com/JosafatGambino/BigData/tree/Unit_1/Unit_1/Pamela's%20Homework/Images/Image7.png)


The variables needed to apply the formula and obtain the Pearson correlation coefficient are calculated: 


![](https://github.com/JosafatGambino/BigData/blob/Unit_1/Unit_1/TareasPamela/Images/Image8.png)


### CONCLUSION

Once the value of the correlation coefficient has been calculated, it is interesting to determine whether such a obtained value shows that the variables X and Y are actually related or only present that relationship when they are initially plotted.
 
In other words, a meaning of the correlation coefficient result is sought. 
 
In conclusion, a correlation coefficient is said to be significant if it is nonzero. Then we can determine the following:

**Negative correlation coefficient:** _"The closer to zero the value of the coefficient, the smaller the relationship between the variables, i.e. the closer the coefficient of -1 is, the more related the variables will be."_

**Positive correlation coefficient:** _"The closer to zero the value of the coefficient, the smaller the relationship between the variables, i.e. the closer the coefficient of 1 is, the more related the variables will be."_