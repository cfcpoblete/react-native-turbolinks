package com.lazaronixon.rnturbolinks.util;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import java.util.ArrayList;

public class TurbolinksRoute implements Parcelable {

    public static final String ACTION_ADVANCE = "advance";
    public static final String ACTION_REPLACE = "replace";

    private String url;
    private String component;
    private String action;
    private boolean modal;
    private boolean dismissable;
    private Bundle passProps;
    private String title;
    private String subtitle;
    private boolean visibleDropDown;
    private boolean hidesNavBar;
    private ArrayList<Bundle> actions;

    public TurbolinksRoute(ReadableMap rp) {
        ReadableMap props = rp.hasKey("passProps") ? rp.getMap("passProps") : null;
        ReadableArray actions = rp.hasKey("actions") ? rp.getArray("actions") : null;
        this.url = rp.hasKey("url") ? rp.getString("url") : null;
        this.component = rp.hasKey("component") ? rp.getString("component") : null;
        this.action = rp.hasKey("action") ? rp.getString("action") : ACTION_ADVANCE;
        this.modal = rp.hasKey("modal") && rp.getBoolean("modal");
        this.dismissable = rp.hasKey("dismissable") && rp.getBoolean("dismissable");
        this.passProps = props != null ? Arguments.toBundle(props) : null;
        this.title = rp.hasKey("title") ? rp.getString("title") : null;
        this.subtitle = rp.hasKey("subtitle") ? rp.getString("subtitle") : null;
        this.visibleDropDown = rp.hasKey("visibleDropDown") && rp.getBoolean("visibleDropDown");
        this.hidesNavBar = rp.hasKey("hidesNavBar") && rp.getBoolean("hidesNavBar");
        this.actions = rp.hasKey("actions") ? Arguments.toList(actions) : null;
    }

    public TurbolinksRoute(Bundle bundle) {
        this.url = bundle.getString("url");
        this.component = bundle.getString("component");
        this.action = bundle.getString("action");
        this.modal = bundle.getBoolean("modal");
        this.dismissable = bundle.getBoolean("dismissable");
        this.passProps = bundle.getBundle("passProps");
        this.title = bundle.getString("title");
        this.subtitle = bundle.getString("subtitle");
        this.visibleDropDown = bundle.getBoolean("visibleDropDown");
        this.hidesNavBar = bundle.getBoolean("hidesNavBar");
        this.actions = bundle.getParcelableArrayList("actions");
    }

    protected TurbolinksRoute(Parcel in) {
        url = in.readString();
        component = in.readString();
        action = in.readString();
        modal = in.readByte() != 0;
        dismissable = in.readByte() != 0;
        passProps = in.readBundle();
        title = in.readString();
        subtitle = in.readString();
        visibleDropDown = in.readByte() != 0;
        hidesNavBar = in.readByte() != 0;
        actions = in.createTypedArrayList(Bundle.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(component);
        dest.writeString(action);
        dest.writeByte((byte) (modal ? 1 : 0));
        dest.writeByte((byte) (dismissable ? 1 : 0));
        dest.writeBundle(passProps);
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeByte((byte) (visibleDropDown ? 1 : 0));
        dest.writeByte((byte) (hidesNavBar ? 1 : 0));
        dest.writeTypedList(actions);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TurbolinksRoute> CREATOR = new Creator<TurbolinksRoute>() {
        @Override
        public TurbolinksRoute createFromParcel(Parcel in) {
            return new TurbolinksRoute(in);
        }

        @Override
        public TurbolinksRoute[] newArray(int size) {
            return new TurbolinksRoute[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public String getComponent() {
        return component;
    }

    public String getAction() {
        return action;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public boolean getModal() {
        return modal;
    }

    public boolean getDismissable() {
        return dismissable;
    }

    public Bundle getPassProps() {
        return passProps;
    }

    public String getTitle() {
        return title;
    }

    public boolean getVisibleDropDown() {
        return visibleDropDown;
    }

    public boolean getHidesNavBar() {
        return hidesNavBar;
    }

    public ArrayList<Bundle> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Bundle> actions) {
        this.actions = actions;
    }

}
