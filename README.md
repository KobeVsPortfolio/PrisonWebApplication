# boxed

# download driver

https://www.microsoft.com/en-us/download/details.aspx?id=57175

# Put the jar in 

\wildfly-15.0.1.Final\modules\system\layers\base\com\microsoft\sqlserver\main

# add module.xml

```xml

<module name="com.microsoft.sqlserver" xmlns="urn:jboss:module:1.3">

    <resources>
        <resource-root path="mssql-jdbc-7.0.0.jre8.jar"/>
    </resources>

    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
    
</module>

```


# add Datasource

go to localhost:9990
JNDI: java:/BoxedPersistenceUnit
Driver name: mssql-jdbc-7.0.0.jre8.jar
Connection url: 
jdbc:sqlserver://boxed.database.windows.net:1433;database=boxed;user=B0xed1@boxed;password={B0xederkoja};

NO NEED TO ADD PASSWORD OR USERNAME

