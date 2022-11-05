# swish 
This is a case study for games collection and wishlist library, mainly focused on Nintendo Switch created for a Java full-stack course. 

It's the first major web app I've created and was made to meet the course requirements, and thus it is quite simple. I plan on improving it (such as adding proper pagination, sorting/filters, more features, etc.). 

Here is a simple gif to show a part of how it works:

![demo-gif](demo.gif)

## About
My friends and I enjoy buying physical copies of Nintendo Switch games for certain games we really love. Sometimes it can be problematic when a game has a limited release, or when we forget that we own a game on multiple platforms.
This is a web app that let's you maintain a record of your gaming collection and add items to your wishlist so you can keep track of the ones you're still missing from your collection.

## Technologies Used
This was built in Java with Spring Boot framework and utilized Thymeleaf to create dynamic webpages with HTML, CSS, and JavaScript.

* Java
* Spring Boot Framework
* Hibernate
* SQL
* Thymeleaf
* HTML, CSS, Javascript
* etc. 

## Project Features
User is able to view the list of games, but must be registered to add to library or wishlist. After registration / logging in, they may also view their profile to see their personal library and wishlist. 

The database will create & populate sample data on startup for MariaDB with default user and pass (root). 

The website is accessed from:
http://localhost:8080/index
