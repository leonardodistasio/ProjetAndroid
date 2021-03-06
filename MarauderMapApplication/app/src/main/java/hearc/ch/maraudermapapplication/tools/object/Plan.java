package hearc.ch.maraudermapapplication.tools.object;

import android.os.Parcel;
import android.os.Parcelable;

import com.estimote.sdk.Beacon;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hearc.ch.maraudermapapplication.tools.bdd.ActionBdd;
import hearc.ch.maraudermapapplication.tools.bdd.ActionEnum;

/**
 * Created by leonardo.distasio on 10.11.2015.
 */
public class Plan implements Parcelable
{
    private int id;
    private String img;
    private int width;
    private int height;
    private float longM;
    private float largM;

    public Plan()
    {

    }

    public Plan(int _id, String _img, int _width, int _height, float _longM, float _largM)
    {
        this.id = _id;
        this.img = _img;
        this.width = _width;
        this.height = _height;
        this.longM = _longM;
        this.largM = _largM;
    }

    /**
     * Constructeur avec objet JSON
     * @param obj
     * @throws JSONException
     */
    public Plan(JSONObject obj) throws JSONException
    {
        this.id = obj.getInt("id");
        this.img = obj.getString("img");
        this.width = obj.getInt("width");
        this.height = obj.getInt("height");
        this.longM = obj.getInt("longM");
        this.largM = obj.getInt("largM");
    }

    /**
     * Création de Plan
     * @return
     */
    public Map<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();

        map.put("width", width+"");
        map.put("height", height+"");
        map.put("longM", longM+"");
        map.put("largM", largM+"");

        return map;
    }

    /**
     * Détection plan actuel
     * @param listLocator
     * @return
     */
    public static Map<String, String> detectActualPlan(List<Beacon> listLocator)
    {
        ActionBdd action = new ActionBdd();
        Map<String, String> kvPairs = new HashMap<String, String>();

        kvPairs.put("function", action.getMapAction().get(ActionEnum.GET_ACTUAL_PLAN));
        kvPairs.put("majorId", listLocator.get(0).getMinor()+"");
        kvPairs.put("minorId", listLocator.get(0).getMajor()+"");

        return kvPairs;
    }

    protected Plan(Parcel in) {
        id = in.readInt();
        img = in.readString();
        width = in.readInt();
        height = in.readInt();
        longM = in.readFloat();
        largM = in.readFloat();
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(img);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeFloat(longM);
        dest.writeFloat(largM);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getLongM() {
        return longM;
    }

    public void setLongM(float longM) {
        this.longM = longM;
    }

    public float getLargM() {
        return largM;
    }

    public void setLargM(float largM) {
        this.largM = largM;
    }
}
