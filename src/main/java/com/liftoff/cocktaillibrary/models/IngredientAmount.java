package com.liftoff.cocktaillibrary.models;

    public enum IngredientAmount {
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

