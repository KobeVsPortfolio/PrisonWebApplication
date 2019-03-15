# boxed

# download driver

https://jar-download.com/artifacts/mysql/mysql-connector-java/8.0.12/source-code

# Put the jar in 

\wildfly-15.0.1.Final\modules\system\layers\base\com\mysql\main

# add module.xml

```xml

<module name="com.mysql" xmlns="urn:jboss:module:1.3">

    <resources>
        <resource-root path="mysql-connector-java-8.0.12.jar"/>
    </resources>

    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
		<module name="javax.servlet.api" optional="true"/>
    </dependencies>

</module>

```


# add Datasource (custom template)

- go to localhost:9990
- JNDI: java:/BoxedPersistenceUnitMySql
- Driver name: mysql-connector-java-8.0.12.jar
- Connection url: 
    - jdbc:mysql://localhost:3306/boxed?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    - username: root
    - password: root
    
#added features


- Cellinfo will be shown when selecting a cell.
- Prisoners can be added and will be inserted into the database.
- Prisoners can be deleted individually.
- Available spaces in a cell are shown.
- Current Day is shown and counting.
- When the current day is equal to the Day of Release a prisoner will be freed. (deleted)




