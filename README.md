


Supported requests:
1. To get all products create GET request with the following URL:<br>
http://localhost:8080/products <br>
Result is returned page with all products.
<br><br>
2. To get specific product create GET request with the following URL:
http://localhost:8080/products/{id} <br> where {id} is a id of the product.<br>
<b>Example:</b>
http://localhost:8080/products/1 <br>
<b>Result:</b><br>
{"id":1,"model":"32W3753DG","productType":{"id":1,"name":"Телевизор"},"brandName":{"id":2,"name":"Toshiba"},"quantity":50,"price":20000.0,"productToProperties":[{"id":7,"property":{"id":3,"name":"Тип матрицы"},"propertyValue":"LED"},{"id":4,"property":{"id":2,"name":"Толщина"},"propertyValue":"735 мм"},{"id":1,"property":{"id":1,"name":"Диагональ"},"propertyValue":"32 ''"}]}
<br><br>
3. To add or modify product create PUT request with the following URL:<br>
http://localhost:8080/products?id={id}&model={model}&brandId={brandId}&typeId={typeId}&quantity={quantity}&price={price} <br>
Where {id} is a product id (Long),
{model} is a String, <br>
{brandId} is a Long value references to specific brand, <br>
{typeId} is a Long value references to specific type, <br>
{quantity} is Long value, <br>
{price} is double value. <br>
<b>Example:</b>
http://localhost:8080/products?id=22&model=Test&brandId=1&typeId=1&quantity=20&price=25.5 <br>
<b>Result: </b> <br>
{"id":22,"model":"Test","productType":{"id":1,"name":"Телевизор"},"brandName":{"id":1,"name":"Samsung"},"quantity":20,"price":25.5,"productToProperties":[]}
<br><br>
4. To delete a product create DELETE request with the following URL: <br>
http://localhost:8080/products/{id} <br> where {id} is a id of the product.<br>
<b>Example:</b>
http://localhost:8080/products/1 <br>
Will be deleted product with id=1 <br><br>
5. To change the price of the specific product create PUT request with the following URL: <br>
http://localhost:8080/products/{id}/price?newPrice={newPrice} <br>
{newPrice} is a double value of the new price. <br>
<b>Example: </b><br>
http://localhost:8080/products/1/price?newPrice=22.2 <br>