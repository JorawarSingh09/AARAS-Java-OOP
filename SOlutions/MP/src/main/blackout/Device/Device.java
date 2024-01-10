package blackout.Device;

import java.util.HashMap;
import java.util.Map;

import blackout.File.File;
import blackout.Satellite.Satellite;
import response.models.EntityInfoResponse;
import response.models.FileInfoResponse;
import utils.Angle;
import utils.MathsHelper;

public abstract class Device {
    private String deviceId;
    private String type;
    private Angle position;
    private double height;
    private int maxRange;
    private Map<String, File> files;

    public Device(String deviceId, String type, Angle position, int maxRange) {
        this.deviceId = deviceId;
        this.type = type;
        this.position = position;
        this.height = MathsHelper.RADIUS_OF_JUPITER;
        this.maxRange = maxRange;
        this.files = new HashMap<String, File>();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getType() {
        return type;
    }

    public Angle getPosition() {
        return position;
    }

    public double getHeight() {
        return height;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public String getFileContent(String fileName) {
        return files.get(fileName).getContent();
    }
    
    public void addFile(File f) {
        files.put(f.getFilename(), f);
    }

    public EntityInfoResponse deviceInfo() {
        Map<String, FileInfoResponse> fInfo = new HashMap<>();
        for (File f : files.values()) {
            fInfo.put(f.getFilename(), new FileInfoResponse(f.getFilename(), f.getAvailableContent(), f.getSize(), f.hasTransferCompleted()));
        }
        EntityInfoResponse e = new EntityInfoResponse(deviceId, position, height, type, fInfo);
        return e;
    }

    public boolean isInRange(Satellite s) {
        if (MathsHelper.isVisible(s.getHeight(), s.getPosition(), getPosition())) {
            if (MathsHelper.getDistance(s.getHeight(), s.getPosition(), getPosition()) <= getMaxRange()) {
                return true;
            }
        }
        return false;
    }
}
