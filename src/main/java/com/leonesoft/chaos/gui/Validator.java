/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonesoft.chaos.gui;

/**
 *
 * @author Pete
 * @param <T>
 */
public interface Validator<T> {
    public default boolean isValid(T value) {
        return true;
    };
}
