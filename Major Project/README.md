
### Task 1 a) Create Device

Adds a device to the ring at the position specified, the position is measured as an angle relative to the x-axis, rotating anti-clockwise.

```java
public void createDevice(String deviceId, String type, Angle position);
```

### Task 1 b) Remove Device

Removes a device (specified by id).  You don't need to cancel all current downloads/uploads (relevant for Task 2).

```java
public void removeDevice(String deviceId);
```

### Task 1 c) Create Satellite

Creates a satellite at a given height (measured from centre of Jupiter) at a given angle.

```java
public void createSatellite(String satelliteId, String type, double height, Angle position);
```

### Task 1 d) Remove Satellite

Removes a satellite from orbit.  You don't need to cancel all current downloads/uploads (relevant for Task 2).

```java
public void removeSatellite(String satelliteId);
```

### Task 1 e) List all device ids

Lists all the device ids that currently exist.

```java
public List<String> listDeviceIds();
```

### Task 1 f) List all satellite ids

Lists all the satellite ids that currently exist.

```java
public List<String> listSatelliteIds();
```

### Task 1 g) Add file to device

Adds a file to a device (not a satellite).  Files are added instantly.

```java
public void addFileToDevice(String deviceId, String filename, String content);
```

### Task 1 h) Get device/satellite information

Get detailed information about a single device or a satellite.

| :information_source:  NOTE: `id`s are unique, so no 2 devices and/or satellites can have the same id. |
| --- |

```java
public EntityInfoResponse getInfo(String id);
```

`EntityInfoResponse` is a struct that is supplied that contains the following members (it also comes with a constructor and a getter).

```java
public final class EntityInfoResponse {
  /**
   * The unique ID of the device.
   **/
  private final String id;

  /**
   * The angular position of the entity in radians
   **/
  private final Angle position;

  /**
   * The height of the entity measured in kilometres
   * devices will have a height equal to the radius of Jupiter.
   */
  private final double height;

  /**
   * the type of the entity i.e. DesktopDevice, ShrinkingSatellite, ...
   **/
  private final String type;

  /**
   * A map of all the files that this entity has access to.
   **/
  private final Map<String, FileInfoResponse> files;
}
```

| :information_source:  NOTE: `final` for classes means it can't have subclasses, `final` for functions means they can't have overrides, and final for members means they can't be modified after the constructor.  You don't have to use it in the assignment. |
| --- |

| :link:  `Map<..>` is similar to Dictionaries in Python and acts as a mapping between a key and a value.  You can find more information [here](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) |
| --- |

### Task 1 Example

You can test your implementations for Task 1 using the simple test provided in the file `src/test/Task1ExampleTests.java`. Later you need to add more tests to properly test your implementations.

The method `testExample` uses a JUnit test to test a few world states. Please read the method `testExample`.

```java
@Test
public void testExample() {
    // Task 1
    // Example from the specification
    BlackoutController controller = new BlackoutController();

    // Creates 1 satellite and 3 devices
    // 2 devices are in view of the satellite
    // 1 device is out of view of the satellite
    controller.createSatellite("Satellite1", "StandardSatellite", 100 + RadiusOfJupiter, Angle.fromDegrees(340));
    controller.createDevice("DeviceA", "HandheldDevice", Angle.fromDegrees(30));
    controller.createDevice("DeviceB", "LaptopDevice", Angle.fromDegrees(180));
    controller.createDevice("DeviceC", "DesktopDevice", Angle.fromDegrees(330));

    // verify properties and that the devices/satellite was created correctly
    assertListAreEqualIgnoringOrder(Arrays.asList("Satellite1"), controller.listSatelliteIds());
    assertListAreEqualIgnoringOrder(Arrays.asList("DeviceA", "DeviceB", "DeviceC"), controller.listDeviceIds());

    assertEquals(new EntityInfoResponse("Satellite1", Math.toRadians(340), 100 + RadiusOfJupiter, "DesktopDevice"), controller.getInfo("Satellite1"));

    assertEquals(new EntityInfoResponse("DeviceA", Math.toRadians(30), RadiusOfJupiter, "HandheldDevice"), controller.getInfo("DeviceA"));
    assertEquals(new EntityInfoResponse("DeviceB", Math.toRadians(180), RadiusOfJupiter, "LaptopDevice"), controller.getInfo("DeviceB"));
    assertEquals(new EntityInfoResponse("DeviceC", Math.toRadians(330), RadiusOfJupiter, "DesktopDevice"), controller.getInfo("DeviceC"));
}
```

