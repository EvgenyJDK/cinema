package com.cinema.model;

/**
 * Created by Админ on 04.05.2016.
 */
public enum AdminRights {
    SHOW_ALL_FILMS("allFilms"), ADD_FILM("addFilm"), EDIT_FILM("editFilm"), ADD_HALL_TO_FILM("addHallToFilm"), REMOVE_FILM("removeFilm"),
    ADD_HALL("addHall"), SHOW_ALL_HALLS("allHalls"), EDIT_HALL("editHall"), REMOVE_HALL("removeHall"),
    ADD_SEANS("addSeans"), EDIT_SEANS("editSeans"), DELETE_SEANS("deleteSeans");

    private String buttonAction;

    AdminRights(String buttonAction) {
        this.buttonAction = buttonAction;
    }

    public static AdminRights getType(String action) {
        String[] names = getArrayNames();
        for (byte index = 0; index < names.length; index++) {
            if (action.equalsIgnoreCase(names[index])) {
                return AdminRights.values()[index];
            }
        }
        return null;
    }


    public static String[] getArrayNames() {
        String[] names = new String[values().length];
        byte counter = 0;
        for (AdminRights type : AdminRights.values()) {
            names[counter++] = type.buttonAction;
        }
        return names;
    }
}
