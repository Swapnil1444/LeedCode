# Write your MySQL query statement below
select MAX(Salary) as SecondHighestSalary from Employee Where salary< (select Max(Salary) from Employee);