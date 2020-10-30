# MVP TODO list

# API Features

* Stock watch, stock price prediction (db, parsing pending)
* Bank transfer (done)
* Rewrite the parsing for the new all accounts summary of closed positions and save all accounts earning in it.

1/ Finish the parser rewrite
2/ Finish the Lombok
3/ https://developer.okta.com/blog/2019/05/13/angular-8-spring-boot-2
	https://www.baeldung.com/spring-boot-angular-web
	https://www.javaguides.net/2019/06/spring-boot-angular-7-crud-example-tutorial.html
	https://spring.io/guides/tutorials/spring-security-and-angular-js/
	https://bezkoder.com/angular-spring-boot-crud/
	https://www.devglan.com/spring-boot/spring-boot-angular-8-example

## UI Service
angular and nodejs service boilerplate with gulp.

## stock watcher

* A table is required with sector, this can be reserved, and manually added in the UI.

* Stock watch list API

`/stocks/watch/allstocks`

`/stocks/{stock_name}/info`

This view will show predicted price.
Check the PE which is negative or EPS is not avail ones.
Check those stocks financial behavior carefully with other manual process or auto tools, try to avoid them, or check if it deserves investment.

## Docker and kubernetes

## Backend improvements
* Intelligent decision functionalities
* Configurable, such as columns with ENUM for different type of file, and make account_config.properties

