package com.github.nimeshabuddhika;

/**
 * @author Nimesha Buddhika on 8/27/2019 5:16 PM
 */
public class ImageDto {

    public String code;
    public String image;
    public double value;

    public ImageDto() {
    }

    public ImageDto(String code, String image) {
        this.code = code;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "code='" + code + '\'' +
                ", image='" + image + '\'' +
                ", value=" + value +
                '}';
    }
}
