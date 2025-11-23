package app.adapter.in.rest.response;

public class TriangulationResponse {
    private Point possibleMuzanPosition;
    private Double confidenceLevel;
    private String description;

    public static class Point {
        public Integer x;
        public Integer y;
        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public TriangulationResponse() {
    }

    // Getters and Setters

    public Point getPossibleMuzanPosition() {
        return possibleMuzanPosition;
    }

    public void setPossibleMuzanPosition(Point possibleMuzanPosition) {
        this.possibleMuzanPosition = possibleMuzanPosition;
    }

    public Double getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(Double confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


