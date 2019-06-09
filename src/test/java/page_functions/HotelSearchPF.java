package page_functions;

import common_functions.JSFunctions;
import common_functions.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page_objects.HotelSearchPO;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.*;

public class HotelSearchPF extends HotelSearchPO
{
    private int rooms; int[] adults, children; String[][] age; String[] arrAge;

    public boolean ValGoingToAutoSuggest(String location) {
        WaitFunctions.WaitUntilElementVisible(PaneGoingToAutoSuggest(), 3000);
        for (int i = 0; i < LbGoingToAutoSuggest().size(); i++)
        {
            if (LbGoingToAutoSuggest().get(i).getText().compareToIgnoreCase(location) < 0) {
                return false;
            }
        }
        return true;
    }

//    public boolean SetTravellers(int rooms, int[] adults, int[] children, String[][] age)
//    {
//        JSFunctions.JSClickElement(TfTravellers());
//        for (int i = 0; i < rooms; i++) {
//            if (i == 0) {
//                int start = 0, totalClicks;
//                if (adults[i] > 2) {
//                    totalClicks = adults[0] - 2;
//                    while (start < totalClicks) {
//                        JSFunctions.JSClickElement(BtnAddAdult().get(i));
//                    }
//                }
//                else if (adults[i] == 1)
//                    JSFunctions.JSClickElement(BtnMinusAdult().get(i));
//            }
//            else {
//                JSFunctions.JSScrollIntoView(BtnAddRoom());
//                JSFunctions.JSClickElement(BtnAddRoom());
//                for (int j = 1; j < adults[i]; j++) {
//                    JSFunctions.JSClickElement(BtnAddAdult().get(i));
//                }
//            }
//            for (int k = 0; k < children[i]; k++) {
//                JSFunctions.JSClickElement(BtnAddChild().get(i));
//                new Select(CbbChildAge().get(CbbChildAge().size() - 1)).selectByValue(age[i][k]);
//            }
//        }
//        JSFunctions.JSClickElement(BtnClose());
//        if (Integer.parseInt(LbAdult().getText().split(" ")[0]) != IntStream.of(adults).sum()) return false;
//        return true;
//    }

//    public String SelectTravellers(int rooms, int adults[], int children[], String age[][])
//    {
//        int currCount, clickCount, index;
//        JSFunctions.JSClickElement(TfTravellers());
//        while (PaneRoom().size() > rooms) {
//            JSFunctions.JSClickElement(LinkRemoveRoom().get(0));
//        }
//        for (int i = 0; i < rooms; i++) {
//            currCount = Integer.parseInt(LbAdultCount().get(i).getText());
//            clickCount = Math.abs(adults[i] - currCount);
//            for (index = 0; index < clickCount; index++) {
//                if (adults[i] < currCount) {
//                    JSFunctions.JSClickElement(BtnMinusAdult().get(i));
//                }
//                else if (adults[i] > currCount) {
//                    JSFunctions.JSClickElement(BtnAddAdult().get(i));
//                }
//            }
//
//            currCount = Integer.parseInt(LbChildCount().get(i).getText());
//            clickCount = Math.abs(children[i] - currCount);
//            for (index = 0; index < clickCount; index++) {
//                if (children[i] < currCount) {
//                    JSFunctions.JSClickElement(BtnMinusChild().get(i));
//                }
//                else if (children[i] > currCount) {
//                    JSFunctions.JSClickElement(BtnAddChild().get(i));
//                }
//            }
//
//            for (index = 0; index < children[i]; index++) {
//                new Select(CbbChildAge(i + 1).get(index)).selectByValue(age[i][index]);
//            }
//
////            JSFunctions.JSScrollIntoView(BtnAddRoom());
//            if (PaneRoom().size() < rooms) {
//                JSFunctions.JSClickElement(BtnAddRoom());
//            }
//        }
//        JSFunctions.JSClickElement(BtnClose());
//
//        String strRooms = rooms + " room" + (rooms > 1 ? "s" : "");
//        currCount = IntStream.of(adults).sum();
//        String strAdults = currCount + " Adult" + (currCount > 1 ? "s" : "") + ", ";
//        currCount = IntStream.of(children).sum();
//        String strChildren = currCount > 0 ? currCount + " Child" + (currCount > 1 ? "ren" : "") + ", " : "";
//        return strAdults + strChildren + strRooms;
//    }

    public String SetTravellers(int rooms, int[] adults, int[] children) {
        this.rooms = rooms;
        this.adults = adults;
        this.children = children;

        JSFunctions.JSClickElement(TfTravellers());
        RemoveRooms();
        for (int i = 0; i < rooms; i++) {
            SetTotalAdults(i);
            SetTotalChildren(i);
            AddRooms();
        }
        JSFunctions.JSClickElement(BtnClose());
        return GetTotalTravellers();
    }

    public String SetTravellers(int rooms, int[] adults, int[] children, String[][] age) {
        this.rooms = rooms;
        this.adults = adults;
        this.children = children;
        this.age = age;

        JSFunctions.JSClickElement(TfTravellers());
        RemoveRooms();
        for (int i = 0; i < rooms; i++) {
            SetTotalAdults(i);
            SetTotalChildren(i);
            SetChildrenAge(i);
            AddRooms();
        }
        JSFunctions.JSClickElement(BtnClose());
        return GetTotalTravellers();
    }

    public void RemoveRooms() {
        while (PaneRoom().size() > rooms) {
            JSFunctions.JSClickElement(LinkRemoveRoom().get(0));
        }
    }

    public void AddRooms() {
        if (PaneRoom().size() < rooms) {
            JSFunctions.JSClickElement(BtnAddRoom());
        }
    }

    public void SetTotalAdults(int idx) {
        int currCount = Integer.parseInt(LbAdultCount().get(idx).getText());
        int clickCount = Math.abs(adults[idx] - currCount);
        for (int i = 0; i < clickCount; i++) {
            if (adults[idx] < currCount) {
                JSFunctions.JSClickElement(BtnMinusAdult().get(idx));
            }
            else if (adults[idx] > currCount) {
                JSFunctions.JSClickElement(BtnAddAdult().get(idx));
            }
            currCount = Integer.parseInt(LbAdultCount().get(idx).getText());
        }
    }

    public void SetTotalChildren(int idx) {
        int currCount = Integer.parseInt(LbChildCount().get(idx).getText());
        int clickCount = Math.abs(children[idx] - currCount);
        for (int i = 0; i < clickCount; i++) {
            if (children[idx] < currCount) {
                JSFunctions.JSClickElement(BtnMinusChild().get(idx));
            }
            else if (children[idx] > currCount) {
                JSFunctions.JSClickElement(BtnAddChild().get(idx));
            }
        }
    }

    public void SetChildrenAge(int idx) {
        for (int i = 0; i < children[idx]; i++) {
            new Select(CbbChildAge(idx + 1).get(i)).selectByValue(age[idx][i]);
        }
//        Arrays.asList(children[idx]).forEach(e -> new Select(CbbChildAge(idx + 1).get(e)).selectByValue(age[idx][e]));
//        List.of(children[idx]).forEach(e -> System.out.println(e));
    }

    public void SetChildrenAge() {
        for (int i = 0; i < CbbChildAge().size(); i++)
        {
            new Select(CbbChildAge().get(i)).selectByValue(arrAge[i]);
        }
    }


    public String GetTotalTravellers() {
        String strRooms = rooms + " room" + (rooms > 1 ? "s" : "");
        int currCount = IntStream.of(adults).sum();
        String strAdults = currCount + " Adult" + (currCount > 1 ? "s" : "") + ", ";
        currCount = IntStream.of(children).sum();
        String strChildren = currCount > 0 ? currCount + " Child" + (currCount > 1 ? "ren" : "") + ", " : "";
        return strAdults + strChildren + strRooms;
    }

    public boolean ValSelectedAge() {
        TfTravellers().click();
        for (int i = 0; i < age.length ; i++) {
            for (int j = 0; j < age[i].length; j++) {
                String selectedAge = new Select(CbbChildAge(i + 1).get(j)).getFirstSelectedOption().getText();
                if (age[i][j] == selectedAge) {
                    return false;
                }
            }
        }
        return true;
    }
}
