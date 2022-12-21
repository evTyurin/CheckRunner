#CheckRunner
**CheckRunner** – it's basic realisation of Clevertec's check creation task

###Technology stack

Java 17
Gradle 7.5
Junit 5

###Launch
Application should be launched using console

* Download from https://github.com/evTyurin/CheckRunner
* Go to the directory /build/libs/ and use command
  **java -jar CheckRunner.jar 1-3 2-15 3-3 card-1111 products.txt discountCards.txt**
* 1-3, 2-15, 3-3 - key-value pairs where key means id of the product and value means amount of products.
* card-1111 it's a discount card with number 1111
* products.txt is name of the file where products data are stored
* discountCards.txt is name of the file where discount card data are stored