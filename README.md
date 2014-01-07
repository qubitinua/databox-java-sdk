# Databox Java SDK

The Java SDK for interacting with the Databox Push API.

## Features

* Built on top of a solid and extensively tested framework [Apache HttpComponents](http://hc.apache.org/)
* Uses Java library to convert JSON to Java objects and vice-versa [google-gson](https://code.google.com/p/google-gson)
* Tested and well-documented

## Requirements

* Java >= 1.5 or later,
* Maven >= 3.0.3 (optional but highly recomended)

## Maven supported

Add a maven repository to your pom file:
```xml
<repository>
	<id>databox-public-repo</id>
	<name>Databox Releases</name>
	<releases>
		<enabled>true</enabled>
	</releases>
	<snapshots>
		<enabled>false</enabled>
	</snapshots>
	<url>https://raw.github.com/databox/maven-public-repo/releases</url>
</repository>
```

Then add a dependency for Databox Custom DataSource artefact:
```xml
<dependency>
	<groupId>com.databox</groupId>
	<artifactId>custom-datasource-sdk</artifactId>
	<version>${databox-sdk.version}</version>
</dependency>
```

## Basic usage of the Databox's `custom-datasource-sdk` client

Most basic sample:

```java
	DataSink<DataboxCustomConnection> sink = new DataboxSink();

	DataboxCustomConnection connection = new DataboxCustomConnection("hd32o1ga8sf7sad0fu9sdufs8440442kj2", "3m2k3u2o3i4hujlb");

	DefaultDataProvider dataProvider = new DefaultDataProvider();
	dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(234D).build());
	dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(234D).build());
	connection.addDataProvider(dataProvider);
	
	sink.push(connection);
```

One more advanced example (XSLDailyDataProvider implements DataProvider interface):
```java
	DataboxSink sink = new DataboxSink();
	List<DataboxCustomConnection> connections = new ArrayList<DataboxCustomConnection>();
	
	DataboxCustomConnection connection = new DataboxCustomConnection("hd32o1ga8sf7sad0fu9sdufs8440442kj2", "3m2k3u2o3i4hujlb");
	XSLDailyDataProvider xlsxDataProvider = new XSLDailyDataProvider("cycling.xlsx");
	connection.addDataProvider(xlsxDataProvider);
	/* You can implement your own data provider that implements DataProvider interface */
	// connection.addDataProvider(new MyCustomDataProviderImpl());
	connections.add(connection);

	/* For each custom connection in app.databox.com we add a separate connection to the sink (each uses a different API Key and URL postfix) */
	// connection = new DataboxCustomConnection("5r4w91ga8sf7sad0fu9sdufs844044", "923noien28dnkj23");
	/* We can use the same data provider for different connections */
	// connection.addDataProvider(xlsxDataProvider);
	// connections.add(connection);

	for (DataboxCustomConnection connection : connections) {
		sink.push(connection);
	}

```

More examples can be found here [Example project]()

## Documentation

See [wiki page](https://github.com/umajeric/databox-java-sdk/wiki) for additional documentation. 

## License

Databox `custom-datasource-sdk` is licensed under the Apache License, Version 2.0 - see the [LICENSE](http://www.apache.org/licenses/LICENSE-2.0) file for details

## Credits

### Contributors

- The Databox team, most importantly [Uros Majeric](http://github.com/umajeric) 


