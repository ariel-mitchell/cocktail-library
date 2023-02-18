package com.liftoff.cocktaillibrary.models;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public enum IngredientAmount {
        DASH ("Dash"),
        BARSPOON ("Barspoon"),
        QAURTERPART("Quarter Part"),
        HALFPART ("Half Part"),
        ONEPART ("One Part"),
        TWOPARTS ("Two Parts"),
        THREEPARTS ("Three Parts"),
        FOURPARTS ("Four Parts");

        private final String displayName;



        IngredientAmount(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }


}

