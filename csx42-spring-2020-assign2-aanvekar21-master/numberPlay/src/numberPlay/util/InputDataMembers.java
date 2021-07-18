package numberPlay.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class InputDataMembers {

    public String inputFilePath;
    public int windowSize;
    public String AvgOutputFilePath;
    public int kWindowSize;
    public String TopKFilePath;
    public String PeakFilePath;

    private static InputDataMembers InputData;

    private InputDataMembers() {
        String inputFilePath;
        int windowSize;
        String AvgOutputFilePath;
        int kWindowSize;
        String TopKFilePath;
        String PeakFilePath;
    }

    public static InputDataMembers getInstance()
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        if (null == InputData) {
            InputData = new InputDataMembers();

        }
        return InputData;
    }

    public String getTopKOutPath() {
        return TopKFilePath;
    }

    public void setTopKOutPath(String TopKPath) {
        this.TopKFilePath = TopKPath;

    }

    public String getPeakFilePath() {
        return TopKFilePath;
    }

    public void setPeakFilePath(String PeakPath) {
        this.PeakFilePath = PeakPath;

    }

    public String getAvgOutputFilePath() {
        return TopKFilePath;
    }

    public void setAvgOutputFilePath(String OutputPath) {
        this.AvgOutputFilePath = OutputPath;

    }

    public String getinputFilePath() {
        return TopKFilePath;
    }

    public void setinputFilePath(String inputPath) {
        this.inputFilePath = inputPath;

    }

    public int getwindowSize() {
        return windowSize;
    }

    public void setwindowSize(String WindowFilePath) {
        this.windowSize = Integer.parseInt(WindowFilePath);
    }

    public int getkWindowSize() {
        return windowSize;
    }

    public void setkWindowSize(String kWindowPath) {
        this.kWindowSize = Integer.parseInt(kWindowPath);
    }

}