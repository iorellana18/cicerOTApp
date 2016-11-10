package cl.usach.CICEROT.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cl.usach.CICEROT.Chat.ChatActivity;
import cl.usach.CICEROT.Hots.HotsActivity;
import cl.usach.CICEROT.Perfil.MyProfileActivity;
import cl.usach.CICEROT.Tours.MyToursActivity;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MyProfileActivity tab1 = new MyProfileActivity();
                return tab1;
            case 1:
                MyToursActivity tab2 = new MyToursActivity();
                return tab2;
            case 2:
                HotsActivity tab3 = new HotsActivity();
                return tab3;
            case 3:
                ChatActivity tab4 = new ChatActivity();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}