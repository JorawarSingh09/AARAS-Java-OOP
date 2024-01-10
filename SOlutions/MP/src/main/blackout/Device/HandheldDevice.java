package blackout.Device;

import utils.Angle;

public class HandheldDevice extends Device{

    public HandheldDevice(String deviceId, Angle position) {
        super(deviceId, "HandheldDevice", position, 50000);
    }
}
