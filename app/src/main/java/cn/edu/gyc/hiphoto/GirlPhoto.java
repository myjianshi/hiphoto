package cn.edu.gyc.hiphoto;
import android.os.Parcel;
import android.os.Parcelable;

public class GirlPhoto implements Parcelable {

    private String mUrl;
    private String mTitle;

    public GirlPhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected GirlPhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<GirlPhoto> CREATOR = new Creator<GirlPhoto>() {
        @Override
        public GirlPhoto createFromParcel(Parcel in) {
            return new GirlPhoto(in);
        }

        @Override
        public GirlPhoto[] newArray(int size) {
            return new GirlPhoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static  GirlPhoto[] getGirlPhotos() {

        return new GirlPhoto[]{
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0003.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0004.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0005.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0006.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0007.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0008.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0009.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0010.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0011.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0012.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0013.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0014.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0015.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0016.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0017.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0018.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0019.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0020.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0021.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0022.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0023.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0024.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0025.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0026.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0027.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0028.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0029.jpg", "Tammy`3"),
                new GirlPhoto("http://192.168.46.1/[Be]2016.03.28%20No.1272%20Tammy[44P348M]/0030.jpg", "Tammy`3"),

        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}