--Select
Select ContactName Adi,CompanyName SirketAdi,City Sehir from Customers

Select * from Customers where City = 'Berlin'

select * from Products where categoryId = 1 or CategoryID = 3

select * from Products where categoryId = 1 and UnitPrice >= 10

select * from Products order by CategoryID, ProductName

select * from Products order by UnitPrice asc

select * from Products order by UnitPrice desc

select * from Products where CategoryID = 1 order by UnitPrice desc

select count(*) Adet from Products where CategoryID = 2

select categoryID from products group by CategoryID

select categoryID, count(*) from products group by CategoryID

select categoryID, count(*) from products group by CategoryID having count(*) < 10

select categoryID, count(*) from products where UnitPrice > 20
group by CategoryID having count(*) < 10

select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName
from Products inner join Categories
on Products.CategoryID = Categories.CategoryID
where Products.UnitPrice > 10

select * from [Order Details]

select * from Products p inner join [Order Details] od
on p.ProductID = od.ProductID

select * from Products p left join [Order Details] od
on p.ProductID = od.ProductID

select * from Customers c inner join Orders o
on c.CustomerID = o.CustomerID

select * from Customers c left join Orders o
on c.CustomerID = o.CustomerID

select * from Customers c left join Orders o
on c.CustomerID = o.CustomerID
where o.CustomerID is null

select * from Products p inner join [Order Details] od
on p.ProductID = od.ProductID
inner join Orders o
on o.OrderID = od.OrderID

select * from Customers c left join Orders o
on c.CustomerID = o.CustomerID
where o.CustomerID is null