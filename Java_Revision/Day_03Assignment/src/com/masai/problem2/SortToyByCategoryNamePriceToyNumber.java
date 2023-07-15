package com.masai.problem2;

import java.util.Comparator;

public class SortToyByCategoryNamePriceToyNumber implements Comparator<Toy> {


    @Override
    public int compare(Toy o1, Toy o2) {

        if(o1.getCategory().compareTo(o2.getCategory()) !=0){
            return  o1.getCategory().compareTo(o2.getCategory());
        //since we are here i can say ctaegory is equal
        }

        if(o1.getToyName().compareTo(o2.getToyName()) !=0){
            return o1.getToyName().compareTo(o2.getToyName());
        }

        if(o1.getPrice() != o2.getPrice()){
            if(o1.getPrice() > o2.getPrice()){
                return 1;
            }
            else{
                return -1;
            }
        }

        return o1.getToyNumber().compareTo(o2.getToyNumber());

    }
}
